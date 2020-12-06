import java.util.stream.Collectors;
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

        //Replace alternative delimiter with default delimiter
        //Concat ",0" to make sure split() never deletes all trailing empty strings
        //Split and map to int stream, then summarize
        return Stream.of((input.replace(alternativeDelimiter, defaultDelimiter).concat(",0")).split(defaultDelimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}