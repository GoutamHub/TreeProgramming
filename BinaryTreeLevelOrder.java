import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Goutam on 02-12-2016.
 */
class Node3 {
   int data;
   Node3 left, right;
   public Node3 (int dataValue) {
      data = dataValue;
      left = right = null;
   }
}

public class BinaryTreeLevelOrder {
   Node3 root;
   public BinaryTreeLevelOrder() {
      root = null;
   }
   
   void printLeveleOrder() {
      int h = treeHight(root);
      System.out.print("height:  " + h + "\n");
      int i;
      for (i=1 ; i <=h ; i++)
         printAtGivenLevel(root, i);
   }
   /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
   
   int treeHight(Node3 root) {
      if (root == null)
         return 0;
      else {
         int lheight = treeHight(root.left);
         int rheight = treeHight(root.right);
         if (lheight > rheight) {
            return lheight+1;
         }
         else {
            return rheight+1;
         }  
      }
   }
   
   void printAtGivenLevel(Node3 root, int height) {
      if (root == null)
         return;
      if (height == 1)
         System.out.print(root.data + " ");
      else if (height > 1) {
         printAtGivenLevel(root.left, height - 1);
         printAtGivenLevel(root.right, height - 1);
      }     
   }
   
   void printBfsIterative (Node3 root) {
      Queue<Node3> queue = new LinkedList<Node3>();
      queue.add(root);
      while (!queue.isEmpty()) {
         Node3 tempNode = queue.poll();
         System.out.print(tempNode.data + " ");
         if (tempNode.left != null)
            queue.add(tempNode.left);
         if (tempNode.right != null)
            queue.add(tempNode.right);
      }
   }
   
   public static void main (String args[]) {
      BinaryTreeLevelOrder bfs = new BinaryTreeLevelOrder();
      bfs.root = new Node3(1);
      bfs.root.left = new Node3(2);
      bfs.root.right = new Node3(3);
      bfs.root.left.left = new Node3(4);
      bfs.root.left.right = new Node3(5);
      bfs.root.right.left = new Node3(6);
      bfs.root.right.right = new Node3(7);
      bfs.root.left.right.left = new Node3(8);
      bfs.printLeveleOrder();   
      System.out.print("\n");
      bfs.printBfsIterative(bfs.root);
   }
}
