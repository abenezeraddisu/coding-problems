public class ReplacingOnes {
    public static int find(int[] arr, int k) {
        int repeat = 0;
        int start = 0;
        int max = 0;

        for (int end = 0; end < arr.length; end++) {
            if (arr[end] == 1) {
                repeat++;
            }
            if (end - start + 1 - repeat > k) {
                if (arr[start] == 1) {
                    repeat--;
                    start++;
                }
            }
            max = Math.max(end - start + 1, max);
        }
        return max;
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


    public static void main(String[] args) {
        System.out.println(ReplacingOnes.findLength(new int[] {  }, 2));
        System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
        System.out.println(ReplacingOnes.find(new int[]{}, 2));
        System.out.println(ReplacingOnes.find(new int[]{ 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
