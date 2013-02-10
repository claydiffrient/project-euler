/**
 * Solution to Project Euler # 92
 * Square Chains
 */
import java.math.BigInteger;

public class SquareChains
   implements Runnable
{
   long mStartNumber;

   long mEightyNineCount;

   public SquareChains(long pStart)
   {
      mStartNumber = pStart;
   }

   private long getNextNumber(long pNumber)
   {
      String string = String.valueOf(pNumber);
      long totalValue = 0;
      for (int i = 0; i < string.length(); i++)
      {
         char c = string.charAt(i);
         int value = Character.getNumericValue(c);
         totalValue += value * value;
      }
      return totalValue;
   }

   private boolean endInEightyNine(long pNum)
   {
      boolean eightyNine = false;
      boolean eightyNineTwo = false;
      boolean numberOne = false;
      boolean numberOneTwo = false;
      long num = pNum;
      while(!(numberOneTwo || eightyNineTwo))
      {
         num = getNextNumber(num);
         if ((eightyNine) || (numberOne))
         {
            if (num == 89)
            {
               eightyNineTwo = true;
            }
            if (num == 1)
            {
               numberOneTwo = true;
            }
         }
         else
         {
            if (num == 89)
            {
               eightyNine = true;
            }
            if (num == 1)
            {
               numberOne = true;
            }
         }
      }
      return eightyNineTwo;
   }

   public void run()
   {
      long startNumber = mStartNumber;
      while (startNumber > 0)
      {
         System.out.println("Starting at: " + startNumber);
         if (endInEightyNine(startNumber))
         {
            mEightyNineCount++;
         }
         startNumber--;
      }
      System.out.println("Number ending in 89 below " + mStartNumber + " is: " +
         mEightyNineCount);

   }

   public static void main(String[] args)
   {
      try
      {
         new SquareChains(Long.parseLong(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
      }
   }

}