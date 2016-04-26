public class SLinkedList {
	
	protected Node head;
	protected Node tail;
	protected long size;
	
	/*Instantiates the Set*/
	public SLinkedList(){
		tail = new Node(null, null);
		head = new Node(null, tail);
		size = 0;
	}
	
	/* If an object does not exist in the set, or if the set is empty, returns false.
	 If an object exists in the set, returns true.*/
	public boolean contain(Object target){
		Node compare = head;
		
		do
		{
			compare = compare.getNext();
			if (compare.getObject() == null) {return false;}
		}while (!compare.getObject().equals(target));
		
		return true;
	}
	
	
	/*will attempt to remove the target Node, then return true if removed.
	if target Node did not exist, it will return false*/ 
	public boolean remove(Object target){
		Node compare = head.getNext();
		Node prev = head; 	
		
		while (!compare.getObject().equals(target)){
			prev = compare;
			compare = compare.getNext();
			
			if (compare.getObject() == null){
				return false;
			}
		}
		if (compare.getNext().getObject() == null){
			prev.setNext(tail);
		}
		else {
		prev.setNext(compare.getNext());
		}
		compare = null;
		return true;
	}
	
	
	
	/*Will return true after method adds a new Node at the top of the list containing the object .
	  Returns false if Node already exists, and therefore cannot be added as a duplicate */
	public boolean addElement(Object object){
		Node curr = head.getNext();
		
		if (curr.getObject() != null){
			if (contain(object) == true){
				return false;
			}
		}
		
		Node addElement = new Node(object, curr);
		head.setNext(addElement);
		return true;
		
	}
	
	/* @returns int of the number of objects that exist in a Set. Does not count the dummy head.*/
	public int size(){
		int size = 0;
		Node curr = head.getNext();
		
		while (!curr.equals(tail)){
			size++;
			curr = curr.getNext();
		}
		return size;
	}
	
	
	/* @returns a Boolean true if Set A, is a subset of Set B. Ordering of the set does not matter.  
	 * If set A is larger than set B, A cannot be a subset of B and returns false.
	 * Otherwise will check if every object in set A exists in set B. If they do, returns true.
	 * If any object in set A does not exist in set B, returns false. 
	 * */
	public boolean subsetOf(SLinkedList b){
		Boolean subset = false;
		Node curr = this.head.getNext();
		Node currB = b.head.getNext();
		
		if (this.size() > b.size()) {return false;}
		
		while (curr.getObject() != null){
			if (curr.getObject().equals(currB.getObject())){
				curr = curr.getNext();
				currB = b.head.getNext();
				if (curr.getObject() == null) {
					subset = true;
					break;
				}
			}
			else {
				currB = currB.getNext();
				if (currB.getObject() == null){
					subset = false;
					break;
				}
			}
		}
		return subset;
	}	
	
	/*Will print out every object in a set*/
	public void printToString(){
		Node curr = head.getNext();
		
		System.out.print("Here are the contents of this set: ");
		
		while (curr.getObject() != null){
			System.out.print(curr.getObject() + ", ");
			curr = curr.getNext();
		}
		System.out.println();
	}
	
	/*
	 @return a boolean true if set A is a subset of set B, and set B is also a subset of set A.
	 Ordering of the objects does not matter. 
	 Otherwise returns false. */
	public boolean isEqual(SLinkedList b){
		if (this.subsetOf(b) && b.subsetOf(this)){
			return true;
		}
		else {return false;}
	}
	
	/* Will first add all objects in set A that are not in Set B.
	 * Then adds all objects in set B.
	 *  @return a new Set that contains all of the objects, in a passed set A and set B without any duplicates.
	 * */
	public SLinkedList union(SLinkedList b){
		Node currB = b.head.getNext();
		Node curr = this.head.getNext();
		SLinkedList union = new SLinkedList();

		while (curr.getObject() != null ){
			if (!b.contain(curr.getObject())){
				union.addElement(curr.getObject());
			}
			curr = curr.getNext();
		}
		
		while (currB.getObject() != null){
			union.addElement(currB.getObject());
			currB = currB.getNext();
		}
		return union;
	}
	
	/*
	 @return a new Set that contains one copy of all the objects that in both Set A and Set B */
	public SLinkedList intersection(SLinkedList b){
		Node curr = this.head.getNext();
		SLinkedList intersection = new SLinkedList();

		while (curr.getObject() != null ){
			if (b.contain(curr.getObject())){
				intersection.addElement(curr.getObject());
			}
			curr = curr.getNext();
		}
		return intersection;
	}
	
	/*If an object in Set A does not exist in Set B, then the object is added to a new Set. 
	 * After all such objects are added to the new Set, this Set is returned.*/
	public SLinkedList complement(SLinkedList b){
		Node curr = this.head.getNext();
		SLinkedList complement = new SLinkedList();

		while (curr.getObject() != null){
			
			if (!b.contain(curr)){
				complement.addElement(curr.getObject());
			}
			curr = curr.getNext();
		}
		return complement;
	}
}
