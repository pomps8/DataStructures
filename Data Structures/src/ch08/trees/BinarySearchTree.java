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
	
	@Override
	public boolean remove(T element)
	{
		return false;
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
	
	@Override
	public int reset(int orderType)
	{
		return 0;
	}

}
