import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.util.List;
import java.util.ArrayList;

/**
 * ProductOfMatrixDiagonals
 *
 * Solution to Project Euler #11
 *
 * The product of diagonals in a matrix of numbers.
 * Returns the greatest of them.
 * Graphical Interface is used.
 * Singleton design pattern.
 *
 *
 * @author Clay Diffrient
 */
public class ProductOfMatrixDiagonals
   extends JFrame
{
   /**
    * Singleton static variable.
    */
   private static ProductOfMatrixDiagonals cInstance =
                              new ProductOfMatrixDiagonals();

   /**
    * Singleton instance getter.
    */
   public static ProductOfMatrixDiagonals getInstance()
   {
      return cInstance;
   }

   /**
    * Container for the number of rows in the Matrix
    */
   JTextField mNumRows = new JTextField(10);

   /**
    * Container for the diagonal length.
    */
   JTextField mDiagonalLength = new JTextField(10);

   /**
    * Panel to hold added text fields.
    */
   JPanel mTextFields = new JPanel();

   /**
    * List containing text fields for the rows.
    */
   List<JTextField> mRows;

   /**
    * List that holds the matrix.
    */
   Matrix<Integer> mMatrix;

   /**
    * Largest product
    */
   int mLargestProduct;

   /**
    * Private constructor
    */
   private ProductOfMatrixDiagonals()
   {
      setTitle("Product Of Matrix Diagonals - Euler #11");
      setFont(new Font("Times", 1, 30));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(400, 200);
      setSize(350,350);
      setResizable(true);
      setLayout(new BorderLayout(5,5));
      mTextFields.setLayout(new BoxLayout(mTextFields, BoxLayout.PAGE_AXIS));
      mRows = new ArrayList<JTextField>();
      mMatrix = new Matrix<Integer>();

      JPanel leftPanel = new JPanel(new GridLayout(3,3));
      JButton findButton = new JButton("Find Greatest Product");
      leftPanel.add(new JLabel("Length of diagonals:"));
      leftPanel.add(mDiagonalLength);
      leftPanel.add(new JLabel("Number of Rows:"));
      leftPanel.add(mNumRows);
      leftPanel.add(findButton);
      final JLabel instructions = new JLabel("Seperate digits by a single space.");
      instructions.setVisible(false);
      leftPanel.add(instructions);
      add(leftPanel, BorderLayout.LINE_START);
      JScrollPane tempScroll = new JScrollPane(mTextFields);
      tempScroll.setPreferredSize(new Dimension(200,200));
      add(tempScroll, BorderLayout.CENTER);

      mNumRows.addFocusListener(new FocusListener()
      {
         public void focusLost(FocusEvent e)
         {
            mTextFields.removeAll();
            mRows.clear();
            int numRows = Integer.parseInt(mNumRows.getText());
            for (int i = 0; i < numRows; i++)
            {
               JTextField temp = new JTextField(10);
               mRows.add(temp);
               mTextFields.add(temp);
            }
            instructions.setVisible(true);
            mTextFields.validate();
            mTextFields.repaint();
            pack();
         }

         public void focusGained(FocusEvent e)
         {
         }

      });

      findButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            mLargestProduct = 0;
            //Do things here.
            displayMatrix();
            /*JOptionPane.showMessageDialog(null, mLargestProduct,
                    "The greatest product of a " + mDiagonalLength +
                    " digit diagonal is...",
                    JOptionPane.INFORMATION_MESSAGE);*/
         }
      });

   }

   private ArrayList<Integer> getRowList(String pRow)
   {
      ArrayList<Integer> list = new ArrayList<Integer>();
      String[] strings = pRow.split(" ");
      for (String string : strings )
      {
         list.add(Integer.parseInt(string));
      }
      return list;
   }

   private void createMatrix()
   {
      for (int i = 0; i < mRows.size(); i++)
      {
         ArrayList<Integer> temp = getRowList(mRows.get(i).getText());
         for (int j = 0; j < temp.size() ; j++ )
         {
            mMatrix.add(temp.get(j), i);
         }
      }
   }

   public void displayMatrix()
   {
      for (int r = 0; r < mMatrix.getNumRows(); r++)
      {
         for (int c = 0; c < mMatrix.getNumCols(r); c++)
         {
            System.out.print(mMatrix.get(r,c) + " ");
         }
         System.out.print("\n");
      }
   }


   /**
    * Main method.
    */
   public static void main(String[] args)
   {
      ProductOfMatrixDiagonals.getInstance().setVisible(true);
   }
}
