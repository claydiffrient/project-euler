import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ProductOfDigits
 *
 * Solution to Project Euler #8
 *
 * The product of consecutive digits in a large number.
 * Returns the greatest of them.
 * Graphical Interface is used.
 * Singleton design pattern.
 *
 * Successfully works with the 1000-digit number:
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 *
 * with 5 digits in each product.
 *
 * @author Clay Diffrient
 */
public class ProductOfDigits
   extends JFrame
{
   /**
    * Singleton static variable.
    */
   private static ProductOfDigits cInstance = new ProductOfDigits();

   /**
    * Singleton instance getter.
    */
   public static ProductOfDigits getInstance()
   {
      return cInstance;
   }

   /**
    * Container for the number of digits to multiply together.
    */
   JTextField mNumFactors = new JTextField(10);

   /**
    * Container for the Prime to find
    */
   JTextArea mLargeInteger = new JTextArea(10,30);

   /**
    * Largest product
    */
   int mLargestProduct;

   /**
    * Private constructor
    */
   private ProductOfDigits()
   {
      setTitle("Product Of Digits - Euler #8");
      setFont(new Font("Times", 1, 30));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(400, 200);
      setSize(350,350);
      setResizable(false);
      setLayout(new FlowLayout());
      add(new JLabel("Number of consecutive factors:"));
      add(mNumFactors);
      add(new JLabel("Large Integer:"));
      add(new JScrollPane(mLargeInteger));
      JButton findButton = new JButton("Find Greatest Product");
      findButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            mLargestProduct = 0;
            String numberAsString = mLargeInteger.getText();
            numberAsString.replaceAll(System.getProperty("line.separator"), "");
            int value = Integer.parseInt(mNumFactors.getText());
            NumericQueue numbers = new NumericQueue(value);
            for (int i = 0; i < numberAsString.length(); i++)
            {
               numbers.add(Character.getNumericValue(numberAsString.charAt(i)));
            }
            while (!numbers.lastFound())
            {
               int[] anArray = numbers.getRange(true);
               int product = 1;
               for (int i = 0; i < anArray.length; i++)
               {
                  product = anArray[i] * product;
               }
               if (product > mLargestProduct)
               {
                  mLargestProduct = product;
               }
            }
            //One final time to make sure the last numbers are calculated
            int[] anArray = numbers.getRange(false);
            int product = 1;
            for (int i = 0; i < anArray.length; i++)
            {
               product = anArray[i] * product;
            }
            if (product > mLargestProduct)
            {
               mLargestProduct = product;
            }
            JOptionPane.showMessageDialog(null, mLargestProduct,
                    "The greatest product of " + value + " digits is...",
                    JOptionPane.INFORMATION_MESSAGE);
         }
      });
      add(findButton);
   }


   /**
    * Main method.
    */
   public static void main(String[] args)
   {
      ProductOfDigits.getInstance().setVisible(true);
   }
}
