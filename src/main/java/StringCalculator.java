import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    /**
     * //https://www.baeldung.com/java-string-with-separator-to-list
     * //https://www.baeldung.com/java-8-collectors
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

        List<Integer> allNumbers = Arrays.stream(input
                .replace(alternativeDelimiter, defaultDelimiter)
                .concat(defaultDelimiter)
                .concat("0")                //Add a delimiter followed by "0" to make split consistant
                .split(defaultDelimiter))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        List<Integer> allNegative = allNumbers.stream().filter(num -> (num < 0)).collect(Collectors.toList());

        if (allNegative.isEmpty()) {
            return allNumbers
                    .stream()
                    .mapToInt(Integer::intValue)
                    .filter(number -> (number <= 1000))
                    .sum();

        } else {
            throw new IllegalArgumentException("Negatives not allowed: " + allNegative);
        }
    }
}