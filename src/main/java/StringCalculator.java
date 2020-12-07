import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    /**
     * @param input numbers separated by comma
     * @return sum of numbers
     * @throws NumberFormatException non-numbers, invalid syntax for changing delimiter
     */
    public int add(String input) {
        String defaultDelimiter = ",";
        String alternativeDelimiter = "\n";

        if (input.isEmpty()) {
            return 0;
        }
        //If input starts with syntax for changed delimiter
        if (input.startsWith("//")) {
            if (input.substring(3, 5).contains("\n")) {
                defaultDelimiter = input.substring(2, 3);
                input = input.substring(4);
            } else {
                //Invalid syntax for changed delimiter
                //Not sure if throwing exception is necessary
            }
        }

        //https://www.baeldung.com/java-string-with-separator-to-list
        //https://www.baeldung.com/java-8-collectors
        return Stream.of((input
                //Change all delimiters
                .replace(alternativeDelimiter, defaultDelimiter)
                //Add a delimiter followed by "0" to make split consistant
                .concat(defaultDelimiter)
                .concat("0"))
                .split(defaultDelimiter))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}