import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SwitchBall {
    public ImageView createSwitchBall(int posY){
        Image switchImg = new Image("file:images/blob.png");
        ImageView switchImgView = new ImageView(switchImg);
        switchImgView.setPreserveRatio(true);
        switchImgView.setFitHeight(25);
        switchImgView.setFitWidth(25);
        switchImgView.setX(287);
        switchImgView.setY(posY);
        return switchImgView;
    }
}
