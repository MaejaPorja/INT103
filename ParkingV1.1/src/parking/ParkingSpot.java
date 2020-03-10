/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import Ticket.ParkingTicket;
import vehicle.Vehicle;

/**
 *
 * @author User
 */
//จุดจอดรถ
public class ParkingSpot {

    public static int parkingSpotCount;
    public final int PARKING_SPOT_ID;
    private ParkingSpotStatus spotStatus;
    private ParkingTicket parkingTicket;
    private Vehicle parkedVehicle;

    public ParkingSpot() {
        this.PARKING_SPOT_ID = ++parkingSpotCount;
        this.spotStatus = ParkingSpotStatus.FREE;
    }

    public ParkingSpotStatus getSpotStatus() {
        return this.spotStatus;
    }

    public Vehicle getParkedVehicle() {
        return this.parkedVehicle;
    }

    public ParkingTicket getParkingTicket() {
        return this.parkingTicket;
    }

    public ParkingSpotStatus setSpotStatus(ParkingSpotStatus pss) {
        ParkingSpotStatus prevStatus = this.spotStatus;
        this.spotStatus = pss;
        return prevStatus;
    }
    
    //รถจอดตรงนี้
    public int setParkedVehicle(ParkingTicket parkingTicket, Vehicle vehicle){
        if(vehicle==null){
            this.parkedVehicle = null;
            this.parkingTicket = null;
            this.spotStatus = ParkingSpotStatus.FREE;
            return 0;
        } else if(this.spotStatus==ParkingSpotStatus.FREE){
            this.parkedVehicle = vehicle;
            this.parkingTicket = parkingTicket;
            this.spotStatus = ParkingSpotStatus.FULL;
            return 1;
        } return 2; //มีรถจอดอยู่
    }           
}

