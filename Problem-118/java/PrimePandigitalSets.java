/**
* Solution to Project Euler #118.
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
*/

public class PrimePandigitalSets
   implements Runnable
{

   int mNumSets;
   boolean[] mPrimes;
   final int PRIME_SIZE = 100000;

   /**
    * Default constructor
    */
   public PrimePandigitalSets()
   {
      mNumSets = 0;
      mPrimes = new boolean[PRIME_SIZE];
   }

   private void sievePrimes()
   {
      for (int i = 2; i < (int) Math.sqrt(PRIME_SIZE); i++)
      {
         if (mPrimes[i])
         {
            for (int j = i*i; j < PRIME_SIZE; j = j+i)
            {
               mPrimes[j] = false;
            }
         }
      }
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      sievePrimes();
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new PrimePandigitalSets().run();
   }

}


