package edu.northeastern.huang;

public class Student implements ISubscriber{
    private Integer studentID;
    private String name;

    public Student(Integer studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    @Override
    public void getGrades(Publisher publisher, String className, String grade) {
        System.out.println(publisher.getName() +  "has published the grade for class " + className);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public void subscribe (Publisher publisher){
        publisher.addSubscribers(this);
    }


}
