/**
 * Solution for Project Euler #12
 * TriangleNumbers
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TriangleNumbers
   implements Runnable
{

   int mFactorCount;

   public TriangleNumbers(int pCount)
   {
      mFactorCount = pCount;
   }

   private int findFactors(long pNum)
   {
      System.out.println(pNum);
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
      System.out.print("Factors: ");
      //long[] facArray = factors.toArray(long);
      for (int i = 0; i < factors.size(); i++)
      {
         System.out.print(factors.get(i) + ", ");
      }
      return factors.size();
   }

   private long getTriangleNumber(long pNum)
   {
      long sum = 0;
      for (long i = 1; i < pNum; i++)
      {
         sum += i;
      }
      return sum;
   }

   public void run()
   {
      long number = 1;
      while (findFactors(getTriangleNumber(number)) < mFactorCount)
      {
         System.out.println(number);
         number++;
      }
      System.out.println("First number with over " + mFactorCount +
                         " factors is: " + getTriangleNumber(number));
   }

   public static void main(String[] args)
   {
      try
      {
         new TriangleNumbers(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Input invalid.");
      }
   }
}