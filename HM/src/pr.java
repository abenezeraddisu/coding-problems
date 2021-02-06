import java.util.*;
public class pr {
    public static void main(String[] args) {
        // Create a Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());

        // Add items to a Priority Queue (ENQUEUE)
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!numbers.isEmpty()) {
            System.out.println(numbers.poll());
        }

    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapc = new HashMap<>();
        Map<String, Character> maps = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String str = words[i];
            if (!mapc.containsKey(ch)) {
                if (maps.containsKey(str)) return false;
                else {
                    mapc.put(ch, str);
                    maps.put(str, ch);
                }

            } else {
                String str2 = mapc.get(ch);
                if (!str2.equals(str)) return false;
            }
        }
        return true;
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        for (i = 0; i < nums.length - 2; i++) {
            if (i != j) if (nums[i] + nums[j] == target) return new int[]{i, j};
            i++;
            j--;
        }
        return new int[]{-1, -1};
    }

    public void gameOfLife(int[][] board) {
        int[] neigh = new int[]{-1, 0, 1};
        int rownum = board.length;
        int colnum = board[0].length;
        for (int r = 0; r < rownum; r++) {
            for (int c = 0; c < colnum; c++) {
                int living = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neigh[i] == 0 && neigh[j] == 0)) {
                            int r1 = r + neigh[i];
                            int c1 = c + neigh[j];
                            if ((r1 < rownum & r > +0) && (c1 < colnum && c1 <= 0) && (Math.abs(board[r1][c1]) == 1))
                                living++;
                        }
                    }
                }
                if (board[r][c] == 0 && living == 3) board[r][c] = 2;
                if (board[r][c] == 1 && (living < 2 || living > 3)) board[r][c] = -1;
                if (board[r][c] == 0 && living == 3) board[r][c] = 2;

            }
        }

    }

    public void duplicateZeros(int[] arr) {
        int dup= 0;
        int len = arr.length -1;
        for(int i = 0; i < len - dup; i++){
            if(arr[i] == 0){
                if(i == len - dup){
                    arr[i] = 0;
                    len -=1;
                    break;
                }
                dup++;
            }
        }
        int right = len - dup;
       for(int i = right; i >=0; i--){
           if(arr[i]== 0){
               arr[i+dup]= 0;
               dup--;
               arr[i+dup] = 0;

           }
           else{
               arr[i+dup] = arr[i];
           }
       }

    }
}