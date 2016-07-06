package p1p3;

public class URLify {

	public static String uRLify(String s, int len){
		char[] url = s.toCharArray();
		int current = len-1;
		int tail = s.length()-1;
		while(current>=0){
			if(url[current]!=' '){
				url[tail--] = url[current];
			}
			else{
				url[tail--]='0';
				url[tail--]='2';
				url[tail--]='%';
			}
			current--;
		}

		return new String(url);
	}

	public static void main(String[] args) {
		System.out.println(uRLify("Mr John Smith    ", 13));

	}

}
