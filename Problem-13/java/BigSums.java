/**
 * Solution to Project Euler #13
 * BigSums
 */

import java.math.BigInteger;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BigSums
   implements Runnable
{
   int mNumDigits;

   BigInteger mSum;

   String mFileName;

   public BigSums(int pDigits, String pFileName)
   {
      mNumDigits = pDigits;
      mFileName = pFileName;
      mSum = BigInteger.ZERO;
   }

   public void run()
   {
      try
      {
         FileInputStream fStream = new FileInputStream(mFileName);
         DataInputStream in = new DataInputStream(fStream);
         BufferedReader reader = new BufferedReader(new InputStreamReader(in));

         String line = new String();

         while ((line = reader.readLine()) != null)
         {
            mSum = mSum.add(new BigInteger(line));
         }
      }
      catch (Exception e)
      {
         System.out.println("Error reading input. " + e.getMessage());
      }
      String result = mSum.toString();
      if (result.length() <= mNumDigits)
      {
         System.out.println(result);
      }
      else
      {
         System.out.println(result.substring(0, mNumDigits));
      }

   }

   public static void main(String[] args)
   {
      try
      {
         new BigSums(Integer.parseInt(args[0]), args[1]).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
         System.out.println("Usage: java BigSums numDigits fileName");
         System.out.println(e.getMessage());
         System.out.println(e.getStackTrace().toString());
      }
   }
}