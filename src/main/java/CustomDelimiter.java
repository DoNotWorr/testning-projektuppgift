import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class CustomDelimiter {
    private List<String> delimiters;
    private boolean defaultDelimiter;
    private String numbers;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("[\n]");
        delimiters.add("[,]");
        defaultDelimiter = true;
    }

    public CustomDelimiter(String input) {
        this();
        this.numbers = input;
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

    public String getNumbers() {
        return "1,1";
    }
}

