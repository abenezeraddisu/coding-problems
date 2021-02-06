public class HappyNumber {
    private static int helper(int num) {
        int sum = 0;
        int digit = 0;
        while (num > 0) {
            digit = num % 10;
            sum += digit * digit;
            num = num / 10;
        }
        return sum;
    }

    public static boolean finder(int num) {
        int slow = num; int fast = num;
        do{
            slow = helper(slow);
            fast = helper(helper(fast));
        }
 while(slow!=fast);
        return slow == 1;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.finder(23));
        System.out.println(HappyNumber.finder(12));
    }
}
