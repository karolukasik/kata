package rocks.kata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateProvider {

    String desiredFormat;

    public DateProvider(String desiredFormat) {
        this.desiredFormat = desiredFormat;
    }

    public String getCurrentDate() {
        var dateFormatter = DateTimeFormatter.ofPattern(desiredFormat);
        LocalDate now = LocalDate.now();
        return dateFormatter.format(now);
    }
}
