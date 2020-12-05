import java.util.stream.Stream;

public class StringCalculator {

    /**
     * @param input numbers separated by comma
     * @return sum of numbers
     * @throws NumberFormatException non-numbers
     */
    public int add(String input) {
        String defaultDelimiter = ",";
        String alternativeDelimiter = "\n";
        if (input.isEmpty()) {
            return 0;
        }
        //https://www.baeldung.com/java-string-with-separator-to-list
        //https://www.baeldung.com/java-8-collectors
        //Replace alternative with default delimiter. Converts to int stream and summarizes
        return Stream.of(input.replace(alternativeDelimiter, defaultDelimiter)
                .split(defaultDelimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}