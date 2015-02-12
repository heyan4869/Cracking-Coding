package string;

public class ReplaceSpace {
	public static String replaceSpace(String str, int n) {
		char[] ca = str.toCharArray();
		int	index = str.length() - 1;
		int curr = 0;
		for(int i=0; i<n; i++) {
			if(ca[i]==' ') {
				curr = i;
				for(int j=index-2; j>i; j--) {
					ca[j+2] = ca[j];
				}
				ca[curr] = '%';
				ca[curr+1] = '2';
				ca[curr+2] = '0';
			}	
				
		}		
		
		return String.valueOf(ca);
	}
	
	public static void main(String args[]) {
		String str = "Mr John Smith      ";
		int n = 13;
		System.out.println(replaceSpace(str, n));
	}
}