package edu.northeastern.martin;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DrivingLicenseApplication {
    Date dateOfBirth;

    public DrivingLicenseApplication(Date dateOfBirth) throws AgeException {
        LocalDate today = LocalDate.now();
        Period p = Period.between(dateOfBirth.toLocalDate(),today);
        int age = p.getYears();
        if(age< 16){
            throw new AgeException("\n" + "The age of the applicant is "+age+" which is too early to apply for a driving license");
        }else{
            this.dateOfBirth = dateOfBirth;
            System.out.println("Age passed!");
        }
    }
}
