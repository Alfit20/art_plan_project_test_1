package com.company;

import java.util.Scanner;

public class ReverseString {
    private int count;
    private long duration;
    private String reverseString;


    public String getString() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        reverseString = sc.nextLine().strip();
        if(!reverseString.isEmpty()) {
            return reverseString;
        }
        System.out.println("Пустую строку ввести нельзя!");
        return getString();
    }

    public String getReverseString() {
        StringBuilder sb = new StringBuilder(reverseString);
        sb.reverse();
        return sb.toString();
    }

    public long timeMeasurement() {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            getReverseString();
        }
        long stop = System.nanoTime();
        duration = stop - start;
        return duration;
    }

    public void start() {
        while (true) {
           getString();
            System.out.println("Развернутая строка " + getReverseString());
            for (int cntLoop = 1000; cntLoop <= 100000; cntLoop = cntLoop * 10) {
                count = cntLoop;
                timeMeasurement();
                System.out.println("Продолжительность " + count + " циклов = " + duration + " ns");
            }
        }
    }
}
