//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;

/**
 * Obstacle dans un niveau.
 *
 * Lorsque le joueur entre en collision avec un obstacle, la partie est
 * terminée.
 */
public abstract class Obstacle extends LevelElement {

    protected int color;
    
    /**
     * Le constructeur de l'obstacle
     * @param x
     * @param y
     */
    public Obstacle(double x, double y) {
        super(x, y);
    }

    /**
     * Gestion de la collision entre le joueur et l'obstacle
     *
     * @param player Le joueur
     * @param game La partie en cours
     */
    @Override
    public void handleCollision(Player player, Game game) {
        game.loose();
    }
}
