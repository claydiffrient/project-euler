/**
 * Solution to Project Euler #95
 * AmicableChains
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AmicableChains
   implements Runnable
{

   int mLargestElement;
   int[] mSums;

   public AmicableChains(int pLargest)
   {
      mLargestElement = pLargest;
      mSums = new int[mLargestElement + 1];
      Arrays.fill(mSums, 1);
   }

   private void fillSums()
   {
      for (int i = 2; i <= mLargestElement / 2; i++)
      {
         for (int j = i + i; j <= mLargestElement; j += i)
         {
            mSums[j] += i;
         }
      }
   }

   public void run()
   {
      fillSums();
      int[] chainLength = new int[mLargestElement + 1]; // -1 means no chain.
      chainLength[1] = -1;
      chainLength[2] = -1;
      chainLength[3] = -1;
      chainLength[4] = -1;

      for (int i = 5; i <= mLargestElement; i++)
      {
         if (chainLength[i] != 0)
         {
            continue;
         }
         List<Integer> chain = new ArrayList<Integer>();
         chain.add(i);
         int next = mSums[i];
         while (true)
         {
            if (next > mLargestElement || chainLength[next] != 0)
            {
               for (Integer n : chain)
               {
                  chainLength[n] = -1;
               }
               break;
            }
            int index = chain.indexOf(next);
            if (index >= 0)
            {
               for (int j = 0; j < index; j++)
               {
                  chainLength[chain.get(j)] = -1;
               }
               for (int j = index; j < chain.size(); j++)
               {
                  chainLength[chain.get(j)] = chain.size();
               }
               break;
            }
            chain.add(next);
            next = mSums[next];
         }
      }
      int smallestMember = 0;
      int longestChain = 0;
      for (int i = 2; i <= mLargestElement; i++)
      {
         if (chainLength[i] > longestChain)
         {
            longestChain = chainLength[i];
            smallestMember = i;
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