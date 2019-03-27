//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Cercle en dessinant un carré coloré sur l'écran.
 */
public class GrowingCircleRenderer extends Renderer {

    private GrowingCircle growingCircle;

    /**
     * Constructeur du Cercle
     * @param g
     */
    public GrowingCircleRenderer(GrowingCircle g) {
        this.growingCircle = g;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, growingCircle.getY());

        context.setFill(Renderer.convertColor(growingCircle.getColor()));

        context.fillOval(
                growingCircle.getX() - growingCircle.getWidth() / 2,
                canvasY - growingCircle.getHeight() / 2,
                growingCircle.getWidth(),
                growingCircle.getHeight());
    }

}
