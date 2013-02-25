/**
* Solution to Project Euler #36.
*
* Finds the sum of all numbers less than 1,000,000 which are palindromes in
* both base 2 and base 10
*
* Problem Link: http://projecteuler.net/problem=36
* Github Issue: https://github.com/claydiffrient/project-euler/issues/43
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

public class DoubleBasePalindromes
   implements Runnable
{

   private final int MAX = 1000000;

   /**
    * Default constructor
    */
   public DoubleBasePalindromes()
   {

   }

   /**
    * palindromeCheck
    * Determines if the pNumber is a palindrome
    * @param pNumber the integer to check
    * @return boolean
    */
   private boolean palindromeCheck(int pNumber)
   {
      String stringVersion = Integer.toString(pNumber);
      String reverse = new StringBuffer(stringVersion).reverse().toString();
      return (stringVersion.equals(reverse));
   }

   private boolean palindromeCheck(String pNumber)
   {
      String reverse = new StringBuffer(pNumber).reverse().toString();
      return (pNumber.equals(reverse));
   }

   /**
    * toBaseTwo
    * @param pNum the number to change to base 2
    * @return String representing the number in base 2.
    */
   private String toBaseTwo(int pNum)
   {
      return Integer.toBinaryString(pNum);
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      int sum = 0;
      for (int i = 0; i < MAX; i++)
      {
         if (palindromeCheck(i) && palindromeCheck(toBaseTwo(i)))
         {
            sum += i;
         }
      }
      System.out.println("Sum = " + sum);

   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new DoubleBasePalindromes().run();
   }

}


