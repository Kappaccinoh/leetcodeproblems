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
    public ListNode swapNodes(ListNode head, int k) {
        int totalLength = getLength(head) + 1;

        System.out.println("total length: " + totalLength);
        int first = getValueAtIndex(head, k);

        System.out.println("first: " + first);
        int last = getValueAtIndex(head, totalLength - k);
        System.out.println("last: " + last);

        setValue(head, last, k);
        setValue(head, first, totalLength - k);
        return head;
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        return 1 + getLength(head.next);
    }

    public int getValueAtIndex(ListNode head, int k) {
        if (k == 1) {
            return head.val;
        }

        return getValueAtIndex(head.next, k - 1);
    }

    public void setValue(ListNode head, int value, int k) {
        if (k == 1) {
            head.val = value;
            return;
        }

        setValue(head.next, value, k - 1);
    }
}