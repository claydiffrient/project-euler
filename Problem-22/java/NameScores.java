/**
 * Solution to Project Euler #22
 * NameScores
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class NameScores
   implements Runnable
{
   final String mLETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   String mFileName;
   List<String> mListOfNames;

   public NameScores(String pFileName)
   {
      mFileName = pFileName;
      mListOfNames = new ArrayList<String>();
   }

   private void getListOfNames()
   {
      try
      {
         FileInputStream fStream = new FileInputStream(mFileName);
         DataInputStream in = new DataInputStream(fStream);
         BufferedReader reader = new BufferedReader(new InputStreamReader(in));
         String names = reader.readLine();
         Scanner tokenize = new Scanner(names);
         tokenize.useDelimiter(",");
         while (tokenize.hasNext())
         {
            String string = tokenize.next();
            string = string.replaceAll("^\"|\"$", "");
            //System.out.println(string);
            mListOfNames.add(string);
         }
         Collections.sort(mListOfNames);
      }
      catch(Exception e)
      {
         System.out.println("Error " + e.getMessage());
      }
   }

   private int getNameScore(String pName)
   {
      int sum = 0;
      for (int i = 0; i < pName.length(); i++)
      {
         sum += mLETTERS.indexOf(pName.charAt(i)) + 1;
      }
      return sum;
   }

   public void run()
   {
      int totalSum = 0;
      getListOfNames();
      for (int i = 0; i < mListOfNames.size(); i++)
      {
         totalSum += (getNameScore(mListOfNames.get(i)) * (i+1));
      }
      System.out.println(totalSum);

   }

   public static void main(String[] args)
   {
      new NameScores(args[0]).run();
   }
}