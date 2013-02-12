/**
 * Solution to Project Euler #18
 */

import java.util.List;
import java.util.ArrayList;

public class MaxPathSum
   implements Runnable
{
   String mFileName;
   List<List<Integer>> mTree;

   public MaxPathSum(String pFileName)
   {
      mFileName = pFileName;
      mTree = new ArrayList<ArrayList<Integer>>();
   }

   public void run()
   {


   }

   public static void main(String[] args)
   {
      if (args[0] == null)
      {
         System.out.println("Invalid input.");
         System.exit(1);
      }
      new MaxPathSum(args[0]).run();
   }
}