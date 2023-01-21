package rocks.kata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CurrentDateProvider {
    public String getCurrentDate(){
        var dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate now = LocalDate.now();
        return dateFormatter.format(now);
    }
}
