/**
 * Solution to Project Euler #162
 */

import java.math.BigInteger;

public class HexadecimalNumbers
   implements Runnable
{
   int mNumDigits;

   public HexadecimalNumbers(int pNumDigits)
   {
      mNumDigits = pNumDigits;
   }

   public void run()
   {
      BigInteger count = BigInteger.ZERO;
      for (int i = 2; i <= mNumDigits; i++)
      {
         long value = (long) (15 *  Math.pow(16, i-1) + 41 * Math.pow(14, i-1) - (43 * Math.pow(15, i-1) + Math.pow(13, i)));
         String string = String.valueOf(value);
         count = count.add(new BigInteger(string));
      }
      System.out.println(count.toString(16));

   }

   public static void main(String[] args)
   {
      int numDigits = Integer.parseInt(args[0]);
      if (numDigits < 3)
      {
         System.out.println("Minimum of 3 digits.");
      }
      else
      {
         new HexadecimalNumbers(Integer.parseInt(args[0])).run();
      }
   }
}