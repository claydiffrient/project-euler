/**
 * Solution to Project Euler #162
 */

import java.math.BigInteger;

public class HexadecimalNumbers
   implements Runnable
{
   int mNumDigits;

   public HexadecimalNumbers(int pNumDigits)
   {
      mNumDigits = pNumDigits;
   }

   private boolean checkDigits(BigInteger pInt)
   {
      String hex = pInt.toString(16);
      boolean containsZero = false;
      boolean containsOne = false;
      boolean containsA = false;
      for (int i = 0; i < hex.length(); i++)
      {
         if (hex.charAt(i) == '0')
         {
            containsZero = true;
         }
         else if (hex.charAt(i) == '1')
         {
            containsOne = true;
         }
         else if (hex.charAt(i) == 'a')
         {
            containsA = true;
         }
         if (containsA && containsOne && containsZero)
         {
            System.out.println("***********ALL**********");
            return true;
         }
      }
      if (containsA && containsOne && containsZero)
      {
         System.out.println("***********ALL**********");
         return true;
      }
      else
      {
         return false;
      }
   }

   BigInteger getUpperLimit()
   {
      String limit = "";
      for (int i = 0; i < mNumDigits; i++)
      {
         limit += "F";
      }
      return new BigInteger(limit, 16);
   }

   public void run()
   {
      BigInteger value = new BigInteger("256");
      BigInteger upper = getUpperLimit();
      int count = 0;
      for (BigInteger i = value; i.compareTo(upper) < 0; i = i.add(BigInteger.ONE))
      {
         if (checkDigits(i))
         {
            System.out.println(i + "=" + i.toString(16));
            count++;
         }
      }
      System.out.println(count);

   }

   public static void main(String[] args)
   {
      int numDigits = Integer.parseInt(args[0]);
      if (numDigits < 3)
      {
         System.out.println("Minimum of 3 digits.");
      }
      else
      {
         new HexadecimalNumbers(Integer.parseInt(args[0])).run();
      }
   }
}