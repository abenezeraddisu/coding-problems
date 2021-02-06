import java.util.*;
class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root);
         while(!q.isEmpty()){
             int sum = 0;
             int s = q.size();
             for(int i= 0; i < s; i++){
                 TreeNode t = q.poll();
                 sum+=t.val;
                 if(t.left!=null)q.offer(t.left);
                 if(t.right!=null)q.offer(t.right);
             }
             result.add((double) sum/s);
         }
         return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
