/**
* Solution to Project Euler #127.
*
* See the problem for a definition.
*
* Problem Link: http://projecteuler.net/problem=127
* Github Issue: https://github.com/claydiffrient/project-euler/issues/134
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.util.List;
import java.util.ArrayList;

public class ABCHits
   implements Runnable
{
   /**
    * Default constructor
    */
   public ABCHits()
   {

   }

   private int getRadical(int pNum)
   {
      return getFactorProduct(primeFactors(pNum));
   }

   private int getGCD(int a, int b)
   {
      if (b == 0)
      {
         return a;
      }
      return getGCD(b, a%b);
   }

   private List<Integer> primeFactors(int pNum)
   {
      int n = pNum;
      List<Integer> factors = new ArrayList<Integer>();
      for (int i = 2; i <= n / i; i++)
      {
         while (n % i == 0)
         {
            factors.add(i);
            n /= i;
         }
      }
      if (n > 1)
      {
         factors.add(n);
      }
    return factors;
  }

   private int getFactorProduct(List<Integer> pFactors)
   {
      int product = 1;
      for (Integer i : pFactors)
      {
         product *= i;
      }
      return product;
   }

   private boolean isTriplet(int a, int b, int c)
   {
      if ((getGCD(a, b) == 1) && (getGCD(a, c) == 1) && (getGCD(b, c) == 1))
      {
         if (a < b)
         {
            if (a + b == c)
            {
               if (getRadical(a*b*c) < c)
               {
                  return true;
               }
            }
         }
      }
      return false;
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      System.out.println(isTriplet(5, 27, 32));
      System.out.println(isTriplet(6, 27, 10));
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new ABCHits().run();
   }

}


