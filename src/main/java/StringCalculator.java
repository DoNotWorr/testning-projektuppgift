public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            String[] terms = input.split(",");
            return Integer.parseInt(terms[0]);
        }
    }
}
