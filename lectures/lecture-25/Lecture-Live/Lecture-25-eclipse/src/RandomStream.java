import java.util.*;

public class RandomStream implements Iterable<Integer> {

	class RandomIterator implements Iterator<Integer> {
		
		//instance variables?
		int count = 0;
		
		public Integer next() {
			//do we really need to call hasNext() twice? maybe yes, maybe no
			if (!hasNext()) { throw new NoSuchElementException(); }
			
			//save value to temp
			int temp = random.nextInt(bound);
			
			//move to next item
			count++;
			
			//return the temp value
			return temp;
		}
		
		public boolean hasNext() { 
			return this.count < size;
		}
	}
	
	//Member variables
	Random random;
	int size;
	int bound;
	
	//Consructor
	public RandomStream(int size, int bound) { 
		this.random = new Random();
		this.size = size;
		this.bound = bound;
	}
	
	//iterator()
	public Iterator<Integer> iterator() {
		return new RandomIterator();
	}

	public static void main(String[] args) {
	
		RandomStream r = new RandomStream(10, 100);
		
		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		Iterator<Integer> itr = r.iterator();
		//for (int i = 0; i < 11; i++) {	//throws exception - not using iterator properly
		for (int i = 0; itr.hasNext(); i++) {
			System.out.println(i + ": " + itr.next() + "");
		}
		System.out.println();
	}
}
