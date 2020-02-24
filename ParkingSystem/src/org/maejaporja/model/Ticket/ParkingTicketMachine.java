/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.Ticket;

import org.maejaporja.model.vehicle.Vehicle;

/**
 *
 * @author NATWORPONGLOYSWAI&NARISARALIMPISIRISANT
 */
public class ParkingTicketMachine {
    public static int parkingTicketMachineCount;
    public final int PARKING_TICKET_MACHINE_ID;
    
    public ParkingTicketMachine(){
       this.PARKING_TICKET_MACHINE_ID = ++parkingTicketMachineCount; 
    }
    
    public ParkingTicket getParkingTicket(Vehicle vehicle){
        return new ParkingTicket(vehicle);
    }
}
