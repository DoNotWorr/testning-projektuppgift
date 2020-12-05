public class StringCalculator {

    /**
     *
     * @param input
     * @throws NumberFormatException non-numbers
     * @return sum of numbers
     */
    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] terms = input.split(",");

        int sum = 0;
        for (int i = 0; i < terms.length; i++) {
            sum += Integer.parseInt(terms[i]);
        }
        return sum;
    }
}