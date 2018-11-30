package ch09.Graphs;

import ch03.stacks.*;
import ch05.queues.*;
public class UseGraph
{
	// Returns true if a path exists on graph, from startVertex to endVertex;
	// otherwise, returns false. Uses depth-first search algorithms.
	private static boolean isPath(WeightedGraphInterface<String> graph, String startVertex,String endVertex)
	{
		UnboundedStackInterface<String> stack = new LinkedStack<String>();
		UnboundedQueueInterface<String> vertexQueue = new LinkedUnboundQueue<String>();
		
		boolean found = false;
		String vertex;
		String item;
		
		graph.clearMarks();
		stack.push(startVertex);
		do {
			vertex = stack.top();
			stack.pop();
			if(vertex == endVertex)
				found = true;
			else
			{
				if(!graph.isMarked(vertex))
				{
					graph.markVertex(vertex);
					vertexQueue = graph.getToVertices(vertex);
					
					while(!vertexQueue.isEmpty())
					{
						try
						{
							item = vertexQueue.dequeue();
							if(!graph.isMarked(item))
								stack.push(item);
						} 
						catch (QueueUnderflowException e)
						{
							e.printStackTrace();
						}
						
					}
				}
			}
		} while (!stack.isEmpty() && !found);
			
		return found;
		
	}
	
	// Returns true if a path exists on graph, from startVertex to endVertex;
	// otherwise, returns false. Uses breadth-first search algorithms.
	private static boolean isPath2(WeightedGraphInterface<String> graph, String startVertex,String endVertex)
	{
		UnboundedQueueInterface<String> queue = new LinkedUnboundQueue<String>();
		UnboundedQueueInterface<String> vertexQueue = new LinkedUnboundQueue<String>();
		
		boolean found = false;
		String vertex = "";
		String item;
		
		graph.clearMarks();
		queue.enqueue(startVertex);
		do {
			try
			{
				vertex = queue.dequeue();
			} catch (QueueUnderflowException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(vertex == endVertex)
				found = true;
			else
			{
				if(!graph.isMarked(vertex))
				{
					graph.markVertex(vertex);
					vertexQueue = graph.getToVertices(vertex);
					
					while(!vertexQueue.isEmpty())
					{
						try
						{
							item = vertexQueue.dequeue();
							if(!graph.isMarked(item))
								queue.enqueue(item);
						} 
						catch (QueueUnderflowException e)
						{
							e.printStackTrace();
						}
						
					}
				}
			}
		} while (!queue.isEmpty() && !found);
			
		return found;
		
	}
}
