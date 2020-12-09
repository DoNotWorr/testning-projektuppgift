import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CustomDelimiter {
    private final List<String> delimiters;
    private boolean defaultDelimiter;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("[\n]");
        delimiters.add("[,]");
        defaultDelimiter = true;
    }

    public String getDelimiters() {
        return delimiters.stream()
                .collect(joining("|", "", ""));
    }

    public void addDelimiter(String input) {
        if (defaultDelimiter) {
            delimiters.remove(1);
            defaultDelimiter = false;
        }
        delimiters.add(formatDelimiter(input));
    }

    private String formatDelimiter(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            resultBuilder.append("[");
            resultBuilder.append(input.substring(i, i+1));
            resultBuilder.append("]");
        }
        return resultBuilder.toString();
    }
}

