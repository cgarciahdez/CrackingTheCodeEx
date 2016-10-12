package p4p11;

import methods.TreeNode;

public class RandomTreeNode{
	
	public RandomTreeNode left;
	public RandomTreeNode right;
	public int data;
	public int size;
	
	public RandomTreeNode(int data){
		size=1;
		this.data=data;
	}

	public void setRight(RandomTreeNode right){
		if(right!=null){
			if(this.right!=null){
				size-=this.right.size;
			}
			size+=right.size;
			this.right=right;
		}
	}
	
	public void setLeft(RandomTreeNode left){
		if(left!=null){
			if(this.left!=null){
				size-=this.left.size;
			}
			size+=left.size;
			this.left=left;
		}
	}
	
	public void insertInOrder(int d){
		if(d<=(data)){
			if (left==null){
				left = new RandomTreeNode(d);
			}
			else{
				left.insertInOrder(d);
			}
		}
		else{
			if(right==null){
				right=new RandomTreeNode(d);
			}
			else{
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isBST() {
		if (left != null) {
			if (data<(left.data)|| !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data>=(right.data) || !right.isBST()) {
				return false;
			}
		}		
		
		return true;
	}
	
	public int height() {
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public RandomTreeNode find(int d) {
		if (d==(data)) {
			return this;
		} else if (d<(data)) {
			return left != null ? left.find(d) : null;
		} else if (d>(data)) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}

	public RandomTreeNode randomNode(RandomTreeNode root){
		int leftS = root.left==null?0:root.left.size;
		int rightS = root.right==null?0:root.right.size;
		int n = leftS+rightS+1;
		int random = (int)(Math.random()*n);
		if(random<leftS)return randomNode(root.left);
		else if(random==leftS)return root;
		else return randomNode(root.right);
	}
}
