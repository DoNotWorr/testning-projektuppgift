import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    void inputReturnsIntRepresentation() {
        String input = "0";
        int expected = 0;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void anotherInputReturnsIntRepresentation() {
        String input = "1";
        int expected = 1;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Two numbers should with comma delimiter should not throw any exceptions. Don't care about return value")
    void twoInputsDoesntThrowException() {
        String input = "1,2";
        //From https://github.com/assertj/assertj-core/issues/943
        assertThatCode(() -> calculator.add(input)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Input with two numbers and comma delimiter should return sum of numbers")
    void twoInputsWithDelimiterShouldReturnSum() {
        String input = "1,2";
        int expected = 3;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Input with two numbers and comma delimiter should return sum of numbers")
    void threeNumbersValidInput() {
        String input = "1,2,3";
        int expected = 6;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Input with ten numbers and comma delimiter should return sum of numbers")
    void tenNumbersValidInput() {
        String input = "1,2,3,4,5,6,7,8,9,10";
        int expected = 55;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Input with two numbers and comma delimiter should return sum of numbers")
    void newLineDelimiterShouldWork() {
        String input = "1\n2,3";
        int expected = 6;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Double delimiter followed by number should throw exception")
    void illegalArgumentOne() {
        String input = "1,\n3";
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Double delimiter at the end should throw exception")
    void illegalArgumentTwo() {
        String input = "1,\n";
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Single delimiter at the end should throw exception")
    void illegalArgumentThree() {
        String input = "1,";
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> calculator.add(input));
    }
}
