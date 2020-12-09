import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CustomDelimiterTest {
    CustomDelimiter customDelimiter = new CustomDelimiter();

    @Test
    void createInstance() {
        assertThat(customDelimiter).isNotNull();
    }

    @Test
    @DisplayName("Newline and comma should be the default delimiters")
    void defaultCallGetter() {
        String expected = "[\n]|[,]";
        String actual = customDelimiter.getDelimiters();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("First time adding a delimiter should return newline and the added delimiter")
    void addDelimiterOnce() {
        String input = ";";
        customDelimiter.addDelimiter(input);

        String expected = "[\n]|[;]";
        String actual = customDelimiter.getDelimiters();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("First added delimiter should overwrite default comma")
    void addDelimiterChangeFalse() {
        String input = ";";
        String secondInput = "*";
        customDelimiter.addDelimiter(input);
        customDelimiter.addDelimiter(secondInput);

        String expected = "[\n]|[;]|[*]";
        String actual = customDelimiter.getDelimiters();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("Adding a longer delimiter should give it the correct format")
    void addLongerDelimiter() {
        String input = "abc";
        customDelimiter.addDelimiter(input);

        String expected = "[\n]|[a][b][c]";
        String actual = customDelimiter.getDelimiters();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void smarterConstructor() {
        String input = "1,1";
        String expectedNumbers = "1,1";
        String expectedDelimiter = "[\n]|[,]";

        CustomDelimiter smarterConstructor = new CustomDelimiter(input);
        String actualNumbers = smarterConstructor.getNumbers();
        String actualDelimiter = smarterConstructor.getDelimiters();

        assertThat(actualNumbers).isEqualTo(expectedNumbers);
        assertThat(actualDelimiter).isEqualTo(expectedDelimiter);
    }
}