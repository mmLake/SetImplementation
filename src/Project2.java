
public class Project2 {

	public static void main(String[] args) {
		SLinkedList A = new SLinkedList();
		SLinkedList B = new SLinkedList();
		
		A.addElement(2 + 6);
		A.addElement(0);
		A.addElement("hello");
		B.addElement(2928734019827341234L);
		B.addElement('c');
		
		A.printToString();
		B.printToString();
		System.out.println();
		System.out.println("Is A a subset of B: " + A.subsetOf(B));
		System.out.println("Did first element of A delete: " + A.remove(0));
		System.out.println("Was element hello added to A: " + A.addElement("hello"));
		System.out.println("Does B contain element c: " + B.contain('c'));
		System.out.println("Size of B: " + B.size() + " and Size of A: " + A.size());
		A.union(B).printToString();
		A.intersection(B).printToString();
		A.complement(B).printToString();
	}

}
