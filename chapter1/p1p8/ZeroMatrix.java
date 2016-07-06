package p1p8;

import methods.Helpers;

public class ZeroMatrix {

	public static void zeroMatrix(int[][] matrix){
		boolean firstRow=false; //First zero will mark column. Can't mark both
		//Check for zeroes and mark columns and rows to be changed
		for (int i =0; i<matrix.length;i++){
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==0){
					if(i==0){
						firstRow=true;
					}
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
//		System.out.println();
//		Helpers.printMatrix(matrix);

		//change marked rows (follow along first column)
		for (int i = 1; i < matrix.length; i++) { //we start from second row o not lose column indices. Moreover, first zero doesn´t say anything about row.
			if(matrix[i][0]==0){
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j]=0;
				}
			}
		}
		
//		System.out.println();
//		Helpers.printMatrix(matrix);

		//change marked columns (follow along first row)
		for (int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i]==0){
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i]=0;
				}
			}
		}
		
		//finally check if first row should be changed
		if(firstRow){
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[0][j]=0;
			}
		}
		
	}



	public static void main(String[] args) {
		int[][] m = Helpers.randomMatrix(6, 10, 0, 9);
		Helpers.printMatrix(m);
		zeroMatrix(m);
		System.out.println();
		Helpers.printMatrix(m);
	}

}
