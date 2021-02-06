import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class findDepth {
    public static int findDepth(TreeNode root) {
        ArrayList<Integer> holder = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        int min = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            min++;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode t = q.poll();
                if (t.left == null && t.right == null) holder.add(min);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return Collections.max(holder); ///to get max; return min to get min;
    }

    public static void connect(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode previousNode = null;
            int levelSize = queue.size();
            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (previousNode != null)
                    //previousNode.next = currentNode; for next to work define linkedlist first here
                    previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Maximum Depth: " + findDepth.findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Maximum Depth: " + findDepth.findDepth(root));
    }
}