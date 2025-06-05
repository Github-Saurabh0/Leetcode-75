class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;  // slow pointer ek step chalega
        ListNode fast = head;  // fast pointer do step chalega

        while (fast != null && fast.next != null) {
            slow = slow.next;        // slow ek step aage badhega
            fast = fast.next.next;   // fast do step aage badhega
        }
        return slow;  // jab fast end tak pahunch jaaye, slow middle node pe hoga
    }
}
