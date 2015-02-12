package linkedList;

import java.util.Stack;

public class AddTwoListReverse {
	public ListNode addTwo(ListNode n1, ListNode n2) {
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;

		ListNode p1 = n1;
		ListNode p2 = n2;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while(p1.next!=null) {
			s1.add(p1.val);
			p1 = p1.next;
		}
		while(p2.next!=null) {
			s2.add(p2.val);
			p2 = p2.next;
		}
		
		//add the first element in the stack and pop both of them
		ListNode end = new ListNode((s1.peek()+s2.peek())%10);
		int flag = (s1.peek()+s2.peek()) / 10;
		s1.pop();
		s2.pop();
		
		// check if list has only one element
		ListNode first = end;
		if(n1.next==null && n2.next==null && flag!=0) {
		    first = new ListNode(flag);
		    first.next = end;
		}
		
		while(!s1.empty() || !s2.empty()) {
			if(!s1.empty() && !s2.empty()) {
				first = new ListNode((s1.peek() + s2.peek() + flag) % 10);
				flag = (s1.peek() + s2.peek() + flag) / 10;
				first.next = end;
				end = first;
				s1.pop();
				s2.pop();
				
			} else if(!s1.empty()) {
				first = new ListNode((s1.peek() + flag) % 10);
				flag = (s1.peek() + flag) / 10;
				first.next = end;
				end = first;
				s1.pop();
				//s2.pop();
			} else {
				first = new ListNode((s2.peek() + flag) % 10);
				flag = (s2.peek() + flag) / 10;
				first.next = end;
				end = first;
				//s1.pop();
				s2.pop();
			}
		}
		
		// check if flag is not zero yet
		if(flag!=0) {
			first = new ListNode(flag);
			first.next = end;
		}
		
		return first;
	}
	
//	public int getLen(ListNode node) {
//        int len = 0;
//        while (node != null) {
//            len++;
//            node = node.next;
//        }
//        return len;
//    }
}