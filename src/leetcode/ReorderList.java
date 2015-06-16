package leetcode;

public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int height = calculateHeight(head);
        int offset = height / 2 + height % 2;
        ListNode secondListHead = getSecondListHead(head, offset);
        secondListHead = reverseList(secondListHead);
        mergeLists(head, secondListHead);
    }

    private void mergeLists(ListNode head, ListNode secondListHead) {
        ListNode currentFirstNode = head;
        ListNode currentSecondNode = secondListHead;
        while (true) {
            ListNode firstNext = currentFirstNode.next;
            ListNode secondNext = currentSecondNode.next;
            currentFirstNode.next = currentSecondNode;
            currentSecondNode.next = firstNext;
            currentFirstNode = firstNext;
            currentSecondNode = secondNext;
            if (secondNext == null) {
                break;
            }
        }
        currentFirstNode.next = null;
    }

    private int calculateHeight(ListNode head) {
        int counter = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    private ListNode getSecondListHead(ListNode head, int offset) {
        ListNode secondListHead = head.next;
        for (int i = 0; i < offset - 1; i++) {
            secondListHead = secondListHead.next;
        }
        return secondListHead;
    }

    private ListNode reverseList(ListNode head) {
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
