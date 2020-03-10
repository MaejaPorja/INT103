/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author User
 */
public class ParkingTicket {

    private static int runningId;
    private String ticketId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double payedAmount;
    private ParkingTicketStatus ParkingTicketStatus;

    public ParkingTicket() {
       
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void issuedAt() {
        this.ticketId = runningId++ + "A";
        this.entryTime = LocalDateTime.now();
        this.ParkingTicketStatus = ParkingTicketStatus.Active;
    }

    public void payedAt() {
        this.payedAmount = calculateParkingHour();
        this.ParkingTicketStatus=ParkingTicketStatus.Paid;
        System.out.println(toString());
    }

    public double calculateParkingHour() {
        this.setExitTime(LocalDateTime.now().plusHours((int) (Math.random() * 24 + 1)));
        long parkedHour = ChronoUnit.HOURS.between(entryTime, getExitTime());
        return parkedHour * ParkingLot.PARKING_RATE;
    }
    
   

    @Override
    public String toString() {
        return "ParkingTicket{" + "ticketld=" + getTicketId()
                + ", entryTime=" + entryTime
                + ", exitTime=" + exitTime
                + ", payedAmount=" + payedAmount
                + ", ParkingTicketStatus="
                + ParkingTicketStatus + '}';
    }

}
