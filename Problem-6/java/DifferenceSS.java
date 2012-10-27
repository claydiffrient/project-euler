/**
 * DifferenceSS
 *
 * A solution to Project Euler #6.  Finds the Difference between the sum of the
 * squares and the square of the sum.
 * Such as:
 *    (a^2 + b^2 + c^2 + ... + limit^2 ) - (a + b + c + ... + limit)^2 = diff
 *
 * @author Clay Diffrient
 */

public class DifferenceSS
   implements Runnable
{
   /**
    * The object containing the Square of the Sum
    */
   SquareOfSum mSquareSum = null;
   /**
    * The object containing the Sum of the Squares
    */
   SumOfSquares mSumSquare = null;

   /**
    * Constructor taking a commandline argument string
    *
    * @param an integer to use as the max.
    */
   public DifferenceSS(String arg)
   {
      mSumSquare = new SumOfSquares(Integer.parseInt(arg));
      mSquareSum = new SquareOfSum(Integer.parseInt(arg));
   }

   private int calculateDifference()
   {
      return mSquareSum.getSquare() - mSumSquare.getSum();
   }

   public void run()
   {
      mSumSquare.run();
      mSquareSum.run();
      System.out.println("The difference is:" + calculateDifference());
   }

   /**
    * Runs the calcuations
    */
   public static void main(String[] args)
   {
      try
      {
         new DifferenceSS(args[0]).run();
      }
      catch (Exception e)
      {
         System.out.println("Error with arguments.");
         System.out.println("Usage: DifferenceSS a");
         System.out.println("a = upper limit for summations");
         System.exit(1);
      }
   }

}