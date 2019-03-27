//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

/**
 * Obstacle simple : Un cercle qui grossit (ou diminue) et qui change de couleur.
 * 
 * Les attributs sont w et h, soit la largeur et l'hauteur.
 * On a un compteur qui sert à calculer le nombre de fois que notre cercle
 * va grossir. On a une booléenne qui est initialisée à TRUE au départ et qui
 * indique quand il faut arrêter de grossir.
 */
public class GrowingCircle extends Obstacle {

    private double w, h;
    private int compteur = 0;
    private boolean condition = true;

    private double timeSinceColorChange = 0;
    
    /**
     * Constructeur du GrowingCircle
     * @param x
     * @param y
     * @param w
     * @param h 
     */
    public GrowingCircle(double x, double y, double w, double h) {
        super(x, y);
        this.w = w;
        this.h = h;
        this.renderer = new GrowingCircleRenderer(this);

        this.color = (int) (Math.random() * 4);
    }

    @Override
    public double getWidth() {
        return 2 * w;
    }

    @Override
    public double getHeight() {
        return 2 * h;
    }
    
    /**
     * Méthode qui permet de faire grossir le cercle. Une fois que le compteur
     * atteint une certaine valeur, on arrête de grossir et on perd du poids!
     */
    public void grossir(){
        if (condition == true){
            w+=0.5;
            h+=0.5;
            compteur +=1;
            if (compteur == 80){
                condition = false;       
            }
        }else{
            w -= 0.5;
            h -=0.5;
            compteur -=1;
            if (compteur == 0){
                condition = true;
            }
        }
        
    }
    
    @Override
    public void tick(double dt) {
        timeSinceColorChange += dt;
        

        
        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }

    public int getColor() {
        return color;
    }
    
    /**
     * La vérification de la collision examine d'abord si le mode Cheat est activé, ou si le joueur est invulnérable
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
                    && d2 < (this.w + player.getRadius())*(this.w + player.getRadius());
        }
    }
}
