//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.util.Duration;

/**
 * Constructeur du rotating circle. Cette classe ne marche malheureusement pas.
 * @author liurober
 */
public class RotatingCircle extends Obstacle{
    private double wh;
    private double midPoint = 120;
    private int compteur = 1;

    private double timeSinceColorChange = 0;

    /**
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public RotatingCircle(double x, double y, double wh) {
        super(x, y);
        this.wh = wh;
        this.renderer = new RotatingCircleRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    /**
     * 
     * @return Retourne le diamètre de notre cercle
     */
    @Override
    public double getWidth() {
        return 2 * wh;
    }
    
    /**
     * 
     * @return Retourne également le diamètre du cercle
     */
    @Override
    public double getHeight() {
        return 2 * wh;
    }

            
    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;



        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }
    /**
     * 
     * @return Retourne la couleur du cercle
     */
    public int getColor() {
        return color;
    }

    public void rotate() {
    	compteur+=1;
    	double angle = compteur* ( Math.PI / 30 );
    	x= x+midPoint/10* Math.sin(angle);
        y= y+midPoint/10* Math.cos(angle);
        if (compteur == 60) {
        	compteur = 0;
        	}             
    }
    
    /**
     * Fonction qui vérifie si l'objet touche le joueur.
     */
    @Override
    public boolean intersects(Player player) {
        double dx = this.x - player.getX();
        double dy = this.y - player.getY();
        double d2 = dx*dx + dy*dy;
        if (player.getInvulnerable()==true || player.getCheat()==true){
        	return false;
        }else {
            return this.color != player.getColor()
                    && d2 < (this.wh + player.getRadius())*(this.wh + player.getRadius());
        }
    }
}
