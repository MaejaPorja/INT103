/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.driver;

import org.maejaporja.model.Customer;
import org.maejaporja.model.Ticket.ParkingFeeMachine;
import org.maejaporja.model.Ticket.ParkingTicketMachine;
import org.maejaporja.model.parking.ParkingLot;
import org.maejaporja.model.vehicle.Truck;
import org.maejaporja.model.vehicle.Vehicle;

/**
 *
 * @author NATWORPONGLOYSWAI&NARISARALIMPISIRISANT
 */
public class ParkingLotDriver {
    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot();
        Vehicle v1 = new Truck();
        
        ParkingTicketMachine ptm = new ParkingTicketMachine();
        ParkingFeeMachine pfm = new ParkingFeeMachine();
        
        Customer cu = new Customer();
        cu.setDriving(v1);
        cu.setParkingTicket(cu.getParkingTicket(ptm));
        cu.parkVehicle(pl);
        pl.showParkingSpot();
        cu.removeVehicle(pl, pfm);
    }
}
