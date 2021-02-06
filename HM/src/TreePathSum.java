import java.util.*;
public class TreePathSum {
    public static boolean hasPath(TreeNode root, int sum) {
        if(root == null) return  false;
        if(root.left == null && root.right==null) return  root.val == sum;
        return  hasPath(root.left, sum - root.val)|| hasPath(root.right, sum - root.val);
    }
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        return allPaths;
    }
    public static  List<List<Integer>> recurse(TreeNode tree, int sum, List<Integer> path, List<List<Integer>> all){
        if(tree==null) return null;
        path.add(tree.val);
        if(tree.val == sum && tree.left == null && tree.right == null){
            all.add(new ArrayList<>(tree.val));
        }
        else {
            recurse(tree.left, sum - tree.val, path, all);
            recurse(tree.left, sum - tree.val, path, all);
        }
        path.remove(path.size()-1);
        return  all;
    }
    public static int findSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        return root.val + findSum(root.left) + findSum(root.right);
    }
    public static int  allpathsum(TreeNode root){
        return  helper(root, 0);
    }
    public static  int helper( TreeNode root, int s){
        if(root == null) return  0;
        s =  10*s + root.val;
        if(root.left == null&& root.right == null) return  s;
        return  helper(root.left, s) + helper(root.right, s);
    }
    public boolean isthere(TreeNode tree, int[] arr){
return  helper(tree, arr,0 );
    }
    public  boolean helper(TreeNode tree,int[] arr, int i){
        if(i>arr.length || tree.val!= arr[i]) return  false;
        if(tree.left == null && tree.right == null && tree.val == arr[i]) return  true;
        return helper(tree.right, arr, i+1) || helper(tree.left, arr, i+1);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
        System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
    }
}