// What if duplicate element?

package linkedList;

public class DeleteMiddle {
	public static boolean deleteMiddle(ListNode c) {
		if(c==null || c.next==null)
			return false;
		ListNode next = c.next;
		c.val = next.val;
		c.next = next.next;
		return true;
	}
}