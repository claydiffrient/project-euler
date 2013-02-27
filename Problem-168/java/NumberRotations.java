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
import java.util.Set;
import java.util.ArrayList;
import java.util.List;


public class NumberRotations
   implements Runnable
{

   /**
    * Holds the sum of the digits.
    */
   BigInteger mSum;

   /**
    * Running Threads
    */
   List<Thread> mThreads;

   /**
    * Count of threads
    */
   int mCount;

   /**
    * Default constructor
    */
   public NumberRotations()
   {
      mSum = BigInteger.ZERO;
      mThreads = new ArrayList<Thread>();
      mCount = 0;
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

   private boolean allThreadsFinished()
   {
      mCount = 0;
      for (Thread t : mThreads )
      {
         if (t.isAlive())
         {
            mCount++;
            return false;
         }
         else
         {
            mCount--;
         }
      }
      return true;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      for (int power = 1; power <= 100; power++)
      {
         final int powerTwo = power;
         final BigInteger lowerLimit = (BigInteger.TEN).pow(power).divide((BigInteger.TEN).pow(1));

         mThreads.add(new Thread(){
            public void run()
            {
               BigInteger upperLimit = (BigInteger.TEN).pow(powerTwo);
               for (BigInteger i = lowerLimit; i.compareTo(upperLimit) < 0; i = i.add(BigInteger.ONE))
               {
                  if (isDivisor(i))
                  {
                     System.out.println(i);
                     mSum = mSum.add(i);
                  }
               }
            }
         });
      }
      mThreads.remove(0);
      for (Thread t : mThreads)
      {
         t.start();
      }
      new Thread()
      {
         public void run()
         {
            while (!allThreadsFinished())
            {
               System.out.println("Running tests: " + mCount + " still running.");
               System.out.println("The current sum is: " + mSum);
               try
               {
                  this.sleep(5000);
               }
               catch (Exception e)
               {
               }
            }
            System.out.println("SUM:" + mSum);
         }
      }.start();
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


