import javafx.util.Duration;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
class Triangle extends Obstacle{
    public Triangle(int speed){
        super(speed);
    }

    @Override
    public Group createObstacle(int speed) {
        Group triangle = new Group();
        Line t1 = new Line(300,410,200,600);
        t1.setStroke(Color.rgb(255,0,140));;
        t1.setStrokeWidth(10);
        t1.setStrokeLineCap(StrokeLineCap.ROUND);

        Line t2 = new Line(300,410,400,600);
        t2.setStroke(Color.rgb(250,225,0));;
        t2.setStrokeWidth(10);
        t2.setStrokeLineCap(StrokeLineCap.ROUND);
        
        Line t3 = new Line(400,600,200,600);
        t3.setStroke(Color.rgb(144,13,255));
        t3.setStrokeWidth(10);
        t3.setStrokeLineCap(StrokeLineCap.ROUND);
        
        triangle.getChildren().add(t1);
        triangle.getChildren().add(t2);
        triangle.getChildren().add(t3);

        RotateTransition triangleRotate = new RotateTransition(Duration.seconds(speed),triangle);
        triangleRotate.setByAngle(360);
        triangleRotate.setCycleCount(RotateTransition.INDEFINITE);
        triangleRotate.play();

        return triangle;
    }    
}