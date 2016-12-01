/**
 * Created by Goutam on 01-12-2016.
 */

class Node {
   int data;
   Node left, right ;
   public Node (int dataValue) {
      data = dataValue;
      left = right = null;
   }

}
public class BinarySearchTree {

   Node root;
   boolean isBST() {
      return helper (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   boolean helper (Node root, int minValue, int maxValue) {

      if (root == null)
         return true;

      if ((root.data < minValue) || (root.data > maxValue))
         return false;

      return (helper (root.left, minValue, root.data) && helper (root.right, root.data, maxValue));
   }
   public static void main(String args[]) {
      BinarySearchTree bst = new BinarySearchTree();
      bst.root = new Node(4);
      bst.root.left = new Node(2);
      bst.root.right = new Node(0);
      bst.root.left.left = new Node(1);
      bst.root.left.right = new Node(3);
      long startTime = System.nanoTime();
      if (bst.isBST())
         System.out.println("Given Tree is a Binary Search Tree");
      else
         System.out.println("Given Tree is not a Binary Search Tree");
      long endTime = System.nanoTime();
      System.out.println("Took "+(endTime - startTime) + " ns");
   }
}
