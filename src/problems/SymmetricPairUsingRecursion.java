package problems;

import java.util.HashMap;
import java.util.Map;

public class SymmetricPairUsingRecursion {

    public static int[] getSymmetricPair(int[][] array, int ind, Map<Integer, Integer> map){
        if(array.length == ind){
            return new int[] {-1, -1};
        }
        int first = array[ind][0];
        int second = array[ind][1];
        if(map.containsKey(second) && map.get(second) == first){
            return new int[]{first, second};
        }else{
            map.put(first, second);
            ind++;
            return getSymmetricPair(array, ind, map);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 6}, {2, 1}, {2, 4}};
        int[] ans = getSymmetricPair(arr, 0, new HashMap<>());
        if (ans[0] != -1) {
            System.out.println("Symmetric pair found: " + ans[0] + " " + ans[1]);
        } else {
            System.out.println("No symmetric pair found.");
        }

    }
}
