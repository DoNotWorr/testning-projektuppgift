import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void createInstanceCallMethod() {
        calculator.add("");
    }

    @Test
    void emptyStringReturnZero() {
        int expected = 0;
        int actual = calculator.add("");
        assertThat(actual).isEqualTo(expected);
    }
}
