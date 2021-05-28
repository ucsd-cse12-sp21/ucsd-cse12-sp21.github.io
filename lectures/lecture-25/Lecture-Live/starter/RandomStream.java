import java.util.*;

public class RandomStream {


	public static void main(String[] args) {
	
		RandomStream r = new RandomStream(10, 100);
		
		for (Integer i : r) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
}
