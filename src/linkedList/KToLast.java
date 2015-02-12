package linkedList;

public class KToLast {
	public ListNode findKth(ListNode head, int k) {
		if(head==null || k<1)
			return null;
		ListNode p = head;
		ListNode q = head;
		int count = 0;
		while(count<k-1) {
			if(q==null)
				return null;
			q = q.next;
			count++;
		}
		while(q.next!=null) {
			p = p.next;
			q = q.next;
		}
		return p;
	}
}