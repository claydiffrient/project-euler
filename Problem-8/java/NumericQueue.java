import java.util.ArrayList;
/**
 * Numeric array queue.
 */

public class NumericQueue
{
   /**
    * ArrayList containing the numeric values.
    */
   ArrayList<int> mMainList = new ArrayList<int>();

   /**
    * Range size indication
    */
   int mRangeSize;

   /**
    * Pointer to first element
    */
   int mFirstElement = 0;

   /**
    * Pointer to the last element in the range
    */
   int mLastElement;

   /**
    * Number of elements in structure.
    */
   int mNumElements;

   /**
    * Constructor
    */
   public NumericQueue(pRangeSize)
   {
      mRangeSize = pRangeSize;
      mLastElement = mFirstElement + mRangeSize;
      mNumElements = 0;
   }

   /**
    * Add an element to the queue.
    * @param pElement the number to add
    */
   public void add(int pElement)
   {
      mMainList.add(pElement);
      mNumElements++;
   }

   public int[] getRange(boolean pIncrement)
   {
      int[] returnArray = new int[mRangeSize];
      returnArray[0] = mMainList.get(mFirstElement);
      returnArray[1] = mMainList.get(mFirstElement + 1);
      returnArray[2] = mMainList.get(mFirstElement + 2);
      returnArray[3] = mMainList.get(mFirstElement + 3);
      returnArray[4] = mMainList.get(mFirstElement + 4);

      if (pIncrement)
      {
         mFirstElement = mLastElement;
         mLastElement = mFirstElement + mRangeSize;
      }

      return returnArray;
   }

   /**
    * Increment the start pointer
    */
   private void incrementStart()
   {
      if (mFirstElement + 1 != (mNumElements - mRangeSize))
      {
         mFirstElement++;
      }
   }

   private void incrementEnd()
   {
      if (mLastElement + 1 != mNumElements + 1)
      {
         mLastElement++;
      }
   }

   private void incrementRange()
   {
      incrementEnd();
      incrementStart();
   }


}