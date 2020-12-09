import java.util.ArrayList;
import java.util.List;

public class CustomDelimiter {
    List<String> delimiters;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
    }

    public String getDelimiters() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (String delimiter : delimiters) {
            result.append(delimiter);
            result.append("|");
        }
        result.deleteCharAt(result.toString().length() - 1);
        result.append("]");
        return result.toString();
    }

    public void addDelimiter(String input) {
        delimiters.remove(1);
        delimiters.add(input);

    }
}
