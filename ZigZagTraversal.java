import java.util.Stack;

/**
 * Created by Goutam on 05-12-2016.
 */

class Node8 {
   int data;
   Node8 left, right;
   public Node8(int dataValue) {
      data = dataValue;
      left = right = null;
   }
}
public class ZigZagTraversal {
   Node8 root; 
   void printSpiralIterative (Node8 root) {
      if (root == null)
         return;
      Stack<Node8> s1 = new Stack<Node8>();
      Stack<Node8> s2 = new Stack<Node8>();
      s1.push(root);
      
      while(!s1.isEmpty() || !s2.isEmpty()) {
         
         while(!s1.isEmpty()) {
            Node8 temp = s1.peek();
            s1.pop();
            System.out.print(" " + temp.data);
            if (temp.left != null)
               s1.push(temp.left);
            if (temp.right != null)
               s1.push(temp.right);
         }
         
         while(!s2.isEmpty()) {
            Node8 temp = s2.peek();
            s2.pop();
            System.out.print(" " + temp.data);
            if (temp.right != null)
               s2.push(temp.right);
            if (temp.left != null)
               s2.push(temp.left);
         }
      }
      
   }
   
   void printSpiral (Node8 root) {
      int height = treeHeight(root);
      boolean directionFlag = false;
      int tempo;
      for (tempo = 1; tempo <= height ; tempo++) {
         printAtGivenLevel(root, tempo, directionFlag);
         directionFlag = !directionFlag;
      }
   }
   
   void printAtGivenLevel(Node8 root, int level, boolean directionFlag) {
      if (root == null)
         return;
      if (level == 1)
         System.out.print(" " + root.data);
      else if (level > 1) {
         if (directionFlag != false) {
            printAtGivenLevel(root.left, level -1, directionFlag);
            printAtGivenLevel(root.right, level -1, directionFlag);
         } else {
            printAtGivenLevel(root.right, level -1, directionFlag);
            printAtGivenLevel(root.left, level -1, directionFlag);
         }
      }
   }
   /*Utility Function*/
   int treeHeight(Node8 root) {
      if (root == null) {
         return 0;
      } else {
         int leftSubTreeHeight = treeHeight(root.left);
         int rightSubTreeHeight = treeHeight(root.right);
         
         if (leftSubTreeHeight > rightSubTreeHeight)
            return leftSubTreeHeight +1;
         else 
            return rightSubTreeHeight +1;
      }
   }
   public static void main (String args[]) {
      ZigZagTraversal tree = new ZigZagTraversal();
      tree.root = new Node8(1);
      tree.root.left = new Node8(2);
      tree.root.right = new Node8(3);
      tree.root.left.left = new Node8(7);
      tree.root.left.right = new Node8(6);
      tree.root.right.left = new Node8(5);
      tree.root.right.right = new Node8(4);
      System.out.println("Spiral order traversal of Binary Tree is ");
      tree.printSpiral(tree.root);
      System.out.println("\n\nSpiral order traversal of Binary Tree is Iterative:");
      tree.printSpiralIterative(tree.root);
   }
}
