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
    @DisplayName("Comma should be the default delimiter")
    void defaultCallGetter() {
        String expected = "[,]";
        String actual = customDelimiter.getDelimiter();
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("First time adding a delimiter, the old one should be removed")
    void addDelimiterOnce() {
        String input = ";";
        customDelimiter.addDelimiter(input);

        String expected = "[;]";
        String actual = customDelimiter.getDelimiter();

        assertThat(expected).isEqualTo(actual);
    }
}