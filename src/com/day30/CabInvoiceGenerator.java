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
 *
 * Step 5 :- Premium Rides (Bonus)
 *          - The cab agency now supports 2 categories of rides :
 *          - Normal Rides : Rs.10 per km, Rs.1 per minute, Minimum fare of Rs.5
 *          - Premium Rides : Rs.15 per km, Rs.2 per minute, Minimum fare of Rs.20
 *
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
     * - Premium Rides (Bonus)
     * - The cab agency now supports 2 categories of rides :
     * - Normal Rides : Rs.10 per km, Rs.1 per minute, Minimum fare of Rs.5
     * - Premium Rides : Rs.15 per km, Rs.2 per minute, Minimum fare of Rs.20
     *
     */

    /**
     * final variables does not change its constant
     */
    private static final double MINIMUM_COST_PER_KILOMETER_NORMAL = 10;
    private static final int COST_PER_TIME_NORMAL = 1;
    private static final double MINIMUM_FARE_NORMAL = 5;
    public static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
    public static final double COST_PER_TIME_PREMIUM = 2;
    public static final double MINIMUM_FARE_PREMIUM = 20;

    /**
     * Create a method name as calculateFare
     * @param distance
     * @param time
     * @param type
     * @return customer type
     */
    public static double calculateFare(double distance, int time, String type) {
        /**
         *  if type is equal to another string normal
         */
        if (type.equalsIgnoreCase("Normal")) {
            /**
             * formula minimum fare normal
             */
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER_NORMAL + time * COST_PER_TIME_NORMAL;
            /**
             * formula minimum fare premium
             */
            return Math.max(totalFare, MINIMUM_FARE_NORMAL);
            /**
             *  if type is equal to another string premium
             */
        } else if (type.equalsIgnoreCase("Premium")) {
            /**
             * formula minimum fare premium
             */
            double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
            /**
             *
             *  Math.max = the larger of a and b.
             */
            return Math.max(totalFare, MINIMUM_FARE_PREMIUM);
            /**
             * suppose 1st and 2nd condition is false then else is executed
             */
        } else {
            /**
             * 2 condition is fails then display this msg
             */
            System.out.println("Please Enter Proper Customer Type");
            return 0.0;
        }
    }

    /**
     * for type - total fare calculate
     * @param rides
     * @param type
     * @return total fare
     */
    public static double calculateFare(Ride[] rides, String type) {
        //variable
        double totalFare = 0.0;
        /**
         * if type is normal
         */
        if (type.equalsIgnoreCase("Normal")) {
            /**
             * using for each loop calculating fare
             */
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);
            }
            /**
             * return total fare
             */
            return totalFare;

            /**
             * if 1st condition was false then check 2nd condition type is comparing to another string
             * premium if they are both are equal then two string are equalIgnore case means its true
             */
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(), type);

            }
            return totalFare;
            /**
             * if upper both condition was fail then else statment execute
             */
        } else
        /**
         * if 1st 2nd condition was false then display this msg
         */
            System.out.println("Please Enter Proper Customer Type");
        return 0.0;
    }

    /**
     * create a method name as calculateTotalFare,this is parameterized method
     * For type- summary invoice
     * @param rides total rides
     * @param type normal ,premium
     * @return invoice summary
     */
    public static InvoiceSummary calculateTotalFare(Ride[] rides, String type) {
        //variable
        double totalFare = 0.0;
        /**
         *  type is comparing to another string
         * premium if they are both are equal then two string are equalIgnore case means its true
         */
        if (type.equalsIgnoreCase("Normal")) {
            /**
             * using for each loop for calculate fare
             */
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(),type);
            }
            /**
             * if 1st condition was false then check 2nd condition type is comparing to another string
             * premium if they are both are equal then two string are equalIgnore case means its true
             */
        } else if (type.equalsIgnoreCase("Premium")) {
            for (Ride ride : rides) {
                totalFare += calculateFare(ride.getDistance(), ride.getTime(),type);
            }
        }
        /**
         * return invoice summary - total fare
         */
        return new InvoiceSummary(rides.length, totalFare);
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