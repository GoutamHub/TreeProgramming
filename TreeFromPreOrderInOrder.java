/**
 * Created by Goutam on 05-12-2016.
 */

class Node5 {
   int data;
   Node5 left, right;
   public Node5 (int dataValue){
      data = dataValue;
      left = right = null;
   }
}
public class TreeFromPreOrderInOrder {
   Node5 root;
   static int preOrderIndex = 0;
   
   Node5 buildTree (int inOrderArray[], int preOrderArray[], int startIndex, int endIndex) {
      if (startIndex > endIndex)
         return null;
      Node5 currentNode = new Node5(preOrderArray[preOrderIndex++]);
      
      if (startIndex == endIndex)
         return currentNode;
      
      int inOrderIndex = search(inOrderArray, startIndex, endIndex, currentNode.data);
      currentNode.left = buildTree(inOrderArray, preOrderArray, startIndex, inOrderIndex-1);
      currentNode.right = buildTree(inOrderArray, preOrderArray, inOrderIndex+1, endIndex);
      
      return currentNode;
   }
   
   /*Utility Functions*/
   
   int search (int inOrderArray[], int startIndex, int endIndex, int data) {
      int i;
      for (i = startIndex; i<=endIndex; i++) {
         if (inOrderArray[i] == data)
            return i;
      }
      return i;
   }
   void inOrder(Node5 root) {
      if (root == null)
         return;
      inOrder(root.left);
      System.out.print(" " + root.data);
      inOrder(root.right);
   }
   
   
   public static void main (String args[]) {
      TreeFromPreOrderInOrder tree = new TreeFromPreOrderInOrder();
      int inOrder[] = new int[] {4, 2, 5, 1, 6, 7, 3, 8};
      int preOrder[] = new int[] {1, 2, 4, 5, 3, 7, 6, 8};
      int len = inOrder.length;
      
      Node5 root = tree.buildTree  (inOrder, preOrder, 0, len-1);
      System.out.println("The Inorder Traversal for the Constructed Tree is: ");
      tree.inOrder(root);
   } 
}
