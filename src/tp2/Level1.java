//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;

/**
 * Le niveau 1 de notre jeu
 * @author Robert
 *
 */
public class Level1 extends Level {

    public Level1(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        
        VerticalBar obstacle1 = new VerticalBar(x, .7 * screenHeight, 30, 90);
        VerticalBar obstacle3 = new VerticalBar(x, 1.5 * screenHeight, 45, 100);
        VerticalBar obstacle5 = new VerticalBar(x, 2.3 * screenHeight, 25, 80);
        VerticalBar obstacle6 = new VerticalBar(x, 2.5 * screenHeight, 22, 75);
        Square obstacle2 = new Square(x, 1 * screenHeight, 40);
        Square obstacle4 = new Square(x, 2 * screenHeight, 55);
        RotatingCircle obstacle0=new RotatingCircle(x-screenWidth/3, 2*screenHeight,15);
        //obstacles.add(obstacle0);
        
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);

        // Création des items
        Potion potion1 = new Potion(x, 1.75 * screenHeight);

        items.add(potion1);

        victoryMushroom = new Mushroom(screenWidth / 2, 2.75 * screenHeight);
    }
}
