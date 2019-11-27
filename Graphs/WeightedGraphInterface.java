public interface WeightedGraphInterface<T>{
	public boolean isEmpty();
	public boolean isFull();
	public void addVertex(T vertex);
	public boolean hasVortex(T vertex);
	public void addEdge(T from, T to, int wight); // from = fromVertex & to = toVertex
	public int weightIs(T from, T to);
	QueueInterface<T> getToVertices(T vertex);
	public void clearMarks();
	public void markVertex(T vertex);
	public boolean isMarked(T vertex);
	public T getUnmarked();
}