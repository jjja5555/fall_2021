package edu.northeastern.martin;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner obj = new Scanner(System.in);
        System.out.println("Please enter date of Birth in this format: YYYY-mm-DD");
        try{
            DrivingLicenseApplication  dla = new DrivingLicenseApplication(Date.valueOf(obj.nextLine()));
        }catch (AgeException e){
            System.err.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.err.println("Error, please enter in correct date format: YYYY-mm-DD!");
        }


    }
}
