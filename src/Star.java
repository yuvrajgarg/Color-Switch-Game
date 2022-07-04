import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Star {
    public ImageView createStar(int posY){
        Image starImg = new Image("file:images/star.png");
        ImageView starImgView = new ImageView(starImg);
        starImgView.setPreserveRatio(true);
        starImgView.setFitHeight(100);
        starImgView.setFitWidth(28);
        starImgView.setX(286);
        starImgView.setY(posY);
        return starImgView;
    }    
}
