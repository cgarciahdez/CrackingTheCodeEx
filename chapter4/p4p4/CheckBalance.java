package p4p4;

import methods.BTreePrinter;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class CheckBalance {
	private static int checkBalance(TreeNode<Integer> root){
		if(root==null){
			return 0;
		}
		int hl = checkBalance(root.left);
		int hr = checkBalance(root.right);

		if(hl<0||hr<0||Math.abs(hl-hr)>1){
			return -1; //akin to returning false for unbalanced
		}
		return Math.max(hl, hr)+1;
	}
	
	public static boolean isBalanced(TreeNode<Integer>root){
		return checkBalance(root)>=0;
	}
	
	public static void main(String[] args) {
		int [] array = {0,1,2,3,4,5,6};
		TreeNode<Integer> tree = TreeFromArray.treeFromArray(array);
//		tree.insertInOrder(7);
//		tree.insertInOrder(8);
//		tree.insertInOrder(0);
		BTreePrinter.printNode(tree);
		System.out.println(isBalanced(tree));
	}
}
