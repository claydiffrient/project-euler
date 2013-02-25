/**
* Solution to Project Euler #49.
*
* 4 digit prime permutations which are all prime and
*
* Problem Link: http://projecteuler.net/problem=49
* Github Issue: https://github.com/claydiffrient/project-euler/issues/Project Number + 7
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
      String one = String.valueOf(pFirst);
      String two = String.valueOf(pSecond);
      if (one.length() != two.length())
      {
         return false;
      }
      char[] oneA = one.toCharArray();
      char[] twoA = two.toCharArray();
      int count = 0;
      for (int i = 0; i < oneA.length; i++)
      {
         for (int j = 0; j < twoA.length; j++)
         {
            if (twoA[j] == oneA[i])
            {
               count++;
            }
         }
      }
      if (count == one.length())
      {
         return true;
      }
      return false;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      int thisPrime = 0;
      int nextPrime = 0;
      int thirdPrime = 0;
      int count = 1;
      int primeOne = 0;
      int primeTwo = 0;
      int primeThree = 0;
      sievePrimes();
      for (int i = 1000; i < 9999; i++)
      {

         if (mPrimes[i])
         {
            System.out.println("Checking: " + i + ":");
            if (count == 1)
            {
               primeOne = i;
               count++;
               System.out.println("\tPrimeOne = " + i);
            }
            else if (count == 2)
            {
               primeTwo = i;
               System.out.println("\tPrimeTwo = " + i);
               count++;
               System.out.println("\tChecking Permutation:" + primeOne + ", " + primeTwo + ":");
               if (!isPermutation(primeOne, primeTwo))
               {
                  count = 1;
                  System.out.println("\t\tNot Permutations. Resetting.");
               }
            }
            else if (count == 3)
            {
               primeThree = i;
               System.out.println("\tChecking Permutation" + primeOne + ", " + primeTwo + ", " + primeThree + ":");
               System.out.println("\tPrimeThree = " + i);
               if (!isPermutation(primeOne, primeTwo) &&
                   !isPermutation(primeTwo, primeThree))
               {
                  System.out.println("\t\tNot Permutations. Resetting.");
                  count = 1;
               }
               else
               {
                  System.out.println("Complete:");
                  System.out.println(primeOne +", " + primeTwo + ", " + primeThree);
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


