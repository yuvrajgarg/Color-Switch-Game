import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
class Belt extends Obstacle{
    public Belt(int speed){
        super(speed);
    }
    @Override
    public Group createObstacle(int speed){
        Group belt = new Group();
        Line line1 = new Line(300,350,500,350);
        line1.setStroke(Color.rgb(255,0,140));  //pink
        line1.setStrokeWidth(10);
        
        Line line2 = new Line(500,350,700,350);
        line2.setStroke(Color.rgb(250,225,0));
        line2.setStrokeWidth(10);

        Line line3 = new Line(700,350,900,350);
        line3.setStroke(Color.rgb(144,13,255));
        line3.setStrokeWidth(10);

        Line line4 = new Line(900,350,1100,350);
        line4.setStroke(Color.rgb(50,219,240));
        line4.setStrokeWidth(10);
        
        belt.getChildren().add(line1);
        belt.getChildren().add(line2);
        belt.getChildren().add(line3);
        belt.getChildren().add(line4);

        Line line = new Line(0,250,600,250);
        PathTransition beltTransition = new PathTransition();
        beltTransition.setNode(belt);
        beltTransition.setDuration(Duration.seconds(2));
        beltTransition.setCycleCount(PathTransition.INDEFINITE);
        beltTransition.setPath(line);
        beltTransition.setAutoReverse(true);
        beltTransition.play();
        return belt;
    }
}