package treeprograms;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Vector;


/**
 * Created by Goutam on 1/20/2018.
 */
public class VerticalOrderTraversal {
    NodeV root;
    
    void printVoT(){
        
        if(root == null)
            return;
        
        /*initialization part*/
        root.hd = 0;
        Queue<NodeV> q = new LinkedList<>();
        TreeMap<Integer, Vector<Integer>> tm = new TreeMap<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            NodeV temp = q.remove();
            int hd = temp.hd;
            Vector<Integer> getVList = tm.get(hd);
            
            if(getVList == null) {
                getVList = new Vector<>();
                getVList.add(temp.data);
            } else {
                getVList.add(temp.data);
            }
            
            tm.put(hd, getVList);
            
            
            if(temp.left != null){
                temp.left.hd = hd -1;
                q.add(temp.left);
            }
            if(temp.right != null){
                temp.right.hd = hd +1;
                q.add(temp.right);
            }
        }

        for (Map.Entry<Integer, Vector<Integer>> entry : tm.entrySet()) {
            System.out.print(entry.getValue() + "\n");
        }
    }
    
    public static void main(String args[]){
        VerticalOrderTraversal tree = new VerticalOrderTraversal();
        tree.root = new NodeV(20);
        tree.root.left = new NodeV(8);
        tree.root.right = new NodeV(22);
        tree.root.left.left = new NodeV(5);
        tree.root.left.right = new NodeV(3);
        tree.root.right.left = new NodeV(4);
        tree.root.right.right = new NodeV(25);
        tree.root.right.right.left = new NodeV(10);
        tree.root.right.right.right = new NodeV(14);
        System.out.println("The vertical order of the given binary tree:");
        tree.printVoT();
    }
}
