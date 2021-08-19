package com.bridgelabz;
/*
Importing Packages
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class InvoiceCabTest {
    /*
    Test Methods To To Calculate Fares
    By Using Time And Distances
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25, fare, 0.0);
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(5, fare, 0.0);
    }
    /*
    UC2 And Uc3
    Test Method To Calculate Fare
    For Multiple Rides
     */
    @Test
    public void givenMultipleRides_ShouldReturnTotalfare() {
        CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                         new Ride(0.1, 1) };

        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    /*
    //UC4
    Invoice Services By User Id
     */
    @Test
    public void givenUserIdAndMultipleRides_ShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
        String userId = "gopi@gmail.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1) };
        cabInvoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,30);
        Assertions.assertEquals(expectedInvoiceSummary,summary);
    }
    /*
    //UC5
    Test Method For Premium Rides
     */
    @Test
    public void givenUserIdAndRides_ShouldReturn_MultipleInvoiceSummary() {
        CabInvoiceGenerator cabInvoiceGenerator= new CabInvoiceGenerator();
        String userId = "gopi@gmail.com";;
        Ride[] rides = { new Ride(2.0, 5, CabInvoiceGenerator.RideMode.NORMAL), new Ride(0.1, 1, CabInvoiceGenerator.RideMode.NORMAL) };
        cabInvoiceGenerator.addRides(userId, rides);
        Ride[] rides1 = { new Ride(2.0, 5, CabInvoiceGenerator.RideMode.PREMIUM), new Ride(0.1, 1, CabInvoiceGenerator.RideMode.PREMIUM) };
        cabInvoiceGenerator.addRides(userId, rides1);
        Ride[] rides2 = { new Ride(2.0, 5, CabInvoiceGenerator.RideMode.NORMAL), new Ride(0.1, 1, CabInvoiceGenerator.RideMode.PREMIUM) };
        cabInvoiceGenerator.addRides(userId, rides2);
        InvoiceSummary summary = cabInvoiceGenerator.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(6, 125);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }
}