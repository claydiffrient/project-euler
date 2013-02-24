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

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Arrays;

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
    * Permutations.
    */
   SortedSet<String> mPermutations;

   /**
    * Default constructor
    */
   public LexicographicPermutations(int pTerm, String pCharacters)
   {
      mTerm = pTerm;
      mCharacters = pCharacters;
      mPermutations = new TreeSet<String>();
   }

   private void fillPermutations(String prefix, String str)
   {
      int n = str.length();
      if (n == 0)
      {
         mPermutations.add(prefix);
      }
      else
      {
         for (int i = 0; i < n; i++)
         {
            fillPermutations(prefix + str.charAt(i),
                             str.substring(0, i) + str.substring(i+1, n));
         }
      }
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      fillPermutations(mCharacters.substring(1),mCharacters);
      System.out.println(mPermutations.size());
      Object[] strings = mPermutations.toArray();
      System.out.println(strings[mTerm - 1]);
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


