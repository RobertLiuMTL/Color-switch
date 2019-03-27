//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

import java.util.List;

/**
 * Contrôleur pour le jeu : fait le pont entre la vue et les modèles.
 */
public class Controller {
	
	/**
	 * Les attributs du Controller. Deux booléennes servent à indiquer si le joueur
	 * gagner la partie, ou s'il perd la partie.
	 */
    private Game game;
    private int level = 1;
    private boolean levelWon = false;
    private boolean levelLost = false;
    
    /**
     * Constructeur du contrôleur 
     */
    public Controller() {
        this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
    }
    
    /**
     * 
     * @return Retourne les entités du jeu (en allant les chercher dans Game)
     */
    public List<Entity> getEntities() {
        return this.game.getEntities();
    }

    /**
     * Fonction appelée à chaque frame du jeu.
     * @param dt Delta-temps exprimé en secondes
     */
    public void tick(double dt) {
        if (this.game.isGameOver()) {
            if (this.game.hasWon()) {
                levelWon = true;
            }else{
                levelLost = true;
            }
            

        } else {
            this.game.tick(dt);
        }
    }
    
    
    /**
     * 
     * @return Retourne une booléenne qui nous dit 
     * si on a gagné le niveau
     */
    public boolean getWon(){
        return this.levelWon;
    }
    
    /**
     * Méthode qui modifie la booléenne de victoire
     */
    public void setWon(){
        levelWon = !levelWon;
    }
    
     /**
     * 
     * @return Retourne une booléenne qui nous dit 
     * si on a perdu le niveau
     */
    public boolean getLost(){
        return this.levelLost;
    }
    
    /**
     * Méthode qui modifie la booléenne de défaite
     */
    public void setLost(){
        levelLost = !levelLost;
    }
    
    /**
     * 
     * @return Retourne le niveau (Level) auquel nous sommes rendu
     */
    public Level getCurrentLevel() {
        return this.game.getLevel();
    }
    /**
     * 
     * @return Retourne le niveau auquel nous sommes rendu.
     */
    public int getLevel(){
        return this.level;
    }
    
    /**
     * Méthode pour modifier manuellement le niveau du jeu
     * @param lvl 
     */
    public void setLevel(int lvl){
        this.level = lvl;
    }
    
    /**
     * Incrémente le niveau par 1
     */
    public void upLevel(){
        this.level+=1;
    }
    /**
     * Fonction appelée lorsque la barre espace est enfoncée.
     * Appelle la méthode .jump de la classe Game
     */
    public void spaceTyped() {
        this.game.jump();
    }
    
    /**
     * Fonction qui est appelée lorsque TAB est appuyé. 
     * Appelle la méthode .invulnerable de la classe Game
     */
    public void tabTyped(){
        this.game.invulnerable();
    }
    
    /**
     * Fonction qui lance le nouveau niveau de jeu en faisant appel
     * au constructeur de Game.
     * @param level 
     */
    public void gameUpdate(int level){
        this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
    }
}
