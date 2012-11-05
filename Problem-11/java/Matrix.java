import java.util.ArrayList;
/**
 * Matrix Class
 */
public class Matrix<Type>
{
   /**
    * Main ArrayList
    */
   ArrayList<ArrayList<Type>> mMainArray;

   public Matrix()
   {
      mMainArray = new ArrayList<ArrayList<Type>>();
   }

   /**
    * ensures a minimum capacity of num rows. Note that this does not guarantee
    * that there are that many rows.
    *
    * @param num
    */
   public void ensureCapacity(int num)
   {
      mMainArray.ensureCapacity(num);
   }

   /**
    * Ensures that the given row has at least the given capacity. Note that
    * this method will also ensure that getNumRows() >= row
    *
    * @param row
    * @param num
    */
   private void ensureCapacity(int row, int num)
   {
      ensureCapacity(row);
      while (row < getNumRows())
      {
         mMainArray.add(new ArrayList<Type>());
      }
      mMainArray.get(row).ensureCapacity(num);
   }

   /**
    * Adds the element to the given row.
    */
   public void add(Type pElement, int row)
   {
      ensureCapacity(row);
      while(row >= getNumRows())
      {
         mMainArray.add(new ArrayList<Type>());
      }
      mMainArray.get(row).add(pElement);
   }

   public Type get(int row, int col)
   {
      return mMainArray.get(row).get(col);
   }

   public int getNumRows()
   {
      return mMainArray.size();
   }

   public int getNumCols(int row)
   {
      return mMainArray.get(row).size();
   }

   public void display()
   {
      for (int r = 0; r < getNumRows(); r++)
      {
         for (int c = 0; c < getNumCols(r); c++)
         {
            System.out.print(get(r,c) + " ");
         }
         System.out.print("\n");
      }
   }

   /**
    * Testing Main
    */
   public static void main(String[] args)
   {
      Matrix testing = new Matrix();
      testing.add(1,0);
      testing.add(2,0);
      testing.add(3,0);
      testing.add(4,1);
      testing.add(5,1);
      testing.add(6,1);
      testing.add(7,2);
      testing.add(8,2);
      testing.add(9,2);

      testing.display();
   }

}
