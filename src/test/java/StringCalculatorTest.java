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

    @Test
    @DisplayName("Changing delimiter invalidates the default delimiter")
    void alternativeDelimiterInvalidatesDefaultDelimiter() {
        String input = "//;\n1,2";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Custom delimiter syntax should throw exception if no custom delimiter is given")
    void invalidAlternativeDelimiter() {
        String input = "//\n1,2";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Input with two numbers and changed delimiter should return sum of numbers")
    void alternativeDelimiterChanges() {
        String input = "//;\n1;2";
        int expected = 3;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Negative number should throw exception")
    void negativeInputThrowsException() {
        String input = "1,-2";
        //assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.add(input));
        assertThatThrownBy(() -> calculator.add(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Negatives not allowed: [-2]");
    }
}

//Support different delimiters:
//
//To change a delimiter, the beginning of the string will contain a separate line
//that looks like this: “//[delimiter]\n[numbers…]”
//for example “//;\n1;2” should return three where the default delimiter is ‘;’.
//
//The first line is optional. All existing scenarios should still be supported.