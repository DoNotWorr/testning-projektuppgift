import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class CustomDelimiter {
    private final List<String> delimiters;
    private boolean defaultDelimiter;
    private String numbers; //Not fully implemented. Do not use until implemented. Tests involving this method is disabled until then.

    /**
     * Constructor that add the default delimiter and newline in the desired format.
     */
    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("[\n]");
        delimiters.add("[,]");
        defaultDelimiter = true;
    }

    /**
     * @deprecated Not fully implemented. Do not use until implemented. Tests involving this method is disabled until then.
     * @param input input String from StringCalculator.add()
     */
    public CustomDelimiter(String input) {
        this();
        this.numbers = input;
    }

    /**
     * Gets all delimiters in the desired format. Newline is always a delimiter.
     * Comma is the default delimiter, but can be replaced by one or more different delimiters.
     * @return delimiters in a regex format where each character in a String is encapsulated delimiter "ABC" becomes "[A][B][C]" and "D" becomes [D].Each delimiter is separated by "|". The first delimiter is always newline. For example "[\n]|[A][B][C]|[D]"
     */
    public String getDelimiters() {
        return delimiters.stream()
                .collect(joining("|", "", ""));
    }

    /**
     * First time this method is called, comma delimiter is overwritten. Each subsequent call adds another delimiter.
     * @param input the delimiter
     */
    public void addDelimiter(String input) {
        if (defaultDelimiter) {
            delimiters.remove(1);
            defaultDelimiter = false;
        }
        delimiters.add(formatDelimiter(input));
    }

    /**
     * Formats a string to escape regex special characters
     * @param input the delimiter to be formatted, for example "A|C"
     * @return a formatted delimiter that is safe for regex special characters, for example [A][|][C]
     */
    private String formatDelimiter(String input) {
        return IntStream.range(0, input.length()).mapToObj(i -> "[" + input.charAt(i) + "]").collect(joining());
    }

    /**
     * @deprecated Not fully implemented. Do not use until implemented. Tests involving this method is disabled until then.
     * @return String of numbers separated by one or more delimiters
     */
    public String getNumbers() {
        return "1,1";
    }
}

