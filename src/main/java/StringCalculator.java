public class StringCalculator {

    public int add(String s) {
        if(s.isEmpty()) {
            return 0;
        } else {
            return Integer.valueOf(s);
        }
    }
}
