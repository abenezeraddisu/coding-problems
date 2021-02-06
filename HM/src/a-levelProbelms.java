import javax.print.attribute.IntegerSyntax;
import java.util.*;







class holder {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            dp[i + 1] = Math.max(dp[i - 1] + val, dp[i]);
        }
        return dp[nums.length];
    }

    public int rob2(int[] nums) {
        int prev = 0;
        int now = 0;
        for (int money : nums) {
            int temp = now;
            now = Math.max(prev + money, now);
            prev = temp;
        }
        return now;
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

class Sn {
    private char board[][];
    private int row_num;
    private int col_num;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.row_num = board.length;
        this.col_num = board[0].length;
        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                if (this.backtrack(i, j, word, 0)) return true;
            }
        }
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) return true;
        if (row < 0 || row == this.row_num || col < 0 || col == this.col_num || this.board[row][col] != word.charAt(index))
            return false;
        boolean toreturn = false;
        this.board[row][col] = '#';
        int[] rowoff = new int[]{0, 1, -1, 0};
        int[] coloff = new int[]{1, 0, 0, -1};
        for (int d = 0; d < 4; d++) {
            toreturn = this.backtrack(row + rowoff[d], col + coloff[d], word, index + 1);
            if (toreturn) break;
        }
        this.board[row][col] = word.charAt(index);
        return toreturn;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList<>();
        toReturn.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> curr : toReturn) {
                temp.add(new ArrayList<>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> l : temp) {
                toReturn.add(l);
            }
        }
        return toReturn;
    }
}

class Sl {
    List<List<Integer>> toRetrun = new ArrayList<>();
    int n, k;

    public void backtrack(int first, List<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            toRetrun.add(new ArrayList<>(curr));
        }
        for (int i = first; i < n; i++) {
            curr.add(nums[first]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int nums[]) {
        this.n = nums.length;
        for (k = 0; k < n + 1; k++) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return toRetrun;
    }
}



class solx {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) list.add(i);
        List<List<Integer>> holder = new LinkedList<>();
        int n = nums.length;
        backtrack(n, list, holder, 0);
        return holder;
    }

    private void backtrack(int n, List<Integer> list, List<List<Integer>> holder, int first) {
        if (first == n) holder.add(new ArrayList<>(list));
        for (int i = first; i < n; i++) {
            Collections.swap(list, i, first);
            backtrack(n, list, holder, first + 1);
            Collections.swap(list, first, i);
        }
    }
}

class lmaowtf {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }

        public void backtrack(List<String> ans, String cur, int open, int close, int max) {
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }

            if (open < max)
                backtrack(ans, cur + "(", open + 1, close, max);
            if (close < open)
                backtrack(ans, cur + ")", open, close + 1, max);
        }
    }
}

class Solun {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) output.add(combination);
        else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = new String(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);

        }
        return new ArrayList(ans.values());
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) j = Math.max(j, map.get(s.charAt(i)));
            ans = Math.max(ans, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return ans;
    }
}






