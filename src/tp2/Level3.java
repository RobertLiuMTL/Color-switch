//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

/**
 * Le niveau 3 de notre jeu
 * @author Robert
 *
 */
public class Level3 extends Level {

    public Level3(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        GrowingCircle obstacle1 = new GrowingCircle(x, 0.75 * screenHeight, 45, 44);
        Square obstacle2 = new Square(x, 1.3 * screenHeight, 40);
        GrowingCircle obstacle3 = new GrowingCircle(x, 1.75 * screenHeight, 40, 42);
        Square obstacle4 = new Square(x, 2.3 * screenHeight, 35);
        VerticalBar obstacle5 = new VerticalBar(x, 2.5 * screenHeight, 30, 80);
        Square obstacle6 = new Square(x, 2.9*screenHeight, 37);
        VerticalBar obstacle7 = new VerticalBar(x, 3.2 * screenHeight, 20, 60);
        GrowingCircle obstacle8 = new GrowingCircle(x, 3.8 * screenHeight, 35, 37);
        GrowingCircle obstacle9 = new GrowingCircle(x, 4.3 * screenHeight, 38, 35);


        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);

        // Création des items
        Potion potion1 = new Potion(x, 2.1   * screenHeight);
        Potion potion2 = new Potion(x, 3.45 * screenHeight);

        items.add(potion1);
        items.add(potion2);

        victoryMushroom = new Mushroom(screenWidth / 2, 4.7 * screenHeight);
    }
}
