/**
 * Solution to Project Euler #187
 */

public class Semiprime
   implements Runnable
{
   int mLessThan;

   public Semiprime(int pLessThan)
   {
      mLessThan = pLessThan;
   }

   private int getNumPrimeFactors(int pNum)
   {
      int count = 0;
      for (int i = 2; i <= pNum; i++)
      {
         while (pNum % i == 0)
         {
            count++;
            if (count > 2)
            {
               break;
            }
            pNum /= i;
         }
         if (count > 2)
         {
            break;
         }
      }
      return count;
   }

   public void run()
   {
      int num = 0;
      for (int i = 0; i < mLessThan; i++)
      {
         System.out.println("Checking:" + i);
         if (getNumPrimeFactors(i) == 2)
         {
            num++;
         }
      }
      System.out.println(num);
   }

   public static void main(String[] args)
   {
      try
      {
         new Semiprime(Integer.parseInt(args[0])).run();
      }
      catch(Exception e)
      {
         System.out.println("Error");
      }
   }
}