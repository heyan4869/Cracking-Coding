package string;

public class Substring {
	public static boolean checkSubstring(String s1, String s2) {
		if(s1==null && s2==null)
			return true;
		if(s1.length()==s2.length() && s1.length()>0) {
			String s = s1 + s1;
			return isSubstring(s, s2);
		} else
			return false;
	}

	private static boolean isSubstring(String str1, String str2) {
		// TODO Auto-generated method stub
		return false;
	}
}