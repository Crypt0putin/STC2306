package org.STC2306;

import java.util.Scanner;

public class LoveMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fenceLength, letterLength, spaceLength, messageLength;

        letterLength = 62; // ����� ���� ����
        spaceLength = 12; // ����� ������ �������
        messageLength = letterLength * 5 + spaceLength * 2; // ����� ���������

        System.out.print("������� ����� ������: ");
        fenceLength = scanner.nextInt();

        if (fenceLength >= messageLength) {
            System.out.println("�� ������ ���������� ��������� � �����!");
        } else {
            System.out.println("�� ������ �� ������ ����� ��� ��������� � �����.");
        }
    }
}