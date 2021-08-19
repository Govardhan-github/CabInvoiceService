package com.bridgelabz;
public class Ride {
    public double distance;
    public double time;
    /*
    Declaring parametrised constructor
     */
    public Ride(double distance, int time) {
        this.distance=distance;
        this.time=time;
    }
    public Ride(double distance, int time, CabInvoiceGenerator.RideMode rideMode) {
        this.distance = distance;
        this.time = time;
    }
}


