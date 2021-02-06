import java.util.Arrays;
import java.util.HashMap;

public class PairWithTargetSum {
    public  static  int[] searcher(int[] arr, int k){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum== k) return  new int[] {left, right};
            if(sum < k) left++;
            else right++;
        }

        return  new int[]{-1, -1};
    }
    public  static  int[] method2( int[] arr, int k){
        HashMap<Integer, Integer> holder = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(holder.containsKey( k - arr[i]))  return  new int[] {i, holder.get( k - arr[i])};
            holder.put(arr[i], i);
        }
        return  new int[] { -1, -1};

    }
}
