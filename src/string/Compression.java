package string;

public class Compression {
	public static String compression(String str) {
		if(str==null || str.length()==0)
			return null;
		int count = 1;
		int[] index = new int[str.length()];
		index[0] = 0;
		for(int i=1; i<str.length(); i++) {
			if(count>=str.length()-1)
				return str;
			if(str.charAt(i)!=str.charAt(i-1)) {
				index[count] = i;
				count++;
			}	
				
		}
		index[count++] = str.length();
		
		String[] result = new String[str.length()];
		for(int j=0; j<count-1; j++) {
			result[2*j] = str.charAt(index[j+1]-1) + "";
			result[2*j+1] = Integer.toString(index[j+1]-index[j]);
		}
		
//		for(int j=0; j<result.length; j++) {
//			System.out.println(result[j]);
//		}
		String compressed = "";
		for (int i=0; i<result.length; i++) {
			if(result[i]!=null)
				compressed = compressed + result[i];
		}
		return compressed;
	}
	
	public static void main(String args[]) {
		System.out.println(compression("abbcccdddde"));
	}
}