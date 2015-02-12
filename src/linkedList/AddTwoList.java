package linkedList;

public class AddTwoList {
	public ListNode addTwo(ListNode n1, ListNode n2) {
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		ListNode sum = new ListNode((n1.val + n2.val) % 10);
		ListNode head = sum;
		int flag = (n1.val + n2.val) / 10;
		
		// check if list has only one element
		if(n1.next==null && n2.next==null && flag!=0) {
		    sum.next = new ListNode(flag);
		}
		while(n1.next!=null || n2.next!=null) {
			if(n1.next!=null && n2.next!=null) {
				sum.next = new ListNode((n1.next.val + n2.next.val + flag) % 10);
				flag = (n1.next.val + n2.next.val + flag) / 10;
				n1 = n1.next;
				n2 = n2.next;
				sum = sum.next;
			} else if(n1.next!=null) {
				sum.next = new ListNode((n1.next.val + flag) % 10);
				flag = (n1.next.val + flag) / 10;
				n1 = n1.next;
				sum = sum.next;
			} else {
				sum.next = new ListNode((n2.next.val + flag) % 10);
				flag = (n2.next.val + flag) / 10;
				n2 = n2.next;
				sum = sum.next;
			}
			
		}
		
		// check if there is still flag left
		if(flag!=0)
		    sum.next = new ListNode(flag);
		return head;
	}
}