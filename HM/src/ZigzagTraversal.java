import java.util.*;
public class ZigzagTraversal {
    public  static List<List< Integer>> zigzag(TreeNode root){
        List<List< Integer>> holder = new ArrayList<>();
        if (root == null) return  holder;
        Queue<TreeNode> q = new LinkedList<>();
        boolean on = true;
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> toput = new LinkedList<>();
            for(int i = 0; i < s; i++){
                TreeNode t = q.poll();
                if(on) toput.add(t.val);
                else toput.add(0, t.val);
                if(t.left!=null) q.offer(t.left);
                if(t.right!=null) q.offer(t.right);
            }
            on = !on;
            holder.add(toput);
        }
        return holder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.zigzag(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
