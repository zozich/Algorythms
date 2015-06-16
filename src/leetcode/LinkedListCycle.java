package leetcode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode check = head;
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            if (current == check) {
                return true;
            }
            counter++;
            if (counter == 2) {
                check = check.next;
                counter = 0;
            }
        }
        return false;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
