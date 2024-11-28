package problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinHeap {

    Queue<Integer> pq;

    public MinHeap(int[] arr) {
        pq = new PriorityQueue<>();
        createMinHeap(arr);
    }

    private void createMinHeap(int[] arr) {
        for(int i: arr){
            pq.offer(i);
        }
    }

    public int peek(){
        return pq.peek();
    }




    public static void main(String[] args) {
        MinHeap heap = new MinHeap(new int[]{5, 2, 3, 6 ,2});
        System.out.println(heap.peek());
    }
}
