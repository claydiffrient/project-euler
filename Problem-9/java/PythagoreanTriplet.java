import java.util.ArrayList;

/**
 * Finds the number of Pythagorean Triplets with a provide sum value,
 * the product of a*b*c, and the values of a, b, and c.
 */
public class PythagoreanTriplet
   implements Runnable
{
   /**
    * A value
    */
   int mA;

   /**
    * B value
    */
   int mB;

   /**
    * C value
    */
   int mC;

   /**
    * Summed value
    */
   int mSum;

   /**
    * Product value
    */
   int mGreatestProduct;

   /**
    * Array of possible values
    */
   ArrayList<Triple> mTriples = new ArrayList<Triple>();


   /**
    * Constructor
    */
   public PythagoreanTriplet(String[] args)
   {
      try
      {
         mSum = Integer.parseInt(args[0]);
         mGreatestProduct = 1;
      }
      catch (Exception e)
      {
         System.out.println("Error with Arguments.");
         System.out.println("Usage: java PythagoreanTriplets a");
         System.out.println("a = Sum of a+b+c");
         System.exit(1);
      }
   }

   public void run()
   {
      for (int c = 0; c <= mSum; c++ )
      {
         for (int b = 0; b < c; b++)
         {
            for (int a = 0; a < b; a++)
            {
               if ((a + b + c) == mSum)
               {
                  if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2))
                  {
                     mTriples.add(new Triple(a,b,c));
                  }
               }
            }
         }
      }
      int numTriples = mTriples.size();
      if (numTriples > 0)
      {
         System.out.println("There are: " + numTriples + " triples.");
         int location = 0;
         for (int i = 0; i < numTriples; i++)
         {
            if (mTriples.get(i).product() > mGreatestProduct)
            {
               mGreatestProduct = mTriples.get(i).product();
               location = i;
            }
         }
         System.out.println("The greatest product is: " + mGreatestProduct);
         System.out.println("which is formed by the triple: ");
         mTriples.get(location).display();
      }
      else
      {
         System.out.println("There are no triples.");
      }

   }

   /**
    * Main
    */
   public static void main(String[] args)
   {
      new PythagoreanTriplet(args).run();
   }

   private class Triple
   {
      /**
       * A value
       */
      int mA;
      /**
       * B value
       */
      int mB;
      /**
       * B value
       */
      int mC;

      public Triple(int pA, int pB, int pC)
      {
         mA = pA;
         mB = pB;
         mC = pC;
      }

      int getA()
      {
         return mA;
      }
      int getB()
      {
         return mB;
      }
      int getC()
      {
         return mC;
      }
      void setA(int pA)
      {
         mA = pA;
      }
      void setB(int pB)
      {
         mB = pB;
      }
      void setC(int pC)
      {
         mC = pC;
      }

      int product()
      {
         return mA * mB * mC;
      }

      void display()
      {
         System.out.println("A=" + mA);
         System.out.println("B=" + mB);
         System.out.println("C=" + mC);
      }

   }

}