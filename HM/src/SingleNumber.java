import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class SingleNumber {
    public static int findSingleNumber(int[] arr) {
        int p = 0;
        for(int s: arr){
           p= p^s;
        }
        return p;
    }

    public static void main( String args[] ) {
        System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
    }
}