package edu.northeastern.huang;

public class Projector {
    private static Projector _instance;
    private Projector(){}


    private static Object obj = new Object();

    public String name = "Default";

    public static Projector getInstance(){

        if(_instance == null){// Double Locking
            synchronized (obj ){
                if(_instance == null){
                    _instance = new Projector();
                }
            }
        }
        return _instance;
    }

    public static void simpleFunction(int value){
        //Debug.log("sampleUnfction " + "value = " + value + userID);
    }
}
