/**
* Solution to Project Euler #168.
*
* Finds the sum of all integers that are the sum of their right rotations between
* 10 and 10^100.
*
*
* Problem Link: http://projecteuler.net/problem=168
* Github Issue: https://github.com/claydiffrient/project-euler/issues/175
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.math.BigInteger;

public class NumberRotations
   implements Runnable
{

   /**
    * Holds the sum of the digits.
    */
   BigInteger mSum;

   /**
    * Default constructor
    */
   public NumberRotations()
   {
      mSum = BigInteger.ZERO;
   }

   /**
    * getRightRotation
    * @param pNum the number to get the rotation for.
    */
   private String getRightRotation(BigInteger pNum)
   {
      String strValue = pNum.toString();
      String last = strValue.substring(strValue.length() - 1);
      String newVal = strValue.substring(0, strValue.length() - 1);
      return last + newVal;
   }

   private boolean isDivisor(BigInteger pNum)
   {
      String rightRotation = getRightRotation(pNum);
      BigInteger rotation = new BigInteger(rightRotation);
      if (rotation.remainder(pNum) == BigInteger.ZERO)
      {
         return true;
      }
      return false;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      BigInteger upperLimit = (BigInteger.TEN).pow(100);
      for (BigInteger i = BigInteger.TEN; i.compareTo(upperLimit) < 0; i = i.add(BigInteger.ONE))
      {
         if (isDivisor(i))
         {
            System.out.println(i);
            mSum.add(i);
         }
      }
      System.out.println("SUM:" + mSum);
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new NumberRotations().run();
   }

}


