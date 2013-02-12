/**
 * Solution to Project Euler #18 and #67
 */

import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class MaxPathSum
   implements Runnable
{
   String mFileName;
   BufferedReader mFileReader;
   int[][] mTriangle;
   int mDepth;

   public MaxPathSum(String pFileName)
   {
      mFileName = pFileName;
      try
      {
         mFileReader = new BufferedReader(new FileReader(mFileName));
      }
      catch (Exception e)
      {
         System.out.println("Error");
      }
      mDepth = getDepth();
      mTriangle = new int[mDepth][];
   }

   private int getDepth()
   {
      int lines = 0;
      try
      {
         while (mFileReader.readLine() != null)
         {
            lines++;
         }
         mFileReader.close();
      }
      catch(Exception e)
      {
         System.out.println("Error Reading.");
      }
      System.out.println(lines);
      return lines;
   }

   private void fillTriangle()
   {
      try
      {
         mFileReader = new BufferedReader(new FileReader(mFileName));
      }
      catch(Exception e)
      {
         System.out.println("Error.");
      }
      String string;
      int i = 0;
      try
      {
         while(( string = mFileReader.readLine()) != null)
         {
            mTriangle[i] = new int[i + 1];
            int j = 0;
            Scanner numbers = new Scanner(string);
            while (numbers.hasNext())
            {
               int value = numbers.nextInt();
               mTriangle[i][j] = value;
               j++;
            }
            i++;
         }
      }
      catch(Exception e)
      {
         System.out.println("IO Error");
         e.printStackTrace();
      }
   }

   private int[] getRowMax(int[] pPrev, int[] pLast)
   {
      for (int i = 0; i < pPrev.length; i++)
      {
         pPrev[i] = pPrev[i] + (Math.max(pLast[i], pLast[i+1]));
      }
      return pPrev;
   }

   private int getMax()
   {
      int[] previous = null;
      for (int i = 1; i < mDepth; i++)
      {
         int[] last = mTriangle[mDepth - i];
         previous = getRowMax(mTriangle[(mDepth -i) -1], last);
      }
      return previous[0];
   }

   public void run()
   {
      fillTriangle();
      System.out.println("Max sum is:" + getMax());
   }

   public static void main(String[] args)
   {
      try
      {
         new MaxPathSum(args[0]).run();
      }
      catch(Exception e)
      {
         System.out.println("Invalid input." + e.getMessage());
         System.exit(1);
      }

   }
}
