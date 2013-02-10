/**
 * Solution to Project Euler #15
 * Lattice Paths
 */
import java.math.BigInteger;

public class LatticePath
   implements Runnable
{
   int mSquareSize;

   BigInteger mNumPaths;

   public LatticePath(int pNum)
   {
      mSquareSize = pNum;
   }

   BigInteger getFactorial(BigInteger pIn)
   {
      BigInteger out = BigInteger.ONE;
      for (BigInteger i = BigInteger.ONE; i.compareTo(pIn) <= 0; i = i.add(BigInteger.ONE))
      {
         out = out.multiply(i);
      }
      return out;
   }

   public void run()
   {
      //mNumPaths = (2*n)!/(n!)^2
      BigInteger upper = getFactorial(BigInteger.valueOf(mSquareSize * 2));
      BigInteger lower = getFactorial(BigInteger.valueOf(mSquareSize));
      lower = lower.multiply(lower);
      mNumPaths = upper.divide(lower);
      System.out.println("The value is : " + mNumPaths);
   }

   public static void main(String[] args)
   {
      try
      {
         new LatticePath(Integer.parseInt(args[0])).run();
      }
      catch (Exception e)
      {
         System.out.println("Invalid Input.");
      }
   }


}