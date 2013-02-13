/**
 * Solution to Euler #164
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigInteger;

public class ConsecutiveSums
   implements Runnable
{
   int mSumLimit;
   int mNumConsec;
   int mNumDigits;
   long[][][] mCount;

   public ConsecutiveSums(int pSumLimit, int pConsec, int pNumDigits)
   {
      mSumLimit = pSumLimit;
      mNumConsec = pConsec;
      mNumDigits = pNumDigits;
      mCount = new long[10][10][mNumDigits];
   }

   long getLowerRange()
   {
      String start = "1";
      for (int i = 0; i < mNumDigits - 1; i++)
      {
         start += "0";
      }
      return Long.parseLong(start);
   }

   long getUpperRange()
   {
      String start = "9";
      for (int i = 0; i < mNumDigits - 1; i++)
      {
         start += "9";
      }
      return Long.parseLong(start);
   }

   private long getCount(int pDOne, int pDTwo, int pRemain)
   {
      if (pRemain == 0)
      {
         return 1;
      }
      else
      {
         if (mCount[pDOne][pDTwo][pRemain] == 0)
         {
            for (int i = 0; i <= mSumLimit - (pDOne+pDTwo); i++)
            {
               mCount[pDOne][pDTwo][pRemain] += getCount(pDTwo, i, pRemain - 1);
            }
         }
         return mCount[pDOne][pDTwo][pRemain];
      }
   }

   public void run()
   {
      long count = 0;
      for (int i = 1; i <= 9; i++)
      {
         count += getCount(0, i, mNumDigits - 1);
      }
      System.out.println("Count is:" + count);

   }

   public static void main(String[] args)
   {
      try
      {
         int one = Integer.parseInt(args[0]);
         int two = Integer.parseInt(args[1]);
         int three = Integer.parseInt(args[2]);
         new ConsecutiveSums(one, two, three).run();
      }
      catch(Exception e)
      {
         System.out.println("Error with Input.");
         e.printStackTrace();
      }
   }
}