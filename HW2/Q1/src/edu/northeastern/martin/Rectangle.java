package edu.northeastern.martin;

public class Rectangle extends Shape{
    private int width;
    private int height;

    public Rectangle(int side) {
        super(null,null,4*side,side*side);
        this.width = side;
        this.height = side;
    }

    public Rectangle(int width, int height) {
        super(null,null,2*width + 2* height,width*height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name, String color, int width, int height) {
        super(name,color,2*width + 2* height,width*height);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //Override
    public int getArea(){
        return width*height;
    }

    //Override
    public int getPerimeter(){
        return width*2+height*2;
    }
}
