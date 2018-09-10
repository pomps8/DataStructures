/*
 * --------------------------------------------------------------------------------
 * DLLNode.java   									by Anthony Pompili
 * 
 * Double Linked List Node containing 2 references: one to its previous element, and one to th next element
 * 
 * One constructor is provided: one that creates a DLLNode with info.
 * --------------------------------------------------------------------------------
*/
package support;

public class DLLNode<T> extends LLNode<T>
{
	// This is just the reference to back.
	// Data & front link are stored in LLNode class (Parent)
	private DLLNode<T> back;
	
	public DLLNode(T info)
	{
		super(info);
		back = null;
	}
	
	// Sets back link of this DLLNode
	public void setBack(DLLNode<T> back)
	{
		this.back = back;
	}
	
	// Returns back link of this DLLNode
	public DLLNode<T> getBack()
	{
		return back;
	}

}
