import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.*;


public class Ball {
    public Circle ball;
    public final int ball_r;
    public int colour;

    public Ball(int ball_r) {
        this.ball_r = ball_r;
        this.colour = 1;
        this.ball = new Circle(this.ball_r);
        this.ball.setTranslateX(300.0f);
        this.ball.setTranslateY(650.0f);
        this.ball.setFill(Color.rgb(144,13,255));
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    public void MoveUp(){
        if(this.ball.getTranslateY()-this.ball_r - 20.0f >= 0)
            this.ball.setTranslateY(this.ball.getTranslateY()-10.0f);
    }

    public void MoveDown() {
        if (this.ball.getTranslateY() + this.ball_r <= 700)
            ball.setTranslateY(ball.getTranslateY() + 2.5f);
    }

}
