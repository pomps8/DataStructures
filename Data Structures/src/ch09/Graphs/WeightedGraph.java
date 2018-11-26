/*
 * --------------------------------------------------------------------------------
 * WeightedGraph.java   									by Anthony Pompili
 * 
 * Implements a directed graph with weighted edges.
 * Vertices are objects of class T and can be marked as having been visited.
 * Edge weights are integers.
 * Equivalence of vertices is determined by the vertices' equals method.
 * 
 * General precondition: Except for the addVertex and hasVertex methods,
 * any vertex passed as an argument to a method is in this graph.
 * --------------------------------------------------------------------------------
*/
package ch09.Graphs;

import ch05.queues.*;

public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
	public static final int NULL_EDGE = 0;
	private static final int DEFCAP = 50; // default capacity
	private int numVertices;
	private int maxVertices;
	private T[] vertices;
	private int[][] edges;
	private boolean[] marks; // marks[i] is mark for vertices[i]
	
	// Instantiates a graph with capacity DEFCAP vertices.
	public WeightedGraph()
	{
		numVertices = 0;
		maxVertices = DEFCAP;
		vertices = (T[]) new Object[DEFCAP];
		marks = new boolean[DEFCAP];
		edges = new int[DEFCAP][DEFCAP];
	}
	
	// Instantiates a graph with capacity maxV.
	public WeightedGraph(int maxV)
	{
		numVertices = 0;
		maxVertices = maxV;
		vertices = (T[]) new Object[maxV];
		marks = new boolean[maxV];
		edges = new int[maxV][maxV];
	}

	// Returns true if this graph is empty; otherwise, returns false.
	@Override
	public boolean isEmpty()
	{
		return (numVertices == 0);
	}

	// Returns true if this graph is full; otherwise, returns false.
	@Override
	public boolean isFull()
	{
		return (numVertices == maxVertices);
	}

	/*
	 * Preconditions: This graph is not full.
	 * 					Vertex is not already in this graph.
	 * 					Vertex is not null.
	 * 
	 * Adds vertex to this graph.
	 */
	@Override
	public void addVertex(T vertex)
	{
		vertices[numVertices] = vertex;
		for(int index = 0; index < numVertices; index++)
		{
			edges[numVertices][index] = NULL_EDGE;
			edges[index][numVertices] = NULL_EDGE;
		}
		numVertices++;
	}
	
	// Returns the index of vertex in vertices.
	private int indexIs(T vertex)
	{
		int index = 0;
		while(!vertex.equals(vertices[index]))
			index++;
		return index;
	}

	// Returns true if this graph contains vertex; otherwise, returns false.
	@Override
	public boolean hasVertex(T vertex)
	{
		for(int index = 0; index < numVertices; index++)
		{
			if(vertex.equals(vertices[index]))
				return true;
		}

		return false;
	}

	// Adds an edge with the specified weight from fromVertex to toVertex
	@Override
	public void addEdge(T fromVertex, T toVertex, int weight)
	{
		int row;
		int column;
		
		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		edges[row][column] = weight;
	}

	// If edge from fromVertex to toVertex exists, returns the 
	// weight of edge ; otherwise, returns a special "null-edge" value.
	@Override
	public int weightIs(T fromVertex, T toVertex)
	{
		int row;
		int column;
		
		row = indexIs(fromVertex);
		column = indexIs(toVertex);
		return edges[row][column];
	}

	// Returns a queue of the vertices that are adjacent from vertex.
	@Override
	public UnboundedQueueInterface<T> getToVertices(T vertex)
	{
		UnboundedQueueInterface<T> adjVertices = new LinkedUnboundQueue<T>();
		int fromIndex;
		int toIndex;
		fromIndex = indexIs(vertex);
		for(toIndex = 0; toIndex < numVertices; toIndex++)
			adjVertices.enqueue(vertices[toIndex]);
		return adjVertices;
	}

	// Sets marks for all vertices to false.
	@Override
	public void clearMarks()
	{
		for(int index = 0; index < maxVertices; index++)
		{
			marks[index] = false;
		}
	}

	// Sets mark for vertex to true
	@Override
	public void markVertex(T vertex)
	{
		marks[indexIs(vertex)] = true;
	}

	// Returns true if vertex is marked; otherwise, returns false
	@Override
	public boolean isMarked(T vertex)
	{
		return (marks[indexIs(vertex)]);
	}

	// Returns an unmarked vertex if any exist; otherwise, returns null.
	@Override
	public T getUnmarked()
	{
		for(int index = 0; index < numVertices; index++)
		{
			T possibleVertex = vertices[index];
			if(!marks[indexIs(possibleVertex)])
				return possibleVertex;
		}
		return null;
	}
	
}
