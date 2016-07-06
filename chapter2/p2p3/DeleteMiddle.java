package p2p3;

import methods.Helpers;
import methods.LinkedListNode;

public class DeleteMiddle {
	
	public static void deleteMid(LinkedListNode<Integer> head){
		LinkedListNode<Integer> current = head;
		LinkedListNode<Integer> runner = head;
		
		while(runner.next!=null&&runner.next.next!=null){
			runner=runner.next.next;
			current=current.next;
		}
		
		//current is mid
		
		//MISUNDERSTOOD. You start at the mid. Only code you need is this.
		if(current.next==null){
			//unsolvable? Make myself null but wont change much
			current=null;
		}
		else{
			current.data=current.next.data;
			current.next=current.next.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = Helpers.randomLinkedList(1, 10, 5);
		System.out.println(head.printForward());
		deleteMid(head);
		System.out.println(head.printForward());
	}

}
