package exam.binaryTreeAndBST;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

public class LeftViewOfBinaryTree {
    static void RecLeftView(Node root, int level,
                            int[] maxLevel, ArrayList<Integer> result) {
        if (root == null) return;

        // If current level is more than max level,
        // this is the first node of that level
        if (level > maxLevel[0]) {
            result.add(root.data);
            maxLevel[0] = level;
        }

        // Traverse left subtree first, then right subtree
        RecLeftView(root.left, level + 1, maxLevel, result);
        RecLeftView(root.right, level + 1, maxLevel, result);
    }

    // Function to return the left view of the binary tree
    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] maxLevel = new int[] {-1};

        // Start recursion with root at level 0
        RecLeftView(root, 0, maxLevel, result);

        return result;
    }

    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        ArrayList<Integer> result = leftView(root);

        printArray(result);
    }
}
