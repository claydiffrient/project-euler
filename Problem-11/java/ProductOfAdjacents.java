/**
 * This is a solution to Project Euler #11.
 * It is written as a JavaFX program.
 * @author Clay Diffrient
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

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

      BorderPane root = new BorderPane();

      TextArea matrixEntry = new TextArea();
      primaryStage.setTitle("Products of Adjacents");

      root.setTop(new Text("Sum Adjacents"));
      root.setBottom(generateButtonPanel());
      root.setCenter(matrixEntry);
      primaryStage.setScene(new Scene(root, 300, 250));
      primaryStage.show();

   }

   /**
    * generateTitleSection
    *
    * Creates the title/instruction section for the UI
    *
    * @return HBox
    */
   private HBox generateTitleSection()
   {
      HBox titleSection = new HBox(10);
      Text title = new Text("Product of Adjacents");
      title.setFont(Font.font("Verdana", 40));
      titleSection.getChildren().addAll(title);
      return titleSection;
   }

   /**
    * generateButtonPanel
    *
    * Creates the button panel needed for the the UI.
    *
    * @return HBox
    */
   private HBox generateButtonPanel()
   {
      Button calcBtn = new Button();
      calcBtn.setText("Calculate");
      calcBtn.setOnAction(new EventHandler<ActionEvent>()
                      {
                        public void handle(ActionEvent event)
                        {
                           performCalculation();
                        }
                      }
      );
      Button exitBtn = new Button("Exit");
      exitBtn.setOnAction(new EventHandler<ActionEvent>()
                     {
                        public void handle(ActionEvent event)
                        {
                           System.exit(1);
                        }
                     });
      HBox bottomPanel = new HBox(10);
      bottomPanel.getChildren().addAll(calcBtn, exitBtn);
      bottomPanel.setAlignment(Pos.CENTER);
      return bottomPanel;
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