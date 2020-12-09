import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CustomDelimiterTest {
    CustomDelimiter customDelimiter = new CustomDelimiter();

    @Test
    void createInstance() {
        assertThat(customDelimiter).isNotNull();
    }

    @Test
    void defaultCallGetterReturnComma() {
        String expected = "[,]";
        String actual = customDelimiter.getDelimiter();
        assertThat(expected).isEqualTo(actual);
    }
}