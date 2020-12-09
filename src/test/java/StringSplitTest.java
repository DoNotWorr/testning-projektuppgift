import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayName("Reminder of how split regex with special characters work")
public class StringSplitTest {
    @Test
    void testSplitOne() {
        String delimiters = "[***][%][abc]";
        String input = "1***2%3abc4";
        assertThat(input.split(delimiters).length).isNotEqualTo(4);
    }

    @Test
    void testSplitTwo() {
        String delimiters = "[***|%|abc]";
        String input = "1***2%3abc4";

        String[] actual = input.split(delimiters);
        String[] expected = {"1", "2", "3", "4"};

        assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    void testSplitThree() {
        String delimiters = "[*]|[%]|[a]";
        String input = "1*2%3a4";

        String[] actual = input.split(delimiters);
        String[] expected = {"1", "2", "3", "4"};

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testSplitFour() {
        String delimiters = "[*][*][*]|[%]|[a][b][c]";
        String input = "1***2%3abc4";

        String[] actual = input.split(delimiters);
        String[] expected = {"1", "2", "3", "4"};

        assertThat(actual).isEqualTo(expected);
    }
}
