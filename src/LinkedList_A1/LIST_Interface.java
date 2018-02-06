package LinkedList_A1;

public interface LIST_Interface {
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
	boolean insert(double elt, int index);
	
	boolean remove(int index);
	
	double get(int index);
}
