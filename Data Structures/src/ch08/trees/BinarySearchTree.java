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
	protected LinkedUnboundQueue<T> postOrderQueue;	// queue of info
	
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

	// Returns the number of elements in this BST.
	@Override
	public int size()
	{
		return recSize(root);
	}

	private int recSize(BSTNode<T> tree)
	{
		if(tree == null)
			return 0;
		else
			return (recSize(tree.getLeft()) + recSize(tree.getRight()) + 1);
		
	}
	// Returns true if tree contains an element e such taht
	// e.compareTo(element) == 0; otherwise, returns false.
	// Uses "recContains(T element, BSTNode<T> tree)... method
	@Override
	public boolean contains(T element)
	{
		return recContains(element, root);
	}

	// Returns true if tree contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns false.
	private boolean recContains(T element, BSTNode<T> tree)
	{
		if(tree == null)
			return false;		// element is not found
		else if (element.compareTo(tree.getInfo()) < 0)  // Search left subtree
			return recContains(element, tree.getLeft());
		else if (element.compareTo(tree.getInfo()) > 0)  // Search right subtree
			return recContains(element, tree.getRight());
		else
			return true;		// element is found
	}
	
	// Removes an element e from this BST such that e.compareTo(element) == 0
	// and returns true if no such element exists, returns false.
	@Override
	public boolean remove(T element)
	{
		root = recRemove(element, root);
		return found;
	}
	
	// Removes an element e from tree such that e.compareTo(element) == 0
	// and returns true; if no such element exists, return false.
	private BSTNode<T> recRemove(T element, BSTNode<T> tree)
	{
		if(tree == null)
			found = false;
		else if (element.compareTo(tree.getInfo()) < 0)
			tree.setLeft(recRemove(element, tree.getLeft()));
		else if (element.compareTo(tree.getInfo()) > 0)
			tree.setRight(recRemove(element, tree.getRight()));
		else
		{
			tree = removeNode(tree);
			found = true;
		}
		return tree;
		
	}
	
	/*
	 * Removes the information at the node referenced by tree.
	 * The user's data in the node referenced by tree is no 
	 * longer in the tree. If tree is a leaf node or has only
	 * a non-null child pointer, the node pointed to by tree is
	 * removed; otherwise, the user's data is replaced by its
	 * logical predecessor and the predecessor's node is removed
	 */
	private BSTNode<T> removeNode(BSTNode<T> tree)
	{
		T data;
		
		if(tree.getLeft() == null)
			return tree.getRight();
		else if (tree.getRight() == null)
			return tree.getLeft();
		else
		{
			data = getPredecessor(tree.getLeft());
			tree.setInfo(data);
			tree.setLeft(recRemove(data, tree.getLeft()));
			return tree;
		}
				
	}
	
	// Returns the information held in the rightmost node in the tree
	private T getPredecessor(BSTNode<T> tree)
	{
		while(tree.getRight() != null)
			tree = tree.getRight();
		return tree.getInfo();
	}
	// Returns element if tree contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns null.
	// Uses private T recGet(T element, BSTNode<T> tree)... method.
	@Override
	public T get(T element)
	{
		return recGet(element, root);
	}
	
	// Returns element if tree contains an element e such that
	// e.compareTo(element) == 0; otherwise, returns null.
	private T recGet(T element, BSTNode<T> tree)
	{
		if(tree == null)
			return null;		// element is not found
		else if (element.compareTo(tree.getInfo()) < 0)  // get left subtree
			return recGet(element, tree.getLeft());
		else if (element.compareTo(tree.getInfo()) > 0)  // get right subtree
			return recGet(element, tree.getRight());
		else
			return tree.getInfo();		// element is found
	}
	
	// Adds element to this BST. The tree retains its BST property.
	@Override
	public void add(T element)
	{
		root = recAdd(element, root);
	}

	// Adds elements to tree; tree retains its BST property
	private BSTNode<T> recAdd(T element, BSTNode<T> tree)
	{
		if(tree == null)
			// Addition place found
			tree = new BSTNode<T>(element);
		else if (element.compareTo(tree.getInfo()) <= 0)
			tree.setLeft(recAdd(element, tree.getLeft()));
		else
			tree.setRight(recAdd(element, tree.getRight())); // Add in right subtree
		return tree;
	}
	
	
	// Initializes current position for an iteration through this BST
	// in orderType order. Returns current number of nodes in the BST.
	@Override
	public int reset(int orderType)
	{
		int numNodes = size();
		if(orderType == INORDER)
		{
			inOrderQueue = new LinkedUnboundQueue<T>();
			inOrder(root);
		}
		else if (orderType == PREORDER)
		{
			preOrderQueue = new LinkedUnboundQueue<T>();
			preOrder(root);
		}
		else if (orderType == POSTORDER)
		{
			postOrderQueue = new LinkedUnboundQueue<T>();
			postOrder(root);
		}
		return 0;
	}
	
	/*
	 * Preconditions: The BST is not empty
	 * 					The BST has been reset for orderType
	 * 					The BST has not been modified since the most recent rest
	 * 					The end of orderTYpe iteration has not been reached
	 * 
	 * Returns the element at the current position on this BST for orderType
	 * and advances the value of the current position based on the orderType.
	 */
	@Override
	public T getNext(int orderType)
	{
		if (orderType == INORDER)
		{
			try
			{
				return inOrderQueue.dequeue();
			} 
			catch (QueueUnderflowException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else if (orderType == PREORDER)
		{
			try
			{
				return preOrderQueue.dequeue();
			} 
			catch (QueueUnderflowException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else if (orderType == POSTORDER)
		{
			try
			{
				return postOrderQueue.dequeue();
			} 
			catch (QueueUnderflowException e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else
			return null;
		
	}

	
	// Initializes inOrder with tree elements inOrder order
	private void inOrder(BSTNode<T> tree)
	{
		if (tree != null)
		{
			inOrder(tree.getLeft());
			inOrderQueue.enqueue(tree.getInfo());
			inOrder(tree.getRight());
		}
	}
	
	// Initializes preOrder with tree elements preOrder order
	private void preOrder(BSTNode<T> tree)
	{
		if (tree != null)
		{
			preOrderQueue.enqueue(tree.getInfo());
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	
	// Initializes postOrder with tree elements postOrder order
	private void postOrder(BSTNode<T> tree)
	{
		if (tree != null)
		{
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			postOrderQueue.enqueue(tree.getInfo());
		}
	}
}
