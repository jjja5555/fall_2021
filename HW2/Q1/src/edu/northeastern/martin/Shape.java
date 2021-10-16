package edu.northeastern.martin;

public class Shape {
    private String name;
    private String color;
    private int perimeter;
    private int area;

    public Shape(String name, String color){
        this.name = name;
        this.color = color;
    }

    public Shape(String name, String color, int perimeter, int area) {
        this.name = name;
        this.color = color;
        this.perimeter = perimeter;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(int perimeter) {
        this.perimeter = perimeter;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String printShape(){
        if(this.name == null){
            return "This Shape has no name, please assign it by using setName(String) method and try again!";
        }else if(this.color == null){
            return "This Shape has no color, please assign it by using setColor(String) method and try again!";
        }
        return "The " + this.name + " has a " + this.color + " color";
    }
}
