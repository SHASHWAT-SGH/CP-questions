package exam.linearDataStructures;

import java.util.Arrays;
import java.util.stream.Collectors;

//Reverse the individual words of the string
public class ReverseWordsInString {

    public static String solve(String str){
        String ans = Arrays.asList(str.split(" "))
                .stream()
                .map(s-> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
        return ans;
    }

    public static void main(String[] args) {
        String str = "Shashwat is a good boy.";
        System.out.println(solve(str));
    }
}
