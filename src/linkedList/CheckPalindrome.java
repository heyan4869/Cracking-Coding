package linkedList;

import java.util.Stack;

public class CheckPalindrome {
	public static boolean checkPalindrome(ListNode head) {
		int len = getLen(head);
		Stack<Integer> s = new Stack<Integer>();
		ListNode p1 = head;
		ListNode p2 = head;
		
		// if the length is odd, skip the middle element 
		if(len%2==0) {
			for(int i=0; i<len/2; i++) {
				s.add(p1.val);
				p1 = p1.next;
			}
			while(!s.empty()) {
				if(s.peek()==p1.val) {
					p1 = p1.next;
					s.pop();
				} else
					return false;
			}
		} else {
			for(int i=0; i<len/2; i++) {
				s.add(p1.val);
				p1 = p1.next;
			}
			p1 = p1.next;
			while(!s.empty()) {
				if(s.peek()==p1.val) {
					p1 = p1.next;
					s.pop();
				} else
					return false;
			}
		}
		
		return true;
	}
	
	public static int getLen(ListNode node) {
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
}