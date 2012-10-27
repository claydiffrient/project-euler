/**
 * Multiplier
 *
 * A solution to Project Euler problem #1.
 *
 * @author Clay Diffrient
 */

import java.util.ArrayList;

public class Multiplier
   implements Runnable
{
   private ArrayList<Integer> mDivideByNumbers = new ArrayList();
   private int mTotalSum = 0;
   private int mCommonMultiple = 1;
   public static final int MAX_NUM = 1000;

   /**
    * Constructor
    *
    * Fills the mDivideByNumbers variable with specified arguments.
    */
   public Multiplier(String[] args)
   {
      try
      {
         for (String arg : args )
         {
            mDivideByNumbers.add(Integer.parseInt(arg));
         }
      }
      catch (Exception e)
      {
         System.out.println("Error: Chances are you didn't give any arguments");
      }
   }

   /**
    * checkDivisibility
    *
    * Checks if one number is divisible by another.
    *
    * @param pNumToCheck the number to check
    *
    * @param pDivisibleBy the number to check if it is divisible by.
    */
   private boolean checkDivisibility(int pNumToCheck, int pDivisibleBy)
   {
      if (pNumToCheck % pDivisibleBy == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * findCommonMultiple
    *
    * Will determine the number which is a multiple of each of the multiples.
    */
   private void findCommonMultiple()
   {
      int commonMultiple = 1;
      if (mDivideByNumbers.size() > 1)
      {
         for (Integer multiple : mDivideByNumbers )
         {
            commonMultiple *= multiple;
         }
      }
      mCommonMultiple = commonMultiple;
   }

   /**
    * addToSum
    *
    * Will add a given number to the total sum.
    *
    * @param pNumber the number to add.
    */
   private void addToSum(int pNumber)
   {
      mTotalSum += pNumber;
   }

   /**
    * removeFromSum
    *
    * Will remove a given number from the total sum.
    *
    * @param pNumber the number to subtract.
    */
   private void removeFromSum(int pNumber)
   {
      mTotalSum -= pNumber;
   }

   /**
    * addNumbers
    *
    * Will loop through all given divisibilty numbers until they are all added.
    */
   private void addNumbers()
   {
      int totalToSubtract = 0;
      for (int i = 0; i < MAX_NUM ; i++ )
      {
         for (Integer divisor : mDivideByNumbers)
         {
            if (checkDivisibility(i, divisor))
            {
               addToSum(i);
            }
         }
         if (mDivideByNumbers.size() > 1)
         {
            if (checkDivisibility(i, mCommonMultiple))
            {
               totalToSubtract += i;
            }
         }
      }
      removeFromSum(totalToSubtract);
   }

   /**
    * getSum
    *
    * Getter to return the sum of all the divisible numbers.
    */
   public int getSum()
   {
      return mTotalSum;
   }

   /**
    * display
    *
    * Prints the final informatin to the console.
    */

   private void display()
   {
      System.out.println("The sum of the multiples is " + getSum());
   }

   /**
    * run
    *
    * Starts a new thread with all the commands needed.
    */
   public void run()
   {
      findCommonMultiple();
      addNumbers();
      display();
   }

   /**
    * main
    *
    * Starts everything going with commandline arguments.
    *
    * @param args the commandline arguments.
    */
   public static void main(String[] args)
   {
      new Multiplier(args).run();
   }


}