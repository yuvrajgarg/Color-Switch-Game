import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
class SquareOfCircles extends Obstacle{
    public SquareOfCircles(int speed){
        super(speed);
    }

    @Override
    public Group createObstacle(int speed) {
        Group squareOfCircles = new Group();
        Group subgr1 = new Group();
        int posX1 = 250;
        for(int i = 1 ; i <= 6; i++){
            Circle circle = new Circle(posX1,375,12);
            circle.setFill(Color.rgb(144,13,255));//violet
            subgr1.getChildren().add(circle);
            posX1+=24;
        }
        
        Group subgr2 = new Group();
        int posX2 = 250;
        for(int i = 1 ; i <= 5; i++){
            Circle circle = new Circle(posX2,250,12);
            circle.setFill(Color.rgb(50,219,240));//aqua
            subgr2.getChildren().add(circle);
            posX2+=24;
        }

        Group subgr3 = new Group();
        int posY1 = 250;
        for(int i = 1 ; i <= 6; i++){
            Circle circle = new Circle(225,posY1,12);
            circle.setFill(Color.rgb(250,225,0));//yellow
            subgr3.getChildren().add(circle);
            posY1+=24;
        }

        Group subgr4 = new Group();
        int posY2 = 250;
        for(int i = 1 ; i <= 5; i++){
            Circle circle = new Circle(370,posY2,12);
            circle.setFill(Color.rgb(255,0,140)); //pink
            subgr4.getChildren().add(circle);
            posY2 += 24;
        }
        squareOfCircles.getChildren().add(subgr1);
        squareOfCircles.getChildren().add(subgr2);
        squareOfCircles.getChildren().add(subgr3);
        squareOfCircles.getChildren().add(subgr4);

        RotateTransition squareOfCirclesRotate = new RotateTransition(Duration.seconds(5),squareOfCircles);
        squareOfCirclesRotate.setByAngle(360);
        squareOfCirclesRotate.setCycleCount(RotateTransition.INDEFINITE);
        squareOfCirclesRotate.play();
        return squareOfCircles;
    }
}