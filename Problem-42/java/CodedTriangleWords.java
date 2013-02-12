/**
 * Solution to Project Euler #42
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CodedTriangleWords
   implements Runnable
{
   final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   final int TRIANGLE_LIMIT = 500;
   String mFileName;
   List<String> mListOfWords;
   BufferedReader mFileReader;
   List<Integer> mTriangleNumbers;

   public CodedTriangleWords(String pFileName)
   {
      mFileName = pFileName;
      mListOfWords = new ArrayList<String>();
      mTriangleNumbers = new ArrayList<Integer>();
   }

   private boolean isTriangle(int pNum)
   {
      return mTriangleNumbers.contains(pNum);
   }

   private void generateTriangleNumbers(int pLimit)
   {
      for (int i = 0; i < pLimit; i++)
      {
         int value = (i * (i + 1)) / 2;
         mTriangleNumbers.add(value);
      }
   }

   private void getListOfWords()
   {
      try
      {
         mFileReader = new BufferedReader(new FileReader(mFileName));
         String words = mFileReader.readLine();
         Scanner tokenizer = new Scanner(words);
         tokenizer.useDelimiter(",");
         while(tokenizer.hasNext())
         {
            String string = tokenizer.next();
            string = string.replaceAll("^\"|\"$", "");
            mListOfWords.add(string);
         }

      }
      catch(Exception e)
      {
         System.out.println("Error");
      }
   }

   private int getWordScore(String pWord)
   {
      int sum = 0;
      for (int i = 0; i < pWord.length(); i++)
      {
         sum += LETTERS.indexOf(pWord.charAt(i)) + 1;
      }
      return sum;
   }

   public void run()
   {
      int count = 0;
      getListOfWords();
      generateTriangleNumbers(TRIANGLE_LIMIT);
      for (String word : mListOfWords)
      {
         int score = getWordScore(word);
         if (isTriangle(score))
         {
            count++;
         }
      }
      System.out.println("Count is " + count);

   }

   public static void main(String[] args)
   {
      try
      {
         new CodedTriangleWords(args[0]).run();
      }
      catch(Exception e)
      {
         System.out.println("Invalid input." + e.getMessage());
         System.exit(1);
      }

   }

}