package p3p5;

import java.util.LinkedList;
import java.util.Queue;

import methods.Helpers;
import p3p3.Stack;
import p3p4.MyQueue;

public class SortStack {

	public static void sortStack(Stack<Integer> toSort){
		Stack<Integer> helper = new Stack<Integer>();

		while(!toSort.isEmpty()){
			Integer temp = toSort.pop();
			while(!helper.isEmpty()&&temp<helper.peek()){
				toSort.push(helper.pop());
			}
			helper.push(temp);
		}
		while(!helper.isEmpty()){
			toSort.push(helper.pop());
		}
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < 50; i++) {
			int element = Helpers.randomIntInRange(0, 50);
			stack.push(element);
		}
		
		System.out.println(stack.toString());
		sortStack(stack);
		System.out.println(stack.toString());
	}
}
