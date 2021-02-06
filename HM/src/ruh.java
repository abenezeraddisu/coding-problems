import java.util.*;

public class ruh {
    public double[] sol(int[] nums, int k) {
        int start = 0;
        double[] toret = new double[nums.length - k + 1];
        int holder = 0;
        for (int end = 0; end < nums.length; end++) {
            holder += nums[end];
            if (end >= k - 1) {
                toret[start] = holder / k;
                holder -= start;
                start++;

            }
        }
        return toret;
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int max = 0;
        int start = 0;
        int holder =0;
        for(int end = 0; end < arr.length; end++){
            holder+=arr[end];
            if(end >= k-1){
                max = Math.max(max, holder);
                holder-=arr[start];
                start++;
            }
        }
        return  max;
    }
    public static int findength(String str, int k) {
        Map<Character, Integer> holdeer = new HashMap<>();
        int start = 0;
        int max = 0;
        for(int end = 0; end < str.length(); end++){
            char rightc = str.charAt(end);
            holdeer.put(rightc, holdeer.getOrDefault(rightc, 0)+1);
            while(holdeer.size()> k){
                char leftc = str.charAt(start);
                //holdeer.get(leftc) != 0 ? holdeer.remove(leftc) : holdeer.put(leftc, holdeer.get(leftc)-1);

                start++;
            }
            max = Math.max(end-start +1, max);
        }
        return  max;
    }
    public static int findLength(String str) {
        Map<Character, Integer> holder = new HashMap<>();
        int start =0;
        int max = 0;
        for(int end= 0; end < str.length(); end++){
            if(holder.containsKey(str.charAt(end))) start = Math.max(start, holder.get(str.charAt(end))+ 1);
            holder.put(str.charAt(end), end);
            max= Math.max(max, end -start+1);
        }
        return max;
    }
    public static int fidLengh(String str, int k) {
       Map<Character, Integer> map = new HashMap<>();
       int start = 0;
       int leng = 0;
       int repeat = 0;
       for(int end = 0; end < str.length(); end++){
           char rightchar = str.charAt(end);
           map.put(rightchar, map.getOrDefault(rightchar, 0)+1);
           repeat = Math.max(repeat, map.get(rightchar));
           while(end-start+1 - repeat > k){
               char leftchar = str.charAt(start);
               map.put(leftchar, map.get(leftchar)-1);
               start++;
           }
           leng = Math.max(leng, end-start+1);

       }
       return leng;
    }
    public static int findLength(int[] arr, int k) {
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1)
                maxOnesCount++;
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1)
                    maxOnesCount--;
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int comparer = 0;
        for (int i : nums) {
            if (i == 1) comparer++;
            else {
                max = Math.max(max, comparer);
                comparer = 0;
            }
        }
        return max;
    }

    public int findNumbers(int[] nums) {
        int toret = 0;
        for (int num : nums) {
            if (helper(num)) toret++;
        }
        return toret;
    }

    private boolean helper(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count % 2 == 0;
    }

    public void duplicateZeros(int[] arr) {
        List<Integer> holder = new ArrayList<>();
        for (int i=0; i < arr.length; i++) {
            if(arr[i]== 0 && i < arr.length -2) holder.add(i+1);
        }
        for(int i = 0; i < holder.size(); i++){
            arr[holder.get(i)] = 0;
        }
    }
    public void duplicatZeros(int[] arr) {
        int poss = 0;
        int len = arr.length -1;
        for(int left = 0; left <=len; left++){
            if(arr[left] ==0){
                if(left == len - poss){
                    arr[len] = 0;
                    len -=1;
                    break;
                }
                poss++;
            }
        }
        int iter = len - poss;
        for(int i = iter; i >=0 ; i--){
            if(arr[i] == 0){arr[i+poss] = 0; poss--;arr[i+poss] = 0;}
            else{arr[i+ poss]= arr[i];}

        }
    }
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int tot = m + n -1;
            int p = m-1;
            int q = n-1;
            while( p >= 0 && q>=0){
                nums1[tot--] = nums1[p] < nums2[q] ? nums2[q--] : nums1[p--];
            }
            System.arraycopy(nums2, 0, nums1, 0, q+1);
        }
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> holder = new ArrayList<>();
        if(root == null) return holder;
        Queue<TreeNode> q = new LinkedList<>();
        boolean c = true;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if (c) {
                    curr.add(temp.val);
                } else {
                    curr.add(0, temp.val);
                }
                if(temp.right!= null) q.offer(temp.right);
                if(temp.left !=null) q.offer(temp.left);

            }
            holder.add(0, curr);
            c = !c;
        }
return  holder;
    }
    private static void findPathsRecursive(TreeNode currentNode, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if(currentNode == null) return;
        currentPath.add(currentNode.val);
        if(currentNode.left == null && currentNode.right == null) allPaths.add(new ArrayList<>(currentPath));
        else{
            findPathsRecursive( currentNode.left, currentPath, allPaths);
            findPathsRecursive( currentNode.right, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() -1);
    }
}

