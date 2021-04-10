import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestStringList {

  @Test
  public void testAdd() {
    List<String> slist = new LList<String>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals("banana", slist.get(1));
    assertEquals("apple", slist.get(0));
  }

  @Test
  public void testAddThenSize() {
    List<String> slist = new LList<String>();
    slist.prepend("banana");
    slist.prepend("apple");

    assertEquals(2, slist.size());
  }


  @Test
  public void testAddMany() {
    List<String> slist = new LList<String>();
    slist.add("a");
    slist.add("b");
    slist.add("c");
    slist.add("d");
    slist.add("e");

    assertEquals("e", slist.get(4));
    assertEquals("d", slist.get(3));
    assertEquals("c", slist.get(2));
    assertEquals("b", slist.get(1));
    assertEquals("a", slist.get(0));

  }
  
  @Test
  public void testAddInteger() {
    List<Integer> slist = new LList<Integer>();
    slist.prepend(1);
    slist.prepend(2);

    assertEquals(new Integer(1), slist.get(1));
    //assertEquals(new Integer(2), slist.get(0));
    assertEquals(2, (int) slist.get(0));
  }

}

