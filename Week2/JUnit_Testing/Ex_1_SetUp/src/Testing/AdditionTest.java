package Testing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AdditionTest {
    @Test
    public void shouldReturnSumOfTwoNumbers() {
        int firstNumber = 2;
        int secondNumber = 3;
        int sum = firstNumber + secondNumber;
        assertEquals("Sum calculation failed", 5, sum);
    }
}
