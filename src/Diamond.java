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
class Diamond extends Obstacle{
    public Diamond(int speed){
        super(speed);
    }
    //more speed value, less time in the animation
    //normal 5 ->this corresponds to time only which will be passed as a parameter to createObstacle() 
    //med 4
    //fast 3
    @Override
    public Group createObstacle(int speed){
        Group diamond = new Group();
        Line redLine = new Line(300,10,225,100);
        redLine.setStroke(Color.rgb(255,0,140));
        redLine.setStrokeWidth(10);
        redLine.setStrokeLineCap(StrokeLineCap.ROUND);

        Line yellowLine = new Line(300,10,375,100);
        yellowLine.setStroke(Color.rgb(250,225,0));;
        yellowLine.setStrokeWidth(10);
        yellowLine.setStrokeLineCap(StrokeLineCap.ROUND);
        
        Line blueLine = new Line(375,100,300,200);
        blueLine.setStroke(Color.rgb(144,13,255));
        blueLine.setStrokeWidth(10);
        blueLine.setStrokeLineCap(StrokeLineCap.ROUND);

        Line greenLine = new Line(300,200,225,100);
        greenLine.setStroke(Color.rgb(50,219,240));
        greenLine.setStrokeWidth(10);
        greenLine.setStrokeLineCap(StrokeLineCap.ROUND);

        diamond.getChildren().add(redLine);
        diamond.getChildren().add(yellowLine);
        diamond.getChildren().add(blueLine);
        diamond.getChildren().add(greenLine);

        RotateTransition diamondRotate = new RotateTransition(Duration.seconds(speed),diamond);
        diamondRotate.setByAngle(360);
        diamondRotate.setCycleCount(RotateTransition.INDEFINITE);
        diamondRotate.play();
        return diamond;
    }
}