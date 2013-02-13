/**
 * Solution to Euler #164
 */

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ConsecutiveSums
   implements Runnable
{
   List<BigInteger> mListOfNumbers;
   int mSumLimit;
   int mNumConsec;
   int mNumDigits;

   public ConsecutiveSums(int pSumLimit, int pConsec, int pNumDigits)
   {
      mListOfNumbers = new ArrayList<BigInteger>();
      mSumLimit = pSumLimit;
      mNumConsec = pConsec;
      mNumDigits = pNumDigits;
   }

   BigInteger getLowerRange()
   {
      String start = "1";
      for (int i = 0; i < mNumDigits - 1; i++)
      {
         start += "0";
      }
      return new BigInteger(start);
   }

   BigInteger getUpperRange()
   {
      String start = "9";
      for (int i = 0; i < mNumDigits - 1; i++)
      {
         start += "9";
      }
      return new BigInteger(start);
   }

   public void run()
   {
      int count = 0;
      BigInteger a = getLowerRange();
      BigInteger b = getUpperRange();
      for (BigInteger c = a ; c.compareTo(b) < 0; c = c.add(BigInteger.ONE))
      {
         String num = c.toString();
         System.out.println(num);
         char[] digits = num.toCharArray();
         for (int i = digits.length - 1; i > 2; i--)
         {
            int sum = 0;
            sum += Character.getNumericValue(digits[i]);
            sum += Character.getNumericValue(digits[i - 1]);
            sum += Character.getNumericValue(digits[i - 2]);
            if (sum < 9)
            {
               count++;
            }
            else
            {
               break;
            }
         }
      }
      System.out.println("Count is:" + count);

   }

   public static void main(String[] args)
   {
      try
      {
         int one = Integer.parseInt(args[0]);
         int two = Integer.parseInt(args[1]);
         int three = Integer.parseInt(args[2]);
         new ConsecutiveSums(one, two, three).run();
      }
      catch(Exception e)
      {
         System.out.println("Error with Input.");
         e.printStackTrace();
      }
   }
}