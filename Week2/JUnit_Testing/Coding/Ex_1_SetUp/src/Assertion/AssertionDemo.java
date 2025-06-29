package Assertion;
import org.junit.Test;
import static org.junit.Assert.*;
public class AssertionDemo {
    @Test
    public void checkVariousAssertions() {
        assertEquals("Sum check failed", 5, 2 + 3);
        assertTrue("Expected condition to be true", 5 > 3);
        assertFalse("Expected condition to be false", 5 < 3);
        Object emptyReference = null;
        assertNull("Expected null reference", emptyReference);
        Object objectInstance = new Object();
        assertNotNull("Expected non-null object", objectInstance);
    }
}
