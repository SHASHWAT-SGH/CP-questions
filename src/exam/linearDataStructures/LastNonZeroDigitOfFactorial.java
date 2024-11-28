package exam.linearDataStructures;

public class LastNonZeroDigitOfFactorial {
    public static void callMeFactorialLastDigit(int n, int[] result, int sumOf5) {
        int number = n; // assaigning to new variable.
        if (number == 1)
            return; // base case

        // To store the count of times 5 can
        // divide the number.
        while (number % 5 == 0) {
            number /= 5;
            // increase count of 5
            sumOf5++;
        }

        // Divide the number by
        // 2 as much as possible
        while (sumOf5 != 0 && (number & 1) == 0) {
            number >>= 1; // dividing the number by 2
            sumOf5--;
        }

        /*multiplied result and current number(after
        removing pairs) and do modular division to get the
        last digit of the resultant number.*/
        result[0] = (result[0] * (number % 10)) % 10;
        // calling again for (currentNumber - 1)
        callMeFactorialLastDigit(n - 1, result, sumOf5);
    }

    public static int lastNon0Digit(int n)
    {
        int[] result = { 1 }; // single element array.
        callMeFactorialLastDigit(n, result, 0);
        return result[0];
    }

    public static void main(String[] args)
    {
        System.out.println(lastNon0Digit(7)); // 3040
        System.out.println(lastNon0Digit(12)); // 479001600
    }
}
