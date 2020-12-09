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
        String expected = "[\n|,]";
        String actual = customDelimiter.getDelimiter();
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @Disabled
    @DisplayName("First time adding a delimiter should return newline and the added delimiter")
    void addDelimiterOnce() {
        String input = ";";
        customDelimiter.addDelimiter(input);

        String expected = "[\n|;]";
        String actual = customDelimiter.getDelimiter();

        assertThat(expected).isEqualTo(actual);
    }
}