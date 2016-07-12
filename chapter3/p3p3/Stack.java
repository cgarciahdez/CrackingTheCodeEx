package p3p3;

import java.util.EmptyStackException;


public class Stack<T> {
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;

		
		public StackNode(T data) {
			this.data=data;
		}
	}
	
	private StackNode<T> top;
	private int size;
	
	public Stack() {
		super();
	}

	public T pop(){
		if(top==null)throw new EmptyStackException();
		T data = top.data;
		top=top.next;
		size--;
		return data;
	}
	
	public void push(T data){
		StackNode<T> n = new StackNode<T>(data);
		n.next=top;
		top=n;
		size++;
	}
	
	public T peek(){
		if(top==null)throw new EmptyStackException();
		T data = top.data;
		return data;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		StackNode<T> temp = top;
		StringBuilder sb  = new StringBuilder();
		while(temp!=null){
			sb.append(temp.data);
			sb.append(" ");
			temp=temp.next;
		}
		return sb.toString();
	}

}
