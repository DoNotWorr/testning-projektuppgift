import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    /**
     * //https://www.baeldung.com/java-string-with-separator-to-list
     * //https://www.baeldung.com/java-8-collectors
     *
     * @param input numbers separated by comma. Alternatively "//c\n1c2" where c can be replaced by any character. Alternatively //[abc][def]\n1abc2def where each delimiter is surrender by brackets.
     * @return sum of numbers
     * @throws NumberFormatException non-numbers, invalid syntax for changing delimiter
     */
    public int add(String input) {
        //Always returns 0 if input is empty
        if (input.isEmpty()) {
            return 0;
        }
        //Create an object to hold delimiters. By default it's "\n" and ","
        CustomDelimiter delimiters = new CustomDelimiter();

        //If input starts with syntax for changed delimiter
        if (input.startsWith("//")) {   //todo could also check that input contains newline
            int beforeDelimiter = 2;
            int afterDelimiter = input.indexOf("\n");
            String possiblyDelimiter = input.substring(beforeDelimiter, afterDelimiter);
            if (possiblyDelimiter.length() == 1) {
                delimiters.addDelimiter(possiblyDelimiter);
                input = input.substring(4);
            } else if (possiblyDelimiter.length() == 3) {
                if (possiblyDelimiter.startsWith("[") && possiblyDelimiter.endsWith("]")) {
                    delimiters.addDelimiter(possiblyDelimiter.substring(1, 2));
                    input = input.substring(afterDelimiter + 1);
                }
            } else if (possiblyDelimiter.length() > 3) {
                if (possiblyDelimiter.startsWith("[") && possiblyDelimiter.endsWith("]")) {
                    String[] possibleDelimiters = possiblyDelimiter.substring(1, possiblyDelimiter.length() - 1).split("]\\[");
                    for (String possibleDelimiter : possibleDelimiters) {
                        delimiters.addDelimiter(possibleDelimiter);
                    }
                    input = input.substring(afterDelimiter + 1);
                }
            }
        }

        List<Integer> allNumbers = Arrays.stream(input.concat("\n0")
                .split(delimiters.getDelimiters()))
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