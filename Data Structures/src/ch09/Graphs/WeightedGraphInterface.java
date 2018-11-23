/*
 * --------------------------------------------------------------------------------
 * WeightedGraphInterface.java   									by Anthony Pompili
 * 
 * Interface for a class that implements a directed graph with weighted edges.
 * Vertices are objects of class T and can be marked as having been visited.
 * Edge weights are integers.
 * Equivalence of vertices is determined by the vertices' equals method.
 * General precondition: Except for the addVertex and hasVertex methods,
 * any vertex passed as an argument to a method is in this graph.
 * --------------------------------------------------------------------------------
*/
package ch09.Graphs;

import ch05.queues.*;

public interface WeightedGraphInterface<T>
{
	
	// Returns true if this graph is empty; otherwise, returns false.
	boolean isEmpty();
	
	// Returns true if this graph is full; otherwise, returns false.
	boolean isFull();
	
	/*
	 * Preconditions: This graph is not full.
	 * 					Vertex is not already in this graph.
	 * 					Vertex is not null.
	 * 
	 * Adds vertex to this graph.
	 */
	void addVertex(T vertex);
	
	// Returns true if this graph contains vertex; otherwise, returns false.
	boolean hasVertex(T vertex);
	
	// Adds an edge with the specified weight from fromVertex to toVertex
	void addEdge(T fromVertex, T toVertex, int weight);
	
	// If edge from fromVertex to toVertex exists, returns the weight of edge;
	// otherwise, returns a special "null-edge" value.
	int weightIs(T fromVertex, T toVertex);
	
	// Returns a queue of the vertices that are adjacent from vertex.
	UnboundedQueueInterface<T> getToVertices(T vertex);
	
	// Sets marks for all vertices to false.
	void clearMarks();
	
	// Sets mark for vertex to true
	void markVertex(T vertex);
	
	// Returns true if vertex is marked; otherwise, returns false
	boolean isMarked(T Vertex);
	
	// Returns an unmarked vertex if any exist; otherwise, returns null.
	T getUnmarked();
}
