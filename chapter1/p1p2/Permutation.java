package p1p2;

import java.util.HashMap;

public class Permutation {
	
	public static boolean isPermutation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}
		
		HashMap<Character, Integer> hm = new HashMap<Character,Integer>();
		
		for (int i =0;i<s1.length();i++){
			if(hm.get(s1.charAt(i))==null){
				hm.put(s1.charAt(i), 1);
			}
			else{
				hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
			}
		}
		System.out.println(hm);
		
		for (int i =0;i<s2.length();i++){
			Integer freq = hm.get(s2.charAt(i));
			if(freq==null||freq<1){
				return false;
			}
			else{
				hm.put(s2.charAt(i), freq-1);
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"wacamole","elomacaw"};
		
		for (int i=0;i<words.length;i++){
			for (int j=i+1;j<words.length;j++){
				System.out.println(words[i]+" is a permutation of "+words[j]+"?");
				System.out.println(isPermutation(words[i], words[j]));
				System.out.println();
			}
		}
	}

}
