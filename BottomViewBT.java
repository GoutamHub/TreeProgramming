package treeprograms;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by Goutam on 1/9/2018.
 */

class NodeV{
    int data;
    int hd;
    NodeV left, right;
    public NodeV(int item){
        data = item;
        left = right = null;
    }
}
public class BottomViewBT {
    NodeV root;
    
    public void bottomView(){
        if(root == null)
            return;
        
        /*Initialization-Section*/
        int hd = 0;
        root.hd = hd;
        Queue<NodeV> q = new LinkedList<NodeV>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(root);
        /*--------*/
        
        while(!q.isEmpty()){
            NodeV temp = q.remove();
            
            hd = temp.hd;
            
            //Below if condition will imposed if we need TopLevel View!!
            if(!map.containsKey(hd)) {
                map.put(hd, temp.data);
            }
            
            if(temp.left != null){
                temp.left.hd = hd -1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.hd = hd +1;
                q.add(temp.right);
            }
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }
    
    
    public static void main(String args[]){
        BottomViewBT tree = new BottomViewBT();
        tree.root = new NodeV(20);
        tree.root.left = new NodeV(8);
        tree.root.right = new NodeV(22);
        tree.root.left.left = new NodeV(5);
        tree.root.left.right = new NodeV(3);
        tree.root.right.left = new NodeV(4);
        tree.root.right.right = new NodeV(25);
        tree.root.left.right.left = new NodeV(10);
        tree.root.left.right.right = new NodeV(14);
        System.out.println("Bottom view of the given binary tree:");
        tree.bottomView();
        
    }
}
