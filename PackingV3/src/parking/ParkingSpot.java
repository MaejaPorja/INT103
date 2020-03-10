/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import vehicle.VehicleForParking;

/**
 *
 * @author User
 */
public class ParkingSpot {

    private String parkingSpotId;
    private boolean free;
    private VehicleForParking vehicle;

    public ParkingSpot(String parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
        this.free = true;
    }

    public void assignVehicle(VehicleForParking vehicle) {
        this.vehicle = vehicle;
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }

    public VehicleForParking getVehicle() {
        return vehicle;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.free = true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("ParkingSpot{" + "parkingSpotId=" 
                + parkingSpotId + ":" + "free: " + free);
        if (free == false) {
            str.append(" " + vehicle.toString() + '}');
        }
        return str.toString();
    }

}
