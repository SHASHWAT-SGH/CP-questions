package problems;

import java.util.HashMap;
import java.util.Map;

public class SymmetricPairs {
    public static int[] getSymmetricPair(int[][] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : array) {
            int first = arr[0];
            int second = arr[1];

            if (map.containsKey(second) && map.get(second) == first) {
                return new int[]{second, first};
            } else {
                map.put(first, second);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ans = getSymmetricPair(new int[][]{{1, 2}, {3, 4}, {5, 6}, {2, 1}, {2, 4}});
        if (ans[0] != -1) {
            System.out.println("Symmetric pair found: " + ans[0] + " " + ans[1]);
        } else {
            System.out.println("No symmetric pair found.");
        }
    }
}
