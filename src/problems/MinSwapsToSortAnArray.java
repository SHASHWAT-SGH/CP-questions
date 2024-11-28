package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSortAnArray {

    public static int minSwap(int[] arr){
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<len; i++){
            map.put(arr[i], i);
        }

        Arrays.sort(arr);

        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        int cnt = 0;
        for(int i=0 ;i<len; i++){
            if(visited[i] || map.get(arr[i])==i){
                continue;
            }

            int j=i, cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;

                j = map.get(arr[j]);
                cycleSize++;
            }

            if(cycleSize>0){
                cnt += (cycleSize -1);
            }
        }

        return cnt;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 4};
        System.out.println("Min swap, "+ minSwap(arr));
    }
}


