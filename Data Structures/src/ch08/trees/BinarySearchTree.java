package ch08.trees;

import ch05.queues.*;
import ch03.stacks.*;
import support.BSTNode;

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>
{

	protected BSTNode<T> root; // reference to the root of this BST
	boolean found; // used by remove
	
	// for traversals
	protected LinkedUnboundQueue<T> inOrderQueue;	// queue of info
	protected LinkedUnboundQueue<T> preOrderQueue;	// queue of info
	protected LinkedUnboundQueue<T> PostOrderQueue;	// queue of info
	
	// Creates an empty BST object
	public BinarySearchTree()
	{
		root = null;
	}
	
	// Returns true if this SBT is empty; otherwise, returns false
	@Override
	public boolean isEmpty()
	{
		return (root == null);
	}
// here
	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public boolean contains(T element)
	{
		return false;
	}

	@Override
	public boolean remove(T element)
	{
		return false;
	}

	@Override
	public T get(T element)
	{
		return null;
	}

	@Override
	public void add(T element)
	{
	}

	@Override
	public int reset(int orderType)
	{
		return 0;
	}

}
