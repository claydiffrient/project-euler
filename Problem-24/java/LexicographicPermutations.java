/**
* Solution to Project Euler #24.
*
* Sorts permutations of the given characters and finds the requested term.
* Usage:
*    java LexicographicPermutations term [abcdefghijklmnopqrstuvwxyz]
*
* Problem Link: http://projecteuler.net/problem=24
* Github Issue: https://github.com/claydiffrient/project-euler/issues/31
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.util.List;
import java.util.ArrayList;

/**
 * Finds a certain term of the permuations of a given string.
 * @author Clay Diffrient
 */
public class LexicographicPermutations
   implements Runnable
{

   /**
    * Term number to find.
    */
   int mTerm;

   /**
    * String to permute over.
    */
   String mCharacters;

   /**
    * Factorial array.
    */
   int[] mFactorials;

   /**
    * Default constructor
    */
   public LexicographicPermutations(int pTerm, String pCharacters)
   {
      mTerm = pTerm;
      mCharacters = pCharacters;
      mFactorials = new int[10];
   }

   /**
    * factorial
    * Finds the factorial of a given number. This implementation supports 0-9.
    * @param pNum value to find the factorial of. (0-9)
    * @return int
    */
   private int factorial(int pNum)
   {
      if ((pNum == 1) || (pNum == 0))
      {
         return 1;
      }
      if (mFactorials[pNum] > 0)
      {
         return mFactorials[pNum];
      }
      else
      {
         int value = 1;
         for (int i = 2; i <= pNum; i++)
         {
            value *= i;
         }
         return mFactorials[pNum] = value;
      }
   }

   /**
    * findPermuationAtTerm
    * Finds a permuation at the given term.
    * @return String
    */
   private String findPermutationAtTerm()
   {
      int[] toPermute = new int[mCharacters.length()];
      for (int i = 0; i < mCharacters.length(); i++)
      {
         toPermute[i] = Character.getNumericValue(mCharacters.charAt(i));
      }
      int length = toPermute.length;
      String permNumber = "";
      int toCheck = mTerm - 1;
      List<Integer> values = new ArrayList<Integer>();
      for (int i = 0; i < length; i++)
      {
         values.add(i);
      }
      for (int i = 1; i < length; i++)
      {
         int j = toCheck / factorial(length - i);
         toCheck = toCheck % factorial(length - i);
         permNumber = permNumber + values.get(j);
         values.remove(j);
         if (toCheck == 0)
         {
            break;
         }
      }
      for (int i = 0; i < values.size(); i++)
      {
         permNumber = permNumber + values.get(i);
      }
      return permNumber;
   }



   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      System.out.println(findPermutationAtTerm());
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      int term = 0;
      String chars = "";
      try
      {
         term = Integer.parseInt(args[0]);
         chars = args[1];
         new LexicographicPermutations(term, chars).run();
      }
      catch (Exception e)
      {
         System.out.println("Error with input.");
         e.printStackTrace();
      }
   }

}


