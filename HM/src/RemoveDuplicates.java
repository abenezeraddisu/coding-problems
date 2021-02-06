import java.util.*;

public class RemoveDuplicates {
    public static int remove(int[] arr) {
        int dupcounter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[dupcounter] == arr[i]) arr[dupcounter] = arr[i];
            dupcounter++;
        }
        return dupcounter;
    }

    public static int[] square(int[] arr) {
        int[] tore = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tore[i] = arr[i] * arr[i];
        }
        Arrays.sort(tore);
        return tore;
    }

    public static int[] maker(int[] arr) {
        int n = arr.length;
        int[] sq = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        while (left <= right) {
            int l = arr[left] * arr[left];
            int r = arr[right] * arr[right];
            if (l > r) arr[index--] = l;
            left++;
            if (l <= r) arr[index--] = r;
            right--;
        }
        return sq;


    }

    public static void dutchflag(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        for (int i = 0; i <= high; ) {
            if (arr[i] == 0) {
                helper(arr, i, low);
                low++;
                i++;
            } else if (arr[i] == 1) i++;
            else helper(arr, high, i);
            high--;
        }
    }

    private static void helper(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static  int helper(int i, String str){
        int count = 0;
        while(i>=0){
            if(str.charAt(i) == '#') count++;
            else if( count > 0) count--;
            else break;
            i --;

        }
        return  i;
    }
    public  static  boolean com(String s, String ss){
        int i1 = s.length() - 1, i2 = ss.length();
        while(i1>=0 || i2>=0){
            int sa = helper( i1, s);
            int s2 = helper(i2, ss);
            if(sa < 0 && s2 <0) return true;
            if(sa < 0 || s2 <0) return  false;
            if(s.charAt(sa) != ss.charAt(s2)) return  false;
            sa = i1- 1; s2 = i2 - 1;
        }
    return  true;}
}
