//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;

/**
 * Obstacle simple : une barre verticale qui change de couleur à toutes les 2 secondes.
 */
public class VerticalBar extends Obstacle {

    private double width;
    private double height;
    private double timeSinceColorChange = 0;
    private boolean condition = true;
    
    /**
     * Constructeur de la barre verticale
     * @param x
     * @param y
     * @param longueur
     * @param hauteur
     */
    public VerticalBar(double x, double y, double longueur, double hauteur) {
        super(x, y);

        this.width = longueur;
        this.height = hauteur;
        this.renderer = new VerticalBarRenderer(this);
        this.color = (int) (Math.random() * 4);
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public void tick(double dt) {
       
    }

    public int getColor() {
        return color;
    }
    
    /**
     * Méthode qui permet de faire bouger le rectangle horizontalement.
     * @param screenW : La largeur de l'écran nous permet de déterminer
     * les limites de déplacement du rectangle.
     */
    public void bouger (double screenW){
    	/**
    	 * Initialement, la condition est à true et le rectangle se déplace
    	 * vers la droite. Une fois que nous atteignions l'extrémité du jeu,
    	 * la condition devient fausse.
    	 */
        if (condition == true){
            x+=2;
            if (x + width/2 >= screenW){
                condition = false;
            }            
        }else{
            x-=2;
            if (x - width/2 <= 0){
                condition = true;
            }
        }
        
    }
    
    @Override
    public boolean intersects(Player player) {
        if (player.getInvulnerable()==true || player.getCheat()==true){
        	return false;
        }else {
            return this.color != player.getColor()
                    && player.getX()-player.getRadius() < this.getX() + this.getWidth() / 2
                    && player.getX()+player.getRadius() > this.getX() - this.getWidth() / 2
                    && player.getY()-player.getRadius() < this.getY() + this.getHeight() / 2
                    && player.getY()+player.getRadius() > this.getY() - this.getHeight() / 2;
        }
    }
}
