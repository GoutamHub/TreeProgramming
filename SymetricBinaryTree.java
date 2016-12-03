/**
 * Created by Goutam on 01-12-2016.
 */
class Node2 {
   int data;
   Node2 left, right;
   public Node2 (int dataValue) {
      data = dataValue;
      left = right = null;
   }
}

public class SymetricBinaryTree {

   static Node2 root;

   static boolean isSymetric() {
      if (root == null)
         return true;
      return isSymetric(root, root);
   }

   static boolean isSymetric(Node2 leftroot, Node2 rightroot) {
      if (leftroot == null && rightroot == null)
         return true;
      else if (leftroot == null || rightroot == null)
         return false;
      if (leftroot.data != rightroot.data)
         return false;
      if (!isSymetric(leftroot.left, rightroot.right))
         return false;
      if (!isSymetric(leftroot.right, rightroot.left))
         return false;

      return true;
   }

   public static void main(String args[]) {
      SymetricBinaryTree sbt = new SymetricBinaryTree();
      sbt.root = new Node2(1);
      sbt.root.left = new Node2(2);
      sbt.root.right = new Node2(2);
      sbt.root.left.left = new Node2(3);
      sbt.root.left.right = new Node2(4);
      sbt.root.right.left = new Node2(3);
      sbt.root.right.right = new Node2(4);
                     
      if (isSymetric())
         System.out.println("Mirror");
      else
         System.out.println("Not Mirror");
   }
}

