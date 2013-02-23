/**
* Solution to Project Euler #118.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

import java.lang.ArrayIndexOutOfBoundsException;
import java.util.SortedSet;
import java.util.Set;
import java.util.TreeSet;

public class PrimePandigitalSets
   implements Runnable
{

   int mNumSets;
   boolean[] mPrimes;
   final int PRIME_SIZE = 100000;
   SortedSet<String> mSetOfPermutations;

   /**
    * Default constructor
    */
   public PrimePandigitalSets()
   {
      mNumSets = 0;
      mPrimes = new boolean[PRIME_SIZE];
      mSetOfPermutations = new TreeSet<String>();
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

   private void fillPermutations()
   {
      mSetOfPermutations = fillPermutations("123456789");
   }

   private SortedSet<String> fillPermutations(String pNum)
   {
      SortedSet<String> permutations = new TreeSet<String>();
      if (pNum == null)
      {
         return null;
      }
      else if (pNum.length() == 0)
      {
         mSetOfPermutations.add("");
         return permutations;
      }
      char first = pNum.charAt(0);
      String remaining = pNum.substring(1);
      Set<String> words = fillPermutations(remaining);
      for (String string : words)
      {
         for (int i = 0; i <= string.length(); i++)
         {
            permutations.add(insertChar(string, first, i));
         }
      }
      return permutations;
   }

   private String insertChar(String pString, char pChar, int pPos)
   {
      String begin = pString.substring(0, pPos);
      String end = pString.substring(pPos);
      return begin + pChar + end;
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

   private boolean checkPrimeSet(String pNum)
   {
      return true;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      int count = 0;
      sievePrimes();
      fillPermutations();
      for (String permutation : mSetOfPermutations )
      {
         if (checkPrimeSet(permutation))
         {
            count++;
         }
      }
      System.out.println("Count = " + count);
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


