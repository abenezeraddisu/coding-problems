import java.util.*;

public class logicProblems {
}
class stfu {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) j = Math.max(j, map.get(ch));
            max = Math.max(max, i - j + 1);
            map.put(ch, i + 1);

        }
        return max;
    }
}

class Slutin {
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public String longestPalindrome(String s) {
        int end = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = expand(s, i, i);
            int l2 = expand(s, i, i + 1);
            int length = Math.max(l1, l2);
            if (length > end - start + 1) {
                start = i - (length - 1) / 2;
                end = i + (length) / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int rob(int[] moneys) {
        int now = 0;
        int prev = 0;
        for (int money : moneys) {
            int temp = now;
            now = Math.max(now, money);
            prev = now;
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

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name = values[i].split("\\(");
                name[1].replace(")", "");
                List<String> holder = map.getOrDefault(name[1], new ArrayList<>());
                holder.add(values[0] + "/" + name[0]);
                map.put(name[1], holder);
            }
        }
        List<List<String>> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1) list.add(map.get(s));
        }
        return list;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_n = new int[n];
        new_n[0] = 1;
        new_n[n - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            new_n[i + 1] = nums[i];
        }
        int[][] holder = new int[n][n];
        return dp(holder, new_n, 0, n - 1);
    }

    public int dp(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        ///// we use open interval
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] + dp(memo, nums, left, i) + dp(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }

    public boolean wordPattern(String pattern, String s) {
        HashMap map = new HashMap();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (Integer i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt((int) i);
            String word = words[i];
            if (!map.containsKey(ch)) map.put(ch, i);
            if (!map.containsKey(word)) map.put(word, i);
            if (map.get(ch) != map.get(word)) return false;
        }
        return true;
    }

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    public boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        if (i == str.length() && j == pat.length()) return true;
        else if (i == str.length() || j == pat.length()) return false;
        char ch = pat.charAt(j);
        if (map.containsKey(ch)) {
            String s = map.get(ch);
            if (!str.startsWith(s, i)) return false;
            return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            if (set.contains(p)) continue;
            map.put(ch, p);
            set.add(p);
            if (isMatch(str, k + 1, pat, j + 1, map, set)) return true;
            map.remove(ch);
            set.remove(p);
        }
        return false;
    }


    public static int findMaxSumSubArray(int k, int[] arr) {
        int global_max = 0;
        int start = 0;
        int max = 0;
        for (int end = 0; end < arr.length; end++) {
            max += arr[end];
            if (end >= k - 1) {
                global_max = Math.max(global_max, max);
                max -= arr[start];
                start++;
            }

        }
        return global_max;
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int maxProduct(int[] nums) {
        if(nums.length==0) return  0;
        int local_max =nums[0];
        int local_min = nums[0];
        int global_max= local_max;
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(curr* local_max, curr*local_min));
            local_min = Math.min(curr, Math.min(curr*local_max, curr*local_min));
            local_max = temp_max;
            global_max = Math.max(global_max,local_max );

        }
        return global_max;
    }
}