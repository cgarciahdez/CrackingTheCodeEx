package p2p7;

import methods.Helpers;
import methods.LinkedListNode;

public class Intersection {

	private static int length (LinkedListNode<Integer> head){
		int counter=0;
		while(head!=null){
			counter++;
			head=head.next;
		}
		return counter;

	}

	public static LinkedListNode<Integer> intersected(LinkedListNode<Integer> h1, LinkedListNode<Integer> h2){
		int l1 = length(h1);
		int l2 = length(h2);
		int dif=Math.abs(l2-l1);
		for(int i=0;i<dif;i++){
			if(l1>l2){
				h1=h1.next;
			}else{
				h2=h2.next;
			}
		}

		while(h1!=null){
			if(h1==h2){
				return h1;
			}
			h1=h1.next;
			h2=h2.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		LinkedListNode<Integer> list1 = Helpers.createLinkedListFromArray(vals);
		
		int[] vals2 = {12, 14, 15};
		LinkedListNode<Integer> list2 = Helpers.createLinkedListFromArray(vals2);
		
		list2.next.next = list1.next.next.next.next;
		
		System.out.println(list1.printForward());
		System.out.println(list2.printForward());
		
		
		LinkedListNode<Integer> intersection = intersected(list1, list2);
		
		System.out.println(intersection.printForward());
}
}
