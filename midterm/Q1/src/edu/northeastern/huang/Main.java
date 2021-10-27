package edu.northeastern.huang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Book a  = new Reference("referenceBook",10.99,"1999","dic");
        //reference cannot be borrowed
        a.setBorrowDate(20211026);
        a.setReturnDate(20211101);
        System.out.println(a.isAvailable(20211027));


        Book b = new Fiction("Dune",10.99,"1965");
        System.out.println(b.description());
        Book c = new NonFiction("Ironman", 10.99,"1999");
        System.out.println(c.description());
    }
}
