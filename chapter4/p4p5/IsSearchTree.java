package p4p5;

import methods.BTreePrinter;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class IsSearchTree {
	private static boolean isBST (int min, int max, TreeNode<Integer> root){
		if(root==null){
			return true;
		}
		boolean is = min< root.data && root.data <=max;
		if(!is){
			return false;
		}
		return is && isBST(min, root.data, root.left) && isBST(root.data, max, root.right);
	}
	
	public static boolean isBst ( TreeNode<Integer> root){
		return isBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
	}
	
	public static void main(String[] args) {
		int [] array = {2,3,5,5,6,7,8};
		TreeNode<Integer> tree = TreeFromArray.treeFromArray(array);
		BTreePrinter.printNode(tree);
		System.out.println(isBst(tree));
	}
}
