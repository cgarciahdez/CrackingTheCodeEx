package p4p8;

import java.util.ArrayList;

import methods.BTreePrinter;
import methods.TreeNode;
import p4p2.TreeFromArray;

public class CommonAncestor {
	
	public static class Descendant{
		private int hereP,hereQ;//-1 no, 1 yes, 0 it's me
		private TreeNode<Integer> n;
		public Descendant(int p,int q, TreeNode<Integer>n){
			hereP=p;
			hereQ=q;
			this.n=n;
		}
	}
	
	public static TreeNode<Integer> findCommonAncestor(TreeNode<Integer> p, TreeNode<Integer>q, TreeNode<Integer> root){
		if(p==q)return null;
		return helper(p,q,root).n;
	}
	
	private static Descendant helper(TreeNode<Integer> p, TreeNode<Integer> q, TreeNode<Integer> root){
		if(root==null)return new Descendant(-1, -1,null);
		Descendant izq = helper(p,q,root.left);
		Descendant der = helper(p,q,root.right);
		if(izq.n!=null)return izq;
		if(der.n!=null)return der;
		int hp = izq.hereP==1||der.hereP==1||izq.hereP==0||der.hereP==0?1:-1;
		int hq = izq.hereQ==1||der.hereQ==1||izq.hereQ==0||der.hereQ==0?1:-1;
		if(hp==1&&hq==1)return new Descendant(1, 1, root);
		hp=p.data==root.data?0:hp;
		hq=q.data==root.data?0:hq;
		return new Descendant(hp, hq, null);
	}
	
	//not mine
	public static String resultToString(String s, TreeNode x, TreeNode y, TreeNode anc) {
		s += ": ";
		s += (x == null ? "null" : x.data);
		s += " & ";
		s += (y == null ? "null" : y.data);
		s += " -> ";
		s += (anc == null ? "null" : anc.data);
		return s;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode<Integer> root = TreeFromArray.treeFromArray(array);
		BTreePrinter.printNode(root);
		
		ArrayList<TreeNode<Integer>> nodes = new ArrayList<TreeNode<Integer>>();
		for (int a : array) {
			nodes.add(root.find(a));
		}
		nodes.add(new TreeNode<Integer>(11));
		
		for (TreeNode<Integer> x : nodes) {
			for (TreeNode<Integer> y : nodes) {
				TreeNode<Integer> r1 = findCommonAncestor(x, y, root);
				
				String s1 = resultToString("A", x, y, r1);
				
				System.out.println("SUCCESS: " + s1);

			}
		}
}

}
