package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Birthdays {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;
        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day) {

        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate todayDate = LocalDate.now();

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy - E", Locale.ENGLISH);
        int count = 0;
        String dateText = "";

        while (birthday.isEqual(todayDate) || (birthday.isBefore(todayDate))) {
            String numberBirthday = String.valueOf(count);
            dateText = dateText + numberBirthday + " - " + birthday.format(formatDate) + System.lineSeparator();
            count++;
            birthday = birthday.plusYears(1);
        }
        return dateText;
    }
}
