import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};

public class LevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> holder = new ArrayList<>();
        if (root == null) {
            return holder;
        }
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while (!q.isEmpty()){
            int s = q.size();
            List<Integer> h = new ArrayList<>();
            for(int i = 0; i< s; i++){
               TreeNode bro =  q.poll();
               h.add(bro.val );
               if(bro.right!=null) q.offer( bro.right);
               if(bro.left!=null) q.offer(bro.left);

            }
            holder.add(h);
        }
        return  holder;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
        List<List<Integer>> bruh = new LinkedList<>();
    }
}
