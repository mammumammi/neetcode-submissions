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
        if (head == null) return null;

        List<ListNode> ll = new ArrayList<>();

        ListNode current = head;

        while(current != null){
            ll.add(current);
            current = current.next;
        }

        int left = 0;
        int right = ll.size();

        int target = right - n;
        if (target == 0){
            return head.next;
        }
        current = head;
        if (right == 1){
            return null;
        }
        while(left<target-1){
            current = current.next;
            left++;
        }
        
        current.next = current.next.next;
        current = current.next;


        return head;
    }
}
