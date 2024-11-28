package exam.linearDataStructures;

import java.util.Arrays;
import java.util.Comparator;

public class SymmetricPairs {
    static int binarySearch(int[][] arr, int i, int j, int n) {
        int mid = (i+j)/2;
        if(i > j){
            return -1;
        }
        if(arr[mid][1] == n){
            return mid;
        }
        else if(arr[mid][1] > n){
            return binarySearch(arr, i, mid - 1, n);
        }
        else if(arr[mid][1] < n){
            return binarySearch(arr, mid + 1, j, n);
        }
        return -1;
    }
    static void findSymPairs(int[][] arr, int row) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for(int i=0; i<row; i++){
            int idx = binarySearch(arr, 0, row-1, arr[i][0]);
            if(idx != -1 && arr[idx][0] == arr[i][1]){
                System.out.println(arr[idx][0] + " " + arr[idx][1]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[5][2];
        arr[0][0] = 11;
        arr[0][1] = 20;
        arr[1][0] = 30;
        arr[1][1] = 40;
        arr[2][0] = 5;
        arr[2][1] = 10;
        arr[3][0] = 40;
        arr[3][1] = 30;
        arr[4][0] = 10;
        arr[4][1] = 5;
        findSymPairs(arr, 5);
    }
}
