import java.math.BigInteger; /**
 * LowestDividend
 *
 * A solution to Project Euler problem #5.
 * The actual problem get solvd in about 2 seconds using the following
 * command:
 * LowestDividend 20 1000000000
 *
 * @author Clay Diffrient
 */ public class LowestDividend
    implements Runnable {
   int mUpperLimit = 1;
   int mHighest = 100;
   /**
     * Constructor with a string.
     *
     * @param pDivideByLimit the limit to try from 1 to this number
     * @param pHighest the highest number to try.
     */
   public LowestDividend(String pDivideByLimit, String pHighest)
   {
      mUpperLimit = Integer.parseInt(pDivideByLimit);
      mHighest = Integer.parseInt(pHighest);
   }
   /**
    * Constructor with an integer
    *
    * @param pInteger the integer to use as the upper limit on divisors.
    * @param pUpper the highest value to try.
    */
   public LowestDividend(int pInteger, int pUpper)
   {
      mUpperLimit = pInteger;
      mHighest = pUpper;
   }
   /**
    * checkEvenDivisibility
    *
    * Checks to see if the number is divisible by all numbers 2 to a.
    * It skips 1 because all numbers are divisible by 1.
    *
    * @param pInt the number that you wish to check.
    *
    * @return boolean true if the number is evenly divisible by all values
    */
   private boolean checkEvenDivisibility(int pInt)
   {
      int i = 2;
      boolean returnValue = true;
      while (i < mUpperLimit)
      {
         if (pInt % i != 0)
         {
            returnValue = false;
            break;
         }
         i++;
      }
      return returnValue;
   }
   /**
     * run
     *
     * Creates a thread running with everything happening.
     */
   public void run()
   {
      int lowest = 0;
      for (int i = 2; i < mHighest; i++)
      {
         if (checkEvenDivisibility(i))
         {
            lowest = i;
            break;
         }
      }
      System.out.println(lowest);
   }
    /**
      * Calls the run method of LowestDividend.
      */
    public static void main(String[] args)
    {
      try
      {
         new LowestDividend(args[0], args[1]).run();
      }
      catch (Exception e)
      {
          System.out.println("Error with arguments.");
          System.out.println("Usage: LowestDividend a b");
          System.out.println("a = upper limit for divsibility");
          System.out.println("b = the highest number to check");
          System.out.println("Find the lowest number divisible by all 1 to a.");
          System.exit(1);
      }
    }
}
