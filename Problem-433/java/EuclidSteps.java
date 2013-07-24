/**
* Solution to Project Euler #433.
*
* Problem Description
*
* Problem Link: http://projecteuler.net/problem=433
* Github Issue: https://github.com/claydiffrient/project-euler/issues/440
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

public class EuclidSteps
   implements Runnable
{
   /**
    * Holds start value.
    */
   private int mStartValue;

   /**
    * Default constructor
    */
   public EuclidSteps(int pStartValue)
   {
      mStartValue = pStartValue;
   }

   /**
    * Solves Euclid's algorithm and returns the number of steps.
    */
   int stepsInEuclid(int x, int y, int count)
   {
      if (y == 0)
      {
         return count;
      }
      else
      {
         count++;
         return stepsInEuclid(y, x % y, count);
      }
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      int totalCount = 0;
      for (int i = 1; i <= mStartValue; i++)
      {
         for (int j = 1; j <= mStartValue; j++)
         {
            totalCount += stepsInEuclid(i, j, 0);
         }
      }
      System.out.println("S(" + mStartValue + ") = " + totalCount);
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      int startValue = 0;
      try
      {
         startValue = Integer.parseInt(args[0]);
      }
      catch (Exception e)
      {
         System.out.println("Invalid input.\nUsage: java EuclidSteps x");
         System.exit(1);
      }
      new EuclidSteps(startValue).run();
   }

}


