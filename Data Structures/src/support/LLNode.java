package support;

//By Anthony Pompili
// Implements <T> nodes for a linked list.
// link -> the reference to the next element
// info -> the data in the object itself

public class LLNode <T>
{
	private LLNode<T> link;
	private T info;
	
	public LLNode(T info)
	{
		this.info = info;
		link = null;
	}
	
	// set the info of this LLNode.
	public void setInfo(T info)
	{
		this.info = info;
	}
	
	// Returns the info of this LLNode.
	public T getInfo()
	{
		return info;
	}
	
	// set the link of this LLNode
	public void setLink(LLNode<T> link)
	{
		this.link = link;
	}
	
	// Get the link of this LLNode
	public LLNode<T> getLink()
	{
		return link;
	}
}
