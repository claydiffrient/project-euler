import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
 * FindAPrime
 *
 * Finds a prime based on given input.
 * Graphical Interface is used.
 * Singleton design pattern.
 *
 * @author Clay Diffrient
 */
public class FindAPrime
   extends JFrame
{
   /**
    * Singleton static variable.
    */
   private static FindAPrime cInstance = new FindAPrime();

   /**
    * Singleton instance getter.
    */
   public static FindAPrime getInstance()
   {
      return cInstance;
   }

   /**
    * Container for the Max number
    */
   JTextField mMaxNumber = new JTextField(10);

   /**
    * Container for the Prime to find
    */
   JTextField mPrimeToFind = new JTextField(10);

   /**
    * Private constructor
    */
   private FindAPrime()
   {
      setTitle("Find a Prime - Euler #7");
      setFont(new Font("Times", 1, 30));
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocation(400, 200);
      setSize(400,400);
      setLayout(new FlowLayout());
      add(new JLabel("Maximum Number:"));
      add(mMaxNumber);
      add(new JLabel("Prime to find:"));
      add(mPrimeToFind);
   }

   /**
    * Main method.
    */
   public static void main(String[] args)
   {
      FindAPrime.getInstance().setVisible(true);
   }
}
