/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class TestShape {
    public static void main(String[] arge){
        Shape s1 = new Circle(2.0,"red");
        System.out.println(s1.getArea());
        System.out.println(s1.getColor());
        System.out.println(((Circle)s1).getDiameter());
        
        System.out.println("---------------------------------------");
        Shape s2 = new Rectangle("pink",20.0,5.0);
        System.out.println(s2.getColor());
        System.out.println(s2.getArea());
        
   
    }
}
