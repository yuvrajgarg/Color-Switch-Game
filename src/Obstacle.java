import javafx.scene.Group;

abstract class Obstacle {
    private int speed;

    public Obstacle(int speed) {
        this.setSpeed(speed);
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public abstract Group createObstacle(int speed);

    
}