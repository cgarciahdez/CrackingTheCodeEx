package p1p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class P1p1 {
	
	public static boolean solveWithStructures(String s){
		HashMap<String,String>hm = new HashMap<String,String>();
		boolean response = false;
		for (int i=0;i<s.length()&&!response;i++){
			response = !(hm.get(s.charAt(i)+"")==null);
			hm.put(s.charAt(i)+"", s.charAt(i)+"");
		}
		return !response;
	}

	public boolean solveWithoutStructures(String s){
		if(s.length()<=0){
			return true;
		}
		boolean response = false;
		char before = s.charAt(0);
		for (int i =1;i<s.length()&&!response;i++){
			char actual = s.charAt(i);
			if(actual==before){
				response=true;
			}
		}
		return !response;
	}
	
	public static void quicksort(){
		
	}
	
	
	public static char[] mergeSort(char[] s){
		System.out.println(s);
		if(s.length<=1){
			return s;
		}
		int mid = (s.length-1)/2;
		
		char[] l1=mergeSort(Arrays.copyOfRange(s, 0, mid+1));
		char[] l2=mergeSort(Arrays.copyOfRange(s, mid+1, s.length));
		return merge(l1,l2);
	}
	
	public static char[] merge(char[] l1,char[] l2){
		if(l1.length<=0){
			return l2;
		}
		if(l2.length<=0){
			return l1;
		}
		int i=0; //pointer for l1
		int j=0; //pointer for l2
		int current =0; //pointer for new array
		char[] ret = new char[l1.length+l2.length];
		
		while(i<l1.length||j<l2.length){
			if (i>=l1.length){
				ret[current] = l2[j];
				j++;
			}
			else if (j>=l2.length){
				ret[current] = l1[i];
				i++;
			}
			else if (l1[i]<l2[j]){
				ret[current] = l1[i];
				i++;
			}
			else{
				ret[current] = l2[j];
				j++;
			}
			
			current++;
		}
		return ret;
	}
	
	public static boolean bookSol(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println(str.charAt(i));
			System.out.println(Integer.toBinaryString(checker));
			System.out.println(val);
			//System.out.println(Integer.toBinaryString(val));
			System.out.println(Integer.toBinaryString(1<<val));
			System.out.println(Integer.toBinaryString(checker & (1 << val)));
			System.out.println(Integer.toBinaryString(checker | (1 << val)));
			System.out.println();
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String... args){
		Scanner sc = new Scanner(System.in);
		//String s = sc.nextLine();
		sc.close();
		//System.out.println(solveWithStructures(s));
		//System.out.println(mergeSort("edcba".toCharArray()));
		System.out.println(bookSol("bcdefghijklmnop"));
	}
}
