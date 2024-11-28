package problems;

public class SortAndMergeLinkedLists {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }

    static ListNode sortLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode middle = getMiddleNode(head);
        ListNode left = sortLinkedList(head);
        ListNode right = sortLinkedList(middle);

        return mergeTwoLists(left, right);
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return dummy.next;
    }

    static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        ListNode head2 = new ListNode(13);
        head2.next = new ListNode(21);
        head2.next.next = new ListNode(15);
        head2.next.next.next = new ListNode(14);
        head2.next.next.next.next = new ListNode(11);

        System.out.print("Original Linked List 1: ");
        printLinkedList(head);

        System.out.print("Original Linked List 2: ");
        printLinkedList(head2);

        // Sort the linked list
        ListNode head3 = mergeTwoLists(head, head2);
        head3 = sortLinkedList(head3);

        System.out.print("Sorted Linked List: ");
        printLinkedList(head3);
    }
}