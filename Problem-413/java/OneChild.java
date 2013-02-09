/**
 * Solution to Project Euler #413
 */

import java.math.BigInteger;

public class OneChild
   implements Runnable
{
   /**
    * The count of one chid numbers.
    */
   private int mCount = 0;

   /**
    * The number to find all one-child numbers less than.
    */
   private String mLessThan = null;

   /**
    * BigInteger representation of the mLessThan
    */
   private BigInteger mLess = null;

   /**
    * Constructor
    */
   public OneChild(String pLessThan)
   {
      mCount = 0;
      mLessThan = pLessThan;
      try
      {
         mLess = new BigInteger(pLessThan);
      }
      catch(Exception e)
      {
         System.out.println("Input is not valid.");
         System.exit(1);
      }
   }

   public void run()
   {
      for (BigInteger i = mLess; i.compareTo(BigInteger.ZERO) > 0; i = i.subtract(BigInteger.ONE))
      {
         System.out.println(i.toString());
         if (determineOneChild(i.toString()))
         {
            mCount++;
         }
      }
      System.out.println("Total Count: " + mCount);
   }

   public boolean determineOneChildTwo(String pInt)
   {
      int length = pInt.length();
      int count = 0;
      BigInteger len = new BigInteger(Integer.toString(length));
      while (length > 0)
      {
         BigInteger sub = new BigInteger(pInt);
         BigInteger remainder = sub.remainder(len);
         if (remainder.equals(BigInteger.ZERO))
         {
            count++;
            if (count > 1)
            {
               return false;
            }
         }
         for (int i = 1; i < pInt.length(); i++)
         {
            pInt.substring(i);
            pInt.substring(0, i);
         }
         pInt = pInt.substring(1, Math.max(pInt.length() - 1, 1));
      }
   }

//   private boolean checkDivisible(BigInteger remainder, BigInteger)

   public boolean determineOneChild(String pInt)
   {
      int length = pInt.length();
      int count = 0;
      BigInteger len = new BigInteger(Integer.toString(length));
      for (int i = 0; i < length; i++)
      {
         for (int j = 0; j <= length - i; j++)
         {
            String sub = pInt.substring(i, i+j);
            if (sub.length() > 0)
            {
               BigInteger temp = new BigInteger(sub);
               BigInteger remainder = temp.remainder(len);
               if (remainder.equals(BigInteger.ZERO))
               {
                  count++;
                  if (count > 1)
                  {
                     return false;
                  }
               }
            }
         }
      }
      return true;
   }

   public static void main(String[] args)
   {
      new OneChild(args[0]).run();
   }

}