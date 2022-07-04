import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;
class Ring extends Obstacle{
    public Ring(int speed){
        super(speed);
    }
    @Override
    public Group createObstacle(int speed) {
        Group ring = new Group();
        Arc arc1 = new Arc();
        arc1.setCenterX(300.0f); 
        arc1.setCenterY(150.0f); 
        arc1.setRadiusX(70.0f); 
        arc1.setRadiusY(70.0f); 
        arc1.setStartAngle(0.0f); 
        arc1.setLength(90.0f);
        arc1.setStroke(Color.rgb(50,219,240));//aqua
        arc1.setStrokeWidth(11);
        arc1.setFill(null);
        arc1.setType(ArcType.OPEN);

        Arc arc2 = new Arc();
        arc2.setCenterX(300.0f); 
        arc2.setCenterY(150.0f); 
        arc2.setRadiusX(70.0f); 
        arc2.setRadiusY(70.0f); 
        arc2.setStartAngle(90.0f); 
        arc2.setLength(90.0f);
        arc2.setStroke(Color.rgb(144,13,255));//violet
        arc2.setStrokeWidth(11);
        arc2.setFill(null);
        arc2.setType(ArcType.OPEN);

        Arc arc3 = new Arc();
        arc3.setCenterX(300.0f); 
        arc3.setCenterY(150.0f); 
        arc3.setRadiusX(70.0f); 
        arc3.setRadiusY(70.0f); 
        arc3.setStartAngle(180.0f); 
        arc3.setLength(90.0f);
        arc3.setStroke(Color.rgb(250,225,0));//yellow
        arc3.setStrokeWidth(11);
        arc3.setFill(null);
        arc3.setType(ArcType.OPEN);

        Arc arc4 = new Arc();
        arc4.setCenterX(300.0f); 
        arc4.setCenterY(150.0f); 
        arc4.setRadiusX(70.0f); 
        arc4.setRadiusY(70.0f); 
        arc4.setStartAngle(270.0f); 
        arc4.setLength(90.0f);
        arc4.setStroke(Color.rgb(255,0,140));//bright pink
        arc4.setStrokeWidth(11);
        arc4.setFill(null);
        arc4.setType(ArcType.OPEN);

        ring.getChildren().add(arc1);
        ring.getChildren().add(arc2);
        ring.getChildren().add(arc3);
        ring.getChildren().add(arc4);

        RotateTransition ringRotate = new RotateTransition(Duration.seconds(5),ring);
        ringRotate.setByAngle(360);
        ringRotate.setCycleCount(RotateTransition.INDEFINITE);
        ringRotate.play();

        return ring;

    }
    public Group createRing(int speed,float centreX , float centreY,float radX , float radY,int strokeW) {
        Group ring = new Group();
        Arc arc1 = new Arc();
        arc1.setCenterX(centreX); 
        arc1.setCenterY(centreY); 
        arc1.setRadiusX(radX); 
        arc1.setRadiusY(radY); 
        arc1.setStartAngle(0.0f); 
        arc1.setLength(90.0f);
        arc1.setStroke(Color.rgb(50,219,240));//aqua
        arc1.setStrokeWidth(strokeW);
        arc1.setFill(null);
        arc1.setType(ArcType.OPEN);

        Arc arc2 = new Arc();
        arc2.setCenterX(centreX); 
        arc2.setCenterY(centreY); 
        arc2.setRadiusX(radX); 
        arc2.setRadiusY(radY); 
        arc2.setStartAngle(90.0f); 
        arc2.setLength(90.0f);
        arc2.setStroke(Color.rgb(144,13,255));//violet
        arc2.setStrokeWidth(strokeW);
        arc2.setFill(null);
        arc2.setType(ArcType.OPEN);

        Arc arc3 = new Arc();
        arc3.setCenterX(centreX); 
        arc3.setCenterY(centreY); 
        arc3.setRadiusX(radX); 
        arc3.setRadiusY(radY); 
        arc3.setStartAngle(180.0f); 
        arc3.setLength(90.0f);
        arc3.setStroke(Color.rgb(250,225,0));//yellow
        arc3.setStrokeWidth(strokeW);
        arc3.setFill(null);
        arc3.setType(ArcType.OPEN);

        Arc arc4 = new Arc();
        arc4.setCenterX(centreX); 
        arc4.setCenterY(centreY); 
        arc4.setRadiusX(radX); 
        arc4.setRadiusY(radY); 
        arc4.setStartAngle(270.0f); 
        arc4.setLength(90.0f);
        arc4.setStroke(Color.rgb(255,0,140));//bright pink
        arc4.setStrokeWidth(strokeW);
        arc4.setFill(null);
        arc4.setType(ArcType.OPEN);

        ring.getChildren().add(arc1);
        ring.getChildren().add(arc2);
        ring.getChildren().add(arc3);
        ring.getChildren().add(arc4);

        RotateTransition ringRotate = new RotateTransition(Duration.seconds(speed),ring);
        ringRotate.setByAngle(360);
        ringRotate.setCycleCount(RotateTransition.INDEFINITE);
        ringRotate.play();

        return ring;

    }
}