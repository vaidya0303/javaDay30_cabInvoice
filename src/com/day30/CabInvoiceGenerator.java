package com.day30;

/**
 * =============== Cab Invoice Generator ======================
 *
 * The cab service is a subscription based cap service, where the customer books a cab, and
 * pays the bill at the end of the month.
 *
 * Step 1 :- Calculate Fare
 *          - Given Distance and time the invoice generator should return the total fare of journey
 *          - Cost Rs.10 per KM + Rs.1 per minute.
 *          - Minimum Fare - Rs.5
 *
 * Step 2 :- Multiple Ride
 *          - The invoice generator should now take in multiple rides, and calculate the aggregate
 *            total for all
 *
 * Step 3 :- Enhanced Invoice
 *          - The invoice generator should now return the following as a part of the invoice-
 *          - Total Number Of Rides
 *          - Total Fare
 *          - Average Fare Per Ride
 *
 * Step 4 :- Invoice Service
 *          - Given a user id ,the invoice service gets the list of rides from the ride repository,
 *            and return the invoice.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * create a class name as CabInvoiceGenerator
 */
public class CabInvoiceGenerator {

    /**
     * final variable
     */
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    /**
     * create a method name as CalculateFare, this is parameterized method
     * Created a method to calculate the fare of journey
     *
     * @param distance is 5
     * @param time
     * @return total fare
     */
    public double calculateFare(double distance, int time) {
        /**
         * formula for total fare
         */
        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;
        /**
         * if total fare is greater than min fare then
         */
        if (totalFare < MIN_FARE) {
            /**
             * return minimum fare
             */
            return MIN_FARE;
        }
        /**
         * return total fare
         */
        return totalFare;
    }

    /**
     * Creating a parameterized method name as calculateFareForMultipleRides
     * Take a multiple ride and calculate the aggregate total for all
     * @param rides multiple ride
     * @return total fare
     */
    public double calculateFareForMultipleRides(Ride[] rides) {
        // variable
        double totalFare = 0.0;
        /**
         * using for each loop
         */
        for (Ride ride : rides) {
            totalFare = calculateFare(ride.getDistance(), ride.getTime());
        }
        /**
         * return total fare
         */
        return totalFare;
    }

    /**
     * create a method name as invoiceSummaryCalculation
     * @param rides total no of rides
     * @return invoice summaray calculation return total ride
     */
    public InvoiceSummary invoiceSummaryCalculation(Ride[] rides) {
        //variable
        double totalFare = 0.0;
        /**
         * using for each loop for total fare
         */
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        /**
         * return total invoice summary
         */
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * create a method name as getInvoice
     * @param userId given user id
     * @return tatal rides array
     */
    public InvoiceSummary getInvoice(int userId) {
        /**
         * crete a map object
         */
        Map<Integer, Ride[]> map = new HashMap<>();
        /**
         * 1st ride
         */
        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        /**
         * 2nd ride
         */
        Ride[] rides2 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };

        /**
         * 3rd ride
         */
        Ride[] rides3 = {new Ride(8.0, 15),
                new Ride(1, 10)
        };
        /**
         * calling put method from map object
         */
        map.put(1, rides1);
        map.put(2, rides2);
        map.put(3, rides3);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return invoiceSummaryCalculation(ridesArray);
            }
        }
        return null;
    }


    /**
     * create a main method ,all program execute in main method
     * @param args no arguments
     */
    public static void main(String[] args) {
        /**
         * create object for CabInvoiceGenerator class, object name is cabInvoiceGenerator
         */
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        /**
         * calling CalculateFare method from cabInvoiceGenerator object
         * and print o/p
         */
        System.out.println(cabInvoiceGenerator.calculateFare(5, 20) + " Rs");

        /**
         * rides array = distance,time
         */
        Ride[] ridesArray = {
                new Ride(0.1,1),
                new Ride(1,1),
                new Ride(1,10)
        };
        /**
         * calling getInvoice method from cabInvoiceGenerator object
         */
        cabInvoiceGenerator.getInvoice(1);
    }
    }