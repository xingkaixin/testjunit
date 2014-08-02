import static org.junit.Assert.*;

import org.junit.Test;

import testdemo.plus;

public class plustest {

	@Test
	public void testAdd() {
		int a = new plus().add(5, 3);
		assertEquals(8, a);
		
	}

}
