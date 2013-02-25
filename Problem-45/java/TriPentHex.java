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
   int[] mT;
   int[] mP;
   int[] mH;

   /**
    * Default constructor
    */
   public TriPentHex(int pMax)
   {
      mMax = pMax;
      mT = new int[pMax + 1];
      mP = new int[pMax + 1];
      mH = new int[pMax + 1];
   }

   private int triangle(int pNum)
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

   private int pentagon(int pNum)
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

   private int hexagon(int pNum)
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

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      boolean isAll = false;
      int t = 0;
      int p = 0;
      int h = 0;
      int nextNum = 0;
      for (int i = 286; i < mMax; i++)
      {
         t = triangle(i);
         for (int j = 166; j < mMax; j++)
         {
            p = pentagon(j);
            System.out.print("\nt("+ i +") = " + t);
            System.out.print("; p("+ j +") = " + p);
            if (p == t)
            {
               for (int k = 144; k < mMax; k++)
               {
                  h = hexagon(k);
                  System.out.print("; h("+ k +") = " + h);
                  if ((t == p) && (t == h))
                  {
                     isAll = true;
                     nextNum = t;
                  }
               }
            }
         }
      }
      if (nextNum == 0)
      {
         System.out.println("\nNot found. Try higher max.");
      }
      else
      {
         System.out.println("\n" + nextNum);
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
