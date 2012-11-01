import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;
/**
 * Finds the sum of all primes below a given boundry.
 */
public class SumPrimes
   implements Runnable
{
   /**
    * Sum
    */
   BigInteger mSum = BigInteger.ZERO;

   /**
    * Upper limit
    */
   int mUpperLimit;

   /**
    * Constructor
    */
   public SumPrimes(String[] args)
   {
      try
      {
         mUpperLimit = Integer.parseInt(args[0]);
      }
      catch (Exception e)
      {
         System.out.println("Error with Arguments.");
         System.out.println("Usage: java SumPrimes a");
         System.out.println("a = Upper limit to sum");
         System.exit(1);
      }
   }

   public void run()
   {
      Sieve theSieve = new Sieve(mUpperLimit);
      theSieve.run();
      List<BigInteger> ourPrimes = theSieve.getPrimes();
      int numPrimes = ourPrimes.size();
      for (int i = 0; i < numPrimes; i++)
      {
         mSum = mSum.add(ourPrimes.get(i));
      }
      System.out.println("Sum = " + mSum);

   }

   public static void main(String[] args)
   {
      new SumPrimes(args).run();
   }
}