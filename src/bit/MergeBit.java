package bit;

public class MergeBit {
	public static int merge(int n, int m, int i, int j) {
		// get an all 1 integer
		int one = ~0;
		System.out.println(one);
		
		// left shift it so that every bit before j is 0
		int leftone = one << (j + 1);
		
		// get an all 1 integer
		int onenew = ~0;
		
		// left shift it so that every bit after i is 0
		int rightzero = onenew << (i);
		
		// xor it with all 1 integer to get the bit after i to be 1
		int rightone = rightzero ^ (~0);
		System.out.println(rightone);
		// get an integer that is 0 between j and i
		int hole = leftone | rightone;
		
		// get integer n to have 0 between j and i
		int newn = n & hole;
		
		// get integer m to left shift
		//int tempm = m | (~1);
		int newm = m << i;
		
		// merge the m and n
		int result = newn ^ newm;
		
		return result;
		
		
	}
	
	public static void main(String args[]) {
		int n = 105;
		int m = 5;
		int i = 2;
		int j = 4;
		int result = merge(n, m, i, j);
		System.out.println(result);
	}
}