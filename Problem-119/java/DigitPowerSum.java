/**
* Solution to Project Euler #119.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

import java.math.BigInteger;
import java.util.Arrays;

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
   int[][] mPowerValues;

   /**
    * Default constructor
    */
   public DigitPowerSum(int pTermNum)
   {
      mTermNum = pTermNum;
      mSequence = new BigInteger[mTermNum + 2];
      mPowerValues = new int[40][500];
   }

   int getPower(int pNum, int pPower)
   {
      if (!(mPowerValues[pPower][pNum] == 0))
      {
         return mPowerValues[pPower][pNum];
      }
      else
      {
         mPowerValues[pPower][pNum] = (int) Math.pow(pNum, pPower);
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

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      mSequence[2] = new BigInteger("512");
      mSequence[10] = new BigInteger("614656");
      for (int i = 11; i <= mTermNum; i++)
      {
         BigInteger j = mSequence[i-1];
         System.out.println(i);
         System.out.println(j);
         mSequence[i] = testPowerSum(j.add(BigInteger.ONE));
      }
      for (int i = 0; i < mSequence.length; i++ )
      {
         System.out.println("mSequence[" + i + "] =" + mSequence[i]);
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


