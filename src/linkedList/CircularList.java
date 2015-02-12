package linkedList;

public class CircularList {
	public static ListNode findNode(ListNode head) {
		ListNode p1 = head;
		ListNode p2 = head;
		
		// find the meeting node
		while(p1!=null && p1.next!=null) {
			p1 = p1.next.next;
			p2 = p2.next;
			if(p1==p2)
				break;
		}
		
		// check if no loop exists
		if(p1==null || p1.next==null)
			return null;
		
		// find the start of the loop
		p2 = head;
		while(p2!=p1) {
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1;
	}
}