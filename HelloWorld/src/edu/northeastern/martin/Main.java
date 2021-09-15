package edu.northeastern.martin;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hellow World");
        System.out.println("Hellow World");
        System.out.println("Hellow World");
        System.out.println("Hellow World");

        int numStudent = 62;//原生
        Integer numStudents = 62;//封装
        System.out.println(numStudents);
        System.out.println(numStudent);

        int max = Integer.MAX_VALUE;
        max += 1;
        int min = Integer.MIN_VALUE;
        System.out.println(max);
        System.out.println(min);
        char firstC  = '\u00A7';
        System.out.println(firstC);
        System.out.println(firstC+1);

        long myLong = 5L;
        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;
        System.out.println(maxLong);
        System.out.println(minLong);

        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;
        System.out.println(maxByte);
        System.out.println(minByte);



    }
}
