/**
 * Created by Goutam on 05-12-2016.
 */

class Node6 {
   int data;
   Node6 left,right;
   public Node6 (int dataValue) {
      data = dataValue;
      left = right = null;
   }
}

class Index {
   int index;
}

public class TreeFromInOrderPostOrder {
    
   public Node6 buildTreeHelper (int inOrderArray[], int postOrderArray[], int startIndex, int endIndex, Index postindex) {
      if (startIndex > endIndex)
         return null;
      Node6 currentNode = new Node6(postOrderArray[postindex.index--]);
      if (startIndex == endIndex)
         return currentNode;
      int inIndex = search(inOrderArray, startIndex, endIndex, currentNode.data);
      
      currentNode.right = buildTreeHelper(inOrderArray, postOrderArray, inIndex+1, endIndex, postindex);
      currentNode.left = buildTreeHelper(inOrderArray, postOrderArray, startIndex, inIndex-1, postindex);
      
      return currentNode;
   }
   
   /*Utility Functions*/
   
   Node6 buildTree (int inOrderArray[], int postOrderArray[], int arrayLength) {
      Index postindex = new Index();
      postindex.index = arrayLength - 1;
      return buildTreeHelper(inOrderArray, postOrderArray, 0, arrayLength-1, postindex);
   }
   void inOrder(Node6 root) {
      if (root == null)
         return;
      inOrder(root.left);
      System.out.print(" " + root.data);
      inOrder(root.right);
   }
   
   int search (int inOrderArray[], int startIndex, int endIndex, int data) {
      int i = 0;
      for (i = startIndex ; i <= endIndex ; i++) {
         if (inOrderArray[i] == data)
            break;
      }
      return i;
   }
   
   public static void main(String args[]) {
      TreeFromInOrderPostOrder tree = new TreeFromInOrderPostOrder();
      int inOrderArray[] = new int[] {4, 2, 5, 1, 6, 7, 3, 8};
      int postOrderArray[] = new int[] {4, 5, 2, 6, 7, 8, 3, 1};
      int len = inOrderArray.length;
      Node6 root = tree.buildTree(inOrderArray, postOrderArray, len);
      
      System.out.println("The Inorder Traversal for the new build tree is: ");
      tree.inOrder(root);     
   }
}
