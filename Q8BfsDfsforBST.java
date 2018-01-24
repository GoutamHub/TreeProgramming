package treeprograms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Goutam on 1/24/2018.
 */
public class Q8BfsDfsforBST {
    static Node root;
     
    public void bfs(Node root, int k){
        if(root == null)
            return;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp.data == k) {
                System.out.print("get the key");
                return;
            }
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
        }

        System.out.print("search key is not present in the tree!");
    }

    public void dfs(Node root, int k){
        if(root == null)
            return;
        dfs(root.left, k);
        if(root.data == k){
            System.out.print("get the key");
            return;
        }
        dfs(root.right, k);
    }
    
    public static void main( String args[]){
        Q8BfsDfsforBST tree = new Q8BfsDfsforBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        int k = 18;
        tree.bfs(root, k);
        System.out.println();
        tree.dfs(root, k);
        
    }
}
