import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class CustomDelimiter {
    List<String> delimiters;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
    }

    public String getDelimiters() {
        return delimiters.stream()
                .collect(joining("|", "[", "]"));
    }

    public void addDelimiter(String input) {
        delimiters.remove(1);
        delimiters.add(input);
    }
}
