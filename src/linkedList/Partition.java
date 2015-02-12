// This solution is not right, the order has been changed

package linkedList;

public class Partition {
	public static ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)
			return head;
		ListNode prev = head;
		ListNode curr = head.next;
		ListNode temp = head;
		ListNode result = head;
		while(curr!=null) {
			if(curr.val<x) {
				temp = curr.next;
				prev.next = curr.next;
				prev = curr.next;
				head = curr;
				result = head;
				curr = temp;
				
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		
		return result;
	}
}