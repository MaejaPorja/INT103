/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.Ticket;

import java.time.Duration;

/**
 *
 * @author NATWORPONGLOYSWAI&NARISARALIMPISIRISANT
 */
public class ParkingFeeMachine {
    public static int parkingFeeMachineCount;
    public final int PARKING_FEE_MACHINE_ID;
    public final double COST_PER_HOUR;
    
    public ParkingFeeMachine(){
        this.PARKING_FEE_MACHINE_ID = ++parkingFeeMachineCount;
        this.COST_PER_HOUR = 20.0;
    }
    
    public double getParkingFee(ParkingTicket parkingTicket){
        Duration parkedHours = Duration.between(parkingTicket.ENTRY_TIME, parkingTicket.getExitTime());
        return parkedHours.toHours()*COST_PER_HOUR;
    }
}
