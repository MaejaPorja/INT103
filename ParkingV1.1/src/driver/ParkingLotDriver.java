/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import Ticket.ParkingFeeMachine;
import Ticket.ParkingTicket;
import Ticket.ParkingTicketMachine;
import parking.ParkingLot;
import vehicle.Car;
import vehicle.Vehicle;

/**
 *
 * @author User
 */
public class ParkingLotDriver {
    public static void showTicket(ParkingTicket pt){
        System.out.println("-------------------PARKING TICKET-------------------");
        System.out.println("No."+pt.PARKING_TICKET_ID);
        System.out.println("License plate : "+pt.VEHICLE.LICENSE_PLATE);
        System.out.println("owner : "+pt.getOwner());
        System.out.println("Vehicle : "+pt.VEHICLE);
        System.out.println("Entry time : "+pt.ENTRY_TIME);
        System.out.println("ExitTime : "+pt.getEXIT_TIME());
        System.out.println("----------------------------------------------------");
        System.out.println("");
    }
    public static void main(String[] args){
        ParkingTicketMachine ptm = new ParkingTicketMachine();
        ParkingFeeMachine pfm = new ParkingFeeMachine();
        
        ParkingLot pl = new ParkingLot();
        //-------------------------------------------------------------------------------------
        Vehicle c1 = new Car();
        Customer cu1 = new Customer();
        
        //-------------------------------------------------------------------------------------
        cu1.setDriving(c1);
        cu1.setParkingTicket(cu1.getParkingTicket(ptm));
        showTicket(cu1.getParkingTicket());
        cu1.parkVehicle(pl);
        pl.showParkingSpot();
        cu1.removeVehicle(pl, pfm);
        showTicket(cu1.getParkingTicket());
        
    }
}
