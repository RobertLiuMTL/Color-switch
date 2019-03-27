//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

/**
 * Le renderer du RotatingCircle. 
 * Malheureusement, cette classe est non-fonctionnelle.
 * @author Robert
 *
 */
public class RotatingCircleRenderer extends Renderer {
    private RotatingCircle rotatingCircle;
    
    /**
     * Constructeur
     * @param r
     */
    public RotatingCircleRenderer(RotatingCircle r) {
        this.rotatingCircle = r;
    }
    
    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, rotatingCircle.getY());

        context.setFill(Renderer.convertColor(rotatingCircle.getColor()));

        context.fillOval(
                rotatingCircle.getX() - rotatingCircle.getWidth() / 2,
                canvasY - rotatingCircle.getHeight()/2,
                rotatingCircle.getWidth(),
                rotatingCircle.getHeight());
    }
    
    
    
   
}
