package p2p5;

import methods.LinkedListNode;

public class SumLists {

	public static LinkedListNode<Integer> sumReverse(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){
		LinkedListNode<Integer> n1=l1; //pointer for l1
		LinkedListNode<Integer> n2=l2; //pointer for l2
		LinkedListNode<Integer> result = null;
		LinkedListNode<Integer> m = null; //result
		int overflow=0;

		while(n1!=null||n2!=null){
			int sum=0;
			if(n1==null){
				sum = n2.data+overflow;
				n2=n2.next;
			}else if(n2==null){
				sum=n1.data+overflow;
				n1=n1.next;
			}else{
				sum=n1.data+n2.data+overflow;
				n1=n1.next;
				n2=n2.next;
			}
			LinkedListNode<Integer> newN = new LinkedListNode<Integer>(sum%10);
			overflow=sum/10;

			if(m!=null){
				m.next=newN;
			}
			else{
				result=newN;
			}
			m = newN;
		}
		
		if(overflow==1){
			LinkedListNode<Integer> newN = new LinkedListNode<Integer>(1);
			m.next=newN;
		}
		return result;
	}
	
	public static LinkedListNode<Integer> sumLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2){
		LinkedListNode<Integer> n1= l1;
		LinkedListNode<Integer> n2 = l2;
		int counter=0;
		int whichOne=0;
		while(n1!=null||n2!=null){
			if(n1==null){
				whichOne=1;
				counter++;
				n2=n2.next;
			}else if (n2==null){
				whichOne=2;
				counter++;
				n1=n1.next;
			}else{
				n1=n1.next;
				n2=n2.next;
			}
		}
		LinkedListNode<Integer> m =whichOne==1?l1:l2;
		for(int i =0;i<counter;i++){
			LinkedListNode<Integer> zero = new LinkedListNode<Integer>(0);
			zero.next = m;
			m=zero;
		}
		if (whichOne==1){
			l1=m;
		}else{
			l2=m;
		}
		
		m = new LinkedListNode<Integer>(1);
		int overflow=sum(m,l1,l2);
		if(overflow==1){
			return m;
		}
		
		return m.next;
	}
	
	private static int sum(LinkedListNode<Integer> head, LinkedListNode<Integer> n1, LinkedListNode<Integer> n2){
		if(n1==null){ //implies that n2 is also null
			return 0;
		}
		LinkedListNode<Integer> newN = new LinkedListNode<Integer>(0);
		head.next=newN;
		int sum = n1.data+n2.data+sum(head.next, n1.next, n2.next);
		newN.data=sum%10;
		return sum/10;
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> l1 = new LinkedListNode<Integer>(7);
		l1.next=new LinkedListNode<Integer>(1);
		l1.next.next = new LinkedListNode<Integer>(6);
		
		LinkedListNode<Integer> l2 = new LinkedListNode<Integer>(5);
		l2.next=new LinkedListNode<Integer>(9);
		l2.next.next= new LinkedListNode<Integer>(6);
		
		System.out.println(l1.printForward());
		System.out.println(l2.printForward());
		System.out.println(sumReverse(l1, l2).printForward());
		
		System.out.println();
		
		l1 = new LinkedListNode<Integer>(6);
		l1.next=new LinkedListNode<Integer>(1);
		l1.next.next = new LinkedListNode<Integer>(7);
		
		l2 = new LinkedListNode<Integer>(6);
		l2.next=new LinkedListNode<Integer>(9);
		l2.next.next = new LinkedListNode<Integer>(5);
		
		System.out.println(l1.printForward());
		System.out.println(l2.printForward());
		System.out.println(sumLists(l1, l2).printForward());
	}

}
