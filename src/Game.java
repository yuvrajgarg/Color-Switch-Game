import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Game extends Application {
    private Group gameSceneRoot = new Group();
    private Group gameOverSceneRoot = new Group();
    private Group homeSceneRoot = new Group();
    private Group pauseSceneRoot = new Group();
    private Group pastGameSceneRoot = new Group();

    private enum UserAction {
        NONE, UP, PAUSE
    }

    private Diamond diamond = new Diamond(5);
    private Triangle triangle = new Triangle(5);
    private Cross cross = new Cross(5);
    private SquareOfCircles squareOfCircles = new SquareOfCircles(5);
    private Ring ring = new Ring(5);
    private Belt belt = new Belt(5);
    Star star = new Star();
    SwitchBall switchBall = new SwitchBall();

    private Ball pl_ball = new Ball(12);

    private Game.UserAction action = Game.UserAction.NONE;

    private Timeline timeline = new Timeline();
    private boolean running = true;
    
    private Scene GameScene;
    private Scene GameOverScene;
    private Scene HomeScene;
    private Scene PauseScene;
    private Scene PastGameScene;
    
    private void createGame(Stage stage,Group root, ImageView pause, Button pausebutton){
        KeyFrame frame = new KeyFrame(Duration.seconds(0.025), event ->{
            if(!running){
                return;
            }
            switch (action){
                case UP:
                    pl_ball.MoveUp();
                    break;
                case NONE:
                    pl_ball.MoveDown();
                    break;
            }

            if (pl_ball.ball.getTranslateY()-pl_ball.ball_r == 0 || pl_ball.ball.getTranslateY()+ pl_ball.ball_r >= 700f){
                // restartGame();
                timeline.pause();
                stage.setScene(GameOverScene);
            }
        });

        timeline.getKeyFrames().add(frame);
        timeline.setCycleCount(Timeline.INDEFINITE);

        root.getChildren().addAll(pl_ball.ball);
        root.getChildren().addAll(pause);
//        root.getChildren().addAll(pausebutton);

    }

    private void restartGame() {
        stopGame();
        startGame();
    }

    private void stopGame(){
        running = false;
        timeline.stop();
    }

    private void startGame(){
        pl_ball.ball.setTranslateX(300f);
        pl_ball.ball.setTranslateY(650f);

        timeline.play();
        running = false;
    }

    
    @Override
    public void start(Stage stage){
        GameScene = new Scene(gameSceneRoot,600,700,Color.rgb(40,40,40));
        HomeScene = new Scene(homeSceneRoot,600,700,Color.rgb(40,40,40));
        PauseScene = new Scene(pauseSceneRoot,600,700,Color.rgb(27,27,27));
        PastGameScene = new Scene(pastGameSceneRoot,600,700,Color.rgb(27,27,27));
        GameOverScene = new Scene(gameOverSceneRoot,600,700,Color.rgb(27,27,27));

        Image startGameLogo = new Image("file:images/startFinal.png");
        ImageView startGameLogoIV = new ImageView(startGameLogo);
        startGameLogoIV.setPreserveRatio(true);
        startGameLogoIV.setFitHeight(160);
        startGameLogoIV.setFitWidth(150);
        startGameLogoIV.setX(230);
        startGameLogoIV.setY(550);
        
        // Media mainPageAudio = new Media("file:sound/Color Switch - Game Theme Music (soundtrack) HQ (128 kbps).mp3");
        // MediaPlayer mediaPlayer = new MediaPlayer(mainPageAudio);
        // mediaPlayer.setAutoPlay(true);
        
        Group imageGr = new Group();
        Ring r1 = new Ring(5);
        Ring r2 = new Ring(5);
        Ring r3 = new Ring(5);
        Ring r4 = new Ring(5);
        Ring r5 = new Ring(5);
        Image colorSwitchLogo = new Image("file:images/color-switch.jpg");
        ImageView iv = new ImageView(colorSwitchLogo);
        iv.setPreserveRatio(true);
        iv.setFitHeight(550);
        iv.setFitWidth(400);
        iv.setX(110);
        iv.setY(50);
        imageGr.getChildren().addAll(iv,
                r1.createRing(3,272.0f,96.0f,15.0f,15.0f,7),
                r2.createRing(3,338.5f,96.0f,15.0f,15.0f,7),
                r3.createRing(3,306.0f,305.0f,69.0f,69.0f,12),
                r4.createRing(4,306.0f,305.0f,87.0f,87.0f,15),
                r5.createRing(5,306.0f,305.0f,109.0f,109.0f,20)
        );

        Button StartBtn = new Button("START GAME");
        StartBtn.setLayoutX(220);
        StartBtn.setLayoutY(450);
        StartBtn.getStylesheets().add("StartBtn.css");

        Button ResumePastGameBtn = new Button("RESUME Previous Game");
        ResumePastGameBtn.setLayoutX(170);
        ResumePastGameBtn.setLayoutY(520);
        ResumePastGameBtn.getStylesheets().add("StartBtn.css");

        Button ExitBtn = new Button("EXIT");
        ExitBtn.setLayoutX(260);
        ExitBtn.setLayoutY(590);
        ExitBtn.getStylesheets().add("StartBtn.css");

        Label score = new Label("Score: X");
        score.setLayoutX(20);
        score.setLayoutY(20);
        score.setTextFill(Color.WHITE);
        score.setStyle("-fx-font-weight: bold;");
        score.setStyle("-fx-font-size: 30px;");
//star
        ImageView starImgView1 = star.createStar(125);
        ImageView starImgView2 = star.createStar(350);
        ImageView switchImgView1 = switchBall.createSwitchBall(276);

        homeSceneRoot.getChildren().addAll(StartBtn,ExitBtn,ResumePastGameBtn);
        homeSceneRoot.getChildren().add(imageGr);
// BUTTON ACTIONS
        StartBtn.setOnAction(e->{
            stage.setScene(GameScene);
            startGame();
        });
        ResumePastGameBtn.setOnAction(e->stage.setScene(PastGameScene));
        ExitBtn.setOnAction(e->stage.close());

        gameSceneRoot.getChildren().add(cross.createObstacle(5));
        gameSceneRoot.getChildren().add(ring.createObstacle(5));
        gameSceneRoot.getChildren().addAll(starImgView1,starImgView2,score,switchImgView1,startGameLogoIV);
        Image pauseLogo = new Image("file:images/pause.jpg");
        ImageView pause = new ImageView(pauseLogo);
        pause.setFitHeight(70);
        pause.setFitWidth(75);
        pause.setX(520);
        pause.setY(1);
        Button PauseBtn = new Button();
        PauseBtn.setLayoutX(550);
        PauseBtn.setLayoutY(19);
        PauseBtn.setStyle("-fx-border-color: transparent;");
        PauseBtn.setStyle("-fx-background-color: transparent;");

        GameScene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case SPACE:
                    running = true;
                    // System.out.println("SPACE");
                    action = Game.UserAction.UP;
                    break;

                case P:
                    stage.setScene(PauseScene);
                    timeline.pause();
                    break;
            }
        });

        GameScene.setOnKeyReleased(event -> {
            switch (event.getCode()){
                case SPACE:
                    action = Game.UserAction.NONE;
                    break;
            }
        });


        createGame(stage,gameSceneRoot, pause, PauseBtn);

