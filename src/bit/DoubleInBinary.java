package bit;

public class DoubleInBinary {
	public static String doubleToBinary(double num) {
		if (num > 1 || num < 0)
			return "ERROR";
	    else if (num == 1)
	    	return "1";
	    else if (num == 0)
	    	return "0";
	    String result = "0.";
	    while (num > 0) {
	        if (result.length() >= 32)
	        	break;
	        num *= 2;
	        if (num >= 1) {
	            result += "1";
	            num -= 1;
	        } else 
	        	result += "0";
	    }
	    if (result.length() >= 32)
	    	return "ERROR";
	    return result;
	}
	
	public static void main(String args[]) {
		double num = 0.125;
		System.out.println(doubleToBinary(num));
	}
}