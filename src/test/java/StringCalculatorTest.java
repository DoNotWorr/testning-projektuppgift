import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    void emptyStringReturnZero() {
        int expected = 0;
        int actual = calculator.add("");
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("String representation should return int representation of number")
    @CsvSource({"0, 0", "1, 1"})
    void oneNumberParameter(String input, int expected) {
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

    @ParameterizedTest
    @DisplayName("Input with multiple numbers and comma delimiter should return sum of numbers")
    @CsvSource(value = {"1,2:3", "1,2,3:6", "1,2,3,4,5,6,7,8,9,10:55"}, delimiter = ':')
    void multipleNumbersReturnSum(String input, int expected) {
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

    @ParameterizedTest
    @DisplayName("Double delimiter with no number should throw exxception")
    @ValueSource(strings = {"1,\n3", "1,\n", "1,"})
    void illegalArgumentsWithDelimiter() {
        String input = "1,\n3";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> calculator.add(input));
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
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.add(input));
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

    @Test
    @DisplayName("Add shouldn't include numbers bigger than 1000 when summarizing")
    void inputAbove1000isIgnoredInSum() {
        String input = "//;\n1;1001;2";
        int expected = 3;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Different format for changing delimiter")
    void differentFormatForChangeDelimiterWorks() {
        String input = "//[;]\n1;2";
        int expected = 3;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Different format for changing delimiter")
    void longerDelimiterWorks() {
        String input = "//[abc]\n1abc2";
        int expected = 3;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Changed delimiter should throw exception if not all characters are within brackets")
    void invalidSyntaxChangedDelimiter() {
        String input = "//[**]1\n1,2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Brackets required when changed delimiter is longer than one character")
    void invalidSyntaxLongerCustomDelimiter() {
        String input = "//ee\n1,2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.add(input));
    }

    @Test
    @DisplayName("Multiple custom delimiters works.")
    void multipleDelimitersWorks() {
        String input = "//[*][%]\n1*2%3";
        int expected = 6;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Multiple longer custom delimiters works.")
    void multipleLongerDelimitersWorks() {
        String input = "//[****][????]\n1****2????3";
        int expected = 6;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Multiple longer custom delimiters works.")
    void fiveLongerDelimitersWorks() {
        String input = "//[****][????][asdf][qwer][ppp]\n1****2????3asdf4qwer5ppp6";
        int expected = 21;
        int actual = calculator.add(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Custom delimiter syntax without newline shouldn't work")
    void customDelimiterInvalidSyntax() {
        String input = "//[abc]1abc2";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculator.add(input));
    }
}