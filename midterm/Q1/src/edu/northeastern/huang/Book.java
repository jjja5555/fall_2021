package edu.northeastern.huang;

//Class Book:
//        This abstract class should have the following three private data members.
//
//        Fields: String title, double price, String publishYear
//        Book (String title, double price, String publishYear); //Constructor
//        Following are the public methods that this class should provide:
//        Methods: getter and setters
//        Add an abstract method to this class called description that will return a string.
public abstract class Book {
        String title;
        double price;
        String publishYear;
        int borrowDate = 0;
        int returnDate = 0;
    public Book(String title, double price, String publishYear) {
        this.title = title;
        this.price = price;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public abstract String description();

    public abstract void setBorrowDate(int day);
    public abstract void setReturnDate(int day);
    public abstract boolean isAvailable(int day);
}
