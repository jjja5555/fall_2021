package edu.northeastern.martin;

public abstract class Moody {
    // Return the mood : sad or happy – depending on which object sends the message
    abstract String getMood();
    // Each Object expresses a different motion
    abstract void ExpressFeelings();

    //an object responds according to how it feels, print ”I feel Happy(or Sad) today!!”
    public void queryMood() {
        if(this.getMood() == "sad"){
            System.out.println("I feel Sad today");
        }else if(this.getMood() == "happy"){
            System.out.println("I feel Happy today");
        }
    }
}
