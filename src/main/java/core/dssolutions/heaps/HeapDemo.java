package core.dssolutions.heaps;

import com.google.common.collect.MinMaxPriorityQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class HeapDemo {
    public static void main(String[] args){
        int[] arr = {1,2,3,8,9,10,55,1,9};

        // find the nth max, nth min using heap:
        Queue<Integer> simpleQueue = new ArrayDeque<>();
        // simpleQueue.
        // Queue<Integer> evictingQueue = EvictingQueue.create(5);

        MinMaxPriorityQueue<Integer> minMaxPriorityQueue = MinMaxPriorityQueue.
                orderedBy(Comparator.<Integer>naturalOrder().reversed()).maximumSize(5).create();
        Arrays.stream(arr).forEach(element->minMaxPriorityQueue.add(element));

    System.out.println(minMaxPriorityQueue.toString());
    System.out.println(minMaxPriorityQueue.poll());
    System.out.println(minMaxPriorityQueue.poll());
    System.out.println(minMaxPriorityQueue.peek());
    }
}
