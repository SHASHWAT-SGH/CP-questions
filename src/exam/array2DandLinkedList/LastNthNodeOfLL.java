package exam.array2DandLinkedList;

class Node {
    int data;
    Node next;

    // Constructor to initialize a new node with data
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class LastNthNodeOfLL {
    static int nthFromEnd(Node head, int N) {

        // Create two pointers main_ptr and ref_ptr
        // initially pointing to head.
        Node main_ptr = head;
        Node ref_ptr = head;

        // Move ref_ptr to the N-th node from beginning.
        for (int i = 1; i < N; i++) {
            ref_ptr = ref_ptr.next;

            // If the ref_ptr reaches NULL, then it means
            // N > length of linked list
            if (ref_ptr == null) {
                return -1;
            }
        }

        // Move ref_ptr and main_ptr by one node until
        // ref_ptr reaches last node of the list.
        while (ref_ptr.next != null) {
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }

        return main_ptr.data;
    }

    public static void main(String[] args) {

        // Create a hard-coded linked list:
        // 35 -> 15 -> 4 -> 20
        Node head = new Node(35);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        // Function Call to find the 4th node from end
        System.out.println(nthFromEnd(head, 4));
    }
}
