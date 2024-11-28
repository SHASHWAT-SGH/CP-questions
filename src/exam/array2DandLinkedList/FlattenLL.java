package exam.array2DandLinkedList;

import java.util.PriorityQueue;


class Node2 {
    int data;
    Node2 next, bottom;

    Node2(int newData) {
        data = newData;
        next = bottom = null;
    }
}

class NodeComparator implements java.util.Comparator<Node2> {
    @Override
    public int compare(Node2 a, Node2 b) {
        return Integer.compare(a.data, b.data);
    }
}

public class FlattenLL {

    public static Node2 flatten(Node2 root) {

        // Create a priority queue with custom comparator
        PriorityQueue<Node2> pq = new PriorityQueue<>(new NodeComparator());

        Node2 head = null;
        Node2 tail = null;

        // Pushing main link nodes into the priority_queue.
        while (root != null) {
            pq.add(root);
            root = root.next;
        }

        // Extracting the minimum node while the priority queue is not empty
        while (!pq.isEmpty()) {
            // Extracting min
            Node2 minNode = pq.poll();

            if (head == null) {
                head = minNode;
                tail = minNode;
            } else {
                tail.bottom = minNode;
                tail = tail.bottom;
            }

            // If we have another node at the bottom of the
            // popped node, push that node into the priority queue
            if (minNode.bottom != null) {
                pq.add(minNode.bottom);
                minNode.bottom = null;
            }
        }

        return head;
    }

    // Function to print the linked list
    public static void printList(Node2 head) {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        /* Create a hard-coded linked list:
            5 -> 10 -> 19 -> 28
            |    |     |
            V    V     V
            7    20    22
            |          |
            V          V
            8          50
            |
            V
            30
        */

        Node2 head = new Node2(5);
        head.bottom = new Node2(7);
        head.bottom.bottom = new Node2(8);
        head.bottom.bottom.bottom = new Node2(30);

        head.next = new Node2(10);
        head.next.bottom = new Node2(20);

        head.next.next = new Node2(19);
        head.next.next.bottom = new Node2(22);
        head.next.next.bottom.bottom = new Node2(50);

        head.next.next.next = new Node2(28);

        // Function call
        head = flatten(head);

        printList(head);
    }


}
