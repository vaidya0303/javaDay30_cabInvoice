package com.day30;

/**
 *  creating a class name as Ride
 */
public class Ride {

    /**
     * private variables can only be accessed within the same class (an outside class has no access to it)
     * private = restricted access
     * However, it is possible to access them if we provide public get and set methods.
     */


    /**
     * final variable
     */
    private final double distance;
    private final int time;

    /**
     * create constructor name as Ride,this is parameterized constructor
     * @param distance in cab invoice generator 
     * @param time in cab invoice generator
     */
    public Ride(double distance, int time) {

        /**
         *  The "this" keyword is used to refer to the current object.
         */
        this.distance = distance;
        this.time = time;
    }
    /**
     * crete a get method name as getDistance
     * The get method returns the value of the variable
     * @return distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * crete a get method name as getTime
     * The get method returns the value of the variable
     * @return time
     */
    public int getTime() {
        return time;
    }
}