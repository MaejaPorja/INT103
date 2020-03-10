/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.util.NoSuchElementException;
import java.util.Objects;
import vehicle.VehicleForParking;

/**
 *
 * @author User
 */
public final class ParkingLot {

    public final static double PARKING_RATE = 20.0;
    private ParkingSpot[] parkingSpots;
    private int count;

    public ParkingLot(int maxCapacity) {
        this.parkingSpots = new ParkingSpot[maxCapacity];
        createParkingSpot();
    }

    public void createParkingSpot() {
        for (int i = 0; i < parkingSpots.length; i++) {
            parkingSpots[i] = new ParkingSpot(i + "Spot");
        }
    }

    public void entryPoint(VehicleForParking vehicle) {
        int availableSpot = getAvailableParkingSpot();
        if (availableSpot == -1) {

            System.out.println("no available parkingspot");
        } else {
            vehicle.assignTicket();
            parkingSpots[availableSpot].assignVehicle(vehicle);
            count++;
        }
    }
    
  
    public void exitPoint(VehicleForParking vehicle) {
        Objects.requireNonNull(vehicle, "exit vehicle cannot be null");
        int foundParkingSpotAt = searchVehicleInParkingSpot(vehicle);
        if (foundParkingSpotAt == -1) {
            throw new NoSuchElementException();
        }
        vehicle.returnTicket();
        parkingSpots[foundParkingSpotAt].removeVehicle();
        count--;
    }

    public int searchVehicleInParkingSpot(VehicleForParking vehicle) {
        Objects.requireNonNull(vehicle, "searning vehicle cannot be null");
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i].isFree() == false) {
                if ((parkingSpots[i].getVehicle()).equals(vehicle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int getAvailableParkingSpot() {
        for (int i = 0; i < parkingSpots.length; i++) {
            if (parkingSpots[i].isFree()) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Parking Lot:\n");
        for (int i = 0; i < parkingSpots.length; i++) {
            str.append(parkingSpots[i] + "\n");
        }
        str.append("available parking spots: " + (parkingSpots.length - count));
        return str.toString();
    }

}
