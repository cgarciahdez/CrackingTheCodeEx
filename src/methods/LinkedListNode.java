package methods;

public class LinkedListNode<E> {

	public LinkedListNode<E> prev, next;
	public E data;



	public LinkedListNode(LinkedListNode<E> prev, LinkedListNode<E> next, E data) {
		super();
		this.prev = prev;
		this.next = next;
		this.data = data;
	}

	public LinkedListNode(E data){
		this.data = data;
	}

	public void setNext(LinkedListNode<E> n){
		next = n;
		if(n!=null&&n.prev!=this){
			n.setPrevious(this);
		}
	}

	public void setPrevious(LinkedListNode<E> n){
		prev = n;
		if(n!=null&&n.next!=this){
			n.setNext(this);
		}
	}

	public boolean hasNext(){
		return next!=null;
	}

	public boolean hasPrev(){
		return prev!=null;
	}

	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return data.toString();
		}
	}

}
