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
      findPrimeButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {

         }
      });
      add(findButton);
   }

   p

   /**
    * Main method.
    */
   public static void main(String[] args)
   {
      ProductOfDigits.getInstance().setVisible(true);
   }
}
