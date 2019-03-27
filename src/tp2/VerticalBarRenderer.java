//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;
import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un VerticalBar en dessinant sur l'écran.
 */
public class VerticalBarRenderer extends Renderer {

    private VerticalBar verticalBar;
    
    /**
     * Constructeur
     * @param v
     */
    public VerticalBarRenderer(VerticalBar v) {
        this.verticalBar = v;
    }

    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, verticalBar.getY());

        context.setFill(Renderer.convertColor(verticalBar.getColor()));

        context.fillRect(
                verticalBar.getX() - verticalBar.getWidth() / 2,
                canvasY - verticalBar.getHeight() / 2,
                verticalBar.getWidth(),
                verticalBar.getHeight());
    }
}
