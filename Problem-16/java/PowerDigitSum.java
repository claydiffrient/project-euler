/**
 * Solution to Project Euler #16
 * Power Digit Sum
 */

import java.math.BigInteger;

public class PowerDigitSum
   implements Runnable
{
   int mPower;
   BigInteger mTwoToPower;

   public PowerDigitSum(int pPower)
   {
      mPower = pPower;
      mTwoToPower = BigInteger.ZERO;
   }

   BigInteger getPowerOfTwo(int pNum)
   {
      if (pNum == 0)
      {
         return BigInteger.ONE;
      }
      else
      {
         return (new BigInteger("2").multiply(getPowerOfTwo(pNum -1)));
      }
   }

   public void run()
   {
      mTwoToPower = getPowerOfTwo(mPower);
      String numbers = mTwoToPower.toString();
      int sum = 0;
      for (int i = 0; i < numbers.length(); i++)
      {
         sum += Character.getNumericValue(numbers.charAt(i));
      }
      System.out.println("2^" + mPower + " = " + mTwoToPower +
                         " and the sum of all it's digits is " + sum);
   }

   public static void main(String[] args)
   {
     try
     {
        new PowerDigitSum(Integer.parseInt(args[0])).run();
     }
     catch (Exception e)
     {
        System.out.println("Invalid Input.");
     }
   }

}