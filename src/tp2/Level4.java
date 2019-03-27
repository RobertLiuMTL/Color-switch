//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;

/**
 * Le niveau 4 de notre jeu
 * @author Robert
 *
 */
public class Level4 extends Level {

    public Level4(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        VerticalBar obstacle1 = new VerticalBar(x, 0.75 * screenHeight, 17, 40);
        GrowingCircle obstacle2 = new GrowingCircle(x, 1.1 * screenHeight, 30, 35);
        VerticalBar obstacle3 = new VerticalBar(x, 1.5 * screenHeight, 8,45);
        VerticalBar obstacle4 = new VerticalBar(x, 1.8 * screenHeight, 10,60);
        GrowingCircle obstacle5 = new GrowingCircle(x, 2.1 * screenHeight, 35, 37);
        GrowingCircle obstacle6 = new GrowingCircle(x, 2.6 * screenHeight, 22, 22);
        VerticalBar obstacle7 = new VerticalBar(x, 2.9 * screenHeight, 5,40);
        GrowingCircle obstacle8 = new GrowingCircle(x, 3.45 * screenHeight, 36, 42);
        VerticalBar obstacle9 = new VerticalBar(x, 4 * screenHeight, 9,55);
        GrowingCircle obstacle10 = new GrowingCircle(x, 4.4 * screenHeight, 32, 34);
        GrowingCircle obstacle11 = new GrowingCircle(x, 4.9 * screenHeight, 15, 15);

        RotatingCircle obstacle12=new RotatingCircle(x-screenWidth/3.5, 4.10*screenHeight,10);
        

        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);
        obstacles.add(obstacle9);
        obstacles.add(obstacle10);
        obstacles.add(obstacle11);
        obstacles.add(obstacle12);

        // Création des items
        Potion potion1 = new Potion(x, 3.1 * screenHeight);
        Potion potion2 = new Potion(x, 3.8 * screenHeight);
        Shield shield1 = new Shield(x, .75*screenHeight);

        items.add(potion1);
        items.add(potion2);
        items.add(shield1);

        victoryMushroom = new Mushroom(screenWidth / 2, 4.9 * screenHeight);
    }
}
