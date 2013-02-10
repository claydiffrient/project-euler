/**
 * Solution to Euler #21
 * Amicable Numbers
 */

import java.util.List;
import java.util.ArrayList;

public class AmicableNumberSum
   implements Runnable
{
   int mMaxNum;

   public AmicableNumberSum(int pMax)
   {
      mMaxNum = pMax;
   }

   private long findFactorsSum(long pNum)
   {
      long n = pNum;
      long upper = pNum;
      List<Long> factors = new ArrayList<Long>();
      factors.add(new Long(1));
      for (long i = 2; i < upper; i++)
      {
         if ((n % i) == 0)
         {
            upper = n / i;
            factors.add(i);
            if (upper != i)
            {
               factors.add(upper);
            }
         }
      }
      long sum = 0;
      System.out.print("Factors: ");
      for (Long i : factors)
      {
         System.out.print(i + " + ");
         sum += i;
      }
      System.out.print(" = " + sum + "\n");
      return sum;
   }

   boolean isAmicable(long pNum)
   {
      long sumOne = findFactorsSum(pNum);
      if (findFactorsSum(sumOne) == pNum)
      {
         return true;
      }
      return false;
   }

   public void run()
   {
      int sum = 0;
      for (int i = 0; i <= mMaxNum; i++)
      {
         System.out.println("Checking: " + i);
         if (isAmicable(i))
         {
            sum += i;
         }
      }
      System.out.println(sum);
   }

   public static void main(String[] args)
   {
      try
      {
         new AmicableNumberSum(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
      }
   }
}