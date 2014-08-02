import org.junit.Test;
import testdemo.plus;

import static org.junit.Assert.*;

public class plusTest2 {

    @Test
    public void testAdd() throws Exception {
        int a = new plus().add(5, 3);
        assertEquals(8, a);
    }
}