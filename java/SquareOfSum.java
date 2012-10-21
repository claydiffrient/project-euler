/**
 * SquareOfSum
 *
 * Adds all the numbers up to the provided limit, then squares it.
 * Such as:
 *    (a + b + c + d + ... + limit)^2 = sum
 * Part of the solution to Project Euler #6.
 *
 * @author Clay Diffrient
 */

public class SquareOfSum
   implements Runnable
{

   /**
    * The total sum.
    */
   private int mSquare = 0;

   /**
    * The limit of the highest number to calculate.
    */
   private int mLimit = 1;

   /**
    * Constructor requiring an integer
    *
    * @param pLimit the highest number to calculate the sum of squares for.
    */
   public SquareOfSum(int pLimit)
   {
      mLimit = pLimit;
   }

   /**
    * getSum
    *
    * Returns the sum
    */
   public int getSquare()
   {
      return mSquare;
   }

   /**
    * Starts a thread running which creates the sum of the squares.
    */
   public void run()
   {
      int sum = 0;
      for (int i = 0; i <= mLimit; i++)
      {
        sum += i;
      }
      mSquare = (int) Math.pow(sum, 2);
   }
}