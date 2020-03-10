/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicle;

import parking.ParkingTicket;

/**
 *
 * @author User
 */
public class VehicleForParking extends Vehicle {
    private ParkingTicket parkingTicket;

    public VehicleForParking(String licenseNumber,VehicleType type) {
        super(licenseNumber, type);
    }
    //กำหนดบัตร
    public void assignTicket(){
        this.parkingTicket = new ParkingTicket();
        this.parkingTicket.issuedAt();
    }
    
    public void returnTicket(){
        this.parkingTicket.payedAt();
    }

    @Override
    public String toString() {
        return super.toString()+parkingTicket.toString();
    }
    
    

    
    
}
