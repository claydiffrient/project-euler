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
    * The maximum value to find
    */
   private int mMaxValue;

   /**
    * Constructor
    * @param pMaxValue the largest value to loop to.
    * @param pToFind the number prime you wish to find.
    */
   public Sieve(String pMaxValue,String pToFind)
   {
      mPrimes = new ArrayList<BigInteger>();
      mMaxValue = Integer.parseInt(pMaxValue);
      mValues = new boolean[mMaxValue + 1];
      Arrays.fill(mValues, false);
      mSqrt = (int) Math.sqrt(Double.parseDouble(pMaxValue));
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
            mPrimes.add(BigInteger.valueOf(i));
            for (int j = i * i; j <= mMaxValue; j+=i)
            {
               mValues[j] = true;
               System.out.println("Composite: " + j);
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
      for (int i = mSqrt; i <= mMaxValue; i++)
      {
         if (!mValues[i])
         {
            mPrimes.add(BigInteger.valueOf(i));
            int loc = mPrimes.indexOf(BigInteger.valueOf(i));
            System.out.println("Prime:" + i + " In location: " + loc);
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
      return mPrimes.get(mToFind - 1).intValue();
   }

}
