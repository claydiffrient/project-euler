/**
 * Solution to Project Euler #20
 * Factorial Digit Sums
 */

import java.math.BigInteger;

public class FactorialDigitSum
   implements Runnable
{
   int mNumToFactorial;

   public FactorialDigitSum(int pNumToFactorial)
   {
      mNumToFactorial = pNumToFactorial;
   }

   BigInteger getFactorial(String pIn)
   {
      BigInteger in = new BigInteger(pIn);
      BigInteger out = BigInteger.ONE;
      for (BigInteger i = BigInteger.ONE; i.compareTo(in) <= 0; i = i.add(BigInteger.ONE))
      {
         out = out.multiply(i);
      }
      return out;
   }

   public void run()
   {
      BigInteger value = getFactorial(String.valueOf(mNumToFactorial));
      String digits = value.toString();
      int sum = 0;
      for (int i = 0; i < digits.length(); i++)
      {
         sum += Character.getNumericValue(digits.charAt(i));
      }
      System.out.println("The sum of all digits of " + mNumToFactorial +
                         "! is: " + sum);
   }

   public static void main(String[] args)
   {
      try
      {
         new FactorialDigitSum(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
      }
   }
}