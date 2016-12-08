import java.util.Vector;

/**
 * Created by Goutam on 07-12-2016.
 */
class Node9 {
   int data;
   Node9 left, right;
   public Node9(int dataValue) {
      data = dataValue;
      left = right = null;
   }
}

public class BSTtoBalancedTree {
   static Node9 root;
   
   Node9 buildTree(Node9 root) {
      Vector <Node9> nodes = new Vector<Node9>();
      inOrderStore(nodes, root);
      int n = nodes.size();
      root = BSTtoBalancedTree(nodes, 0, n-1);
      return root;
   }
   
   public void inOrderStore(Vector <Node9> storage, Node9 root) {
      if (root == null)
         return;
      
      preOrder(root.left);
      storage.add(root);
      preOrder(root.right);
   }
   
   Node9 BSTtoBalancedTree (Vector <Node9> nodes, int startIndex, int endIndex) {
      if (startIndex > endIndex)
         return null;
      int midIndex = (startIndex + endIndex)/2;
      Node9 newRoot = (nodes.get(midIndex));

      newRoot.left = BSTtoBalancedTree(nodes, startIndex, midIndex -1);
      newRoot.right = BSTtoBalancedTree(nodes, midIndex+1, endIndex);

      return newRoot;
   } 
   Node9 BSTtoBalancedTree (int inputArray[], int startIndex, int endIndex) {
      if (startIndex > endIndex)
         return null;
      int midIndex = (startIndex + endIndex)/2;
      Node9 newRoot = new Node9(inputArray[midIndex]);
      
      newRoot.left = BSTtoBalancedTree(inputArray, startIndex, midIndex -1);
      newRoot.right = BSTtoBalancedTree(inputArray, midIndex+1, endIndex);
      
      return newRoot;
   }
   public void preOrder(Node9 root) {
      if (root == null)
         return;
      System.out.print(" " + root.data);
      preOrder(root.left);
      preOrder(root.right);
   }
   
   public static void main(String args[]){
      BSTtoBalancedTree bsb = new BSTtoBalancedTree();
      //int inputArray[] = new int[] {1, 2, 3};
      bsb.root = new Node9(10);
      bsb.root.left = new Node9(8);
      bsb.root.left.left = new Node9(7);
      bsb.root.left.left.left = new Node9(6);
      bsb.root.left.left.left.left = new Node9(5);
      bsb.root = bsb.buildTree(bsb.root);
      //int arrayLenghth = inputArray.length;
      //root = bsb.BSTtoBalancedTree(inputArray, 0, arrayLenghth-1);
      System.out.println("The PreOrder Traversal of the given Tree is: ");
      bsb.preOrder(bsb.root);
      
   }
}
