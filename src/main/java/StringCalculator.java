import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    /**
     *
     * @param input numbers separated by comma
     * @throws NumberFormatException non-numbers
     * @return sum of numbers
     */
    public int add(String input) {
        String delimiter = ",";
        if (input.isEmpty()) {
            return 0;
        }
        //https://www.baeldung.com/java-string-with-separator-to-list
        //https://www.baeldung.com/java-8-collectors
        return Stream.of(input.split(delimiter)).mapToInt(Integer::parseInt).sum();
    }
}