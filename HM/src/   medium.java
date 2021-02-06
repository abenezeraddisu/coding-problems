import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class lmaooooo {
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left + 1;
    }

    public String longestPalindrome(String s) {
        int end = 0;
        int start = 0;
        if (s == null || s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public boolean canJump(int[] nums) {
        int curr = nums.length - 1;
        for (int i = nums.length - 1; i <= 0; i--) {
            if (nums[i] + i > curr) curr = nums[i];
        }
        return curr == 0;
    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) row[0] = 1;
        for (int num : matrix[0]) num = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

    public int coinChange(int[] coins, int amount) {
        int[] holder = new int[amount + 1];
        holder[0] = 0;
        for (int i = 1; i < holder.length; i++) {
            for (int coin : coins) {
                if (i >= coin) holder[i] = Math.min(holder[i], holder[i - coin] + 1);
            }
        }
        return holder[holder.length - 1] > amount ? -1 : holder[holder.length - 1];
    }

    public int lengthOfLIS(int[] nums) {
        int max_length = 1;
        int[] dp = new int[nums.length];
        for (int number : nums) {
            int i = Arrays.binarySearch(dp, 0, max_length, number);
            if (i < 0) i = -1 * (i + 1);
            dp[i] = number;
            if (i == max_length) {
                max_length++;
            }

        }
        return max_length;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> holder = new ArrayList<>();
        holder.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return holder;
        for (int i = 0; i < nums.length; i++) {
            int size = holder.size();
            for (int j = 0; j < size; j++) {
                List<Integer> l = new ArrayList<>(new ArrayList<>(holder.get(i)));
                l.add(i);
                holder.add(l);
            }

        }
        return holder;
    }

    private void backtrack(int n, List<Integer> list, List<List<Integer>> holder, int first) {
        if (n == first) holder.add(new ArrayList<>(list));
        for (int i = first; i < n; i++) {
            Collections.swap(list, i, first);
            backtrack(n, list, holder, first + 1);
            Collections.swap(list, i, first);
        }
    }
}
