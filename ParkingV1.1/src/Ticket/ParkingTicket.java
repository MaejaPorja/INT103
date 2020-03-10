/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ticket;

import driver.Customer;
import java.time.LocalDateTime;
import vehicle.Vehicle;

/**
 *
 * @author User
 */
public class ParkingTicket {
    private Customer owner;

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
    
    
    public static int parkingTicketCount;
    public final int PARKING_TICKET_ID;
    public final LocalDateTime ENTRY_TIME;
    private LocalDateTime EXIT_TIME;
    public final Vehicle VEHICLE;
    private boolean exited;

    public int getPARKING_TICKET_ID() {
        return PARKING_TICKET_ID;
    }

    public LocalDateTime getENTRY_TIME() {
        return ENTRY_TIME;
    }

    public LocalDateTime getEXIT_TIME() {
        return EXIT_TIME;
    }

    public Vehicle getVEHICLE() {
        return VEHICLE;
    }

    public ParkingTicket(Customer customer,Vehicle vehicle) {
        this.PARKING_TICKET_ID = ++parkingTicketCount;
        this.ENTRY_TIME = LocalDateTime.now();
        this.VEHICLE = vehicle;
        this.owner = customer;
    }

    public LocalDateTime setExitTime(LocalDateTime time) {
        if (!exited) {
            this.EXIT_TIME = time;
            exited = true;
        }
        return this.EXIT_TIME;
    }

    public LocalDateTime getExitTime() {
        return this.EXIT_TIME;
    }
}
