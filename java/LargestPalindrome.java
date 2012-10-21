/**
 * LargestPalindrome
 *
 * A solution to Project Euler problem #4. Will work for 3 digits multiples.
 *
 * @author Clay Diffrient
 *
 */
public class LargestPalindrome
   implements Runnable
{
   //////////////////////////////////////////Member Variables
   int mNumDigits = 1;
   int mFactors = 9;
   int mFinalFactorOne = 1;
   int mFinalFactorTwo = 1;
   int mLowerFactorLimit = 1;

   /////////////////////////////////////////Constructors

   /**
    * Default Constructor
    *
    * @param args string array containing the commandline arguments
    */
   LargestPalindrome(String[] args)
   {
      try
      {
         mNumDigits = Integer.parseInt(args[0]);
      }
      catch (Exception e)
      {
         System.out.println("Argument error.");
         System.out.println("Usage: LargestPalindrome a");
         System.out.println("       a - the number of digits in the factors");
         System.exit(1);
      }
   }

   /**
    * Constructor
    *
    * @param pNumber the number to find information for.
    */
   LargestPalindrome(int pNumber)
   {
      mNumDigits = pNumber;
   }

   ////////////////////////////////////////Methods

   /**
    * findFactors
    *
    * Determine the largest factor based on the number of digits needed.
    *
    */
   private void findFactors()
   {
      String stringVersion = "9";
      for (int i = 1; i < mNumDigits; i++)
      {
         stringVersion += "9";
      }
      mFactors = Integer.parseInt(stringVersion);
      String stringVersionTwo = "9";
      for (int i = 1; i < mNumDigits - 1; i++)
      {
         stringVersionTwo += "9";
      }
      mLowerFactorLimit = Integer.parseInt(stringVersionTwo);
   }

   /**
    * multiplyFactors
    *
    * Will multiply factors.  It checks for a palindrome by calling
    * palindromeCheck().
    *
    * @return int
    */
   private int multiplyFactors()
   {
      int largest = 0;
      for (int i = mFactors; i >= mLowerFactorLimit; i--)
      {
         for (int j = mFactors; j >= mLowerFactorLimit; j--)
         {
            int product = i * j;
            if (palindromeCheck(product) && (product > largest))
            {
               largest = product;
               mFinalFactorOne = i;
               mFinalFactorTwo = j;
               //return product;
            }
         }
      }
      return largest;
   }


   /**
    * palindromeCheck
    *
    * Determines if the pNumber is a palindrome
    *
    * @param pNumber the integer to check
    *
    * @return boolean
    *
    */
   private boolean palindromeCheck(int pNumber)
   {
      String stringVersion = Integer.toString(pNumber);
      String reverse = new StringBuffer(stringVersion).reverse().toString();
      return (stringVersion.equals(reverse));
   }

   /**
    * getFactorString
    *
    * Creates a simple string in the "A and B" format from the two factors
    * that were multiplied to give the palindromatic string.
    *
    * @return String
    */
   public String getFactorString()
   {
      String r = new Integer(mFinalFactorOne).toString();
      r += " and ";
      r += new Integer(mFinalFactorTwo).toString();
      return r;
   }

   /**
    * run
    *
    * starts a thread with everything happening.
    */
   public void run()
   {
      findFactors();
      System.out.println("Largest Palindrome: " + multiplyFactors());
      System.out.println("Which results from " + getFactorString());
   }

   /**
    * main
    *
    * @param args
    */
   public static void main(String[] args)
   {
      new LargestPalindrome(args).run();
   }
}
