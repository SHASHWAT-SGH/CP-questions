package exam.linearDataStructures;

public class TwoPeopleMeetEachOther {
    static boolean everMeet(int x1, int x2, int v1, int v2) {

        // If speed of a person at a position before
        // other person is smaller, then return false.
        if (x1 < x2 && v1 <= v2) {
            return false;
        }
        if (x1 > x2 && v1 >= v2) {
            return false;
        }

        // Making sure that x1 is greater
        if (x1 < x2) {
            swap(x1, x2);
            swap(v1, v2);
        }

        // checking if relative speed is
        // a factor of relative distance or not
        return ((x1 - x2) % (v1 - v2) == 0);
    }

    static void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
    }

    public static void main(String[] args) {
        int x1 = 5, v1 = 8, x2 = 4, v2 = 7;
        if (everMeet(x1, x2, v1, v2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
