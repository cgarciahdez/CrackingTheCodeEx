package p2p1;

import java.util.HashMap;

import methods.Helpers;
import methods.LinkedListNode;

public class EraseDuds {
	
	public static void eraseDuds(LinkedListNode<Integer> head){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		LinkedListNode<Integer> n = head;
		while(n!=null){
			int val = n.data;
			if(hm.get(val)!=null){
				eraseNode(n);
			}
			else{
				hm.put(val, val);
			}
			n = n.next;
		}
	}
	
	public static void eraseDudsFU(LinkedListNode<Integer> head){
		LinkedListNode<Integer> n = head;
		LinkedListNode<Integer> m = head;
		
		while(n!=null){
			m = n.next;
			while(m!=null){
				if(n.data==m.data){
					eraseNode(m);
				}
				m=m.next;
			}
			n=n.next;
		}
	}
	
	private static void eraseNode(LinkedListNode<Integer>n){
		if(n.hasNext()){
			n.next.setPrevious(n.prev);
		}
		else if(n.hasPrev()){
			n.prev.setNext(n.next);
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = Helpers.randomLinkedList(4, 10, 5);
		System.out.println(head.printForward());
		eraseDudsFU(head);
		System.out.println(head.printForward());
	}

}
