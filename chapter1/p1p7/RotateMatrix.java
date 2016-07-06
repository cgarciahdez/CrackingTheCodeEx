package p1p7;

public class RotateMatrix {
	
	public static void main(String[] args) {
		char[][] x = new char[4][4];
		char counter ='a';
		
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				x[i][j]=counter;
				counter++;
			}
		}
		
		
		
		printMatrix(x);
		rotate(x);
		System.out.println();
		printMatrix(x);
		
		
	}
	
	public static void printMatrix(char[][] x){
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j< x[i].length; j++) {
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotate(char[][] matrix){
		int start = 0;
		int finish = matrix.length;
		while(start<finish-1){
			for(int i=start;i<finish-1;i++){
				int offset = i-start;
				char temp = matrix[start][i];
				matrix[start][i]= matrix[finish-1-offset][start];
				matrix[finish-1-offset][start] = matrix[finish-1][finish-1-offset];
				matrix[finish-1][finish-1-offset] = matrix[i][finish-1];
				matrix[i][finish-1]=temp;
			}
			start++;
			finish--;
		}
	}

}
