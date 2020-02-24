/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.parking;

import org.maejaporja.model.Ticket.ParkingTicket;
import org.maejaporja.model.vehicle.Vehicle;

/**
 *
 * @author NATWORPONGLOYSWAI&NARISRALIMPISIRISANT
 */
public class ParkingLot {
    public int PARKING_LOT_ID;
    private ParkingSpot[][] parkingSpots;
    private final int MAX_PARKING_SPOT_SIZE;
    private int parkedHead;
    
    public ParkingLot(){
        this(10);
    }
    public ParkingLot(int x){
        this(x, 10);
    }
    public ParkingLot(int x, int y){
        if (validateSlotSize(x) && validateSlotSize(y)){
            parkingSpots = new ParkingSpot[x][y];
        } else {
            parkingSpots = new ParkingSpot[10][10];
        } 
        for(int i=0; i<parkingSpots.length; i++){
            for(int j=0; j<parkingSpots[i].length; j++){
                parkingSpots[i][j] = new ParkingSpot();
            }
        }
        MAX_PARKING_SPOT_SIZE = x*y;
    }
    
    public ParkingSpot[][] getParkingSpots(){
        return this.parkingSpots;
    }
    public int getParkedHead(){
        return this.parkedHead;
    }
    
    public int setParkedHead(int newParkedHead){
        int prevParkedHead = this.parkedHead;
        this.parkedHead = newParkedHead;
        return prevParkedHead;
    }
    
    public boolean isFull(){
        return parkedHead==MAX_PARKING_SPOT_SIZE;
    }
    public boolean isParked(ParkingTicket parkingTicket){
        for(int i=0; i<parkingSpots.length; i++){
            for(int j=0; j<parkingSpots[i].length; j++){
                if(parkingTicket==parkingSpots[i][j].getParkingTicket()){
                    return true;
                }
            }
        } return false;
    }
    public void showParkingSpot(){
        for(int i=0; i<parkingSpots.length; i++){
            for(int j=0; j<parkingSpots[i].length; j++){
                System.out.print(
                        parkingSpots[i][j].getSpotStatus()
                            ==
                        ParkingSpotStatus.FREE ? " | O" : " | X"
                );
            } System.out.println(" |");
            System.out.println();
        }
    }
    public ParkingSpot[][] park(ParkingTicket parkingTicket, Vehicle vehicle){
        if(parkingTicket!=null&&!isFull()){
            int x = parkedHead % this.parkingSpots[0].length;
            int y = parkedHead / this.parkingSpots.length;
            int parkedStatus = this.parkingSpots[y][x].setParkedVehicle(parkingTicket, vehicle);
            if(parkedStatus==0){
                this.parkedHead--;
            } else if (parkedStatus==1){
                this.parkedHead++;
            }
        }
        return this.parkingSpots;
    }
    
    private static boolean validateSlotSize(int slotSize){
        return slotSize >= 10 && slotSize <= 100;
    }

    public ParkingSpot[][] remove(ParkingTicket parkingTicket, Vehicle driving) {
        for(int i=0; i<parkingSpots.length; i++){
            for(int j=0; j<parkingSpots[i].length; j++){
                ParkingTicket spotParkingTicket = parkingSpots[i][j].getParkingTicket();
                Vehicle spotParkingVehicle = parkingSpots[i][j].getParkedVehicle();
                if(parkingTicket==spotParkingTicket&&spotParkingVehicle==driving){
                    this.parkingSpots[i][j].setParkedVehicle(null, null);
                    this.parkedHead--;
                }
                //TODO REARRANGE ARRAY
                rearrangeArrayAfterRemove(i, j);
            }
        }
        return this.parkingSpots;
    }
    private void rearrangeArrayAfterRemove(int i, int j){
        //TODO REARRANGE ARRAY
    }
}
