package problems;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        // Add the new element to the queue
        queue.add(x);

        // Rotate the queue to maintain stack order
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.poll());
        }
    }

    // Pop the top element from stack
    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.poll(); // Remove the front of the queue (top of stack)
    }

    // Get the top element from stack
    public int top() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.peek(); // Return the front of the queue (top of stack)
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element: " + stack.top()); // Should print 3
        System.out.println("Popped element: " + stack.pop()); // Should print 3
        System.out.println("Top element after pop: " + stack.top()); // Should print 2
        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
        System.out.println("Size of stack: " + stack.size()); // Should print 2
    }
}