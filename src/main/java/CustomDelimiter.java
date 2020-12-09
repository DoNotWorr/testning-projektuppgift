import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class CustomDelimiter {
    private List<String> delimiters;
    private boolean changedDelimiter;

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
        if (changedDelimiter) {
            delimiters.add(input);
        } else {
            delimiters.remove(1);
            delimiters.add(input);
            changedDelimiter = true;
        }
    }
}
