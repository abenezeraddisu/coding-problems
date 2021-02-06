import java.util.*;

public class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class nextInterval {
    public static int[] finder(Interval[] given) {
        int n = given.length;
        PriorityQueue<Integer> end = new PriorityQueue<>(n, (a, b) -> given[b].end - given[a].end);
        PriorityQueue<Integer> start = new PriorityQueue<>(n, (a, b) -> given[b].start - given[a].start);
        int[] toreturn = new int[n];
        for (int i = 0; i < n; i++) {
            end.add(i);
            start.add(i);
        }
        for (int i = 0; i < n; i++) {
            int topend = end.poll();
            toreturn[end.poll()] = -1;

            if (given[start.peek()].start >= given[topend].end) {
                int topstart = start.poll();
                while (!start.isEmpty() && given[start.peek()].start >= given[topend].end) {
                    topstart = start.poll();
                }
                toreturn[topend] = topstart;
                start.add(topstart);
            }

        }
        return  toreturn;
    }

}
