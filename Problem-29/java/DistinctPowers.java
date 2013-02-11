/**
 * Solution to Project Euler #29
 */

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class DistinctPowers
   implements Runnable
{
   int mLowerLimitA;
   int mUpperLimitA;
   int mLowerLimitB;
   int mUpperLimitB;
   List<BigInteger> mSequence;

   public DistinctPowers(int pLowA, int pUpA, int pLowB, int pUpB)
   {
      mLowerLimitA = pLowA;
      mUpperLimitA = pUpA;
      mLowerLimitB = pLowB;
      mUpperLimitB = pUpB;
      mSequence = new ArrayList<BigInteger>();
   }

   private void generateSequence()
   {
      for (int a = mLowerLimitA; a <= mUpperLimitA; a++)
      {
         for (int b = mLowerLimitB; b <= mUpperLimitB; b++)
         {
            BigInteger aVal = new BigInteger(String.valueOf(a));
            BigInteger temp = aVal.pow(b);
            if (!mSequence.contains(temp))
            {
               mSequence.add(temp);
            }
         }
      }
   }

   public void run()
   {
      generateSequence();
      Collections.sort(mSequence);
      System.out.println(mSequence.size());
   }

   public static void main(String[] args)
   {
      try
      {
         new DistinctPowers(Integer.parseInt(args[0]), Integer.parseInt(args[1]),
                            Integer.parseInt(args[2]), Integer.parseInt(args[3]))
                           .run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid input." + e.getMessage());
      }
   }
}