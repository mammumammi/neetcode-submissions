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
    public void reorderList(ListNode head) {
        List<ListNode> result = new ArrayList<>();

        ListNode current = head;

        if (head == null || head.next == null) return;

        while(current!=null){
            result.add(current);
            current = current.next;
        }

        int left = 0;
        int right = result.size() - 1;

        while(left<right){
            result.get(left).next = result.get(right);
            left++;

            if (left == right) break;

            result.get(right).next = result.get(left);
            right--;
        }

        result.get(left).next = null;
    }
}