//PAUSE SCENE
        Button ResumeBtn = new Button("RESUME");
        ResumeBtn.setLayoutX(70);
        ResumeBtn.setLayoutY(120);
        ResumeBtn.getStylesheets().add("StartBtn.css");

        Button SaveAndExitBtn = new Button("SAVE AND EXIT");
        SaveAndExitBtn.setLayoutX(270);
        SaveAndExitBtn.setLayoutY(120);
        SaveAndExitBtn.getStylesheets().add("StartBtn.css");

        pauseSceneRoot.getChildren().addAll(ResumeBtn,SaveAndExitBtn);
        
        ResumeBtn.setOnMouseClicked(e->{
            stage.setScene(GameScene);
            timeline.play();
        });
        SaveAndExitBtn.setOnMouseClicked(e->stage.setScene(HomeScene));

//game over scene
        Label gameoverLabel1 = new Label("GAME");
        gameoverLabel1.setLayoutX(40);
        gameoverLabel1.setLayoutY(20);
        gameoverLabel1.setTextFill(Color.WHITE);
        gameoverLabel1.setStyle("-fx-font-weight: bold;");
        gameoverLabel1.setStyle("-fx-font-size: 50px;");

        Label gameoverLabel2 = new Label("OVER");
        gameoverLabel2.setLayoutX(200);
        gameoverLabel2.setLayoutY(20);
        gameoverLabel2.setTextFill(Color.RED);
        gameoverLabel2.setStyle("-fx-font-weight: bold;");
        gameoverLabel2.setStyle("-fx-font-size: 50px;");

        Label starsCollectedLabel = new Label("Total SCORE: X");
        starsCollectedLabel.setLayoutX(50);
        starsCollectedLabel.setLayoutY(240);
        starsCollectedLabel.setTextFill(Color.AQUA);
        starsCollectedLabel.setStyle("-fx-font-weight: bold;");
        starsCollectedLabel.setStyle("-fx-font-size: 30px;");

        Button RestartBtn = new Button("RESTART GAME");
        RestartBtn.setLayoutX(270);
        RestartBtn.setLayoutY(360);
        RestartBtn.getStylesheets().add("StartBtn.css");

        Button ExitToMainBtn = new Button("EXIT TO MAIN MENU");
        ExitToMainBtn.setLayoutX(270);
        ExitToMainBtn.setLayoutY(120);
        ExitToMainBtn.getStylesheets().add("StartBtn.css");

        Button continueStarsBtn = new Button("Continue with Stars Collected");
        continueStarsBtn.setLayoutX(270);
        continueStarsBtn.setLayoutY(240);
        continueStarsBtn.getStylesheets().add("StartBtn.css");
        continueStarsBtn.setOnAction(e->
            {
                stage.setScene(GameScene);
                restartGame();
            }
        );
        RestartBtn.setOnAction(e->
            {
                stage.setScene(GameScene);
                restartGame();
            });
            
        ExitToMainBtn.setOnAction(e->stage.setScene(HomeScene));
        
        gameOverSceneRoot.getChildren().addAll(gameoverLabel1,gameoverLabel2,ExitToMainBtn,continueStarsBtn,RestartBtn,starsCollectedLabel);
//PAST GAME SCENE
        Label previosGameslabel = new Label("PAST PLAYED GAMES");
        previosGameslabel.setLayoutX(150);
        previosGameslabel.setLayoutY(40);
        previosGameslabel.setTextFill(Color.AQUA);
        previosGameslabel.setStyle("-fx-font-weight: bold;");
        previosGameslabel.setStyle("-fx-font-size: 30px;");

        Button GoBackBtn = new Button("Go Back");
        GoBackBtn.setLayoutX(30);
        GoBackBtn.setLayoutY(12);
        GoBackBtn.getStylesheets().add("StartBtn.css");
        pastGameSceneRoot.getChildren().addAll(previosGameslabel,GoBackBtn);
        GoBackBtn.setStyle("-fx-font-size: 15px;");
        GoBackBtn.setOnAction(e->stage.setScene(HomeScene));

        stage.setScene(HomeScene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}