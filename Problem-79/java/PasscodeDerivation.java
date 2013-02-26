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
import java.io.FileReader;
import java.io.BufferedReader;

public class PasscodeDerivation
   implements Runnable
{

   List<Node> mListOfNodes;
   List<List<Integer>> mListOfValues;
   private final string FILENAME = "keylog.txt";

   /**
    * Default constructor
    */
   public PasscodeDerivation()
   {
      mListOfNodes = new ArrayList<Node>();
      mListOfValues = new ArrayList<ArrayList<Integer>>();
   }

   /**
    * Run all the code in a thread.
    */
   public void run()
   {
      try
      {
         BufferedReader in = new BufferedReader(new FileReader(FILENAME));
         while (in.ready())
         {
            List<Integer> values = new ArrayList<Integer>();
            String text = in.readLine();
            for (int i = 0; i < text.length(); i++)
            {
               values.add(Character.getNumericValue(text.charAt(i)));
            }
            mListOfValues.add(values);
         }

      }
      catch (Exception e)
      {
         System.out.println("Error reading file.")
         e.printStackTrace();
         System.exit(1);
      }

      Set<Node> startNodes = new HashSet<Node>();
      //Loop through each set of 3 nodes and add them to the hash set as needed.
      //Perform topological sort.
      //Output the value.
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


