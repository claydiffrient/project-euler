import java.math.BigInteger;

/**
 * Summation
 *
 * A solution to Project Euler problem #2.
 *
 * @author Clay Diffrient
 *
 */

public class Summation
    implements Runnable
{
    BigInteger mSum = BigInteger.ZERO;
    BigInteger mTermOne = BigInteger.ZERO;
    BigInteger mTermTwo = BigInteger.ONE;
    BigInteger mNextTerm = BigInteger.ZERO;
    BigInteger mMultiplesOf = BigInteger.ONE;
    BigInteger mLimit = BigInteger.ONE;

    /**
      * Constructor
      */
    public Summation(String[] args)
    {
         try
         {
             mMultiplesOf = new BigInteger(args[0]);
             mLimit = new BigInteger(args[1]);
         }
         catch (Exception e)
         {
             System.out.println("Error with arguments.");
             System.out.println("Usage: Summation a b");
             System.out.println("a = sum the multiples of this number");
             System.out.println("b = the limit of the Fibonnacci sequence");
             System.exit(1);
         }
    }

    /**
      * generateNextTerm
      *
      * Sets the next term to the next term in the Fibonnacci number sequence.
      */
    private void generateNextTerm()
    {
         mNextTerm = mTermOne.add(mTermTwo);
    }

    /**
      * setTermOne
      *
      * Will set TermOne
      */
    private void setTermOne(BigInteger pNumber)
    {
         mTermOne = pNumber;
    }

    /**
      * setTermTwo
      *
      * Will set TermTwo
      */
    private void setTermTwo(BigInteger pNumber)
    {
         mTermTwo = pNumber;
    }

    /**
      * isMultiple
      *
      * Checks to see if the term is a multiple of the mMultiplesOf variable.
      *
      * @param pNumber the number to check
      *
      * @return boolean
      */
    boolean isMultiple(BigInteger pNumber)
    {
         BigInteger[] array = pNumber.divideAndRemainder(mMultiplesOf);
         if (array[1].equals(BigInteger.ZERO))
         {
             return true;
         }
         else
         {
             return false;
         }
    }

    /**
      * addToSum
      *
      * Adds the given number to the main sum.
      *
      * @param pNumber BigInteger value to add.
      */
    private void addToSum(BigInteger pNumber)
    {
         mSum = mSum.add(pNumber);
    }

    /**
     * display
     *
     * Shows the sum on the console.
     */
   public void display()
   {
      System.out.println(mSum);
   }

    /**
      * run
      *
      * Creates a thread running with everything happening.
      */
    public void run()
    {
         boolean keepGoing = true;
         while (keepGoing)
         {
            generateNextTerm();
            setTermOne(mTermTwo);
            setTermTwo(mNextTerm);
            if (mNextTerm.compareTo(mLimit) > 0)
            {
               keepGoing = false;
               display();
            }
            else
            {
               if (isMultiple(mNextTerm))
               {
                  addToSum(mNextTerm);
               }
            }
         }
    }

    /**
      * Calls the run method of Summation.
      */
    public static void main(String[] args)
    {
         new Summation(args).run();
    }
}
