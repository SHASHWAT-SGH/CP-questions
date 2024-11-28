package problems;

import java.util.Arrays;

public class MaximumSumPairUsingK {

    static void getMaximumSum(int[] arr1, int[] arr2, int k){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int n1 = arr1.length-1;
        int n2 = arr2.length-1;

//        1, 2, 3, 4
//        1, 2, 5, 6

//        int max = Integer.MIN_VALUE;
//        for(int i=n2; i>=0; i--){
//            int sum = arr2[i]+arr1[n1];
//            if(sum > max){
//                max = sum;
//                System.out.println("{ "+ arr2[i] + ", " + arr1[n1]+ " }");
//            }
//
//        }


    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 2, 3};
        int[] arr2 = {2, 5, 1, 6};
        getMaximumSum(arr1, arr2, 3);
    }
}
