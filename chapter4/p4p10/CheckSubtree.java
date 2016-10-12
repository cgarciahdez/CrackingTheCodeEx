package p4p10;

import java.util.ArrayList;

import methods.BTreePrinter;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class CheckSubtree {
	
	public static ArrayList<Integer> preOrder(TreeNode<Integer> root){
		ArrayList<Integer> ret = new ArrayList<Integer>();
		preOrder(root,ret);
		return ret;
	}
	
	private static void preOrder(TreeNode<Integer> root, ArrayList<Integer> order){
		if(root!=null){
			order.add(root.data);
			preOrder(root.left,order);
			preOrder(root.right, order);
		}
		else{
			order.add(null);
		}
	}
	
	public static boolean isSubtree (TreeNode<Integer> T1, TreeNode<Integer> T2){
		ArrayList<Integer> first = preOrder(T1);
		ArrayList<Integer> second = preOrder(T2);
		for(int i=0;i<first.size();i++){
			if(first.get(i)==second.get(0)){
				if(checkEquality(first,i,second))return true;
			}
		}
		return false;
	}
	
	private static boolean checkEquality(ArrayList<Integer> first, int start, ArrayList<Integer> second){
		for(Integer j:second){
			if(start>=first.size()||first.get(start)!=j)return false;
			start++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] array1 = {1, 2, 1, 3, 1, 1, 5};
		int[] array2 = {2, 3, 1};
		
		TreeNode<Integer> t1 = TreeFromArray.treeFromArray(array1);
		TreeNode<Integer> t2 = TreeFromArray.treeFromArray(array2);
		
		BTreePrinter.printNode(t1);
		BTreePrinter.printNode(t2);

		if (isSubtree(t1, t2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}

		// t4 is not a subtree of t3
		int[] array3 = {1, 1};
		TreeNode<Integer> t3 = TreeFromArray.treeFromArray(array1);
		TreeNode<Integer> t4 = TreeFromArray.treeFromArray(array3);
		
		BTreePrinter.printNode(t4);

		if (isSubtree(t3, t4)) {
			System.out.println("t4 is a subtree of t3");
		} else {
			System.out.println("t4 is not a subtree of t3");
}
	}

}
