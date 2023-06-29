package org.STC2306;

import java.time.LocalDate;
import java.util.Scanner;

public class CactusWatering {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¬ведите год даты последнего полива: ");
        int year = scanner.nextInt();

        System.out.print("¬ведите мес€ц (число от 1 до 12) даты последнего полива: ");
        int month = scanner.nextInt();

        System.out.print("¬ведите день (число от 1 до 31) даты последнего полива: ");
        int day = scanner.nextInt();

        LocalDate lastWateringDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() == 12 || currentDate.getMonthValue() <= 2) {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate)) {
                message = " актус нужно полить. ѕрошло больше мес€ца с даты последнего полива" + "(" + lastWateringDate + ").";
            } else {
                message = " актус не нужно поливать. ѕрошло меньше мес€ца с даты последнего полива" + "(" + lastWateringDate + ").";
            }
        } else if ((currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9)) {
            message = " актус нужно полить. ѕрошло больше недели с даты последнего полива " + "(" + lastWateringDate + ").";
        } else {
            Sensor sensor = new Sensor();
            int humidity = sensor.getHumidity();
            if (humidity < 30) {
                message = " актус нужно полить, так как влажность воздуха ниже 30% " + "(" + humidity + "%). ƒата последнего полива: "  + lastWateringDate + ".";
            } else if (currentDate.minusDays(2).isAfter(lastWateringDate)) {
                message = " актус нужно полить, так как прошло более двух дней с даты последнего полива. ƒата последнего полива: "  + lastWateringDate + ".";
            } else {
                message = " актус не нужно поливать, так как последний полив был менее двух дней назал. ѕоказани€ датчика влажности: " + humidity + "%. ƒата последнего полива: "  + lastWateringDate + ".";
            }
        }

        System.out.println(message);
    }
}