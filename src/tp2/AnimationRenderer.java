//Robert Liu (865826) et Maud Moerel-Martini (20037754)

package tp2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimationRenderer extends Renderer {

    private Image img;
    private Entity entity;
    private Image []images = new Image[26];
    public AnimationRenderer(String name, Entity e) {
        img = new Image("/" + name + "_animation1.png");
        this.entity = e;
        for (int i=1;i<=26;i++){
            images[i-1]= new Image ("/" + name + "_animation"+i+".png");
        }
    }
    /**
     * Fonction qui permet de modifier l'image de l'objet animé
     * @param i 
     */
    public void setImage(int i){
        this.img = images[i];
    }
    
    /**
     * 
     * @return Retourne un tableau d'images
     */
    public Image[] getImage(){
        return this.images;
    }
    @Override
    public void draw(Level level, GraphicsContext context) {

        double x = entity.getX();
        double y = Renderer.computeScreenY(level, entity.getY());

        context.drawImage(img, x - entity.getWidth() / 2, y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());
    }
}