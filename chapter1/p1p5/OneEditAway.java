package p1p5;

public class OneEditAway {
	
	public static boolean oneAway(String s1, String s2){
		if(s1.length()==s2.length()){
			return oneAwayEq(s1,s2);
		}
		else{
			//Assumption
			String longer = s1;
			String shorter = s2;
			//Check assumption
			if(s1.length()<s2.length()){
				longer=s2;
				shorter=s1;
			}
			if(longer.length()-shorter.length()<=1){
				return oneAwayNotEq(longer,shorter);
			}
			else{
				return false;
			}
		}
	}

	private static boolean oneAwayNotEq(String lo, String sh) {
		int i=0;
		int j=0;
		boolean oneChange = false;
		while(i<sh.length()){
			if(lo.charAt(j)!=sh.charAt(i)){
				if(!oneChange){
					oneChange=true;
					j++;
				}
				else{
					return false;
				}
			}
			else{
				i++;
				j++;
			}
		}
		return true;
	}

	private static boolean oneAwayEq(String s1, String s2) {
		boolean oneChange = false;
		for (int i=0;i<s1.length();i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				if(!oneChange){
					oneChange = true;
				}
				else{
					return false;
				}
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(oneAway("pale", "bake"));
	}

}
