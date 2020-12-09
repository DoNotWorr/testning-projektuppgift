import java.util.ArrayList;
import java.util.List;

public class CustomDelimiter {
    List<String> delimiters;

    public CustomDelimiter() {
        delimiters = new ArrayList<>();
        delimiters.add("\n");
        delimiters.add(",");
    }

    public String getDelimiter() {
        return "[\n|,]";
    }

    public void addDelimiter(String input) {
        //this.delimiter = input;
    }
}
