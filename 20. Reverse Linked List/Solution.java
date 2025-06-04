public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;           // Pichla node
        ListNode curr = head;           // Current node
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Agla node yaad rakhna
            curr.next = prev;              // Current ka next ko reverse karna
            prev = curr;                   // Prev ko aage badhana
            curr = nextTemp;               // Current ko aage badhana
        }
        
        return prev;  // Naya head
    }
}