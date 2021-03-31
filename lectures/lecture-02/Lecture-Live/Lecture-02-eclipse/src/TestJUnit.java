import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {

	@Test
	public void testQuestion1() {
		helper();
		otherHelper();
	}
	
	private void helper() {
		
	}
	
	public void otherHelper() {
		
	}
	
	public int sumNumbers(String input) {
		//System.out.println(input);
		return 0;
	}
	
	@Test
	public void testNull() {
		String s = null;
		assertEquals(0, sumNumbers(s));
	}
	
	@Test
	public void testString1() {
		String s = "abc123xyz";
		assertEquals(123, sumNumbers(s));
	}
	
	@Test
	public void testString2() {
		String s = "aa11b33";
		assertEquals(44, sumNumbers(s));
	}
}
