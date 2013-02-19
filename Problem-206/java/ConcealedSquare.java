/**
 * Solution to Project Euler #206
 */



public class ConcealedSquare
   implements Runnable
{
   long mStart = 1000000000;
   long mEnd = 1389026623;

   public static void checkNumber(long pStart, long pEnd, long pIncrement)
   {
      for (long current = pStart; current < pEnd; current += pIncrement)
      {
         String string = String.valueOf(current * current);
         boolean isValid = true;
         for (int i = 1; i <= 9 && isValid; i++)
         {
            if (string.charAt(2 * (i-1)) != '0' + i)
            {
               isValid = false;
            }
         }
         if (string.charAt(2*(10-1)) != '0')
         {
            isValid = false;
         }
         if (isValid)
         {
            System.out.println("Solution:" + current);
         }
      }
   }

   public void run()
   {
      new Thread(){
         public void run()
         {
            checkNumber(mStart + 30, mEnd, 100);
         }
      }.start();
      new Thread(){
         public void run()
         {
            checkNumber(mStart + 70, mEnd, 100);
         }
      }.start();
   }



   public static void main(String[] args)
   {
      new ConcealedSquare().run();
   }
}