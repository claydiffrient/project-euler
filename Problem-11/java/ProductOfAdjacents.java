/**
 * This is a solution to Project Euler #11.
 * It is written as a JavaFX program.
 * @author Clay Diffrient
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * ProductOfAdjacents
 *
 * The main class of the program contains the logic for the graphics.
 */
public class ProductOfAdjacents
   extends Application
{
   /**
    * start
    *
    * Contains the initialization parameters to start the application.
    *
    * @param primaryStage the stage on which to start.
    */
   public void start(Stage primaryStage)
   {
      Button btn = new Button();
      btn.setText("Calculate");
      StackPane root = new StackPane();
      btn.setOnAction(new EventHandler<ActionEvent>()
                      {
                        public void handle(ActionEvent event)
                        {
                           performCalculation();
                        }
                      }
      );
      primaryStage.setTitle("Products of Adjacents");
      root.getChildren().add(btn);
      primaryStage.setScene(new Scene(root, 300, 250));
      primaryStage.show();

   }

   /**
    * performCalcuation
    *
    * Handles the calculation of the products of adjacent numbers.
    */
   public void performCalculation()
   {
      System.out.println("Called");
   }

   /**
    * Main is normally ignored in a JavaFX application.  Used for fallback.
    */
   public static void main(String[] args)
   {
      launch(args);
   }
}