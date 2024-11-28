package exam.linearDataStructures;

public class PascalTriangle {
    public int pascal(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        }
        return pascal(row - 1, col - 1) + pascal(row - 1, col);
    }

    public static void main(String[] args) {
        int n = 4;
        PascalTriangle triangle = new PascalTriangle();

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(" " + triangle.pascal(i, j));
            }

            System.out.println();
        }
    }
}
