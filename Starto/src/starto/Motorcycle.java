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
public class Motorcycle extends Vehicles {
    private int wheel;
    
    public Motorcycle(String license_plate, String brand,int wheel) {
        super(license_plate, brand);
        this.wheel = wheel;
    }
    public Motorcycle(String license_plate, String brand) {
        super(license_plate, brand);
    }
     public int getWheel() {
        return wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }
    
    @Override
   public void start(){
        System.out.println(".......,_oo");
        System.out.println(".....-/c-//:: ");
        System.out.println("....(_)'==(_)");
    }
   
    @Override
   public void playSound(){
       System.out.println("แว๊นนนนนนน");
   }
    @Override
    public void stop(){
    System.out.println("Stop!!!");
    }
}
