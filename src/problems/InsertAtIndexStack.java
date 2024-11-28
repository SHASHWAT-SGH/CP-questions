package problems;

import java.util.Stack;

public class InsertAtIndexStack {
    public static void insertAtIndex(Stack<Integer> stack, int value, int index) {
        if (index == 0 || stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int temp = stack.pop();
        insertAtIndex(stack, value, index - 1);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        int valueToInsert = 10;
        int index = 2;

        insertAtIndex(stack, valueToInsert, index);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
