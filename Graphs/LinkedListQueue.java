/*Time Complexity:
enqueue(item): O(1) constant
dequeue(): O(1) constant
size(): O(1) constant
isEmpty(): O(1) constant 
isFull(): O(1) constant
*/
class LinkedListQueue<T> implements QueueInterface<T>{
	protected LinkedListNode <T> front;
	protected LinkedListNode<T> rear;
	protected int numElements;

	public LinkedListQueue(){
		front = null;
		rear = null;
	}
	//Time Complexity: O(1) Constant
	public void enqueue(T item){
		LinkedListNode<T> newItem = new LinkedListNode<T>(item);
		if(rear == null){
			front = newItem;
		}
		else{
			rear.setNext(newItem);
		}
		rear = newItem;
		numElements++;
	}
	//Time Complexity: O(1) Constant
	public T dequeue(){
		if(isEmpty()){
			throw new QueueUnderflowException("Queue is Empty!");
		}
		else{
			T element;
			element = front.getData();
			front = front.getNext();
			if(front == null){
				rear = null;
			}
			numElements--;
			return element;
		}
	}
	//Time Complexity: O(1) Constant
	public int size(){
		return numElements;
	}
	//Time Complexity: O(1) Constant
	public boolean isEmpty(){
		return (numElements == 0);
	}
	//Time Complexity: O(1) Constant
	public boolean isFull(){
		return false;
	}
}