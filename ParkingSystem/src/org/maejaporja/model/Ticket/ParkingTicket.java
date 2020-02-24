/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.Ticket;

import java.time.LocalDateTime;
import org.maejaporja.model.vehicle.Vehicle;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class ParkingTicket {
    public static int parkingTicketCount;
    public final int PARKING_TICKET_ID;
    public final LocalDateTime ENTRY_TIME;
    private LocalDateTime EXIT_TIME;
    public final Vehicle VEHICLE;
    private boolean exited;
    
    public ParkingTicket(Vehicle vehicle){
        this.PARKING_TICKET_ID = ++parkingTicketCount;
        this.ENTRY_TIME = LocalDateTime.now();
        this.VEHICLE = vehicle;
    }
    
    public LocalDateTime setExitTime(LocalDateTime time){
        if(!exited) {
            this.EXIT_TIME = time;
            exited = true;
        }
        return this.EXIT_TIME;
    }
    public LocalDateTime getExitTime(){
        return this.EXIT_TIME;
    }
}
