import java.util.HashMap;

public class CharacterReplacement {
    public static  int find(String str, int k){
        int start = 0;
        int max = 0;
        int repeat = 0;
        HashMap< Character , Integer> holder = new HashMap<>();
        for(int end = 0; end<str.length(); end++){
            char ch = str.charAt(end);
            holder.put(ch, holder.getOrDefault(ch, 0)+1);
            repeat = Math.max(repeat, holder.get(ch));
            if(end-start+1 - repeat > k){
                char ch2 = str.charAt(start);
                holder.put(ch2, holder.get(ch2)-1);
                if(holder.get(ch2)==0){
                    holder.remove(ch2);
                }
                start++;
            }
            max = Math.max(max, end-start+1);

        }
        return  max;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.find("aabccbb", 2));
        System.out.println(CharacterReplacement.find("abbcb", 1));
        System.out.println(CharacterReplacement.find("abccde", 1));
    }
}
