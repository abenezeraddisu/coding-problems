import java.util.Collections;
import java.util.PriorityQueue;

public class max {
    public static int finder(int[] cap, int[] profit, int numpro, int initial) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : cap) {
            min.offer(i);
        }
        int start = initial;
        for (int i = 0; i < numpro; i++) {
            while (!min.isEmpty() && cap[min.peek()] <= start) {
                max.add(min.poll());
            }
            if (max.isEmpty()) break;
            start += profit[max.poll()];
        }
        return start;

    }

}
