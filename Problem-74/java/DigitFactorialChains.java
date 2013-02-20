/**
 * Solution to Project Euler #74
 */

import java.util.List;
import java.util.ArrayList;

public class DigitFactorialChains
   implements Runnable
{
   int mNumTerms;
   int[] mFactorialResults;
   int mUpperLimit;

   public DigitFactorialChains(int pNumTerms, int pUpperLimit)
   {
      mNumTerms = pNumTerms;
      mUpperLimit = pUpperLimit;
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

   private int getFactorialSum(int pNum)
   {
      String intString = String.valueOf(pNum);
      int sum = 0;
      for (int i = 0; i < intString.length(); i++)
      {
         sum += getFactorial(Character.getNumericValue(intString.charAt(i)));
      }
      return sum;
   }

   private int getFactorialChainLength(int pNum)
   {
      List<Integer> chain = new ArrayList<Integer>();
      int value = pNum;
      while (true)
      {
         if (!chain.contains(value))
         {
            chain.add(value);
         }
         else
         {
            return chain.size();
         }
         value = getFactorialSum(value);
      }

   }

   public void run()
   {
      int start = 1;
      int count = 0;
      while(start < mUpperLimit)
      {
         if (getFactorialChainLength(start) == mNumTerms)
         {
            count++;
         }
         start++;
      }
      System.out.println("Count = " + count);
   }

   public static void main(String[] args)
   {
      try
      {
         new DigitFactorialChains(Integer.parseInt(args[0]),
                                  Integer.parseInt(args[1])).run();
      }
      catch(Exception e)
      {
         System.out.println("Invalid input");
      }
   }
}