/**
 * Created by Goutam on 03-12-2016.
 */

class Node4 {
   int data;
   Node4 left, right;
   public Node4 (int dataValue) {
      data = dataValue;
      left = right = null;
   }
}
public class MirrorTree {
   Node4 root;
   
   void inOrder() {
      inOrder(root);
   }
   
   void inOrder(Node4 root) {
      if (root == null)
         return;
      inOrder(root.left);
      System.out.print(" " + root.data);
      inOrder(root.right);
   }
   
   void mirrorTree() {
      root = mirrorTree(root);
   }
   Node4 mirrorTree(Node4 root) {
      if (root == null)
         return root;
      Node4 left = mirrorTree(root.left);
      Node4 right = mirrorTree(root.right);
      
      root.left = right;
      root.right = left;
      
      return root;
   }
   public static void main(String args[]){
      MirrorTree mt = new MirrorTree();
      mt.root = new Node4(4);
      mt.root.left = new Node4(2);
      mt.root.right = new Node4(5);
      mt.root.left.left = new Node4(1);
      mt.root.left.right = new Node4(3);
      
      System.out.println("The Inorder Traversal for Given Tree is \n");
      mt.inOrder();
      mt.mirrorTree();
      System.out.println("\nThe Inorder Traversal for Mirror Tree is \n");
      mt.inOrder();
      
   }
}
