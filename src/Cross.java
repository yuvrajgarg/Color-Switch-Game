import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
class Cross extends Obstacle{
    public Cross(int speed){
        super(speed);
    }
    @Override
    public Group createObstacle(int speed) {
        Group cross = new Group();
        Line cross1 = new Line(400,410,280,410);
        cross1.setStroke(Color.rgb(255,0,140));//pink
        cross1.setStrokeWidth(15);
        cross1.setStrokeLineCap(StrokeLineCap.ROUND);

        Line cross2 = new Line(400,410,520,410);
        cross2.setStroke(Color.rgb(250,225,0));
        cross2.setStrokeWidth(15);
        cross2.setStrokeLineCap(StrokeLineCap.ROUND);
        
        Line cross3 = new Line(400,410,400,290);
        cross3.setStroke(Color.rgb(144,13,255));
        cross3.setStrokeWidth(15);
        cross3.setStrokeLineCap(StrokeLineCap.ROUND);

        Line cross4 = new Line(400,410,400,530);
        cross4.setStroke(Color.rgb(50,219,240));
        cross4.setStrokeWidth(15);
        cross4.setStrokeLineCap(StrokeLineCap.ROUND);
        
        cross.getChildren().add(cross1);
        cross.getChildren().add(cross2);
        cross.getChildren().add(cross3);
        cross.getChildren().add(cross4);

        RotateTransition crossRotate = new RotateTransition(Duration.seconds(5),cross);
        crossRotate.setByAngle(360);
        crossRotate.setCycleCount(RotateTransition.INDEFINITE);
        crossRotate.play();
        return cross;
    }
}