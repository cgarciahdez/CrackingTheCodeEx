package p5p2;

public class BinaryFraction {
	
	public static String fractionToBinary(double number){
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		for(int i=0;i<32;i++){
			number*=2;
			sb.append((int)number);
			number=number%1;
			if(number==0)return sb.toString();
		}
		return "ERROR";
	}
	
	public static void main(String[] args) {
		String bs = fractionToBinary(.1);
		System.out.println(bs);
		
		for (int i = 0; i < 1000; i++) {
			double num = i / 1000.0;
			String binary = fractionToBinary(num);
			if (!binary.equals("ERROR") ) {
				System.out.println(num + " : " + binary );
			}
}
	}

}
