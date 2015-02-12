// Describe	how	you	could use a	single array to implement three	stacks.

package stack;

public class ArrayStack {
	public void arrayToStack(int n) {
		//suppose that n is the size of each stack
		int size = n;
		//use [0, n), [n, 2*n), [2*n, 3*n) of the array to implement the three stacks
		int[] array = new int[n*3];
		//initial three integer to be the pointers for the stacks
		int[] pointers = new int[3];
		pointers[0] = Integer.MIN_VALUE;
		pointers[1] = Integer.MIN_VALUE;
		pointers[2] = Integer.MIN_VALUE;
		
	}
	
	public void push(int num, int n, int[] pointers, int[] array, int val) throws Exception{
		//suppose the num stands for which stack need to be operated
		if(pointers[num]+1>=n) {
			throw new Exception("No space in stack");
		}
		pointers[num]++;
		array[topOfStack(num, n, pointers)] = val;
	}
	
	public int pop(int num, int n, int[] pointers, int[] array) throws Exception {
		if(pointers[num]==-1) {
			throw new Exception("No item in stack");
		}
		int val = array[topOfStack(num, n, pointers)];
		array[topOfStack(num, n, pointers)] = 0;
		pointers[num]--;
		return val;
	}
	
	public int peek(int num, int n, int[] pointers, int[] array) throws Exception {
		if(pointers[num]==-1) {
			throw new Exception("No item in stack");
		}
		int val = array[topOfStack(num, n, pointers)];
		return val;
	}

	public int topOfStack(int num, int n, int[] pointers) {
		
		return n * num + pointers[num];
	}
}