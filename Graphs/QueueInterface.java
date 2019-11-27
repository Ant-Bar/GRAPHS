/*Time Complexity: 
enqeue(): O(1) constant
dequeue(): O(1) constant
isFull(): O(1) constant
isEmpty(): O(1) constant
size(): O(1) constant
*/

public interface QueueInterface<T>{
	public void enqueue(T item) throws QueueOverflowException; 
	public T dequeue() throws QueueUnderflowException;
	public boolean isFull();
	public boolean isEmpty();
	public int size();
}