//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;
/**
 * Item : Potion magique.
 *
 * Fait changer la sorcière de couleur
 */
public class Potion extends Item {

    private boolean used = false;

    public Potion(double x, double y) {
        super(x, y);

        this.renderer = new ImageRenderer("potion", this);
    }

    @Override
    public void tick(double dt) {
        // Rien à faire
    }

    @Override
    public double getWidth() {
        return 48;
    }

    @Override
    public double getHeight() {
        return 48;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        used = true;
        this.renderer = new ImageRenderer("empty-potion", this);
        player.randomizeColor();
    }

    @Override
    public boolean intersects(Player player) {
        return !used
                && player.getX()-player.getRadius() < this.getX() + this.getWidth() / 2
                && player.getX()+player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY()-player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY()+player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}


