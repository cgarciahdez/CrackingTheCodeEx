package p1p9;

public class RotateString {

	public static boolean isSubstring(String big, String small) {
		if (big.indexOf(small) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean strRotation(String s1, String s2){
		if(s1.length()!=s2.length())return false;
		String checker = s2+s2;
		if(isSubstring(checker,s1)){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = strRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}


}
