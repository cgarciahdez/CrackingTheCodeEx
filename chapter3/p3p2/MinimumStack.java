package p3p2;

import java.util.EmptyStackException;

public class MinimumStack<T extends Comparable<T>> {
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		private StackNode<T> min;
		
		public StackNode(T data) {
			this.data=data;
		}
	}
	
	private StackNode<T> top;
	
	public T pop(){
		if(top==null)throw new EmptyStackException();
		T data = top.data;
		top=top.next;
		return data;
	}
	
	public void push(T data){
		StackNode<T> n = new StackNode<T>(data);
		n.min=(top==null||top.data.compareTo(data)>0)?n:top;
		n.next=top;
		top=n;
	}
	
	public T min(){
		return top.min.data;
	}

}
