import java.util.ArrayList;			//Implementation B - uses Inteface C (interface List)

public interface Stack<E> {			//Interface A
  void push(E element);
  E pop();
  int size();
  E peek();
}

class ALStack<E> implements Stack<E> {

	private ArrayList<E> contents;

	public ALStack() {
		contents = new ArrayList<E>();
	}
	
	public void push(E element) {
		//Add to the back of the array list (i.e. the Top)
		this.contents.add(element);
	}
	
	public E pop() {
		//Remove the Top from the arraylist
		return this.contents.remove(this.contents.size() - 1);
	}

	public E peek() {
		return this.contents.get(this.contents.size() - 1);
	}
	
	public int size() {
	  return this.contents.size();
	}

	public String toString() {
		return this.contents.toString() + "<- top";
	}
}
