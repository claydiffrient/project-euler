/**
 * Integer Binary Tree
 */

public class BinaryTree
{
   /**
    * Private class representing a node on the tree.
    */
   private static class BinaryNode
   {
      /**
       * Holds integer value.
       */
      private Integer mValue;
      /**
       * Holds reference to the left node.
       */
      private BinaryNode mLeft;
      /**
       * Holds reference to the right node.
       */
      private BinaryNode mRight;
      /**
       * Constructor which creates a node with the given value.
       */
      private BinaryNode(Integer pValue)
      {
         mValue = pValue;
         mLeft = null;
         mRight = null;
      }
      /**
       * Constructor which sets no inital value.
       */
      private BinaryNode()
      {
         mValue = null;
         mLeft = null;
         mRight = null;
      }
   }

   /**
    * Holds a reference to the root node.
    */
   private BinaryNode mRoot;

   /**
    * Constructor which creates a null rooted tree.
    */
   public BinaryTree()
   {
      mRoot = new BinaryNode();
   }

   /**
    * Constructor which creates a tree with the given value as the root.
    */
   public BinaryTree(Integer pValue)
   {
      mRoot = new BinaryNode(pValue);
   }

   /**
    * Sets the root node value.
    */
}