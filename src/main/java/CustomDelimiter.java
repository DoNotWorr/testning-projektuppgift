import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class CustomDelimiter {
    private final List<String> delimiters;
    private boolean defaultDelimiter;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
        defaultDelimiter = true;
    }

    public String getDelimiters() {
        return delimiters.stream()
                .collect(joining("|", "[", "]"));
    }

    public void addDelimiter(String input) {
        if (defaultDelimiter) {
            delimiters.remove(1);
            defaultDelimiter = false;
        }
        delimiters.add(input);
    }
}

