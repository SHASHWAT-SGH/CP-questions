package exam.binaryTreeAndBST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SpiralOrderTraversalTree {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    // spiral order traversal using dequeue
    public List<Integer> spiralOrder(Node root){
        List<Integer> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    Node node = deque.pollFirst();
                    level.add(node.data);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    Node node = deque.pollLast();
                    level.add(node.data);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }
            list.addAll(level);
            leftToRight = !leftToRight;
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        SpiralOrderTraversalTree tree = new SpiralOrderTraversalTree();
        List<Integer> list = tree.spiralOrder(root);
        System.out.println(list);
    }

}
