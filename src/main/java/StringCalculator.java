public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String[] terms = input.split(",");

        if (terms.length > 1) {
            return Integer.parseInt(terms[0]) + Integer.parseInt(terms[1]);
        } else {
            return Integer.parseInt(terms[0]);
        }
    }
}