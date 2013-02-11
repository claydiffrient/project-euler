/**
 * Solution to Project Euler #95
 * AmicableChains
 */

import java.util.List;
import java.util.ArrayList;

public class AmicableChains
   implements Runnable
{

   int mLargestElement;
   List<Integer> mLongestChain;
   List<Integer> mCurrentChain;

   public AmicableChains(int pLargest)
   {
      mLargestElement = pLargest;
      mLongestChain = new ArrayList<Integer>();
      mCurrentChain = new ArrayList<Integer>();
   }

   private int findFactorsSum(int pNum)
   {
      int n = pNum;
      int upper = pNum;
      List<Integer> factors = new ArrayList<Integer>();
      factors.add(new Integer(1));
      for (int i = 2; i < upper; i++)
      {
         if ((n % i) == 0)
         {
            upper = n / i;
            factors.add(i);
            if (upper != i)
            {
               factors.add(upper);
            }
         }
      }
      int sum = 0;
      for (Integer i : factors)
      {
         sum += i;
      }
      return sum;
   }

   private int processChain(int pNum)
   {
      if ((mCurrentChain.contains(pNum)) || (pNum > mLargestElement) || (pNum == 1))
      {
         if (mCurrentChain.size() > mLongestChain.size())
         {
            mLongestChain = mCurrentChain;
         }
         return pNum;
      }
      else
      {
         mCurrentChain.add(pNum);
         return processChain(findFactorsSum(pNum));
      }

   }

   void processAmicableChain(int pNum)
   {
      List<Integer> chain = new ArrayList<Integer>();
      chain.add(pNum);
      int nextNum = findFactorsSum(pNum);
      int prevNum = pNum;
      boolean amicable = false;
      while (nextNum < mLargestElement)
      {
         if (!chain.contains(nextNum))
         {
            chain.add(nextNum);
            nextNum = findFactorsSum(nextNum);
         }
         else
         {
            if (nextNum == 1)
            {
               amicable = false;
            }
            else
            {
               amicable = true;
            }
            break;
         }

      }
      if (amicable && (chain.size() > mLongestChain.size()))
      {
         mLongestChain = chain;
      }

   }

   public void run()
   {
      for (int i = 10; i < mLargestElement; i++)
      {
         System.out.println("Checking: " + i);
         //processAmicableChain(i);
         processChain(i);
      }
      int smallestMember = 0;
      for (int i = 0; i < mLongestChain.size(); i++)
      {
         if (i < 1)
         {
            smallestMember = mLongestChain.get(i);
         }
         else
         {
            if (mLongestChain.get(i) < smallestMember)
            {
               smallestMember = mLongestChain.get(i);
            }
         }
      }
      System.out.println("Smallest member of longest chain is:" + smallestMember);
   }

   public static void main(String[] args)
   {
      try
      {
         new AmicableChains(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Error with input.");
      }
   }

}