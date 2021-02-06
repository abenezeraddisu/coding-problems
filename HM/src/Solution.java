public class Solution {
    public  static  int[][] flipandinvert(int[][] arr){
        int len = arr[0].length;
        for(int[]row: arr){
            for(int i = 0; i< (len+1)/2; i++){
                int temp = row[i] ^1;
                row[i] = row[len-i-1]^1;
                row[len-i-1] = temp;
            }
        }
   return  arr; }
}
