class LinkedListNode<T>{
	private T data;
	private LinkedListNode next;

	public LinkedListNode(T data){
		this.data = data;
		next = null;
	}
	public T getData(){
		return data;
	}
	public void setData(T data){
		this.data = data;
	}
	public LinkedListNode getNext(){
		return next;
	}
	public void setNext(LinkedListNode next){
		this.next = next;
	}
}