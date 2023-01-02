package demoPractice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataUtility {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu");
        String text = date.format(formatter);

        System.out.println(text.toUpperCase());
    }
}
