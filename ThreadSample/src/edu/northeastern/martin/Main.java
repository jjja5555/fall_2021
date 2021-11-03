package edu.northeastern.martin;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Thread th = new Thread(new RunnableWithArguments(5));
        th.start();

        Thread th1 = new Thread(new RunnableWithComplex(new Tweet("煮豆燃豆萁，豆在釜中泣。本是同根生，相煎何太急。","elon musk")));
        th1.start();

    }
}
