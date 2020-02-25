package driver;


import Ticket.ParkingFeeMachine;
import Ticket.ParkingTicket;
import Ticket.ParkingTicketMachine;
import java.time.Duration;
import java.time.LocalDateTime;
import parking.ParkingLot;
import parking.ParkingSpot;
import vehicle.Vehicle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Customer {
    private Vehicle driving;
    private ParkingTicket parkingTicket;

    public Vehicle getDriving() {
        return driving;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setDriving(Vehicle driving) {
        this.driving = driving;
    }

    public ParkingTicket getParkingTicket(ParkingTicketMachine ptm) {
        if (this.parkingTicket == null) {
            return ptm.getParkingTicket(this,this.driving);
        }
        return this.parkingTicket;
    }

    public ParkingTicket setParkingTicket(ParkingTicket parkingTicket) {
        ParkingTicket prevParkingTicket = this.parkingTicket;
        this.parkingTicket = parkingTicket;
        return prevParkingTicket;
    }

    public ParkingSpot[] parkVehicle(ParkingLot parkingLot) {
        return parkingLot.park(this.parkingTicket, this.driving);

    }

    public ParkingSpot[] removeVehicle(ParkingLot parkingLot, ParkingFeeMachine pfm) {
        this.parkingTicket.setExitTime(LocalDateTime.now().plusHours(
                (int) (Math.random() * 24 + 1))
        );
        long parkedHours = Duration.between(parkingTicket.ENTRY_TIME, parkingTicket.getExitTime()).toHours();
        double cost = payParkingFee(pfm.getParkingFee(parkingTicket));
        System.out.println("Paid " + cost + " bath for parking "
                + this.driving.LICENSE_PLATE + " for " + parkedHours + " hours.");
        return parkingLot.remove(this.parkingTicket, this.driving);
    }

    private double payParkingFee(double parkingFee) {
        return parkingFee;
    }
}
