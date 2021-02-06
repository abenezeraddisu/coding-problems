import java.util.*;


    class hackton {
        int id = 0;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        private TreeNode helper(int left, int right) {
            if (left == right) return null;
            int j = preorder[id];
            TreeNode t = new TreeNode(j);
            int index = idx_map.get(j);
            id++;
            t.left = helper(left, index);
            t.right = helper(index + 1, right);
            return t;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            // build a hashmap value -> its index
            int idx = 0;
            for (Integer val : inorder)
                idx_map.put(val, idx++);
            return helper(0, inorder.length);
        }

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
            PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
            for (int i : map.keySet()) {
                p.add(i);
                if (p.size() > k) p.poll();
            }
            int[] holder = new int[k];
            for (int i = p.size() - 1; i >= 0; i -) {
                holder[i] = p.poll();
            }
        }

        public String top(String a, List<String> list) {
            String[] holder = a.split(" ");
            Map<String, Integer> map = new HashMap<>();
            PriorityQueue<String> p = new PriorityQueue<>((q, b) -> map.get(b) - map.get(q));
            for (String s : holder) {
                char ch = s.charAt(s.length() - 1);
                if (Character.isAlphabetic(ch)) s = s.substring(0, s.length() - 1);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            for (String s : holder) p.add(s);
            while (!p.isEmpty()) {
                String s = p.poll();
                if (!list.contains(p)) return s;
            }
            return "";
        }

        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (int[] interval : intervals) {
                if (!p.isEmpty() || p.peek()[1] <= interval[0]) {
                    p.poll();
                }
                p.add(interval);
            }
            return p.size();
        }

        public int climbStairs(int n) {
            if (n == 1) return 1;
            int[] arr = new int[n + 1];
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }

        public int maxProfit(int prices[]) {
            int min = Integer.MAX_VALUE;
            int profit = 0;
            for (int price : prices) {
                if (price < min) {
                    min = price;
                } else if (price - min > profit) {
                    profit = price - min;
                }
            }
            return profit;
        }

        public int maxSubArray(int[] nums) {
            int max = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) nums[i] += nums[i - 1];
                max = Math.max(max, nums[i]);
            }
            return max;
        }

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m - 1;
            int j = n - 1;
            int p = m - 1;
            while (i >= 0 && j >= 0) {
                nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j++];
            }
            System.arraycopy(nums2, 0, nums1, 0, i + 1);
        }

        public int rob(int[] nums) {
            if (nums.length <= 1) return nums.length == 0 ? 0 : nums[0];
            int sofarMax = 0;
            int thisMax = 0;
            int[] holder = new int[nums.length];
            holder[0] = nums[0];
            holder[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < holder.length; i++) {
                holder[i] = Math.max(holder[i - 2] + nums[i], holder[i - 1]);
            }
            return holder[holder.length - 1];
        }

        public boolean canJump(int[] nums) {
            int lastValid = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] + i >= lastValid) lastValid = i;
            }
            return lastValid == 0;
        }

        public int jump(int[] A) {
            int jumps = 0, curEnd = 0, curFarthest = 0;
            for (int i = 0; i < A.length - 1; i++) {
                curFarthest = Math.max(curFarthest, i + A[i]);
                if (i == curEnd) {
                    jumps++;
                    curEnd = curFarthest;
                }
            }
            return jumps;
        }

        public int uniquePaths(int m, int n) {
            int[][] matrix = new int[m][n];
            for (int[] row : matrix) {
                Arrays.fill(row, 1);
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
            return matrix[m - 1][n - 1];
        }

        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }

        public int len(int[] arr) {
            int result = 0;
            int anchor = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) anchor = i;
                result = Math.max(result, i - anchor + 1);
            }
            return result;
        }

    }
