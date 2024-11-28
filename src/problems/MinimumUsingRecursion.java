package problems;

public class MinimumUsingRecursion {

    public static int findMin(int[] arr, int ind, int min){
        if(ind >= arr.length){
            return min;
        }
        int minn = Math.min(min, arr[ind]);
        return findMin(arr, ind + 1, minn);
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {5, 3, 6, 2, 5}, 0, Integer.MAX_VALUE));
    }
}
