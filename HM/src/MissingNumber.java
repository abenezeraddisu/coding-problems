public class MissingNumber {
    public static int missing(int[] arr) {
        int j = 1;
        for (int i = 2; i < arr.length + 2; i++) {
            j = j ^ i;
        }
        int p = arr[0];
        for (int s : arr) {
            if (s != arr[0]) {
                p = p ^ s;
            }
        }
        return j ^ p;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 6, 4};
        System.out.print("Missing number is: " + MissingNumber.missing(arr));
    }
}
