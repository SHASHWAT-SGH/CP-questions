package problems;

import java.math.BigInteger;

public class LastNonZeroDigitInFactorial {

    public static int lastNonZeroDigitInFactorial(int n){
        BigInteger fact = BigInteger.ONE;
        for(int i=2; i<n; i++){
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        while(fact.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            fact = fact.divide(BigInteger.TEN);
        }

        return fact.mod(BigInteger.TEN).intValue();
    }

    public static void main(String[] args) {
        System.out.println(lastNonZeroDigitInFactorial(12));
    }
}
