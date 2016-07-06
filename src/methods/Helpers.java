package methods;

import java.util.Arrays;

public class Helpers {
	
	public static void printCharMatrix(char[][] x){
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j< x[i].length; j++) {
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void printMatrix(int[][] x){
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j< x[i].length; j++) {
				System.out.print(x[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomIntInRange(min, max);
			}
		}
		return matrix;
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
	
	private static char[] merge(char[] l1,char[] l2){
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

	public static LinkedListNode<Integer> randomLinkedList(int min, int max, int N){
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(randomIntInRange(min, max));
		LinkedListNode<Integer> n = head;
		for (int i=1;i<N;i++){
			LinkedListNode<Integer> next = new LinkedListNode<Integer>(randomIntInRange(min, max));
			n.setNext(next);
			n = next;
		}
		return head;
	}
	
	public static LinkedListNode<Integer> valueLinkedList(int value, int N){
		LinkedListNode<Integer> head = new LinkedListNode<Integer>(value);
		LinkedListNode<Integer> n = head;
		for (int i=0;i<N;i++){
			LinkedListNode<Integer> next = new LinkedListNode<Integer>(value);
			n.setNext(next);
			n = next;
		}
		return head;
	}

}
