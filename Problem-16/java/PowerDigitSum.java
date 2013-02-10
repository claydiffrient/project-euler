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

   BigInteger getPowerOfTwo(pNum)
   {
      if (pNum.equals(BigInteger.ZERO))
      {
         return BigInteger.ONE;
      }
      else
      {
         BigInteger answer = BigInteger.ONE;
         int count = 1;
         while (count <= mPower)
         {
            answer = answer.multiply(2);
            count++;
         }
         return answer;
      }
   }

   public void run()
   {
      mTwoToPower = getPowerOfTwo(mPower);
      System.out.println(mTwoToPower);

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