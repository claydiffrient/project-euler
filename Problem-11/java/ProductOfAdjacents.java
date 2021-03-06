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
import javafx.collections.ObservableList;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ProductOfAdjacents
 *
 * The main class of the program contains the logic for the graphics.
 */
public class ProductOfAdjacents
   extends Application
{

   /**
    * Holds text from the entry box.
    */
   ObservableList<CharSequence> mText;

   /**
    * Holds the text area.
    */
   TextArea mMatrixArea = new TextArea();

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

      primaryStage.setTitle("Products of Adjacents");

      root.setTop(new Text("Sum Adjacents"));
      root.setBottom(generateButtonPanel());
      root.setCenter(mMatrixArea);
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
      //TODO: Clean all this up some
      mText = mMatrixArea.getParagraphs();
      Matrix input = new Matrix<Integer>();
      Iterator<CharSequence> myIterator = mText.iterator();
      List<String> stringValues = new ArrayList<String>();
      while (myIterator.hasNext())
      {
         stringValues.add(myIterator.next().toString());
      }
      Iterator<String> stringIterator = stringValues.iterator();
      ArrayList<String[]> stringArrays = new ArrayList<String[]>();
      while (stringIterator.hasNext())
      {
         stringArrays.add(splitToArray(stringIterator.next()));
      }
      Iterator<String[]> saIterator = stringArrays.iterator();
      int counter = 0;
      while (saIterator.hasNext())
      {
         String[] row = saIterator.next();
         for (int i = 0; i < row.length; i++)
         {
            input.add(Integer.parseInt(row[i]), counter);
         }
         counter++;
      }
      input.display();
      //TODO: Fix the getNumCols so that it doesn't use a constant.
      System.out.println(input.getNumRows() + "x" + input.getNumCols(1));

   }

   /**
    * splitToArray
    *
    * Will split a string into an Array based on spaces.
    *
    * @param string - The string to split.
    * @return String[]
    */
   private String[] splitToArray(String string)
   {
      return string.split(" ");
   }

   /**
    * combineStringArrays
    *
    * Combines an arbitrary amount of String Arrays into one String Array
    *
    * @param first - The first String[]
    * @param rest - a variable amount of String[] to concatenate
    * @return String[]
    */
   public String[] combineStringArrays(String[] first, String[]... rest)
   {
      int totalLength = first.length;
      for (String[] array : rest )
      {
         totalLength += array.length;
      }
      String[] result = Arrays.copyOf(first, totalLength);
      int offset = first.length;
      for (String[] array : rest )
      {
         System.arraycopy(array, 0, result, offset, array.length);
         offset += array.length;
      }
      return result;
   }

   /**
    * Main is normally ignored in a JavaFX application.  Used for fallback.
    */
   public static void main(String[] args)
   {
      launch(args);
   }
}