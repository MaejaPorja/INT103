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
abstract public class Vehicles {
    private String license_plate;
    private String brand;

    public Vehicles(String license_plate) {
        this.license_plate = license_plate;
    }
   

    public Vehicles(String license_plate, String brand) {
        this.license_plate = license_plate;
        this.brand = brand;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
    
    abstract public void start();
    
    abstract public void stop();    
    public void playSound(){
        System.out.println("บรึ้นนนนนนนน");
    }
}
