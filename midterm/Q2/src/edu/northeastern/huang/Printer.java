package edu.northeastern.huang;

public class Printer {
    private static Printer _instanceOf;
    private Printer() {

    }
    public static Printer getInstance() {
        if(_instanceOf == null){
            _instanceOf = new Printer();
        }
        return _instanceOf;

    }

    public void getConnection() {
        System.out.println("Your Printer is working");
    }
}
