package string;

import java.util.HashSet;

public class UniqueCharacters {
	public static boolean checkUnique(String str) {
		if(str.length()>256)
			return false;
		HashSet<Character> hs = new HashSet<Character>();
		for(int i=0; i<str.length(); i++) {
			if(hs.contains(str.charAt(i)))
				return false;
			else 
				hs.add(str.charAt(i));
			
		}
		
		return true;
	}
	
	public static void main(String args[]) {
		System.out.println(checkUnique("acbfdr345!~"));
	}
}