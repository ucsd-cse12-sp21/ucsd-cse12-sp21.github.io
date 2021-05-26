import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.*;
import java.nio.BufferOverflowException;

public class TestMemoryStream {
	
	@Test
	public void testMemoryStreamWrite() {
		
		Integer[] testArray = { new Integer(1), new Integer(2), null, null };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(4);
		
		memoryStream.write(1);
		memoryStream.write(2);
		//System.out.println(memoryStream);

		assertArrayEquals(testArray, memoryStream.contents);
		assertEquals(2, memoryStream.size);
		//assertEquals(2, memoryStream.back);
	}
	
	@Test (expected = BufferOverflowException.class)
	public void testMemoryStreamOverflow() {
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(1);
		
		memoryStream.write(1);
		memoryStream.write(2);
	}
	
	@Test
	public void testMemoryStreamMultipleReads() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		assertEquals(new Integer(5), memoryStream.next());
		assertEquals(new Integer(2), memoryStream.next());
		assertEquals(new Integer(4), memoryStream.next());
		assertEquals(new Integer(1), memoryStream.next());
		assertEquals(new Integer(7), memoryStream.next());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testMemoryStreamEmpty() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		while (true) {
			memoryStream.next();
		}
	}
	
	@Test
	public void testMemoryStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };
		
		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		//System.out.println(memoryStream);
		
		while (memoryStream.hasNext()) {
			memoryStream.next();
		}
		
		//assertEquals(5, memoryStream.front);
		assertEquals(0, memoryStream.size);
		
		memoryStream.close();
	}
	
	@Test
	public void testMemoryStreamWrap() {
		Integer[] a = { 5, 2, 4, 1, 7 };

		MemoryStream<Integer> memoryStream = new MemoryStream<>(5);
		for (Integer i : a) {
			memoryStream.write(i);
		}
		
		assertEquals(new Integer(5), memoryStream.next());
		assertEquals(new Integer(2), memoryStream.next());
		assertEquals(3, memoryStream.size);
		
		//System.out.println("testMemoryStreamWrap: start");
		//System.out.println(memoryStream);

		memoryStream.write(10);
		memoryStream.write(11);
		assertEquals(5, memoryStream.size);

		//System.out.println("Wrap contents: ");
		//System.out.println(memoryStream);
		//while (memoryStream.hasNext()) {
		//	System.out.print(memoryStream.next() + " ");
		//}
		//System.out.println();
		
		//System.out.println("testMemoryStreamWrap: end");
	}
	
	@Test
	public void testInputWriteStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };

		MemoryStream<Integer> inputStream = new MemoryStream<>(5);
		for (Integer i : a) {
			inputStream.write(i);
		}
		
		MemoryStream<Integer> newStream  = new MemoryStream<>(5);
		
		newStream.write(inputStream);
		assertEquals(5, newStream.size);
		assertEquals(0, inputStream.size);

		//System.out.println("testInputWriteStream start");
		//System.out.println(newStream);
		//while (newStream.hasNext()) {
		//	System.out.print(newStream.next() + " ");
		//}
		//System.out.println();
		//System.out.println("testInputWriteStream end");
		
		newStream.close();
		inputStream.close();
	}
	
	@Test
	public void testOutputReadStream() {
		Integer[] a = { 5, 2, 4, 1, 7 };

		MemoryStream<Integer> inputStream = new MemoryStream<>(5);
		for (Integer i : a) {
			inputStream.write(i);
		}
		
		MemoryStream<Integer> newStream  = new MemoryStream<>(5);
		
		inputStream.next(newStream);
		assertEquals(5, newStream.size);
		assertEquals(0, inputStream.size);

		//System.out.println("testOutputReadStream start");
		//System.out.println(newStream);
		//while (newStream.hasNext()) {
		//	System.out.print(newStream.next() + " ");
		//}
		//System.out.println();
		//System.out.println("testOutputReadStream end");
		
		newStream.close();
		inputStream.close();
	}
	
	@Test
	public void testIterator() {
		MemoryStream<Integer> stream = new MemoryStream<>(10);
		for (int i = 0; i < 10; i++) {
			stream.write(i);
		}
	
		for (Integer i : stream) {
			//System.out.print(i + " ");
		}
		//System.out.println();
		
		stream.close();
	}
	
	@Test
	public void testPQ() {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compare);
		
		pq.add(2);
		pq.add(1);
		pq.add(3);
		
		for (Integer i : pq) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		for (Integer i : pq) {
			System.out.print(i + " ");
			//pq.add(5);
			//pq.add() will set a flag in pq, 
			//iterator checks the flag during next() and throws exception
		}
		System.out.println();
	}
}
