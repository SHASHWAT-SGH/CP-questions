package problems;

import java.util.HashMap;

public class AAddBEqualsCAddD {
    public static void findPair(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n ;j++){
                map.put(arr[i], arr[j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1; j<n ;j++){
                if(map.get(arr[i]) == arr[j]){
                    continue;
                }
                if(arr[i]+arr[j] == map.get(arr[i])+arr[i]){

                }
            }
        }
    }

    public static void main(String[] args) {
        findPair(new int[]{1, 2, 3, 4, 5});
    }
}
