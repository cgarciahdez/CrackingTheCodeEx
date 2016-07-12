package p2p6;

import methods.LinkedListNode;

public class Palindrome {
	
	public static class Pal{
		boolean isPal;
		LinkedListNode<Integer> right;
		public Pal(boolean isPal, LinkedListNode<Integer> right) {
			super();
			this.isPal = isPal;
			this.right = right;
		}
	}
	
	public static boolean isPalindrome(LinkedListNode<Integer> head){
		int len = length(head);
		boolean odd = len%2!=0;
		int mid = odd?(len+1)/2:len/2;
		return helper(head,mid,odd,1).isPal;
	}
	
	private static Pal helper(LinkedListNode<Integer> head, int mid, boolean odd, int current){
		if(mid==current){
			if(!odd){
				boolean isPal = head.data==head.next.data;
				return new Pal(isPal,head.next.next);
			}
			return new Pal(true,head.next);
		}
		Pal inner = helper(head.next,mid,odd,current+1);
		return new Pal(inner.isPal&&head.data==inner.right.data,inner.right.next);
	}
	
	private static int length (LinkedListNode<Integer> head){
		int counter=0;
		while(head!=null){
			counter++;
			head=head.next;
		}
		return counter;
		
	}
	
	public static void main(String[] args) {
		LinkedListNode<Integer> l1 = new LinkedListNode<Integer>(7);
		l1.next=new LinkedListNode<Integer>(1);
		l1.next.next = new LinkedListNode<Integer>(6);
		l1.next.next.next = new LinkedListNode<Integer>(1);
		l1.next.next.next.next = new LinkedListNode<Integer>(7);

		
		System.out.println(l1.printForward());
		
		System.out.println(isPalindrome(l1));
	}

}
