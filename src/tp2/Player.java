//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe représentant l'entité de la personne qui joue (aka, la sorcière).
 *
 * La sorcière est représentée par un cercle.
 */
public class Player extends Entity {

    private double radius;
    private double vy;
    private double ay;
    private int color = 1;
    private boolean invulnerable = false;
    private boolean cheat = false;
    
    /**
     * Le constructeur de Player
     * @param x
     * @param y
     * @param r
     */
    public Player(double x, double y, double r) {
        super(x, y);

        this.radius = r;

        this.vy = 0;
        this.ay = -400;

        this.renderer = new PlayerRenderer(this);
    }
    
    /**
     * 
     * @return Retourne le rayon (Double)
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Fonction appelée à chaque frame pour mettre à jour les attributs de
     * l'entité
     *
     * @param dt Delta-Temps en secondes
     */
    @Override
    public void tick(double dt) {
        // Mise à jour de la vitesse
        vy += dt * ay;

        // Mise à jour de la position
        y += dt * vy;

        // Clip la vitesse pour rester entre -300 et 300
        vy = Math.min(vy, 300);
        vy = Math.max(vy, -300);
    }
    
    /**
     * 
     * @return Retourne la couleur sous forme de int
     */
    public int getColor() {
        return color;
    }

    /**
     * Remplace la couleur actuelle par une nouvelle couleur aléatoire
     */
    public void randomizeColor() {
        int newColor;

        do {
            newColor = (int) (Math.random() * 4);
        } while (newColor == this.color);

        this.color = newColor;
    }

    /**
     * Fait sauter la sorcière
     */
    public void jump() {
        vy = Math.max(vy, 0);
        vy += 200;
    }
    
    /**
     * activer le mode de test (Cheat mode)
     */
    public void cheat(){
        this.cheat = !cheat;
        if (cheat == true){
            System.out.println("Cheat more on!");
        }else if (cheat== false){
            System.out.println("Cheat mode disabled!");
        }
    }
    
    /**
     * 
     * @return Retourne le statut d'invulnérabilité (potion)
     */
    public boolean getInvulnerable(){
        return this.invulnerable;
    }
    
    /**
     * 
     * @return Retourne sous forme de booléenne le mode de test.
     */
    public boolean getCheat() {
    	return this.cheat;
    }
    
    /**
     * Méthode qui active l'invulnérabilité (potion) de la sorcière!
     * On utilise le multithreading pour attendre 3 secondes!
     * @throws InterruptedException 
     */
    public void activateInvulnerable() throws InterruptedException{
        
    	/**
    	 * Un nouveau thread est créé sur lequel nous appliquerons .sleep. 
    	 * Au réveil, nous pouvons retirer l'état d'invulnérabilité.
    	 */
        Thread cpu = new Thread(() -> {
            
            this.invulnerable = true;
            System.out.println("Début du Shield");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.invulnerable = false;
            System.out.println("Fin du Shield");
        });
        cpu.start();
    }
 
    /**
     * Un setter pour modifier la position y.
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getWidth() {
        return this.getRadius() * 2;
    }

    @Override
    public double getHeight() {
        return this.getRadius() * 2;
    }
}

