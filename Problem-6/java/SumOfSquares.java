/**
 * SumOfSquares
 *
 * Adds all the squares of a number up to the provided limit.
 * Such as:
 *    a^2 + b^2 + c^2 + d^2 + ... + limit^2 = sum
 * Part of the solution to Project Euler #6.
 *
 * @author Clay Diffrient
 */

public class SumOfSquares
   implements Runnable
{

   /**
    * The total sum.
    */
   private int mSum = 0;

   /**
    * The limit of the highest number to calculate.
    */
   private int mLimit = 1;

   /**
    * Constructor requiring an integer
    *
    * @param pLimit the highest number to calculate the sum of squares for.
    */
   public SumOfSquares(int pLimit)
   {
      mLimit = pLimit;
   }

   /**
    * getSum
    *
    * Returns the sum
    */
   public int getSum()
   {
      return mSum;
   }

   /**
    * Starts a thread running which creates the sum of the squares.
    */
   public void run()
   {
      for (int i = 0; i <= mLimit; i++)
      {
         mSum += Math.pow(i, 2);
      }
   }
}
