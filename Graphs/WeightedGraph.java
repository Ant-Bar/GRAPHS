public class WeightedGraph<T> implements WeightedGraphInterface<T>{
	private static final int NULL_EDGE = 0;
	private static final int DEF_CAP = 50;
	private int numOfVertices;
	private int maxVertices;
	private T[] vertices;
	private int[][] edges;
	private boolean[] marks;
	
	public boolean isEmpty(){
		return (numOfVertices == 0);
	}
	
	public boolean isFull(){
		return (numOfVertices == maxVertices);
	}

	public WeightedGraph(){
		numOfVertices = 0;
		maxVertices = DEF_CAP;
		vertices = (T[]) new Object[DEF_CAP];
		marks = new boolean[DEF_CAP];
		edges = new int[DEF_CAP][DEF_CAP];
	}

	public void addVertex(T vertex){
		//Precondition: 1) graph is not FULL!
		//2) Vertex is NOT a DUPLICATE!
		//3) Vortex is NOT null!
		vertices[numOfVertices] = vertex;
		for(int index = 0; index < numOfVertices; index++){
			edges[numOfVertices][index] = NULL_EDGE;
			edges[index][numOfVertices] = NULL_EDGE;
		}
		numOfVertices++;
	}

	public boolean hasVortex(T vertex){
		return (vertex.equals(vertices));
	}

	public void addEdge(T from, T to, int weight){
		int row;
		int col;
		row = indexIs(from);
		col = indexIs(to);
		edges[row][col] = weight;
	}

	private int indexIs(T vertex){
		int index = 0;
		while(!vertex.equals(vertices[index])){
			index++;
		}
		return index;
	}

	public int weightIs(T from, T to){
		int row;
		int col;
		row = indexIs(from);
		col = indexIs(to);
		return edges[row][col];
	}

	public QueueInterface<T> getToVertices(T vertex){
		QueueInterface<T> queue = new LinkedListQueue<T>();
		int fromIndex;
		int toIndex;
		fromIndex = indexIs(vertex);
		for(toIndex = 0; toIndex < numOfVertices; toIndex++){
			if(edges[fromIndex][toIndex] != NULL_EDGE){
				queue.enqueue(vertices[toIndex]);
			}
		}
		return queue;
	}

	public boolean edgeExists(T v1, T v2){
		return (edges[indexIs(v1)][indexIs(v2)] != NULL_EDGE);
	}

	public boolean removeEdge(T v1, T v2){
		boolean exists = edgeExists(v1, v2);
		edges[indexIs(v1)][indexIs(v2)] = NULL_EDGE;
		return exists;
	}

	//Unmarks all vertex
	public void clearMarks(){
		for(int i = 0; i < numOfVertices; i++){
			marks[i] = false;
		}
	}

	//Marks vertex
	public void markVertex(T vertex){
		marks[indexIs(vertex)] = true;
	}

	//Returns true if vertex is marked; otherwise return false
	public boolean isMarked(T vertex){
		return marks[indexIs(vertex)];
	}

	//Returns an unmarked vertex if exist; otherwise, returns null
	public T getUnmarked(){
		for(int i = 0; i < maxVertices; i++){
			if(marks[i] == false){
				return vertices[i];
			}
		}
		return null;
	}
}