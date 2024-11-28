package exam.linearDataStructures;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        // Initialize an empty list
        PriorityQueue<Integer> kNumbersMinHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // Add first k elements to the list
        for (int i = 0; i < k; i++) {
            kNumbersMinHeap.add(nums[i]);
        }

        // Loop through the remaining elements in the 'nums' array
        for (int i = k; i < nums.length; i++) {
            // Compare the current element with the minimum
            // element (root) of the min-heap
            if (nums[i] > kNumbersMinHeap.peek()) {
                // Remove the smallest element
                kNumbersMinHeap.poll();
                // Add the current element
                kNumbersMinHeap.add(nums[i]);
            }
        }

        // The root of the heap has the Kth largest element
        return kNumbersMinHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9};
        System.out.println(findKthLargest(nums, 3));
    }
}
