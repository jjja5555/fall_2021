package edu.northeastern.huang;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Publisher ashishi = new Publisher("ashishi","info5100");

        Student abc = new Student(1,"abc");
        Student mark = new Student(2,"mark");
        Student bob = new Student(3,"bob");
        Student cat = new Student(4,"cat");

        ashishi.addGrade(1,"A");
        ashishi.addGrade(2,"B");
        ashishi.addGrade(3,"C");
        ashishi.addGrade(4,"D");

        mark.subscribe(ashishi);
        abc.subscribe(ashishi);
        bob.subscribe(ashishi);
        cat.subscribe(ashishi);

    }
}
