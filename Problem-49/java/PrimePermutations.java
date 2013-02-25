/**
* Solution to Project Euler #49.
*
* 4 digit prime permutations which are all prime and
*
* Problem Link: http://projecteuler.net/problem=49
* Github Issue: https://github.com/claydiffrient/project-euler/issues/56
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.util.Arrays;

public class PrimePermutations
   implements Runnable
{
   int mPrimeDigits;
   boolean[] mPrimes;

   /**
    * Default constructor
    */
   public PrimePermutations()
   {
      mPrimeDigits = 10000;
      mPrimes = new boolean[10000];
      Arrays.fill(mPrimes, true);
   }

   private void sievePrimes()
   {
      for (int i = 2; i < (int) Math.sqrt(mPrimeDigits); i++)
      {
         if (mPrimes[i])
         {
            for (int j = i*i; j < mPrimeDigits; j = j+i)
            {
               mPrimes[j] = false;
            }
         }
      }
   }

   private boolean isPermutation(int pFirst, int pSecond)
   {
      int[] array = new int[10];
      int temp = pSecond;
      while (temp > 0)
      {
         array[temp % 10]++;
         temp /= 10;
      }
      temp = pFirst;
      while (temp > 0)
      {
         array[temp % 10]--;
         temp /= 10;
      }
      for (int i = 0; i < 10; i++)
      {
         if (array[i] != 0)
         {
            return false;
         }
      }
      return true;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      sievePrimes();
      for (int i = 1000; i < 10000; i++)
      {
         if (mPrimes[i])
         {
            //System.out.println("i = " + i);
            for (int j = i + 1; j < 10000; j++)
            {
               if (mPrimes[j])
               {
                  //System.out.println("j = " + j);
                  int k = j + (j - i);
                  if (k < 9999)
                  {
                     if (mPrimes[k])
                     {
                        //System.out.println("k = " + k);
                        if (isPermutation(i, j) && isPermutation(j, k))
                        {
                           System.out.println(i + " " + j + " " + k);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new PrimePermutations().run();
   }

}


