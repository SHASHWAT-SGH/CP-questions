package exam.binaryTreeAndBST;

import java.util.Arrays;

// Given an array of integers and a number k. We can pair two numbers of
// the array if the difference between them is strictly less than k.
// The task is to find the maximum possible sum of disjoint pairs.
// Sum of P pairs is the sum of all 2P numbers of pairs.
public class MaximumSumPairUsingK {
    // Method to return maximum sum we can get by
    // finding less than K difference pairs
    static int maxSumPairWithDifferenceLessThanK(int arr[],
                                                 int N,
                                                 int k)
    {
        int maxSum = 0;

        // Sort elements to ensure every i and i-1 is
        // closest possible pair
        Arrays.sort(arr);

        // To get maximum possible sum,
        // iterate from largest
        // to smallest, giving larger
        // numbers priority over
        // smaller numbers.
        for (int i = N - 1; i > 0; --i)
        {
            // Case I: Diff of arr[i] and arr[i-1] is less
            // than K, add to maxSum
            // Case II: Diff between arr[i] and arr[i-1] is
            // not less than K, move to next i
            // since with sorting we know, arr[i]-arr[i-1] <
            // arr[i]-arr[i-2] and so on.
            if (arr[i] - arr[i - 1] < k)
            {
                // Assuming only positive numbers.
                maxSum += arr[i];
                maxSum += arr[i - 1];

                // When a match is found skip this pair
                --i;
            }
        }

        return maxSum;
    }

    // Driver code
    public static void main(String[] args)
    {

        int arr[] = { 3, 5, 10, 15, 17, 12, 9 };
        int N = arr.length;
        int K = 4;

        System.out.println(
                maxSumPairWithDifferenceLessThanK(arr, N, K));
    }
}
