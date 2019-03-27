//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

/**
 * Item : champignon.
 *
 * Ramasser un champignon permet de gagner le niveau actuel
 */
public class Mushroom extends Item {
    private int compteur = 1;
    private boolean croitre = true;
    
    /**
     * Le constructeur du champignon
     * @param x
     * @param y
     */
    public Mushroom(double x, double y) {
        super(x, y);

        this.renderer = new AnimationRenderer("mushroom", this);
    }

    @Override
    public void tick(double dt) {
        if (compteur>25){
            croitre=false;
        }
        if (compteur<1){
            croitre=true;
        }
        
        if (croitre == true){
            compteur+=1;
            ((AnimationRenderer)renderer).setImage(compteur);
        }else{
            compteur-=1;
            ((AnimationRenderer)renderer).setImage(compteur);
        }
    }


    @Override
    public double getWidth() {
        return 64;
    }

    @Override
    public double getHeight() {
        return 64;
    }

    @Override
    public void handleCollision(Player player, Game game) {
        game.win();
    }

    @Override
    public boolean intersects(Player player) {
        return player.getY()-player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY()+player.getRadius() > this.getY() - this.getHeight() / 2;
    }
}
