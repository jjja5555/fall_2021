package edu.northeastern.martin;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"Jinx",3.9, Date.valueOf("1999-01-01")));
        list.add(new Student(2,"Jayce",3.7, Date.valueOf("1990-01-01")));
        list.add(new Student(3,"Vi",2.0, Date.valueOf("1998-01-01")));
        list.add(new Student(4,"Viktor",4.0, Date.valueOf("2001-01-01")));
        //name asc
        list.sort(new NameComparator());
        System.out.println("Name asc:");
        print(list);
        //gpa desc
        System.out.println("GPA desc");
        list.sort(new GpaComparator());
        print(list);
        //DOB asc
        System.out.println("DOB asc");
        list.sort(new DateOfBirthComparetor());
        print(list);
    }

    private static void print(List<Student> list){
        for (Student student : list) {
            System.out.print("ID: "+student.getId()+" ");
            System.out.print("Name: "+student.getName()+" ");
            System.out.print("GPA: "+student.getGpa()+" ");
            System.out.print("DOB: "+student.getDateOfBirth() + " ");
            System.out.println();
        }
        System.out.println();
    }
}
