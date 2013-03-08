/**
* Solution to Project Euler #35.
*
* Circular Primes
*
* Problem Link: http://projecteuler.net/problem=35
* Github Issue: https://github.com/claydiffrient/project-euler/issues/42
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CircularPrimes
   implements Runnable
{

   boolean[] mPrimes;
   final int MAX_SIZE = 1000000;

   /**
    * Default constructor
    */
   public CircularPrimes()
   {
      mPrimes = new boolean[MAX_SIZE];
      Arrays.fill(mPrimes, true);
   }

   private void sievePrimes()
   {
      sievePrimes(MAX_SIZE);
   }

   private void sievePrimes(int pSize)
   {
      for (int i = 2; i < (int) Math.sqrt(pSize); i++)
      {
         if (mPrimes[i])
         {
            for (int j = i*i; j < pSize; j = j+i)
            {
               mPrimes[j] = false;
            }
         }
      }
   }

   /**
    * getRightRotation
    * @param pNum the number to get the rotation for.
    */
   private String getRightRotation(int pNum)
   {
      String strValue = String.valueOf(pNum);
      String last = strValue.substring(strValue.length() - 1);
      String newVal = strValue.substring(0, strValue.length() - 1);
      return last + newVal;
   }

   public boolean isPrime(String pString)
   {
      return isPrime(Integer.parseInt(pString));
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

   private boolean isCircularPrime(int pNum)
   {
      if (!isPrime(pNum))
      {
         return false;
      }
      List<String> checkedValues = new ArrayList<String>();
      String stringVal = String.valueOf(pNum);
      for (int i = 0; i < stringVal.length(); i++)
      {
         if ((stringVal.charAt(i) == '2') ||
             (stringVal.charAt(i) == '5'))
         {
            return false;
         }
      }
      String rotation = getRightRotation(pNum);
      while (!checkedValues.contains(rotation))
      {
         checkedValues.add(rotation);
         if (!isPrime(rotation))
         {
            return false;
         }
         rotation = getRightRotation(Integer.parseInt(rotation));
      }
      if (!isPrime(rotation))
      {
         return false;
      }
      return true;
   }



   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      sievePrimes();
      int count = 0;
      for (int i = 0; i < MAX_SIZE; i++)
      {
         if (isCircularPrime(i))
         {
            count++;
         }
      }
      System.out.println(count);
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new CircularPrimes().run();
   }

}


