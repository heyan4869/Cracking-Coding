// this solution works, but not in O(1)

package challenge;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumQueue {
	private static Queue<Integer> q = new LinkedList<Integer>();
	//private LinkedList<Integer> min = new LinkedList<Integer>();
	public static ListNode head = new ListNode(Integer.MIN_VALUE);
	
	
	
	public static void enQueue(int val) {
		q.add(val);
		
		ListNode curr = head;
		ListNode temp = new ListNode(val);
		
		if (curr.next == null) {
			curr.next = temp;	
		} else {
			while (curr.next != null) {
				if (temp.val > curr.next.val) {
					curr = curr.next;
				} else {
					ListNode backup = curr.next;
					curr.next = temp;
					temp.next = backup;
					break;
				}
			}
		}
		
	}
	
	public static void deQueue() {
		ListNode curr = head;
		int target = q.peek();
		
		q.remove();
		
		while (curr.next != null) {
			if (target == curr.next.val) {
				System.out.println("if");
				ListNode backup = curr.next.next;
				curr.next = backup;
				break;
			} else {
				System.out.println("else");
				curr = curr.next;
			}
		}
		
	}
	
	public static int getMin() {
		
		return head.next.val;
	}
	
	public static void main(String args[]) {
		enQueue(6);
		enQueue(5);
		enQueue(2);
		enQueue(3);
		enQueue(4);
		deQueue();
		deQueue();
		deQueue();
		deQueue();
		//System.out.println(head.next.val);
		System.out.println("testing");
		System.out.println(getMin());
	}
}