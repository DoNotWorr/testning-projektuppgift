public class StringCalculator {

    public int add(String input) {
        if (input.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(input);
        }
    }
}
