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

	
	@Override
	public boolean isEmpty()
	{
		return false;
	}

	@Override
	public boolean isFull()
	{
		return false;
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

	@Override
	public boolean hasVertex(T vertex)
	{
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

	@Override
	public UnboundedQueueInterface<T> getToVertices(T vertex)
	{
		return null;
	}

	@Override
	public void clearMarks()
	{
	}

	@Override
	public void markVertex(T vertex)
	{
	}

	@Override
	public boolean isMarked(T Vertex)
	{
		return false;
	}

	@Override
	public T getUnmarked()
	{
		return null;
	}
	
}
