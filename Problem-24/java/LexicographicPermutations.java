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

   private SortedSet<String> fillPermutations(String pNum)
   {
      SortedSet<String> permutations = new TreeSet<String>();
      if (pNum == null)
      {
         return null;
      }
      else if (pNum.length() == 0)
      {
         mPermutations.add("");
         return permutations;
      }
      char first = pNum.charAt(0);
      String remaining = pNum.substring(1);
      SortedSet<String> words = fillPermutations(remaining);
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

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      mPermutations = fillPermutations(mCharacters);
      //TODO:Fix this.
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


