import java.util.Arrays;

public class StringPermutation {
    public static boolean find(String str, String pat) {
        if (helper(str).startsWith(helper(pat))) return true;
        return false;
    }

    public static String helper(String str) {
        char[] tmp = str.toCharArray();
        Arrays.sort(tmp);
        String holder = new String(tmp);
        return holder;
    }

}
