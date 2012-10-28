
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
/**
 * Sieve
 *
 * Uses a Sieve of Erotosthenes to find prime numbers.
 *
 * @author Clay Diffrient
 */

public class Sieve
   implements Runnable
{
   /**
    * List of Prime Numbers
    */
   private List<BigInteger> mPrimes;

   /**
    * Boolean List to sieve
    */
   private boolean[] mValues;

   /**
    * Upper square root.
    */
   private int mSqrt;

   /**
    * Value to find.
    */
   private int mToFind;

   /**
    * Constructor
    * @param pMaxValue the largest value to loop to.
    * @param pToFind the number prime you wish to find.
    */
   public Sieve(pMaxValue, pToFind)
   {
      mPrimes = new ArrayList<BigInteger>();
      mValues = new boolean[Integer.parseInt(pMaxValue) + 1];
      Arrays.fill(mValues, false);
      mSqrt = (int) Math.sqrt(pMaxValue);
      mToFind = Integer.parseInt(pToFind);
   }

   /**
    * sieve
    *
    * Runs the sieve to remove all composite values.
    */
   private void sieve()
   {
      for (int i = 2; i <= mSqrt; i++)
      {
         if (!mValues[i])
         {
            for (int j = i * i; j <= mValues.length; j+=i)
            {
               mValues[j] = true;
            }
         }
      }
   }

   /**
    * copyPrimes
    *
    * Copies all the prime numbers from the mValues array to the mPrimes list.
    */
   private void copyPrimes()
   {
      for (int i = mSqrt; i <= mValues.length; i++)
      {
         if (!mValues[i])
         {
            mPrimes.add(new BigInteger(i));
         }
      }
   }

   /**
    * Starts a thread running everything else.
    */
   public void run()
   {
      sieve();
      copyPrimes();
   }

   /**
    * getResult
    *
    * Getter that returns the value of the prime.
    *
    * @return int
    */
   public int getResult()
   {
      return mPrimes.get(mToFind);
   }

}