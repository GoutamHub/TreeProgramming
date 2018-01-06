package treeprograms;

/**
 * Created by Goutam on 1/6/2018.
 */


public class LeftViewBT {
    Node root;
    public static int lastMaxLevel = 0;
    
    public static void printLeftViewUtil(Node root, int presentLevel){
        if(root == null)
            return;
        
        if(lastMaxLevel < presentLevel){
            System.out.print(root.data + " ");
            lastMaxLevel = presentLevel;
        }
        
        printLeftViewUtil(root.left, presentLevel+1);
        printLeftViewUtil(root.right, presentLevel+1);
    }
    
    public static void printLeftView(Node root){
        printLeftViewUtil(root, 1);
    }
    
    
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        
        printLeftView(root);
    }
}
