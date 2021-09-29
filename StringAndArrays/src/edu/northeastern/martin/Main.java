package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isPalindron("abcba"));
        pringDayOfTheWeek(-1);
        printMonth("January");
    }

    private static boolean isPalindron(String input){
        if(input == null || input.length() <= 1){
            return true;
        }
        char [] arr = input.toCharArray();
        for(int i = 0; i < arr.length/2;i++){
            if(arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }

    private static boolean areAnagrams(String str1, String str2){

        return false;
    }

    private static void pringDayOfTheWeek(int day){
        switch(day){
            case 0:
                System.out.println("today is monday");
                break;
            case 1:
                System.out.println("today is monday");
                break;
            case 2:
                System.out.println("today is tuesdsay");
                break;
            case 3:
                System.out.println("today is wednesday");
                break;
            case 4:
                System.out.println("today is thursday");
                break;
            case 5:
                System.out.println("today is friday");
                break;
            case 6:
                System.out.println("today is saturday");
                break;
            case 7:
                System.out.println("today is sunday");
                break;
            default:
                System.out.println("invalid day");
                break;
        }
    }

    static void printMonth(String month){
        switch(month){
            case "January":
                System.out.println(month);
                break;
            case "February":
                System.out.println(month);
                break;
            case "March":
                System.out.println(month);
                break;
            case "April":
                System.out.println(month);
                break;
            case "May":
                System.out.println(month);
                break;
            case "June":
                System.out.println(month);
                break;
            case "July":
                System.out.println(month);
                break;
            case "August":
                System.out.println(month);
                break;
            case "September":
                System.out.println(month);
                break;
            case "October":
                System.out.println(month);
                break;
            case "November":
                System.out.println(month);
                break;
            case "December":
                System.out.println(month);
                break;
            default:
                System.out.println("Not a valid month");
                break;
        }
    }

    static void printSeason(String month){
        switch(month){
            case "January", "February", "March":
                System.out.println("Spring");
                break;
            case "April", "May", "June":
                System.out.println("Summer");
                break;
            case "July", "August", "September":
                System.out.println("Fall");
                break;
            case "October", "November", "December":
                System.out.println("Winter");
                break;
            default:
                System.out.println("Not a valid month");
                break;
        }
    }
}
