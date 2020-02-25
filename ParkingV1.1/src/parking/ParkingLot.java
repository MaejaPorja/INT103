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
//ลานจอดรถ
public class ParkingLot {

    public int PARKING_LOY_ID;
    private ParkingSpot[] parkingSpots;
    private final int MAX_PARKING_SPOT_SIZE;
    private int parkedHead; //รถคันล่าสุด

    public ParkingLot() {
        this(10);
    }

    public ParkingLot(int x) {
        if (validateSlotSize(x)) {
            parkingSpots = new ParkingSpot[x];
        } else {
            parkingSpots = new ParkingSpot[10];
        }
        for (int i = 0; i < parkingSpots.length; i++) {
            parkingSpots[i] = new ParkingSpot();
        }
        MAX_PARKING_SPOT_SIZE = x;
    }

    public ParkingSpot[] getParkingSpot() {
        return parkingSpots;
    }

    public int getParkedHead() {
        return parkedHead;
    }

    public boolean isFull() {
        return parkedHead == MAX_PARKING_SPOT_SIZE;
    }

    public void showParkingSpot() {
        for (int i = 0; i < parkingSpots.length; i++) {
            System.out.print(
                    parkingSpots[i].getSpotStatus()
                    == ParkingSpotStatus.FREE ? " | O" : " | X"
            );
        }
        System.out.print(" |");
        System.out.println();
    }

    public ParkingSpot[] park(ParkingTicket parkingTicket, Vehicle vehicle) {
        if (parkingTicket != null && !isFull()) {
            int x = parkedHead;
            int parkedStatus = this.parkingSpots[x].setParkedVehicle(parkingTicket, vehicle);
            if (parkedStatus == 1) {
                this.parkedHead++;
            }
        }
        return this.parkingSpots;
    }

    private static boolean validateSlotSize(int slotSize) {
        return slotSize >= 10 && slotSize <= 30;
    }

    public ParkingSpot[] remove(ParkingTicket parkingTicket, Vehicle driving) {
        for (int i = 0; i < parkingSpots.length; i++) {
            ParkingTicket spotParkingTicket = parkingSpots[i].getParkingTicket();
            Vehicle spotParkingVehicle = parkingSpots[i].getParkedVehicle();

            if (parkingTicket == spotParkingTicket && spotParkingVehicle == driving) {
                this.parkingSpots[i].setParkedVehicle(null, null);
                this.parkedHead--;
            }
        }
        return this.parkingSpots;
    }
}
