/*
 * --------------------------------------------------------------------------------
 * BSTNode.java   									by Anthony Pompili
 * 
 * Implements Comparable nodes for a binary searchtree
 * --------------------------------------------------------------------------------
*/
package support;

public class BSTNode<T extends Comparable<T>>
{

	// Used to hold references to BST nodes for the linked implementation
	protected T info;				// The info in a BST Node
	protected BSTNode<T> left;		// A link to the left child node
	protected BSTNode<T> right;		// A link to the right child node
	
	public BSTNode(T info)
	{
		this.info = info;
		left = null;
		right = null;
	}
	
	// Sets info of this BSTNode
	public void setInfo(T info)
	{
		this.info = info;
	}
	
	// Returns info of this BSTNode
	public T getInfo()
	{
		return info;
	}
	
	// Sets left link of this BSTNode
	public void setLeft(BSTNode<T> link)
	{
		left = link;
	}
	
	// Sets right link of this BSTNode
	public void setRight(BSTNode<T> link)
	{
			right = link;
	}
	
	// Returns left link of this BSTNode
	public BSTNode<T> getLeft()
	{
		return left;
	}
	
	// Returns right link of this BSTNode
	public BSTNode<T> getRight()
	{
		return right;
	}
}
