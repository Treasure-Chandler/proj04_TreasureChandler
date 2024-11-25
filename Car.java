/*
 * (Not an honors student so this assignment was optional,
 * but I am deciding to do it anyway)
 * 
 * Treasure Chandler
 * CS 16000-01 – 02/03, Fall Semester 2024
 * Project 4: Parking Management
 * 
 * Description:
 * Car describes car objects; each car object should know the
 * arrival time for occupying a parking bay
 */

public class Car {
    // Variable declaration
    long timeIn, arrivalTime, departureTime;

    /**
     * Accessor method for the car's elapsed time
     * @return      The car's elapsed time in the garage
     */
    public long getTime() {
        return timeIn;
    } // End of getTime()

    /**
     * Car constructor for storing the car's elapsed time
     * in the garage
     */
    public Car() {
        timeIn = System.currentTimeMillis();
        arrivalTime = System.currentTimeMillis();
        departureTime = System.currentTimeMillis();
    } // End of Car()
} // End of Car 
