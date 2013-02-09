/**
 * Solution for Project Euler #14
 * Collatz Sequence.
 */

public class Collatz
   implements Runnable
{

   long mLongestSequenceStart;

   long mSequenceLength;

   long mUpperLimit;

   public Collatz(long pUpperLimit)
   {
      mLongestSequenceStart = 0;
      mSequenceLength = 0;
      mUpperLimit = pUpperLimit;
   }

   private long oddMethod(long pInput)
   {
      return (3 * pInput) + 1;
   }

   private long evenMethod(long pInput)
   {
      return (pInput/2);
   }

   private long processCollatz(long pInput, long pCount, long pStart)
   {
      //System.out.println("Inputs:" + pInput + ", " + pCount + ", " + pStart);
      pCount++;
      if (pInput == 1)
      {
         if (pCount > mSequenceLength)
         {
            mSequenceLength = pCount;
            mLongestSequenceStart = pStart;
         }
         return 0;
      }
      else
      {
         long value = 0;
         if (pInput % 2 == 0)
         {
            value = evenMethod(pInput);
         }
         else
         {
            value = oddMethod(pInput);
         }
         return processCollatz(value, pCount, pStart);
      }
   }


   public void run()
   {
      for (long i = mUpperLimit; i > 0; i--)
      {
         System.out.println(i);
         processCollatz(i, 0, i);
      }
      System.out.println("Longest Collatz starts with: " + mLongestSequenceStart);
      System.out.println("It's length is: " + mSequenceLength);

   }

   public static void main(String[] args)
   {
      try
      {
         new Collatz(Long.parseLong(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Input invalid.");
      }
   }

}