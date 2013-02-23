/**
* Solution to Project Euler #118.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

import java.lang.ArrayIndexOutOfBoundsException;

public class PrimePandigitalSets
   implements Runnable
{

   int mNumSets;
   boolean[] mPrimes;
   final int PRIME_SIZE = 100000;

   /**
    * Default constructor
    */
   public PrimePandigitalSets()
   {
      mNumSets = 0;
      mPrimes = new boolean[PRIME_SIZE];
   }

   private void sievePrimes()
   {
      sievePrimes(PRIME_SIZE);
   }

   private void sievePrimes(int pVal)
   {
      for (int i = 2; i < (int) Math.sqrt(pVal); i++)
      {
         if (mPrimes[i])
         {
            for (int j = i*i; j < pVal; j = j+i)
            {
               mPrimes[j] = false;
            }
         }
      }
   }

   public boolean isPrime(int pNum)
   {
      try
      {
         return mPrimes[pNum];
      }
      catch (ArrayIndexOutOfBoundsException e)
      {
         mPrimes = new boolean[pNum + 100];
         sievePrimes(pNum + 100);
         return mPrimes[pNum];
      }
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      sievePrimes();
      System.out.println(isPrime(99999));
      System.out.println(isPrime(200000));
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new PrimePandigitalSets().run();
   }

}


