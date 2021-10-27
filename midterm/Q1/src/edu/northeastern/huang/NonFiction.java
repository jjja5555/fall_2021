package edu.northeastern.huang;

public class NonFiction extends Book implements iBorrowable{
    public NonFiction(String title, double price, String publishYear) {
        super(title, price, publishYear);
    }

    @Override
    public void setBorrowDate(int day) {
        this.borrowDate = day;
    }

    @Override
    public void setReturnDate(int day) {
        this.returnDate = day;
    }

    @Override
    public boolean isAvailable(int day) {
        return (day <= returnDate && day >= borrowDate);
    }

    @Override
    public String description(){
        return "Anne Frank(title) all events are true and based on real facts.";
    }
}
