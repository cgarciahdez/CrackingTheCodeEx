package p4p6;

import methods.BTreePrinter;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class FindSuccesor {
	
	private static TreeNode<Integer> searchParents(TreeNode<Integer> root){
		TreeNode<Integer> n = root;
		while(n!=null&&n.data<=root.data){
			n=n.parent;
		}
		return n;
	}
	
	private static TreeNode<Integer> searchRightSubTree(TreeNode<Integer> root){
		TreeNode<Integer> n = root;
		while(n.left!=null){
			n=n.left;
		}
		return n;
	}
	
	public static TreeNode<Integer> findNext(TreeNode<Integer> root){
		if(root.right==null){
			return searchParents(root);
		}
		else{
			return searchRightSubTree(root.right);
		}
	}
	
	public static void main(String[] args) {
		int [] array = {2,3,5,6,7,8};
		TreeNode<Integer> tree = TreeFromArray.treeFromArray(array);
		BTreePrinter.printNode(tree);
		System.out.println(findNext(tree.left).data);
	}

}
