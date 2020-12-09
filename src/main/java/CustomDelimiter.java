public class CustomDelimiter {
    String delimiter = ",";

    public String getDelimiter() {
        return "[" + delimiter + "]";
    }

    public void addDelimiter(String input) {
        this.delimiter = input;
    }
}
