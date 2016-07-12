package p3p4;

import p3p3.Stack;

public class MyQueue<T> {
	private Stack<T> pushing;
	private Stack<T> popping;
	
	public MyQueue(){
		pushing = new Stack<T>();
		popping = new Stack<T>();
	}
	
	public void add(T data){
		if(!popping.isEmpty()){
			transferAll(popping,pushing);
		}
		pushing.push(data);
	}
	
	public T remove(){
		if(!pushing.isEmpty()){
			transferAll(pushing, popping);
		}
		return popping.pop();
	}
	
	public T peek(){
		if(!pushing.isEmpty()){
			transferAll(pushing, popping);
		}
		return popping.peek();
	}
	
	public boolean isEmpty(){
		return pushing.isEmpty()&&popping.isEmpty();
	}
	
	private void transferAll(Stack<T> from, Stack<T> to){
		while(!from.isEmpty()){
			to.push(from.pop());
		}
	}
	
	public int size(){
		return pushing.getSize()+popping.getSize();
	}

}
