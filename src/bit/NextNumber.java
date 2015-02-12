/*
 * Given a positive integer, print the next smallest and the next largest number
 * that have the same number of 1 bits in their binary representation.
 */

//package bit;
//
//public class NextNumber {
//	public static void findNext(int num) {
//		
//	}
//}
//
package bit;

public class NextNumber{
	
	public int getNext(int n) {
		// if the original number is：	（for example）11011 00111 0011-->11011 00111 0101
		//			（for example）11011 00111 1100-->11011 01000 1111
		//		
		int c = n;
		int c0 = 0;
		int c1 = 0;
		// compute c0 and c1
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1;
		}
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		// Error: if n==11..1100..00, then there is no bigger number with the
		// same number of 1s.
		if (c0 + c1 == 0 || c0 + c1 == 31)
			return -1;
		int p = c0 + c1;
		n |= 1 << p;
		n &= ~(1 << (p) - 1);
		n |= (1 << (c1 - 1)) - 1;
		return n;
	}
	public int getPrev(int n){
		//if the original number is：	（for example）11011 00111 0011-->11011 00110 1110
		//			（for example）11011 00111 1100-->11011 00111 1010
		//
		int c=n;
		int c0=0;
		int c1=0;
		// compute c1 and c0
		while((c&1)==1){
			c1++;
			c>>=1;
		}
		if(c==0)
			return -1;
		while((c&1)==0&&c!=0){
			c0++;
			c>>=1;
		}	
		int p=c0+c1;
		n&=(~0)<<(p+1);
		int mask=(1<<(c1+1))-1;
		n|=(mask<<(c0-1));
		return n;
	}
}


