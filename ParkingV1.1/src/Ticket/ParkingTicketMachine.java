/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import driver.Customer;
import vehicle.Vehicle;

/**
 *
 * @author User
 */
public class ParkingTicketMachine {
    public static int parkingTicketMachineCount;
    public final int PARKING_TICKET_MACHINE_ID;
    
    public ParkingTicketMachine(){
       this.PARKING_TICKET_MACHINE_ID = ++parkingTicketMachineCount; 
    }
    
    public ParkingTicket getParkingTicket(Customer customer,Vehicle vehicle){
        return new ParkingTicket(customer,vehicle);
    }
}
