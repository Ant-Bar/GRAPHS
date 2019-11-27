import java.util.ArrayList;
import java.util.Comparator;
public class HeapPriorityQueue<T> implements PriorityQueueInterface<T>{
	protected ArrayList<T> elements; //Priority queue elements
	protected int lastIndex; //index of last element in priority queue
	protected int maxIndex; //index of last position in ArrayList

	protected Comparator<T> comp;

	public HeapPriorityQueue(int maxSize){
		elements = new ArrayList<T>(maxSize);
		lastIndex = -1;
		maxIndex = maxSize - 1;

		comp = new Comparator<T>(){
			public int compare(T element1, T element2){
				return ((Comparable)element1).compareTo(element2);
			}
		};
	}

	public HeapPriorityQueue(int maxSize, Comparator<T> comp){ 
		elements = new ArrayList<T>(maxSize);
		lastIndex = -1;
		maxIndex = maxSize - 1;

		this.comp = comp;
	}

	public boolean isEmpty(){
		return (lastIndex == -1);
	}

	public boolean isFull(){
		return (lastIndex == maxIndex);
	}

	public int size(){
		return (lastIndex + 1);
	}

	public void enqueue(T element){
		if(isFull()){
			throw new PriorityQueueOverflowException("Priority queue is full!");
		}
		else{
			lastIndex++;
			elements.add(lastIndex,element);
			reheapUp(element);
		}
	}

	private void reheapUp(T element){
		int hole = lastIndex;
		while((hole > 0) && (comp.compare(element,elements.get((hole - 1)/2))>0)){
			elements.set(hole, elements.get((hole - 1)/2));
			hole = (hole - 1) / 2;
		}
		elements.set(hole, element);
	}

	public T dequeue(){
		T hold;
		T toMove;
		if(lastIndex == -1){
			throw new PriorityQueueUnderflowException("Priority queue is empty!");
		}
		else{
			hold = elements.get(0);
			toMove = elements.remove(lastIndex);
			lastIndex--;
			if(lastIndex != -1){
				reheapDown(toMove);
			}
			return hold;
		}
	}

	private void reheapDown(T element){
		int hole = 0;
		int next;
		next = newHole(hole, element);
		while(next != hole){
			elements.set(hole, elements.get(next));
			hole = next;
			next = newHole(hole, element);
		}
		elements.set(hole, element);
	}

	private int newHole(int hole, T element){
		int left = (hole * 2) + 1;
		int right = (hole * 2) + 2;
		if(left > lastIndex){ //hole has no children? 
			return hole;
		}
		else if(left == lastIndex){ //hole has left child
			if(comp.compare(element, elements.get(left)) < 0){
				return left;
			}
			else{
				return hole;
			}
		}
		else if(comp.compare(elements.get(left), elements.get(right)) < 0){ //hole has two children
			if(comp.compare(elements.get(right), element) <= 0){ //left child < right child
				return hole;
			}
			else{
				return right;
			}
		}
		else if(comp.compare(elements.get(left), element) <= 0){ //left child >= right child
			return hole;
		}
		else{
			return left;
		}
	}

	@Override
	public String toString(){
		String myHeap = new String("My heap is: \n");
		for(int i = 0; i < lastIndex; i++){
			myHeap = myHeap + i + ". " + elements.get(i) + "\n";
		}
		return myHeap;
	}
}