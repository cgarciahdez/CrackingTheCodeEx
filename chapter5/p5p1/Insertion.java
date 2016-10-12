package p5p1;

public class Insertion {
	
	public static int insertion (int N, int M, int i, int j){
		int mask=-1;
		mask>>>=(31-(j-i)); //leave (i-i) (M's length in significant bits) ones at the end of mask
		mask<<=i; //shift the 1's by i bits, so that mask starts at ith bit
		N&=(~mask); //use negative of mask
		return N|(M<<i);// position M to start at ith bit and mege
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(8));
	}

}
