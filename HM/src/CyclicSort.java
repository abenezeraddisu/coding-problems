import java.util.*;
public class CyclicSort {
    private static void helper(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }
    public static void sorter(int[] arr){
        int i =0;
        while (i <arr.length){
            int j = arr[i] -1;
            if(arr[i]!= j-1) helper(arr, i, j);
            else i++;
        }
    }
    public  static  List<Integer> finder(int[] arr){
        int i = 0;
        while(i < arr.length){
           if(arr[i] != arr[arr[i] -1]) helper(arr, i, arr[i]-1);
           else i++;
        }
        List<Integer> holder = new LinkedList<>();
        for( i = 0; i < arr.length; i++ ){
            if(arr[i] !=i+1) holder.add(i+1);
        }
    return holder;}

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1])
                    helper(nums, i, nums[i] - 1);
                else // we have found the duplicate
                    return nums[i];
            }
            else {
                i++;
            }
        }

        return -1;
    }
}
