/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starto;

/**
 *
 * @author User
 */
public class Driver {

    public static void main(String[] agre) {
        Vehicles v1 = new Car("V001", "LULU", 4);
        v1.start();
        v1.playSound();
        v1.stop();
        System.out.println("-------------------------------------------");
        Vehicles v2 = new Motorcycle("v002","MoMo");
        v2.start();
        v2.playSound();
        v2.stop();
        System.out.println("-------------------------------------------");
        Vehicles v3 = new Jet("v003","DDs");
        v3.start();
        v3.playSound();
        v3.stop();
        
    }
    

}
