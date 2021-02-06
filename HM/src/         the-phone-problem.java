import java.util.*;

class Solutio {

    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1) {
                String doubleSymbol = s.substring(i, i + 2);
                // Check if this is the length-2 symbol case.
                if (values.containsKey(doubleSymbol)) {
                    sum += values.get(doubleSymbol);
                    i += 2;
                    continue;
                }
            }
            // Otherwise, it must be the length-1 symbol case.
            String singleSymbol = s.substring(i, i + 1);
            sum += values.get(singleSymbol);
            i += 1;
        }
        return sum;
    }

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = (getNext(getNext(fastRunner)));
        }
        return fastRunner == 1;
    }

    public int trailingZeroes(int n) {
        int count = 0;
        long curr = 5;
        while (n >= curr) {
            count += n / curr;
            curr *= 5;
        }
        return count;
    }

    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }
        return result;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            list.add(l);
        }
        return list;
    }

    public TreeNode helper(int[] nums, int i, int j) {
        if (i > j) return null;
        int p = i + (j - i) / 2;
        TreeNode t = new TreeNode(p);
        t.left = helper(nums, i, p - 1);
        t.right = helper(nums, p + 1, j);
        return t;
    }
}
