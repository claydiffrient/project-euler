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
import java.util.Iterator;
import java.io.FileReader;
import java.io.BufferedReader;


import static com.wagnerandade.coollection.Coollection.*;

public class PasscodeDerivation
   implements Runnable
{

   List<Node> mListOfNodes;
   List<List<Integer>> mListOfValues;
   private final String FILENAME = "keylog.txt";

   /**
    * Default constructor
    */
   public PasscodeDerivation()
   {
      mListOfNodes = new ArrayList<Node>();
      mListOfValues = new ArrayList<List<Integer>>();
   }

   /**
    * Converts Integer lists to int[]
    */
   private int[] toIntArray(List<Integer> pList)
   {
      int[] ret = new int[pList.size()];
      for (int i = 0; i < ret.length; i++)
      {
         ret[i] = pList.get(i);
      }
      return ret;
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
         for (List<Integer> entry : mListOfValues )
         {
            int[] curValues = toIntArray(entry);
            Node firstNode = from(mListOfNodes).where("getValue", eq(curValues[0])).first();
            Node secondNode = from(mListOfNodes).where("getValue", eq(curValues[1])).first();
            Node thirdNode = from(mListOfNodes).where("getValue", eq(curValues[2])).first();
            if (firstNode == null)
            {
               firstNode = new Node(curValues[0]);
               mListOfNodes.add(firstNode);
            }
            if (secondNode == null)
            {
               secondNode = new Node(curValues[1]);
               mListOfNodes.add(secondNode);
            }
            if (thirdNode == null)
            {
               thirdNode = new Node(curValues[2]);
               mListOfNodes.add(thirdNode);
            }
            firstNode.addEdge(secondNode);
            secondNode.addEdge(thirdNode);
         }
         //Get ready to sort.
         Set<Node> startNodes = new HashSet<Node>();
         List<Node> completedSort = new ArrayList<Node>();
         for (Node node : mListOfNodes)
         {
            if (node.getInEdgeSize() == 0)
            {
               startNodes.add(node);
            }
         }
         while (!startNodes.isEmpty())
         {
            Iterator<Node> itr = startNodes.iterator();
            Node next = itr.next();
            itr.remove();
            completedSort.add(next);
            for (Iterator<Edge> it = next.getOutEdges().iterator(); it.hasNext();)
            {
               Edge e = it.next();
               Node m = e.getTo();
               it.remove();
               m.getInEdges().remove(e);
               if (m.getInEdges().isEmpty())
               {
                  startNodes.add(m);
               }
            }
         }
         boolean repeat = false;
         for (Node n : mListOfNodes)
         {
            if (!n.getInEdges().isEmpty())
            {
               repeat = true;
               break;
            }
         }
         if (repeat)
         {
            System.out.println("Cycle present. Not possible.");
         }
         else
         {
            System.out.println("Passcode:" + Arrays.toString(completedSort.toArray()));
         }

      }
      catch (Exception e)
      {
         System.out.println("Error reading file.");
         e.printStackTrace();
         System.exit(1);
      }



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
   public class Node
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

      public Set<Edge> getOutEdges()
      {
         return mOutEdges;
      }

      public int getInEdgeSize()
      {
         return mInEdges.size();
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

      @Override
      public String toString()
      {
         return String.valueOf(mValue);
      }
   }

   public  class Edge
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


