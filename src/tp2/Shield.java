//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *C'est la classe de l'item de bouclier qui confère l'invulnérabilité au joueur pendant 3 secondes.
 * @author liurober
 */
public class Shield extends Item {
    
    private boolean used = false;
    
    /**
     * Constructeur du Shield
     * @param x
     * @param y
     */
    public Shield(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("shield", this);
    }

    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    @Override
    public double getWidth() {
        return 32;
    }

    @Override
    public double getHeight() {
        return 32;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        try {
            player.activateInvulnerable();
        } catch (InterruptedException ex) {
            Logger.getLogger(Shield.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean intersects(Player player) {
        double dx = this.x - player.getX();
        double dy = this.y - player.getY();
        double d2 = dx*dx + dy*dy;
        return !used && d2 < (getWidth() + player.getRadius())*(getWidth() + player.getRadius());
    }
}
