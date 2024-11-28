package problems;

import java.util.Stack;

public class DuplicateParenthesis {

    public boolean hasDuplicateParenthesis(String expr){
        Stack<Character> stack = new Stack<>();
        for(char ch: expr.toCharArray()){
            if(ch==')'){
                int elementsInside = 0;
                while(stack.peek() != '('){
                    stack.pop();
                    elementsInside++;
                }
                stack.pop();

                if(elementsInside<1){
                    return true;
                }
            }
            else{
                stack.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateParenthesis dp = new DuplicateParenthesis();
        System.out.println(dp.hasDuplicateParenthesis("(a+b+((b-c)))"));
    }
}
