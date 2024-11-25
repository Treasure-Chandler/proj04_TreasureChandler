/*
 * (Not an honors student so this assignment was optional,
 * but I am deciding to do it anyway)
 * 
 * Treasure Chandler
 * CS 16000-01 – 02/03, Fall Semester 2024
 * Project 4: Parking Management
 * 
 * Description:
 * Garage represents the parking garage. This class does the
 * following functions:
 * • Knows a car type array to store Car objects
 * • Uses accessor and mutator methods
 * • Decides if a bay of a given index is empty
 * • Displays the state of occupancy of the garage
 * • Parks a car at the first available index (adding a car to
 *   the array), and notifying the caller (manager) of the index
 * • Removes a car from the array at a given index, and notifies
 *   the manager of the elapsed parking time measured in seconds
 * • Determines the bay index of a randomly selected car currently
 *   in the garage
 */

public class Garage {
    // Variables declaration
    Car[] cars;

    /**
     * Accessor method for the cars in the array
     * @return      Returns the cars in the array
     */
    public Car[] getCars() {
        return cars;
    } // End of getCars()

    /**
     * Mutator method for the cars in the array
     * Adds "auto" to the cars array using the value of "index"
     * @param auto      Cars present
     * @param index     Amount of cars
     */
    public void setCars(Car auto, int index) {
        cars[index] = auto;
    } // End of setCars()

    /**
     * Parking validation
     * @param k     Counter variable
     * @return      If cars at the spot "k" is null
     */
    public boolean isEmpty(int k) {
        return cars[k] == null;
    } // End of isEmpty()

    /**
     * Displays the state of the carage and the status
     * of all of the parking spots
     */
    public void displayState() {
        for (int i = 0; i < cars.length; i++) {
            // Prints all of the spots in the garage
            System.out.print(cars[i] + "\t");
            // Parking spot validation
            if (cars[i] == null) {
                /*
                 * If the parking spot is "null" (empty),
                 * print "E"
                 */
                System.out.print("E + \t");
            } else {
                // Otherwise, print "C"
                System.out.print("C + \t");
            }
        }
    } // End of displayState()

    // public int park(Car auto) {
        
    // }
} // End of Garage
