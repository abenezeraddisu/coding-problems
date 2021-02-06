import java.util.Collections;
import java.util.PriorityQueue;

public class medianfinder{
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();
    public double[] findSlidingWindowMedian(int[] arr, int k){
        double[] result = new double[arr.length - k+1];
        for(int i= 0; i < arr.length; i++){
            if(max.isEmpty() || max.peek() >= arr[i]) max.add(arr[i]);
            else min.add(arr[i]);
            helper();
            if(i +1 >= k) {
                if (max.size() == min.size()) result[i-k+1] = max.peek() / 2.0 + min.peek() / 2.0;
                if (max.size() > min.size()) result[i-k+1] = max.peek();
                int window = arr[i - k + 1];
                if (max.contains(window)) max.remove(window);
                if (min.contains(window)) min.remove(window);
            }
            helper();
        }
        return result;
    }
    private void helper(){
        if(max.size() > min.size() +1) min.add(max.poll());
        else if(min.size() > max.size()) max.add(min.poll());
    }
    public double[] bruh(int[] given, int k){
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> (b-a));
        PriorityQueue<Integer> min = new PriorityQueue<>();
        double[] toreturn  = new double[given.length - k+1];
        for(int i = 0; i < given.length; i++){
            if(max.isEmpty()|| given[i] <= max.peek()) max.add(given[i]);
            else min.add(given[i]);
            yo();
            if(i +1 > k){
                if(max.size() == min.size()) toreturn[i-k+1] = max.peek()/2.0 + min.peek()/2.0;
                else toreturn[i-k+1] = max.poll();
                int toremove = given[i-k+1];
                if(max.contains(toremove)) max.remove(given[i-k+1]);
                else min.remove(toremove);
            }
            yo();
        }
        return  toreturn;
    }
    private void yo (){
        if(max.size() > min.size() +1) min.add(max.poll());
        if(min.size()> max.size()) max.add(min.poll());
    }
    public static void main(String[] args) {
       medianfinder slidingWindowMedian = new medianfinder();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new medianfinder();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }

}
