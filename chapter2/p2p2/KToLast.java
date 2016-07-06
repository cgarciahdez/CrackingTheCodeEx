package p2p2;

import methods.Helpers;
import methods.LinkedListNode;

public class KToLast {
	
	public static LinkedListNode<Integer> kToLast(LinkedListNode<Integer> head, int k){
		LinkedListNode<Integer> current = head;
		LinkedListNode<Integer> runner = head;
		if(head==null)return null;
		if(k<1)return null;
		//Move runner so that current is kth from runner
		for(int i=1;i<k;i++){
			runner=runner.next;
			if(runner==null){ //list is not long enough
				return null;
			}
		}
		
		while(true){
			runner=runner.next;
			if(runner==null){
				return current;
			}
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = Helpers.randomLinkedList(1, 10, 10);
		System.out.println(head.data);
		System.out.println(head.printForward());
		System.out.println(kToLast(head, 10).data);
		
	}

}
