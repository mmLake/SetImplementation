
public class Node {

	private Object object;
	private Node next;
	
	/*Instantiates all Nodes with an Object and another Node ( which points to the next link) in it.*/
	public Node(Object o, Node n) {
		object = o;
		next = n;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object newElement) {
		object = newElement;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node newLink) {
		next = newLink;
	}
	
	
	
	


}


