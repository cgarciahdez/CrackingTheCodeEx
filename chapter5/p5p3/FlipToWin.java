package p5p3;

public class FlipToWin {
	
	public static int maxConsecutive(int number){
		int current=0;
		int acum=0;
		int mask=1;
		int max=0;
		
		while(mask!=0){
			if((mask&number)!=0){ //the one bit is 1
				current++;
				acum++;
			}
			else{
				if(acum>max)max=acum;
				acum=current;
				current=0;
			}
			mask<<=1;
		}
		return max+1;
	}
	
	public static void main(String[] args) {
		System.out.println(maxConsecutive(1775));
	}

}
