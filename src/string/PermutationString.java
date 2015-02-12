package string;

import java.util.HashSet;


public class PermutationString {
	public static boolean checkPermutation(String str1, String str2) {
		if(str1==null && str2==null)
			return true;
		if(str1.length()!=str2.length())
			return false;
		HashSet<Character> hs1 = new HashSet<Character>();
		HashSet<Character> hs2 = new HashSet<Character>();
		for(int i=0; i<str1.length(); i++) {
			hs1.add(str1.charAt(i));
			hs2.add(str2.charAt(i));
			for(int j=0; j<str2.length(); j++) {
				if(hs1.contains(str2.charAt(j))) {
					hs1.remove(str2.charAt(j));
					hs2.remove(str2.charAt(j));
				}
			}
		}

		if(hs1.size()==0 && hs2.size()==0)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]) {
		String str1 = "22233344";
		String str2 = "2223334";
		System.out.println(checkPermutation(str1, str2));
	}
}