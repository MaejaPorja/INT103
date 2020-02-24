package org.maejaporja.model;

import java.time.Duration;
import java.time.LocalDateTime;
import org.maejaporja.model.parking.ParkingLot;
import org.maejaporja.model.vehicle.Vehicle;
import org.maejaporja.model.Ticket.*;
import org.maejaporja.model.parking.ParkingSpot;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NATWORPONGLOYSWAI&NARISARALIMPISIRISANT
 */
public class Customer {
    private Vehicle driving;
    private ParkingTicket parkingTicket;
    
    public Customer(){}
    public Customer(Vehicle driving){
        this.driving = driving;
    }
    
    public ParkingTicket getParkingTicket(){
        return this.parkingTicket;
    }
    public ParkingTicket getParkingTicket(ParkingTicketMachine ptm){
        if(this.parkingTicket==null){
            return ptm.getParkingTicket(this.driving);
        }
        return this.parkingTicket;
    }
    public Vehicle getDriving(){
        return this.driving;
    }
    
    public ParkingTicket setParkingTicket(ParkingTicket parkingTicket){
        ParkingTicket prevParkingTicket = this.parkingTicket;
        this.parkingTicket = parkingTicket;
        return prevParkingTicket;
    }
    public Vehicle setDriving(Vehicle driving){
        Vehicle prevDriving = this.driving;
        this.driving = driving;
        return prevDriving;
    }
    
    public ParkingSpot[][] parkVehicle(ParkingLot parkingLot){   
        return parkingLot.park(this.parkingTicket, this.driving);

    }
    public ParkingSpot[][] removeVehicle(ParkingLot parkingLot, ParkingFeeMachine pfm){
        this.parkingTicket.setExitTime(LocalDateTime.now().plusHours(
                (int)(Math.random()*24+1))
        );
        long parkedHours = Duration.between(parkingTicket.ENTRY_TIME,parkingTicket.getExitTime()).toHours();
        double cost = payParkingFee(pfm.getParkingFee(parkingTicket));
        System.out.println("Paid "+cost+" bath for parking "+
                this.driving.LICENSE_PLATE+" for "+parkedHours+" hours.");
        return parkingLot.remove(this.parkingTicket, this.driving);
    }
    private double payParkingFee(double parkingFee){
        return parkingFee;
    }
}
