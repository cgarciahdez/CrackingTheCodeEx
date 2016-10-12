package p4p2;

import methods.BTreePrinter;
import methods.TreeNode;

public class TreeFromArray {
	
	private static TreeNode<Integer> treeFromArray(int start, int end, int[] array){ //end is inclusive
		if(end<start){
			return null;
		}
		int middle = (start+end)%2==0?(start+end)/2:(start+end)/2+1;//can be used to make complete Btree
		TreeNode<Integer> midNode=new TreeNode<Integer>(array[middle]);
		midNode.setLeft(treeFromArray(start, middle-1, array));
		midNode.setRight(treeFromArray(middle+1, end, array));
		return midNode;
	}
	
	public static TreeNode<Integer> treeFromArray(int[] array){
		return treeFromArray(0, array.length-1, array);
	}
	
	public static void main(String[] args) {
		int [] array = {0,1,2,3,4,5,6,7};
		System.out.println(array.toString());
		TreeNode<Integer> tree = treeFromArray(array);
		System.out.println();
		BTreePrinter.printNode(tree);

	}

}
