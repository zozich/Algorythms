package leetcode;

public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = countLength(headA);
        int lengthB = countLength(headB);
        if (lengthA > lengthB) {
            headA = incrementNode(headA, lengthA - lengthB);
        } else {
            headB = incrementNode(headB, lengthB - lengthA);
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private ListNode incrementNode(ListNode head, int difference) {
        for (int j = 0; j < difference; j++) {
            head = head.next;
        }
        return head;
    }

    private int countLength(ListNode head) {
        int counter = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }
}
