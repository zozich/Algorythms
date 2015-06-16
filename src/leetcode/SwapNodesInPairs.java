package leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode newSecondNode = swapNodesAndReturnNewSecond(null, head, head.next);
        while (newSecondNode.next != null && newSecondNode.next.next != null) {
            ListNode current = newSecondNode;
            newSecondNode = swapNodesAndReturnNewSecond(current, newSecondNode.next, newSecondNode.next.next);
        }
        return newHead;
    }

    private ListNode swapNodesAndReturnNewSecond(ListNode previous, ListNode firstNode, ListNode secondNode) {
        if (previous != null) {
            previous.next = secondNode;
        }
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        return firstNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
