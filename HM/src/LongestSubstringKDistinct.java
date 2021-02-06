import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int find(String str, int k) {
//        if (str == null || str.length() == 0 || str.length() < k) {
//            throw new IllegalArgumentException();
//        }
//        HashMap<Character, Integer> holder = new HashMap<>();
//        int start = 0;
//        int sum = 0;
//        int max = 0;
//        for (int end = 0; end < str.length(); end++) {
//            char ch = str.charAt(end);
//            holder.put(ch, holder.getOrDefault(ch, 0) + 1);
//            while (holder.size() > k) {
//                char ch2 = str.charAt(start);
//                holder.put(ch, holder.get(ch) - 1);
//                if (holder.get(ch) <= 0) {
//                    holder.remove(ch);
//                }
//                start++;
//            }
//            max = Math.max(max, end - start + 1);
//
//
//        }
//        return  max;
        // TODO: Write your code here
        if(str.length() ==0 || str== null){
            throw new IllegalArgumentException();
        }
        if(str.length() < k){
            return str.length();
        }
        HashMap<Character, Integer> holder = new HashMap<>();
        int start = 0;
        int sum = 0;
        int max = 0;
        for(int end =0; end<str.length(); end++){
            char ch = str.charAt(end);
            holder.put(ch, holder.getOrDefault(ch, 0)+ 1);
            while(holder.size() > k){
                char ch2 = str.charAt(start);
                holder.put(ch, holder.get(ch)-1);
                if(holder.get(ch)<=0){
                    holder.remove(ch);
                }
                start++;

            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.find("aabccbb", 1));
        System.out.println("Length of the longest substring: " +  LongestSubstringKDistinct.find("abbbb",1 ));
        System.out.println("Length of the longest substring: " +  LongestSubstringKDistinct.find("abccde",1 ));
    }
}