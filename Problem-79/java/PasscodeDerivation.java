/**
* Solution to Project Euler #79.
*
* Makes a keycode solution
*
* Problem Link: http://projecteuler.net/problem=79
* Github Issue: https://github.com/claydiffrient/project-euler/issues/86
*
* Created by: Clay Diffrient
* Email: clay.diffrient@gmail.com
* Github/Twitter: @claydiffrient
* Project Euler Account: http://projecteuler.net/profile/claydiffrient.png
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PasscodeDerivation
   implements Runnable
{
   /**
    * Default constructor
    */
   public PasscodeDerivation()
   {

   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      Node one = new Node(1);
      Node two = new Node(2);
      one.addEdge(two);
   }

   /**
    * Main
    * @param args command-line input
    */
   public static void main(String[] args)
   {
      new PasscodeDerivation().run();
   }

   /**
    * Inner Classes
    */
   private class Node
   {
      private int mValue;
      private Set<Edge> mInEdges;
      private Set<Edge> mOutEdges;

      public Node(int pValue)
      {
         mValue = pValue;
         mInEdges = new HashSet<Edge>();
         mOutEdges = new HashSet<Edge>();
      }

      public Set<Edge> getInEdges()
      {
         return mInEdges;
      }

      public Node addEdge(Node pNode)
      {
         Edge e = new Edge(this, pNode);
         mOutEdges.add(e);
         pNode.getInEdges().add(e);
         return this;
      }

      public int getValue()
      {
         return mValue;
      }
   }

   private class Edge
   {
      private Node mFrom;
      private Node mTo;

      public Edge(Node pFrom, Node pTo)
      {
         mFrom = pFrom;
         mTo = pTo;
      }

      public Node getFrom()
      {
         return mFrom;
      }

      public Node getTo()
      {
         return mTo;
      }

      @Override
      public boolean equals(Object pObj)
      {
         Edge e = (Edge) pObj;
         return e.getFrom() == mFrom && e.getTo() == mTo;
      }
   }
}


