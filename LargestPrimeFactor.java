/**
 * LargestPrimeFactor
 *
 * A solution to Project Euler problem #3. Will work for 600851475143.
 *
 * @author Clay Diffrient
 *
 */
public class LargestPrimeFactor
   implements Runnable
{
   //////////////////////////////////////////Member Variables
   long mOriginalNumber = 0;

   /////////////////////////////////////////Constructors

   /**
    * Default Constructor
    *
    * @param args string array containing the commandline arguments
    */
   LargestPrimeFactor(String[] args)
   {
      try
      {
         mOriginalNumber = Long.parseLong(args[0]);
      }
      catch (Exception e)
      {
         System.out.println("Argument error.");
         System.out.println("Usage: LargestPrimeFactor a");
         System.out.println("       a - the number to factor to largest prime");
         System.exit(1);
      }
   }

   /**
    * Constructor
    *
    * @param pNumber the number to find information for.
    */
   LargestPrimeFactor(long pNumber)
   {
      mOriginalNumber = pNumber;
   }

   ////////////////////////////////////////Methods

   /**
    * findLargestPrime
    *
    * Iterates through and returns the largest prime factor of a number.
    *
    * @param pPrime a long to find the largest prime of.
    *
    * @return double
    */
   private double findLargestPrime(long pPrime)
   {
      long n = 3;
      long greatestFactor = 1;

      while (pPrime % 2 == 0)
      {
         greatestFactor = 2;
         pPrime /= 2;
      }
      while (pPrime != 1)
      {
         while (pPrime % n == 0)
         {
            greatestFactor = n;
            pPrime /= n;
         }
         n = n+2;
      }
      return greatestFactor;

   }

   /**
    * run
    *
    * starts a thread with everything happening.
    */
   public void run()
   {
      System.out.println("Largest Prime Factor: " + findLargestPrime(mOriginalNumber));
   }

   public static void main(String[] args) {
      new LargestPrimeFactor(args).run();
   }
}
