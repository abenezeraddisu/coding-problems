import java.util.ArrayList;
import java.util.*;

public class MedianOfAStream {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public  MedianOfAStream(){
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    public  void  insertNum( int n){
        if(max.isEmpty()|| max.peek()>= n) max.add(n);
        else min.add(n);
        if(max.size() > min.size() +1) min.add(max.poll());
        if(min.size()> max.size()) max.add(min.poll());
    }
    public  double findMedian(){
        if(max.size() == min.size()) return  max.peek()/2.0 + min.peek()/2.0;
        else return  max.peek();
    }
    public static void main(String[] args) {
        MedianOfAStream medianOfAStream = new MedianOfAStream();
        medianOfAStream.insertNum(3);
        medianOfAStream.insertNum(1);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(5);
        System.out.println("The median is: " + medianOfAStream.findMedian());
        medianOfAStream.insertNum(4);
        System.out.println("The median is: " + medianOfAStream.findMedian());
    }
}
