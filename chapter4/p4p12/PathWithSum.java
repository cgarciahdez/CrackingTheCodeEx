package p4p12;

import java.util.ArrayList;

import methods.TreeNode;

public class PathWithSum {
	
	public static int pathSum(TreeNode<Integer> root, int target){
		ArrayList<Integer> sums = new ArrayList<>();
		return helper(root,target,sums);
	}
	
	private static int helper(TreeNode<Integer> root , int target, ArrayList<Integer> sums){
		if(root==null) return 0;
		int counter=0;
		for(int i=0;i<sums.size();i++){
			sums.set(i, sums.get(i)+root.data);
			if(sums.get(i)==target) counter++;
		}
		
		if(root.data==target)counter++;
		sums.add(root.data);
		counter+=helper(root.left,target,sums)+helper(root.left, target, sums);
		sums.remove(sums.size()-1);
		for(int i=0;i<sums.size();i++){
			sums.set(i, sums.get(i)-root.data);
		}
		return counter;
	}

}
