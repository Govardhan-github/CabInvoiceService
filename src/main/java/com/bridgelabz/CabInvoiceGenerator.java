package com.bridgelabz;
public class CabInvoiceGenerator {
    public  final double MINIMUM_FARE = 5.0;
    public final int MINIMUM_CHARGE_PER_KILOMETER = 10;
    public final double RATE_PER_MIN = 1;
    public RideRepository rideRepository;
    /*
    Declared Enum For Constants
     */
    public enum RideMode {
        NORMAL(10,
                1,
                5.0), 
        PREMIUM(15,
                2,
                20.0);

        private double MINIMUM_CHARGE_PER_KILOMETER;
        private int RATE_PER_MIN;
        private double MINIMUM_FARE;

        RideMode(double MINIMUM_CHARGE_PER_KILOMETER, int RATE_PER_MIN, double MINIMUM_FARE) {
            this. MINIMUM_CHARGE_PER_KILOMETER =  MINIMUM_CHARGE_PER_KILOMETER;
            this.RATE_PER_MIN = RATE_PER_MIN;
            this.MINIMUM_FARE = MINIMUM_FARE;
        }
    }
    public CabInvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }
        /*
         Declaring Calculate Fare Method
         Calculating Fare Using By Formula
         */
        public double calculateFare(double distance, double time) {
            double totalFare = (distance * MINIMUM_CHARGE_PER_KILOMETER) + (time * RATE_PER_MIN);
            if (totalFare < MINIMUM_FARE)
                return MINIMUM_FARE;
            return totalFare;
        }
        /*
      Declaring Calculate Fare Method
      Calculating Fare For Multiple Rides
       */
        public InvoiceSummary calculateFare(Ride[] rides) {
            double totalFare = 0;
            for (Ride ride : rides) {
                totalFare += this.calculateFare(ride.distance, ride.time);
            }
            return new InvoiceSummary(rides.length, totalFare);
        }
        public void addRides(String userId, Ride[] rides) {
            rideRepository.addRides(userId, rides);
        }
        public  InvoiceSummary getInvoiceSummary(String userId) {
            return this.calculateFare(rideRepository.getRides(userId));
        }
    }

