/**
 * Solution to Project Euler #25
 * FibDigits
 */

import java.math.BigInteger;

public class FibDigits
   implements Runnable
{
   int mNumDigits;
   BigInteger mFirstTerm;
   BigInteger mSecondTerm;
   BigInteger mNextTerm;

   public FibDigits(int pNum)
   {
      mFirstTerm = BigInteger.ONE;
      mSecondTerm = BigInteger.ONE;
      mNextTerm = BigInteger.ZERO;
      mNumDigits = pNum;
   }

   private boolean isLength(BigInteger pNumber)
   {
      String s = pNumber.toString();
      if (s.length() == mNumDigits)
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
      int termCount = 2;
      while (!isLength(mNextTerm))
      {
         mNextTerm = mFirstTerm.add(mSecondTerm);
         mFirstTerm = mSecondTerm;
         mSecondTerm = mNextTerm;
         termCount++;
      }
      System.out.println(termCount);
   }

   public static void main(String[] args)
   {
      try
      {
         new FibDigits(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
      }
   }
}