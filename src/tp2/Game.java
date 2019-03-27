//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

import java.util.ArrayList;
import java.util.List;


/**
 * La classe Game contient une partie de la logique du jeu. D'ailleurs, plusieurs de ses méthodes seront 
 * sollicitées par la classe Controller tout au long du jeu.
 * @author Robert
 *
 */
public class Game {
	
	//Garde en attributs Level et Player. Ce qui va nous permettre de les manipuler
    private Level level;
    private Player player;

    /**
     * Dimensions de l'écran
     */
    private double screenWidth, screenHeight;

    /**
     * Indique si la partie est terminée/gagnée
     */
    private boolean gameOver = false;
    private boolean hasWon = false;
    

    /**
     * Crée une partie dans le niveau levelNumber.
     *
     * @param screenWidth largeur de l'écran
     * @param screenHeight hauteur de l'écran
     * @param levelNumber numéro du niveau
     */
    public Game(double screenWidth, double screenHeight, int levelNumber) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        player = new Player(screenWidth / 2, 200, 15);

        switch (levelNumber) {
            case 1:
                level = new Level1(screenWidth, screenHeight);
                break;
            case 2:
                level = new Level2(screenWidth, screenHeight);
                break;
            case 3:
                level = new Level3(screenWidth, screenHeight);
                break;
            case 4:
                level = new Level4(screenWidth, screenHeight);
                break;
            default:
                throw new IllegalArgumentException("Niveau inconnu");
        }
    }

    /**
     * Fonction appelée à chaque frame
     *
     * @param dt Delta-Temps (en secondes)
     */
    public void tick(double dt) {
        level.tick(dt);
        player.tick(dt);

        if (player.getY() - player.getRadius() < level.getScroll()) {
            // Empêche la balle de sortir de l'écran
            player.setY(level.getScroll() + player.getRadius());
        } else if (player.getY() - level.getScroll() > screenHeight / 2) {
            // Scroll le level verticalement si nécessaire
            level.incrementScroll(player.getY() - level.getScroll() - screenHeight / 2);
        }

        // Gestion des collisions avec les éléments (items/obstacles/...) du niveau
        for (LevelElement element : level.getEntities()) {
            if (element.intersects(player)) {
                element.handleCollision(player, this);
            }
        }
    }

    /**
     * @return les entités à afficher à l'écran
     */
    public List<Entity> getEntities() {
        List<Entity> entities = new ArrayList<>();

        entities.addAll(level.getEntities());
        entities.add(player);

        return entities;
    }
    
    /**
     * 
     * @return Retourne le Level
     */
    public Level getLevel() {
        return level;
    }
    
    /**
     * Appelle la méthode .jump() de Player.
     */
    public void jump() {
        player.jump();
    }
    
    /**
     * Active le mode test (Invulnérabilité)
     */
    public void invulnerable(){
        player.cheat();
    }
    
    /**
     * Modifie la booléenne sur l'état de la partie (partie perdue)
     */
    public void loose() {
        System.out.println("You lose... Too bad !");
        this.gameOver = true;
    }
    
    /**
     * Modifie la booléenne sur l'état de la partie (partie gagnée)
     */
    public void win() {
        System.out.println("You win !");
        this.hasWon = true;
        this.gameOver = true;
    }

    /**
     *
     * @return Retourne la booléenne sur l'état de victoire
     */
    public boolean hasWon() {
        return hasWon;
    }

    /**
     * Indique si la partie est terminée
     *
     * @return Retourne la booléenne sur si le joueur a perdu.
     */
    public boolean isGameOver() {
        return gameOver;
    }
}
