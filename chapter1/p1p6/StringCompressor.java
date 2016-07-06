package p1p6;

public class StringCompressor {
	
	public static String compressor(String s){
		if(s.length()<1)return s;
		int counter = 1;
		char last = s.charAt(0);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1;i<s.length();i++){
			if(s.charAt(i)!=last){
				sb.append(last);
				sb.append(counter);
				counter=1; //you are seeing it right now
				last = s.charAt(i);
			}
			else{
				counter++;
			}
		}
		sb.append(last);
		sb.append(counter);
		
		String compressed = sb.toString();
		return s.length()<compressed.length()?s:compressed;
	}
	public static void main(String[] args) {
		System.out.println(compressor("camiaaaaaaaaaaaaaaaaaa"));
	}
}
