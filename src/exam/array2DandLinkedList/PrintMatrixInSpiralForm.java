package exam.array2DandLinkedList;

public class PrintMatrixInSpiralForm {
    static void spiralPrint(int m, int n, int[][] mat) {

        // Initialize boundaries
        int top = 0, bottom = m - 1, left = 0,
                right = n - 1;

        // Iterate until all elements are printed
        while (top <= bottom && left <= right) {

            // Print top row from left to right
            for (int i = left; i <= right; ++i) {
                System.out.print(mat[top][i] + " ");
            }
            top++;

            // Print right column from top to bottom
            for (int i = top; i <= bottom; ++i) {
                System.out.print(mat[i][right] + " ");
            }
            right--;

            // Print bottom row from right to left (if
            // exists)
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    System.out.print(mat[bottom][i] + " ");
                }
                bottom--;
            }

            // Print left column from bottom to top (if
            // exists)
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    System.out.print(mat[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {

        int[][] mat = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        spiralPrint(mat.length, mat[0].length,
                mat);
    }
}
