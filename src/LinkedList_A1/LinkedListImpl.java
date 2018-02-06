package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
	
	// **Field**
	Node sentinel;
	
	// **Constructor**
	public LinkedListImpl() {
		sentinel = new Node(0);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	

	// **Methods**
	
	public void clear() {
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	public int size() {
		// First, check if size is 0
		if (sentinel.next == sentinel) {
			return 0;
		}
		
		// The size method should count up the linked list until it comes back to the sentinel
		Node a = sentinel.next;
		int size = 0;
		while (a != sentinel) {
			a = a.next;
			size++;
		}
		return size;
	}

	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean insert(double elt, int index) {
		
		// If the user is inserting an element at an index that is larger than the list size
		// or smaller than 0 then the insert function will do nothing
		if ((index > this.size()) || (index < 0)) {
			return false;
		}
		
		Node a = new Node(elt);
		
		// If an element is being inserted at the beginning or end of a list
		// then the "next" and/or "prev" fields of the sentinel need to be changed
		if (this.size() == 0) {
			// If the list is empty and a node is being added, then:
			// The sentinel's next and prev are changed to the new node
			sentinel.next = a;
			sentinel.prev = a;
			// The new node's next and prev are changed to the sentinel
			a.prev = sentinel;
			a.next = sentinel;
			return true;
		} else
		if (index == 0) {
			// If an element is being placed at the beginning of the list:
			// The new node's next is assigned to the sentinel's current next
			a.next = sentinel.next;
			a.prev = sentinel;
			sentinel.next.prev = a;
			sentinel.next = a;
			return true;
		} else
		if (index == this.size()) {
			a.prev = sentinel.prev;
			a.next = sentinel;
			sentinel.prev.next = a;
			sentinel.prev = a;
			return true;
		}
		
		// Otherwise, the insert method needs to count up the linked list to the 
		// proper index then reassign the next and prev values for the nodes next to it
		Node next = sentinel.next;
		for (int i = 0; i < index; i++) {
			next = next.next;
		}
		Node prev = next.prev;
		a.next = next;
		a.prev = prev;
		prev.next = a;
		next.prev = a;
		return true;
	}

	public boolean remove(int index) {
		// If the index is less than 0 or greater than/equal to size then return false
		if ((index >= this.size()) || (index < 0)) {
			return false;
		}
		
		// Starting with the sentinel, the program needs to count up the linked list
		// until it gets to the proper index
		Node a = sentinel.getNext();
		for (int i = 0; i < index; i++) {
			a = a.getNext();
		}
		
		// Once the right index is found, the indices before and after need to have their
		// respective next and prev fields reassigned
		Node prev = a.getPrev();
		Node next = a.getNext();
		prev.next = next;
		next.prev = prev;
				
		return true;
	}

	public double get(int index) {
		// If the index is less than 0 or greater than/equal to size then return Double.NaN
		if ((index >= this.size()) || (index < 0)) {
			return Double.NaN;
		}
		// Otherwise, the get method needs to count up the linked list to the proper index
		// and then return the data value held by the node occupying that index
		Node a = sentinel.next;
		for (int i = 0; i < index; i++) {
			a = a.next;
		}
		
		return a.getData();
	}

	public Node getRoot() {
		return sentinel;
	}
}
