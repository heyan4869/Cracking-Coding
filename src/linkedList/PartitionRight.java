package linkedList;

public class PartitionRight {
	public static ListNode partition(ListNode head, int x) {
		if(head==null || head.next==null)
			return head;
		ListNode large = new ListNode(-1);
		ListNode small = new ListNode(-1);
		ListNode smallHead = small;
		ListNode largeHead = large;
		while(head!=null) {
			if(head.val<x) {
				small.next = head;
				small = head;
			} else {
				large.next = head;
				large = head;
			}
			head = head.next;
		}
		large.next = null;
		small.next = largeHead.next;
		return smallHead.next;
	}
}