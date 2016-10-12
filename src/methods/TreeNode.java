package methods;

public class TreeNode<T extends Comparable<T>> {

	public TreeNode<T> parent;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T data;
	public int size;
	
	public TreeNode(T data){
		size=1;
		this.data=data;
	}

	public void setRight(TreeNode<T> right){
		if(right!=null){
			if(this.right!=null){
				size-=this.right.size;
			}
			size+=right.size;
			right.parent=this;
			this.right=right;
		}
	}
	
	public void setLeft(TreeNode<T> left){
		if(left!=null){
			if(this.left!=null){
				size-=this.left.size;
			}
			size+=left.size;
			left.parent=this;
			this.left=left;
		}
	}
	
	public void insertInOrder(T d){
		if(d.compareTo(data)<=0){
			if (left==null){
				left = new TreeNode<T>(d);
			}
			else{
				left.insertInOrder(d);
			}
		}
		else{
			if(right==null){
				right=new TreeNode<T>(d);
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
			if (data.compareTo(left.data)<0|| !left.isBST()) {
				return false;
			}
		}
		
		if (right != null) {
			if (data.compareTo(right.data)>=0 || !right.isBST()) {
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
	
	public TreeNode<T> find(T d) {
		if (d.compareTo(data)==0) {
			return this;
		} else if (d.compareTo(data)<0) {
			return left != null ? left.find(d) : null;
		} else if (d.compareTo(data)>0) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
}
