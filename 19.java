/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cycle = getLength(head) - n;
        ListNode remaining = remaining(head, cycle);
        ListNode cut = cut(head, cycle);
        return join(cut, remaining);
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return 1 + getLength(head.next);
    }

    public ListNode remaining(ListNode head, int n) {
        if (n == 0) {
            return head.next;
        }

        return remaining(head.next, n - 1);
    }

    public ListNode cut(ListNode head, int n) {
        if (n == 0) {
            head = null;
            return head;
        }

        return new ListNode(head.val, cut(head.next, n - 1));
    }
    
    public ListNode join(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }

        return new ListNode(a.val, join(a.next, b));
    }
}