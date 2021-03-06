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
 * Solution to Project Euler #7  Correct Answer found using
 * 200,000 as the maximum and 10,001 as the searched for value.
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
      setSize(200,200);
      setLayout(new FlowLayout());
      add(new JLabel("Maximum Number:"));
      add(mMaxNumber);
      add(new JLabel("Prime to find:"));
      add(mPrimeToFind);
      JButton findPrimeButton = new JButton("Find Prime");
      findPrimeButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            Sieve primeGen =
               new Sieve(mMaxNumber.getText(), mPrimeToFind.getText());
            primeGen.run();
            JOptionPane.showMessageDialog(null, primeGen.getResult(),
                                          "The " + mPrimeToFind.getText() +
                                          "th prime is...",
                                          JOptionPane.INFORMATION_MESSAGE);
         }
      });
      add(findPrimeButton);
   }

   /**
    * Main method.
    */
   public static void main(String[] args)
   {
      FindAPrime.getInstance().setVisible(true);
   }
}
