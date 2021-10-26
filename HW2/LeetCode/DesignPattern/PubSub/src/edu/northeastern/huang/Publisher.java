package edu.northeastern.huang;

import java.util.ArrayList;
import java.util.HashMap;

public class Publisher {
    private ArrayList<Student> students;

    private HashMap<Integer,String> grades;

    private String name;
    private String className;

    public Publisher(String name, String className){
        this.name = name;
        this.className = className;
        students = new ArrayList<>();
        grades = new HashMap<>();
    }

    public void notifyGrades(){
        for (Student student: students) {
            student.getGrades(this,this.className,grades.get(student.getStudentID()));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void addGrade(Integer studentID, String grade){
        grades.put(studentID,grade);
    }

    public void addSubscribers(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
    }

}
