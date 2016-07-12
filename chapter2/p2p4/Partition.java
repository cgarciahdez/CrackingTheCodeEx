package p2p4;

import methods.Helpers;
import methods.LinkedListNode;

public class Partition {
	
	public static void partition(LinkedListNode<Integer> head, int partition){
		
		LinkedListNode<Integer> head1=null;
		LinkedListNode<Integer> head2=null;
		LinkedListNode<Integer> tail1=null;
		LinkedListNode<Integer> tail2=null;
		LinkedListNode<Integer> n = head;
		
		while(n!=null){
			LinkedListNode<Integer> newn = new LinkedListNode<Integer>(n.data);
			if(n.data<partition){
				if(head1==null){
					head1=newn;
				}
				else{
					tail1.next=newn;
				}
				tail1=newn;
			}
			else{
				if(head2==null){
					head2=newn;
				}
				else{
					tail2.next=newn;
				}
				tail2=newn;
			}
			n=n.next;
		}
		
		tail1.next=head2;
		n = head;
		LinkedListNode<Integer> m = head1;
		
		while(n!=null){
			n.data=m.data;
			n=n.next;
			m=m.next;
		}
		
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> head = Helpers.randomLinkedList(1, 10, 20);
		System.out.println(head.printForward());
		partition(head, 5);
		System.out.println(head.printForward());
	}


}
