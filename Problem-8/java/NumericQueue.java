import java.util.ArrayList;
/**
 * Numeric array queue.
 */

public class NumericQueue
{
   /**
    * ArrayList containing the numeric values.
    */
   ArrayList<Integer> mMainList = new ArrayList<Integer>();

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
    * Boolean indicating that the last consecutive range has been found.
    */
   private boolean mLastFound;

   /**
    * Constructor
    */
   public NumericQueue(int pRangeSize)
   {
      mRangeSize = pRangeSize;
      mLastElement = mFirstElement + mRangeSize;
      mNumElements = 0;
      mLastFound = false;
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
      for (int i = 0; i < mRangeSize; i++)
      {
         if ((mFirstElement + i) >= mNumElements)
         {
            break;
         }
         else
         {
            returnArray[i] = mMainList.get(mFirstElement + i);
         }
      }

      if (pIncrement)
      {
         incrementRange();
      }

      return returnArray;
   }

   public boolean lastFound()
   {
      return mLastFound;
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
      mFirstElement = mLastElement;
      if ((mFirstElement + mRangeSize) <= mNumElements - 1)
      {
         mLastElement = mFirstElement + mRangeSize;
      }
      else
      {
         mLastFound = true;
      }
   }


}