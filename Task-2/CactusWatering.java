package org.STC2306;

import java.time.LocalDate;
import java.util.Scanner;

public class CactusWatering {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("������� ��� ���� ���������� ������: ");
        int year = scanner.nextInt();

        System.out.print("������� ����� (����� �� 1 �� 12) ���� ���������� ������: ");
        int month = scanner.nextInt();

        System.out.print("������� ���� (����� �� 1 �� 31) ���� ���������� ������: ");
        int day = scanner.nextInt();

        LocalDate lastWateringDate = LocalDate.of(year, month, day);
        LocalDate currentDate = LocalDate.now();
        String message;

        if (currentDate.getMonthValue() == 12 || currentDate.getMonthValue() <= 2) {
            if (currentDate.minusMonths(1).isAfter(lastWateringDate)) {
                message = "������ ����� ������. ������ ������ ������ � ���� ���������� ������" + "(" + lastWateringDate + ").";
            } else {
                message = "������ �� ����� ��������. ������ ������ ������ � ���� ���������� ������" + "(" + lastWateringDate + ").";
            }
        } else if ((currentDate.getMonthValue() <= 5 || currentDate.getMonthValue() >= 9)) {
            message = "������ ����� ������. ������ ������ ������ � ���� ���������� ������ " + "(" + lastWateringDate + ").";
        } else {
            Sensor sensor = new Sensor();
            int humidity = sensor.getHumidity();
            if (humidity < 30) {
                message = "������ ����� ������, ��� ��� ��������� ������� ���� 30% " + "(" + humidity + "%). ���� ���������� ������: "  + lastWateringDate + ".";
            } else if (currentDate.minusDays(2).isAfter(lastWateringDate)) {
                message = "������ ����� ������, ��� ��� ������ ����� ���� ���� � ���� ���������� ������. ���� ���������� ������: "  + lastWateringDate + ".";
            } else {
                message = "������ �� ����� ��������, ��� ��� ��������� ����� ��� ����� ���� ���� �����. ��������� ������� ���������: " + humidity + "%. ���� ���������� ������: "  + lastWateringDate + ".";
            }
        }

        System.out.println(message);
    }
}