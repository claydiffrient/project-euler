/**
* Solution to Project Euler #problem number.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

public class PandigitalMultiples
   implements Runnable
{
   /**
    * Default constructor
    */
   public PandigitalMultiples()
   {

   }

   /**
    * concatenateProduct
    * @param pNum the number to multiply
    * @param pUpper the highest number to try
    * @return long the number.
    */
   private long concatenateProduct(long pNum, long pUpper)
   {
      String returnString = "";
      for (long i = 0; i <= pUpper; i++)
      {
         returnString += pNum * i;
      }
      if (returnString.length() > 9)
      {
        return 0;
      }
      if (returnString.length() > 1)
      {
         if (returnString.charAt(0) == 0)
         {
            return 0;
         }
      }
      return Long.parseLong(returnString);
   }

   /**
    * isNineDigitPandigital
    * Determines if a number is 9 digits long and pandigital.
    * @param pNum The number to check
    * @return boolean true if it meets the conditions.
    */
   private boolean isNineDigitPandigital(long pNum)
   {
      String num = String.valueOf(pNum);
      boolean[] digits = new boolean[10];
      digits[0] = true;
      if (num.length() == 9)
      {
         for (int i = 0; i < num.length(); i++)
         {
            digits[Character.getNumericValue(num.charAt(i))] = true;
         }
      }
      for (boolean bool : digits )
      {
         if (!bool)
         {
            return false;
         }
      }
      return true;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      long largest = 0;
      for (long i = 0; i < 8000; i++)
      {
         for (long j = 1; j < 8000; i++)
         {
            long value = concatenateProduct(i, j);
            if (isNineDigitPandigital(value))
            {
               if (value > largest)
               {
                  largest = value;
               }
            }
         }
      }
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new PandigitalMultiples().run();
   }

}


