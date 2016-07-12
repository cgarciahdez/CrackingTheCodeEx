package p2p8;

import java.util.HashSet;

import methods.LinkedListNode;

public class LoopDetection {

	public static LinkedListNode<Integer> detectLoop(LinkedListNode<Integer> head){
		HashSet<LinkedListNode<Integer>> hs = new HashSet<LinkedListNode<Integer>>();
		while(head!= null){
			if(hs.contains(head)){
				return head;
			}
			hs.add(head);
			head=head.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 100;
		
		// Create linked list
		LinkedListNode<Integer>[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode<Integer>(i);
			nodes[i].setPrevious(i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
//		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode<Integer> loop = detectLoop(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
}
}
