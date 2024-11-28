package problems;

import java.util.Scanner;

public class Palindrome {

    public static boolean customIsDigit(char ch){
        switch (ch){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    public static void isNumberPalindrome(int n){
        int copy = n;
        int reversed = 0;
        while(n!=0){
            int digit = n%10;
            n = n/10;
            reversed = reversed * 10 +digit;
        }

        if(reversed == copy){
            System.out.println("Number is a Palindrome");
        }else{
            System.out.println("Number is Not A Palindrome");
        }
    }

    public static void isStringPalindrome(String str){
        String reversedStr = "";
        int n = str.length()-1;
        while(n>=0){
            reversedStr += str.charAt(n);
            n--;
        }

        if(reversedStr.equals(str)){
            System.out.println("String is Palindrome");
        }else{
            System.out.println("String is Not A Palindrome");
        }

    }

    public static boolean isNumber(String str){
        char[] strArray = str.toCharArray();
        for(char ch: strArray){
            if(!customIsDigit(ch)){
                return false;
            }
        }
        return true;
    }

    public static void isPalindrome(String str){
        if(isNumber(str)){
            isNumberPalindrome(Integer.parseInt(str));
        }else{
            isStringPalindrome(str);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give Input: ");
        String str = scanner.next();
        isPalindrome(str);
    }
}
