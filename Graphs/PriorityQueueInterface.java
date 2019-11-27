import java.util.Comparator;
public interface PriorityQueueInterface<T>{
	public void enqueue(T item) throws PriorityQueueOverflowException; 
	public T dequeue() throws PriorityQueueUnderflowException;
	public boolean isFull();
	public boolean isEmpty();
	public int size();
}