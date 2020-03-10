/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public abstract class Shape {
    private String color;
    private String type;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double getArea(){
        return 0;
    }
    
    public double getPerimeter(){
        return 0;
    }

    @Override
    public String toString() {
        return "Shape{" + "color = " + color + " , type = " + type +  '}';
    }
}
