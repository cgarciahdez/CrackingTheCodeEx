package p8p2;

import java.util.ArrayList;
import java.util.Arrays;

public class RobotInAGrid {
	
	public static boolean robot(boolean[][] casillas, int rows, int cols, ArrayList<String> camino){
		int[][] isRoad = new int[rows][cols]; //1=true 0=false -1=unvisited
		
		for (int i = 0; i < isRoad.length; i++) {
			Arrays.fill(isRoad[i], -1);
		}
		return helper(casillas, rows-1, cols-1, isRoad, camino);
	}
	
	public static boolean helper(boolean[][] casillas, int rows, int cols,int[][] isRoad, ArrayList<String> camino){	
		if(!casillas[rows][cols]){
			//No puedo estar en esta casilla
			return false;
		}
		if(rows==0&&cols==0){
			return true;
		}
		if(isRoad[rows][cols]==-1){
			if(rows==0){
				isRoad[rows][cols]=helper(casillas,rows,cols-1,isRoad,camino)?1:0;
			}else if(cols==0){
				isRoad[rows][cols]=helper(casillas,rows-1,cols,isRoad,camino)?1:0;
			}else{
				isRoad[rows][cols]=(helper(casillas,rows-1,cols,isRoad,camino)||helper(casillas,rows,cols-1,isRoad,camino))?1:0;
			}
		}
		if(isRoad[rows][cols]==1){
			camino.add("("+rows+","+cols+")");
		}
		return isRoad[rows][cols]==1;
	}
	
	public static void main(String[] args) {
		boolean[][] casillas ={
				{true, true, true},
				{false, true, false},
				{false, true, true},
				{false, false, true},
				{true, true, true}
		};
		ArrayList<String> camino = new ArrayList<String>();
		System.out.println(Arrays.deepToString(casillas));
		
		System.out.println(robot(casillas, 5, 3,camino));
		for(String s:camino){
			System.out.println(s);
		}
		System.out.println();
	}

}
