/**
 * Solution to Euler #56
 */

import java.math.BigInteger;

public class DigitSum
   implements Runnable
{
   int mLimit;
   int mMaxSum;

   public DigitSum(int pLimit)
   {
      mLimit = pLimit;
      mMaxSum = 0;
   }

   public int getDigitSum(BigInteger pInt)
   {
      int sum = 0;
      String string = pInt.toString();
      for (int i = 0; i < string.length(); i++)
      {
         sum += Character.getNumericValue(string.charAt(i));
      }
      return sum;
   }

   public void run()
   {
      for (int a = 0; a < mLimit; a++)
      {
         System.out.println("A=" + a);
         BigInteger aBig = new BigInteger(String.valueOf(a));
         for (int b = 0; b < mLimit; b++)
         {
            System.out.println("B=" + b);
            int value = getDigitSum(aBig.pow(b));
            if (value > mMaxSum)
            {
               mMaxSum = value;
            }
         }
      }
      System.out.println("Max digital sum is: " + mMaxSum);
   }

   public static void main(String[] args)
   {
      try
      {
         new DigitSum(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Error");
      }
   }
}