import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Goutam on 05-12-2016.
 */

class Node7{
   int data;
   Node7 left, right;
   public Node7(int dataValue) {
      data = dataValue;
      left = right = null;
   }
}


public class SameTree {
   Node7 root1, root2;
   boolean isSameTree() {
      return helperUtil(root1, root2);
   }
   boolean isIdentical () {
      return isIdentical(root1, root2);
   }
   
   
   boolean helperUtil (Node7 root1, Node7 root2) {
      if (root1 == null && root2 == null)
         return true;
      if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
         return false;
      return (root1.data == root2.data && helperUtil(root1.left,root2.left) && helperUtil(root1.right, root2.right));
   }
   
   boolean isIdentical (Node7 root1, Node7 root2) {
      if (root1 == null && root2 == null)
         return true;
      Queue <Node7> queue1 = new LinkedList<Node7>();
      Queue <Node7> queue2 = new LinkedList<Node7>();
      
      queue1.add(root1);
      queue2.add(root2);
      
      while (!queue1.isEmpty() && !queue2.isEmpty()) {
         Node7 temp1 = queue1.poll();
         Node7 temp2 = queue2.poll();
         if (temp1.data == temp2.data) {
            if ((root1.left != null || root2.left != null))
               return false;
            if (root1.left != null && root2.left != null) {
               queue1.add(root1.left);
               queue2.add(root2.left);
            }
            if ((root1.right != null || root2.right != null))
               return false;
            
            if (root1.right != null && root2.right != null) {
               queue1.add(root1.right);
               queue2.add(root2.right);
            }
            
         } else {
            return false;
         }
         
      }
       return true;
   }
   
   public static void main(String args[]) {
      SameTree st = new SameTree();
      st.root1 = new Node7(1);
      st.root1.left = new Node7(2);
      st.root1.right = new Node7(3);
      st.root1.left.left = new Node7(4);
      st.root1.left.right = new Node7(5);

      st.root2 = new Node7(1);
      st.root2.left = new Node7(2);
      st.root2.right = new Node7(3);
      st.root2.left.left = new Node7(4);
      //st.root2.left.right = new Node7(5);
      
      if(st.isSameTree())
      System.out.println("Both the Trees are Identical\n");
      else
         System.out.println("Both the Trees are NOT Identical\n");

      if(st.isIdentical())
         System.out.println("Both the Trees are Identical");
      else
         System.out.println("Both the Trees are NOT Identical");
   }
   
}
