package s019_removeNthNodeFromEndOfList;

import s019_removeNthNodeFromEndOfList.ListNode;

public class Solution {
    private int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        ListNode node = new ListNode(0, head);
        removeNth(node);
        return node.next;
    }

    private void removeNth(ListNode node) {
        if (node.next == null) {
            return;
        }
        removeNth(node.next);
        this.n--;

        if (this.n == 0) {
            node.next = node.next.next;
        }
    }
}