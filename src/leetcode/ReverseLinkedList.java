package leetcode;

public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode previous = null;
        while (head != null) {
            current = head.next;
            head.next = previous;
            previous = head;
            head = current;
        }
        return previous;
    }
}
