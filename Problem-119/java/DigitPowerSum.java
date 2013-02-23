/**
* Solution to Project Euler #119.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class DigitPowerSum
   implements Runnable
{
   /**
    * Term to Find
    */
   int mTermNum;

   /**
    * Array of BigInteger to use.
    */
   BigInteger[] mSequence;

   /**
    * Array for Memoizized values.
    */
   BigInteger[][] mPowerValues;

   /**
    * Default constructor
    */
   public DigitPowerSum(int pTermNum)
   {
      mTermNum = pTermNum;
      mSequence = new BigInteger[mTermNum + 2];
      mPowerValues = new BigInteger[100][500];
      for (BigInteger[] row : mPowerValues)
      {
         Arrays.fill(row, BigInteger.ZERO);
      }
   }

   BigInteger getPower(int pNum, int pPower)
   {
      if (!(mPowerValues[pPower][pNum].compareTo(BigInteger.ZERO) == 0))
      {
         return mPowerValues[pPower][pNum];
      }
      else
      {
         BigInteger pNumBI = new BigInteger(String.valueOf(pNum));
         mPowerValues[pPower][pNum] = pNumBI.pow(pPower) ;
         return mPowerValues[pPower][pNum];
      }
   }

   /**
    * testPowerSum
    * @param pStart number to start testing for a power sum.
    * @return BigInteger the next power sum.
    */
   BigInteger testPowerSum(BigInteger pStart)
   {
      System.out.println("***********TESTING " + pStart + "************");
      while(!isPowerSum(pStart))
      {
         pStart = pStart.add(BigInteger.ONE);
      }
      return pStart;
   }

   boolean isPowerSum(BigInteger pNum)
   {
      String string = pNum.toString();
      int sum = 0;
      for (int i = 0; i < string.length(); i++)
      {
         sum += Character.getNumericValue(string.charAt(i));
      }
      System.out.println(pNum + " = " + sum);
      BigInteger powerSum = BigInteger.ZERO;
      int power = 2;
      if (sum > 1)
      {
         while (powerSum.compareTo(pNum) < 0)
         {
            powerSum = new BigInteger(String.valueOf(getPower(sum, power)));
            System.out.println("PowerSum:" + powerSum);
            power++;
         }
         if (powerSum.compareTo(pNum) == 0)
         {
            return true;
         }
      }
      return false;
   }

   public int getSum(BigInteger pValue)
   {
      String string = pValue.toString();
      int sum = 0;
      for (int i = 0; i < string.length(); i++)
      {
         sum += Character.getNumericValue(string.charAt(i));
      }
      return sum;
   }


   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      List<BigInteger> aValues = new ArrayList<BigInteger>();
      for (int a = 2; a < 400; a++)
      {
         BigInteger value = new BigInteger(String.valueOf(a));
         for (int b = 2; b < 50; b++)
         {
            value = getPower(a, b);
            if (getSum(value) == a)
            {
               aValues.add(value);
            }
            if (aValues.size() > mTermNum)
            {
               break;
            }
         }
         if (aValues.size() > mTermNum)
         {
            break;
         }
      }
      Collections.sort(aValues);
      int count = 1;
      for (BigInteger bi : aValues )
      {
         System.out.println(count + " : " + bi);
         count++;
      }
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new DigitPowerSum(Integer.parseInt(args[0])).run();
   }

}


