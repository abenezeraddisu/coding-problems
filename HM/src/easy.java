import java.util.*;

public class easy {
}
class Soln {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) twoSumII(nums, i, res);
        return new ArrayList<>(res);
    }

    void twoSumII(int[] nums, int i, Set<List<Integer>> set) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                set.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
            }
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) j = Math.max(j, map.get(ch));
            ans = Math.max(ans, i - j + 1);
            map.put(ch, i + 1);
        }
        return ans;
    }
}

