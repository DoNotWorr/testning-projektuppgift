public class StringCalculator {

    /**
     *
     * @param input numbers separated by comma
     * @throws NumberFormatException non-numbers
     * @return sum of numbers
     */
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] terms = input.split(",");

        int sum = 0;
        for (String term : terms) {
            sum += Integer.parseInt(term);
        }
        return sum;
    }
}