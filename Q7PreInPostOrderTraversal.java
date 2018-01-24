package treeprograms;

/**
 * Created by Goutam on 1/24/2018.
 */
public class Q7PreInPostOrderTraversal {
    static Node root;
    
    public void printInOrder(Node root){
        if(root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.data);
        printInOrder(root.right);
    }

    public void printPreOrder(Node root){
        if(root == null)
            return;
        System.out.print(root.data);
        printInOrder(root.left);
        printInOrder(root.right);
    }

    public void printPostOrder(Node root){
        if(root == null)
            return;
        printInOrder(root.right);
        printInOrder(root.left);
        System.out.print(root.data);
    }
    
    public static void main( String args[]){
        Q7PreInPostOrderTraversal tree = new Q7PreInPostOrderTraversal();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        tree.printInOrder(root);
        System.out.println();
        tree.printPreOrder(root);
        System.out.println();
        tree.printPostOrder(root);
    }
}
