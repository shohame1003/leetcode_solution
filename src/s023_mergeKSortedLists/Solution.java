package s023_mergeKSortedLists;

public  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }

    private ListNode mergeKLists(ListNode[] lists, int leftIndex, int rightIndex) {
        if (rightIndex > leftIndex + 1) {
            int mid = (leftIndex + rightIndex) / 2;
            ListNode left = mergeKLists(lists, leftIndex, mid);
            ListNode right = mergeKLists(lists, mid, rightIndex);
            return mergeTwoLists(left, right);
        } else {
            return lists[leftIndex];
        }
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode res;
        if (left.val <= right.val) {
            res = left;
            left = left.next;
        } else {
            res = right;
            right = right.next;
        }
        ListNode node = res;
        while (left != null || right != null) {
            if (left == null) {
                node.next = right;
                right = right.next;
            } else if (right == null) {
                node.next = left;
                left = left.next;
            } else {
                if (left.val <= right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
            }
            node = node.next;
        }
        return res;
    }
}