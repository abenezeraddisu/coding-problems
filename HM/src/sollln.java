import java.util.ArrayList;
import java.util.List;

public class sollln {
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int p = left + (right - left) / 2;
        TreeNode t = new TreeNode(nums[p]);
        t.left = helper(left, p - 1);
        t.right = helper(p + 1, right);
        return t;

    }

    public void helper(TreeNode t, List<Integer> list) {
        if (t != null) {
            if (t.left != null) helper(t.left, list);
            list.add(t.val);
            if (t.right != null) helper(t.right, list);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

}