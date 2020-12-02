import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    void createInstanceCallMethod() {
        StringCalculator calculator = new StringCalculator();
        calculator.add("");
    }
}
