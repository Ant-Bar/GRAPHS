public interface StackInterface<T>{
	public void push(T element) throws StackOverflowException;
	public void pop() throws StackUnderflowException;
	public T top() throws  StackUnderflowException;
	public boolean isFull();
	public boolean isEmpty();
}