/**
 * Solution to Project Euler #29
 */

//import java.math.BigInteger;

public class DigitFactorial
   implements Runnable
{
   int mUpperLimit;
   int[] mFactorialResults;

   public DigitFactorial(int pUpper)
   {
      mUpperLimit = pUpper;
      mFactorialResults = new int[20];
   }

   private int getFactorial(int pNum)
   {
      if ((pNum == 0) || (pNum == 1))
      {
         return 1;
      }
      if (mFactorialResults[pNum] > 0)
      {
         return mFactorialResults[pNum];
      }
      else
      {
         return mFactorialResults[pNum] = getFactorial(pNum - 1) * pNum;
      }
   }

   private boolean isFactorialSum(int pNum)
   {
      String number = String.valueOf(pNum);
      int sum = 0;
      for (int i = 0; i < number.length(); i++)
      {
         sum += getFactorial(Character.getNumericValue(number.charAt(i)));
      }
      if (sum == pNum)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   public void run()
   {
      int sum = 0;
      for (int i = 3; i < mUpperLimit; i++)
      {
         if (isFactorialSum(i))
         {
            sum += i;
         }
      }
      System.out.println("Sum from 3 to " + mUpperLimit + " = " + sum);
   }

   public static void main(String[] args)
   {
      try
      {
         new DigitFactorial(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid input." + e.getMessage());
      }
   }
}