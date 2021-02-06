import java.util.HashMap;

public class NoRepeatSubstring {
    public static int find(String str){
        HashMap<Character, Integer> holder = new HashMap<>();
        int start = 0;
        int max = 1;
        for(int end= 0; end <str.length(); end++){
            char ch = str.charAt(end);
            if(holder.containsKey(ch)){
                start = Math.max(start, holder.get(ch)+1);
            }
            holder.put(ch, end);
            max = Math.max(max, end - start +1);
        }
  return  max;
    }

    public static void main(String[] args) {
        System.out.println( "bruh: " + NoRepeatSubstring.find( "aabccbb"));
    }
}
