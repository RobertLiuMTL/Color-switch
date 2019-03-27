//Robert Liu (865826) et Maud Moerel-Martini (20037754)//

package tp2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.javafx.geom.Rectangle;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Classe principale. Définit la vue. C'est cette classe qui est lancée initialement.
 */
public class ColorsWitch extends Application {

    public static final double WIDTH = 320, HEIGHT = 480;

    private Controller controller;
    private GraphicsContext context;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        
        //Scene1 pour l'écran d'accueil
        BorderPane root = new BorderPane();
        context = canvas.getGraphicsContext2D();
        HBox box = new HBox();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        
        //Scene 2 pour le jeu.
        Pane root2 = new Pane(canvas);
        Scene scene2 = new Scene(root2, WIDTH, HEIGHT);
        
        Text texte = new Text("Bienvenue au Beta de Color Switch!\nCeci est le menu du 5% bonus!");
        texte.setFont(Font.font(20));
        root.setTop(texte);
        
        Image img = new Image("color.jpg");
        ImageView iv = new ImageView(img);
        iv.setFitWidth(WIDTH);
        iv.setFitHeight(HEIGHT-55);
        root.setCenter(iv);
        
        //Les 4 boutons qui contrôlent le niveau du jeu
        Button bouton1 = new Button ("Niveau 1");
        bouton1.setOnAction((event)->{
        	controller.setLevel(1);
        	try {

        		primaryStage.setScene(scene2);
				niveauNormal (primaryStage, scene2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        Button bouton2 = new Button ("Niveau 2");
        bouton2.setOnAction((event)->{
        	try {

        		controller.setLevel(2);
        		primaryStage.setScene(scene2);

				niveauNormal (primaryStage, scene2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        Button bouton3 = new Button ("Niveau 3");
        bouton3.setOnAction((event)->{
        	try {

        		primaryStage.setScene(scene2);

        		controller.setLevel(3);
				niveauNormal (primaryStage, scene2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        Button bouton4 = new Button ("Niveau 4");
        bouton4.setOnAction((event)->{
        	try {

        		primaryStage.setScene(scene2);

        		controller.setLevel(4);
				niveauNormal (primaryStage, scene2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        
        box.setSpacing(10);
        box.setPrefWidth(WIDTH);
        box.setPrefHeight(HEIGHT);
        box.setTranslateY(-20);
        box.setTranslateX(20);
        box.getChildren().addAll(bouton1,bouton2,bouton3,bouton4);
        root.setBottom(box);
        
       
        
        scene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case ESCAPE:
                    System.exit(1);
                    break;
            }
        });

        primaryStage.setTitle("Colors Witch");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * Puisque nous avons un menu initial créé par START, 
     * la méthode niveauNormal permet de construire le niveau normal du jeu
     * @param primaryStage
     * @param scene
     * @throws Exception
     */
    public void niveauNormal (Stage primaryStage, Scene scene) throws Exception{
    	scene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case SPACE:
                    controller.spaceTyped();
                    break;

                case TAB:
                    controller.tabTyped();
                    break;

                case ESCAPE:
                    System.exit(1);
                    break;
            }
        });

        /**
         * L'animation timer qui permet de faire animer le jeu. À chaque appel,
         * on lance un tick au Controller. Si la booléenne de victoire est à
         * TRUE, on lance la fonction niveauWon (écran de victoire). Sinon, on
         * dessine toutes les entités
         */
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = System.nanoTime();

            @Override
            public void handle(long now) {
                controller.tick((now - lastTime) * 1e-9);

                context.setFill(Color.BLACK);
                context.fillRect(0, 0, WIDTH, HEIGHT);
                if (controller.getWon() == true) {
                    try {
                        controller.setWon();
                        niveauWon(primaryStage, scene);
                    } catch (Exception ex) {
                        Logger.getLogger(ColorsWitch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (controller.getLost()==true){
                    controller.setLost();
                    try {
                        niveauLost (primaryStage,scene);
                    } catch (Exception ex) {
                        Logger.getLogger(ColorsWitch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                
                } else {

                    List<Entity> entities = controller.getEntities();

                    for (Entity e : entities) {
                        e.getRepresentation().draw(controller.getCurrentLevel(), context);
                    }
                }

                lastTime = now;
            }
        };
        timer.start();
        controller.gameUpdate(controller.getLevel());
    }
    
    /**
     * Méthode qui permet de créer l'écran de victoire!
     *
     * @param primaryStage
     * @param original : Prend en paramètre la Scène originale.
     * @throws Exception
     */
    public void niveauWon(Stage primaryStage, Scene original) throws Exception {
        BorderPane root = new BorderPane();
        root.maxWidthProperty().setValue(WIDTH);
        root.maxHeightProperty().set(HEIGHT);
        Text text = new Text();
        
        //Selon le niveau de jeu, le message affiché va changer.
        if (controller.getLevel()==4) {
        	text.setText("Bravo! Vous avez complété le jeu!!");
        }else {
        	text.setText("Bravo! Vous avez complété le niveau " + controller.getLevel());
        }
        text.setFont(Font.font(20));
        text.wrappingWidthProperty().set(WIDTH - 20);
        text.setTranslateX(10);
        root.setTop(text);

        Text text2 = new Text("Pour poursuivre, appuyez sur TAB.\nPour quitter, appuyez sur ESC");
        text2.wrappingWidthProperty().set(WIDTH);
        text2.setTranslateX(40);
        root.setBottom(text2);

        Image happy = new Image("happy.jpeg");
        ImageView iv = new ImageView(happy);
        root.setCenter(iv);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case TAB:
                    if (controller.getLevel() ==  4){
                        controller.setLevel(1);
                        controller.gameUpdate(controller.getLevel());
                        primaryStage.setScene(original);
                        break;
                    }else{
                        controller.upLevel();

                        controller.gameUpdate(controller.getLevel());
                        primaryStage.setScene(original);
                        break;
                    }

                case ESCAPE:
                    System.exit(1);
                    break;
            }
        });
        primaryStage.setScene(scene);
    }

    /**
     * Fonction qui permet de créer l'écran de défaite
     *
     * @param primaryStage
     * @param original
     * @throws Exception
     */
    public void niveauLost(Stage primaryStage, Scene original) throws Exception {
        BorderPane root = new BorderPane();
        root.maxWidthProperty().setValue(WIDTH);
        root.maxHeightProperty().set(HEIGHT);
        Text text = new Text("Vous avez échoué le niveau " + controller.getLevel());
        text.setFont(Font.font(20));
        text.wrappingWidthProperty().set(WIDTH - 20);
        text.setTranslateX(10);
        root.setTop(text);

        Text text2 = new Text("Pour recommencer, appuyez sur TAB.\nPour quitter, appuyez sur ESC");
        text2.wrappingWidthProperty().set(WIDTH);
        text2.setTranslateX(40);
        root.setBottom(text2);

        Image haha = new Image("haha.jpg");
        ImageView iv = new ImageView(haha);
        root.setCenter(iv);
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        scene.setOnKeyPressed((event) -> {
            switch (event.getCode()) {
                case TAB:
                    controller.gameUpdate(controller.getLevel());
                    primaryStage.setScene(original);
                    break;

                case ESCAPE:
                    System.exit(1);
                    break;
            }
        });
        primaryStage.setScene(scene);
    }

}
