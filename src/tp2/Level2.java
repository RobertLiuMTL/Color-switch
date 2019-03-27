//Robert Liu (865826) et Maud Moerel-Martini (20037754)//


package tp2;


/**
 * Le niveau 2 de notre jeu
 * @author Robert
 *
 */
public class Level2 extends Level {

    public Level2(double screenWidth, double screenHeight) {
        super(screenWidth, screenHeight);

        double x = screenWidth / 2;

        // Création des obstacles
        Square obstacle1 = new Square(x, 0.75 * screenHeight, 50);
        VerticalBar obstacle2 = new VerticalBar(x, 1.25 * screenHeight, 30, 80);
        GrowingCircle obstacle3 = new GrowingCircle(x, 1.6*screenHeight, 40,40);
        VerticalBar obstacle4 = new VerticalBar(x, 1.9 * screenHeight, 35, 90);
        Square obstacle5 = new Square(x, 2.2 * screenHeight, 50);
        GrowingCircle obstacle6 = new GrowingCircle(x, 2.5*screenHeight, 30,30);
        VerticalBar obstacle7 = new VerticalBar(x, 2.8 * screenHeight, 20, 60);
        Square obstacle8 = new Square(x, 3.2 * screenHeight, 35);
        RotatingCircle obstacle0=new RotatingCircle(x-screenWidth/3, 2*screenHeight,20);
        RotatingCircle obstacle9=new RotatingCircle(x-screenWidth/3, 1*screenHeight,10);
        //obstacles.add(obstacle0);
        //obstacles.add(obstacle9);
        obstacles.add(obstacle1);
        obstacles.add(obstacle2);
        obstacles.add(obstacle3);
        obstacles.add(obstacle4);
        obstacles.add(obstacle5);
        obstacles.add(obstacle6);
        obstacles.add(obstacle7);
        obstacles.add(obstacle8);


        Shield shield1 = new Shield(x, 1.1*screenHeight);
        items.add(shield1);

        victoryMushroom = new Mushroom(screenWidth / 2, 3.4 * screenHeight);
    }
}
