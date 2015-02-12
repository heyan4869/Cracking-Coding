/*
 * | is bitwise operator, so Y |=(x & 1) means Y will be 1 if either Y or/and (x & 1) are 1.
 * So if Y is 1 Y |= (x & 1) will be 1 whatever x is. Also, Y will be 1 if X is 1 from (x & 1). 
 * I hope it is clear, since english is not my prime language :d.
 * In short, if either Y or (x & 1) or both are 1, the result inclusive or (|) is 1.
 */

// question: how many bits?

package bit;

public class ReverseBit {
	public static int reverseBit(int in) {
	    int out = 0;
	    for (int i = 0 ; i < 8 ; i++) {
	        int bit = (in & 1);
	        out = (out << 1) | bit;
	        in = (in >> 1);
	    }
	    return out;
	}
	
    
	public static void main(String[] args) {
        int val = 4;
        val = reverseBit(val);
        System.out.println(val);
        System.out.println(Integer.reverse(val));
    }
}