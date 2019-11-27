class LinkedStack<T> implements StackInterface<T>{
	private LinkedListNode<T> top;
	public LinkedStack(){
		top = null;
	}
	public void push(T item){
		LinkedListNode<T> node = new LinkedListNode<T>(item);
		node.setNext(top);
		top = node;
	}
	public void pop(){
		if(isEmpty()){
			throw new StackUnderflowException("Pop on an Empty Stack");	
		}
		top = top.getNext();
	}
	public T top(){
		if(isEmpty()){
			throw new StackUnderflowException("Top on an Empty Stack");
		}
		return top.getData();
	}
	public boolean isEmpty(){
		return top == null;
	}
	public boolean isFull(){
		return false;
	}
	//Recursive method to print forward
	public void print(LinkedListNode<T> top){
		if(top != null){
			System.out.println(top.getData());
			print(top.getNext());
		}
	}
	//Recursive method to print backwards
	public void printReversed(LinkedListNode<T> top){
		if(top != null){
			printReversed(top.getNext());
			System.out.println(top.getData());
		}
	}
	//recursive method for size
	public int size(LinkedListNode<T> top){
		if(top == null){
			return 0;
		}
		else{
			return 1 + size(top.getNext());
		}
	}
	
}