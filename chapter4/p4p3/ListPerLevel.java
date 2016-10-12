package p4p3;

import java.util.HashMap;

import methods.BTreePrinter;
import methods.LinkedListNode;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class ListPerLevel {
	
	public static LinkedListNode<Integer>[] listsPerLevel(TreeNode<Integer> root){
		HashMap<Integer, LinkedListNode<Integer>> hm = new HashMap<>();
		listsPerLevel(root, 0, hm);
		LinkedListNode<Integer>[] ret = new LinkedListNode[hm.size()];
		for(int i=0;i<ret.length;i++){
			ret[i]=hm.get(i);
		}
		return ret;
	}
	
	private static void listsPerLevel(TreeNode<Integer> root,int level, HashMap<Integer, LinkedListNode<Integer>> hm){
		if(root==null){
			return;
		}
		LinkedListNode<Integer> n = new LinkedListNode<Integer>(root.data);
		if(hm.containsKey(level)){
			n.next=hm.get(level);
		}
		hm.put(level, n);
		listsPerLevel(root.left,level+1,hm);
		listsPerLevel(root.right,level+1,hm);
	}
	
	public static void main(String[] args) {
		int [] array = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1};
		TreeNode<Integer> tree = TreeFromArray.treeFromArray(array);
		BTreePrinter.printNode(tree);
		LinkedListNode<Integer>[] ret = listsPerLevel(tree);
		for(LinkedListNode<Integer> ll:ret){
			System.out.println(ll.printForward());
		}
	}

}
