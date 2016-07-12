package p3p3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetStacks<T> {
	
	private ArrayList<Stack<T>> stacks;
	private int capacity;
	public void push(T data){
		if(stacks.size()==0||stacks.get(stacks.size()-1).getSize()==capacity){
			stacks.add(new Stack<T>());
		}
		stacks.get(stacks.size()-1).push(data);
	}
	
	public T pop(){
		if(stacks.size()==0)throw new EmptyStackException();
		T ret = stacks.get(stacks.size()-1).pop();
		if(stacks.get(stacks.size()-1).getSize()==0){
			stacks.remove(stacks.size()-1);
		}
		return ret;
	}
	
	public T pop(int stack){
		if(stacks.size()==0)throw new EmptyStackException();
		T ret = stacks.get(stack).pop();
		if(stacks.get(stack).getSize()==0){
			stacks.remove(stack);
		}
		return ret;
	}

}
