package treeprograms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Goutam on 2/9/2018.
 */
public class Q12ConnectSameLevel {
    static class newNode{
        int data;
        newNode left;
        newNode right;
        newNode rightConnection;
        
        public newNode(int value){
            data = value;
            left = right = rightConnection = null;
        }
    }
    
    static newNode root;
    
    static void connect(newNode root){
        if(root == null)
            return;
        Queue<newNode> q = new LinkedList<newNode>();
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            newNode p = q.peek();
            q.remove();
            
            if(p != null){
                p.rightConnection = q.peek();
                
                if(p.left != null)
                    q.add(p.left);
                if(p.right != null)
                    q.add(p.right);
            }
            else if(!q.isEmpty()){
                q.add(null);
            }
        }
        
    }
    
    
    public static void main(String args[]) {
        Q12ConnectSameLevel tree = new Q12ConnectSameLevel();
        tree.root = new newNode(10);
        tree.root.left = new newNode(8);
        tree.root.right = new newNode(2);
        tree.root.left.left = new newNode(3);
        tree.root.right.right = new newNode(9);
        
        connect(root);
        
        System.out.println(tree.root.left.rightConnection.data);
    }
}
