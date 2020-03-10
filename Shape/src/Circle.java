/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Circle extends Shape {
    
    private double radius;
    
    public Circle(String color) {
        super(color);
    }

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }
    
    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter(){
        return 2*radius;
    }
    

    @Override
    public double getArea(){
      return Math.PI*radius*radius;  
    }
    
    @Override
    public double getPerimeter(){
        return Math.PI*2*radius;
    }
    
    
}
