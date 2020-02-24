/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.maejaporja.model.vehicle;

/**
 *
 * @author NATWORPONGLOYSWAI
 */
public class Vehicle {
    public static int vehicleCount;
    public final String LICENSE_PLATE;
    
    public Vehicle(){
        LICENSE_PLATE = "VEHICNO_"+vehicleCount++;
    }
}
