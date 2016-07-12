package p3p1;

import java.util.EmptyStackException;

public class MultiStack {
	//TODO: needs dome rethinking
	private class StackInfo{
		public int headIndex;
		public int size;
		private int capacity;
		public StackInfo(int headIndex,int capacity){
			this.headIndex = headIndex;
			this.capacity = capacity;
		}
	}

	private Integer[] array;
	private StackInfo[] info;

	public MultiStack(int[] sizes){
		int totalSize=0;
		info = new StackInfo[sizes.length];
		for (int i = 0; i < sizes.length; i++){
			info[i]=new StackInfo(totalSize, sizes[i]);
			totalSize+=sizes[i];	
		}
		array = new Integer[totalSize];
	}

	public MultiStack(int size,int stacks){
		info = new StackInfo[stacks];
		for (int i = 0; i < stacks; i++){
			info[i]=new StackInfo(size*i, size);	
		}
		array = new Integer[size*stacks];
	}

	/**
	 * 
	 * @param value
	 * @param stack which stack to insert into. Starts at 1.
	 * @throws NoSuchStackException 
	 * @throws MultiStackFullException 
	 */
	public void push(int value, int stack) throws NoSuchStackException, MultiStackFullException{
		if(stack<1||stack>info.length){
			throw new NoSuchStackException();
		}
		int trueStack=stack-1;
		if(isFull()){
			throw new MultiStackFullException();
		}
		insert(trueStack, value);
		
		

	}

	private void insert(int stack, int value){
		int insert = info[stack].headIndex+1;
		if(info[stack].size==info[stack].capacity){
			int tail = info[info.length-1].headIndex;
			for(int i=tail;i>insert;i++){
				array[i+1]=array[i];
			}
			for(int i=stack;i<info.length;i++){
				info[i].headIndex+=1;
			}
			info[stack].capacity+=1;
		}
		info[stack].size+=1;
		array[insert] = value;

	}

	public Integer pop(int stack) throws MultiStackFullException, NoSuchStackException{
		if(stack<1||stack>info.length){
			throw new NoSuchStackException();
		}
		int trueStack=stack-1;
		if(info[trueStack].size==0){
			throw new EmptyStackException();
		}
		int index = info[trueStack].headIndex;
		Integer ret = array[index];
		remove(index);
		for(int i=trueStack;i<info.length;i++){
			info[i].headIndex-=1;
		}
		info[trueStack].size-=1;
		return ret;
	}

	private void remove(int index){
		for(int i=index;i<array.length-1;i++){
			array[i]=array[i+1];
		}
	}

	public Integer peek(int stack) throws NoSuchStackException, MultiStackFullException{
		if(stack<1||stack>info.length){
			throw new NoSuchStackException();
		}
		int trueStack=stack-1;
		if(info[trueStack].size==0){
			throw new EmptyStackException();
		}
		int index = info[trueStack].headIndex;
		return array[index];
	}

	public boolean isEmpty(int stack) throws NoSuchStackException{
		if(stack<1||stack>info.length){
			throw new NoSuchStackException();
		}
		int trueStack=stack-1;
		return info[trueStack].size==0;


	}

	private boolean isFull(){
		return info[info.length-1].headIndex>=array.length;
	}

}
