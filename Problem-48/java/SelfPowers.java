/**
 * Solution to Project Euler #48
 */
import java.math.BigInteger;

public class SelfPowers
   implements Runnable
{
   int mMaxNumber;

   public SelfPowers(int pMax)
   {
      mMaxNumber = pMax;
   }

   BigInteger power(int pBase, int pPower)
   {
      if (pPower == 0)
      {
         return BigInteger.ONE;
      }
      else
      {
         return (new BigInteger(String.valueOf(pBase)).multiply(power(pBase, pPower - 1)));
      }
   }

   public void run()
   {
      BigInteger totalSum = BigInteger.ZERO;
      for (int i = 1; i <= mMaxNumber; i++)
      {
         totalSum = totalSum.add(power(i,i));
      }
      System.out.println(totalSum);
   }

   public static void main(String[] args)
   {
      try
      {
         new SelfPowers(Integer.parseInt(args[0])).run();
      }
      catch(Exception e)
      {
         System.out.println("Error with input");
      }
   }
}