package p1p4;

import java.util.HashMap;
import java.util.Iterator;

public class PalPer {

	public static boolean palPerASCII(String s){
		s = s.toLowerCase().replace(" ", ""); //if it doesnt matter
		int bitVec =0;
		int current = 0;
		int highest = 0;

		for (int i = 0;i<s.length();i++){
			current = s.charAt(i)-'a';
			bitVec ^= (1<<current);
			if(current>highest){
				highest=current;
			}
		}
		
		System.out.println(Integer.toBinaryString(bitVec));
		System.out.println(Integer.toBinaryString(bitVec-1));

//		int ones=0;
//		current=highest;
//		while (current>=0 && ones<2){
//			if((bitVec&(1<<current))>0){
//				ones++;
//			}
//			current--;
//		}
//		return ones<2?true:false;
		
		//optimization
		
		return (bitVec&(bitVec-1))==0;
	}

	public static boolean palPerASCIIOpti(String s){
		s = s.toLowerCase().replace(" ", ""); //if it doesnt matter
		int bitVec =0;
		int current = 0;

		int ones = 0;

		for (int i = 0;i<s.length();i++){
			current = s.charAt(i)-'a';
			bitVec ^= (1<<current);
			if((bitVec&(1<<current))>0){
				ones++;
			}
			else{
				ones--;
			}
		}
		return ones<2?true:false;

	}
	
	public static boolean palPer(String s){
		s = s.toLowerCase().replace(" ", ""); //if it doesnt matter
		HashMap<Character, Boolean> hm = new HashMap<Character,Boolean>();
		
		for (int i =0; i<s.length();i++){
			Boolean current = hm.get(s.charAt(i));
			hm.put(s.charAt(i), current==null?true:!current);
		}
		
		int ones =0;
		Iterator<Boolean> it = hm.values().iterator();
		
		while(it.hasNext()){
			if(it.next()){
				ones++;
			}
		}
		
		return ones<2?true:false;
	}
	
	public static void main(String[] args) {
		String s = "Tact Coa";
		System.out.println(palPerASCII(s));
		System.out.println(palPerASCIIOpti(s));
		System.out.println(palPer(s));	}


}
