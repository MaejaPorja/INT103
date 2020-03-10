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
public class Jet extends Vehicles {
    
    public Jet(String license_plate, String brand) {
        super(license_plate, brand);
    }
    
    @Override
     public void start(){
        System.out.println("                 _/___            ");
        System.out.println("          _____/______|           ");
        System.out.println("_______/_____\\_______\\_____ ");
        System.out.println("\\              < < <       |");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
      @Override
    public void stop(){
    System.out.println("Stop!!!");
    }
}
             