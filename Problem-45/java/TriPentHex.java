/**
* Solution to Project Euler #45.
*
* Number which is triagonal, pentagonal, and hexagonal.
*
* T(N) = N(N+1)/2
* P(N) = N(3N-1)/2
* H(N) = N(2N-1)
*
* Starts at T285, P165, and H143 which is the first which is all 3.  (40755)
*
* Problem Link: http://projecteuler.net/problem=45
* Github Issue: https://github.com/claydiffrient/project-euler/issues/52
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

public class TriPentHex
   implements Runnable
{

   int mMax;
   long[] mT;
   long[] mP;
   long[] mH;

   /**
    * Default constructor
    */
   public TriPentHex(int pMax)
   {
      mMax = pMax;
      mT = new long[pMax + 1];
      mP = new long[pMax + 1];
      mH = new long[pMax + 1];
   }

   private long triangle(int pNum)
   {
      if (mT[pNum] > 0)
      {
         return mT[pNum];
      }
      else
      {
         return mT[pNum] = (pNum * (pNum + 1) / 2);
      }
   }

   private long pentagon(int pNum)
   {
      if (mP[pNum] > 0)
      {
         return mP[pNum];
      }
      else
      {
         return mP[pNum] = (pNum * (3 * pNum - 1) / 2);
      }
   }

   private long hexagon(int pNum)
   {
      if (mH[pNum] > 0)
      {
         return mH[pNum];
      }
      else
      {
         return mH[pNum] = (pNum * (2 * pNum - 1));
      }
   }

   private boolean isPentagonal(long pNum)
   {
      double test = (Math.sqrt(1 + 24 * pNum) + 1.0) / 6.0;
      return (test == ((long) test));
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      boolean isAll = false;
      long t = 0;
      long nextNum = 0;
      int i = 147;
      while (true)
      {
         t = hexagon(i);
         if (isPentagonal(t))
         {
            System.out.println(t);
            break;
         }
         i++;
      }

   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      int value = 1;
      try
      {
         value = Integer.parseInt(args[0]);
      }
      catch (Exception e)
      {
         System.out.println("Invalid input.");
         System.exit(1);
      }
      new TriPentHex(value).run();
   }

}
