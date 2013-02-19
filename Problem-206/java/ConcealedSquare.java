/**
 * Solution to Project Euler #206
 */

import java.math.BigInteger;

public class ConcealedSquare
   implements Runnable
{

   public boolean checkNumber(BigInteger pNum)
   {
      String string = pNum.toString();
      if (string.length() < 19)
      {
         return false;
      }
      if (string.charAt(0) != '1')
      {
         return false;
      }
      if (string.charAt(2) != '2')
      {
         return false;
      }
      if (string.charAt(4) != '3')
      {
         return false;
      }
      if (string.charAt(6) != '4')
      {
         return false;
      }
      if (string.charAt(8) != '5')
      {
         return false;
      }
      if (string.charAt(10) != '6')
      {
         return false;
      }
      if (string.charAt(12) != '7')
      {
         return false;
      }
      if (string.charAt(14) != '8')
      {
         return false;
      }
      if (string.charAt(16) != '9')
      {
         return false;
      }
      if (string.charAt(18) != '0')
      {
         return false;
      }
      return true;
   }

   public void run()
   {
      boolean found = false;
      BigInteger value = BigInteger.valueOf(1100000000);
      while (!found)
      {
         BigInteger check = value.multiply(value);
         found = checkNumber(check);
         value = value.add(BigInteger.ONE);
         System.out.println(value + "^2 = " + check);
      }
      System.out.println("Found:" + value);
   }



   public static void main(String[] args)
   {
      new ConcealedSquare().run();
   }
}