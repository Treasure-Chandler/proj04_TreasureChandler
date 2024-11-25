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
        // Iterate through all of the cars in the garage
        for (int i = 0; i < cars.length; i++) {
            // Print all of the spots in the garage
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

    /**
     * Park the cars in free spots in the garage
     * @param auto      Current car in question
     * @return          A car's specified index
     */
    public int park(Car auto) {
        // Variables declaration
        int takenSpots = 0;

        // Iterate through the parking spots
        for (int i = 0; i < cars.length; i++) {
            if (!isEmpty(i)) {
                /*
                 * If the current spot is not empty, increment
                 * the amount of taken spots
                 */
                takenSpots++;
            } else {
                /*
                 * Otherwise, park the current car and return its
                 * index
                 */
                cars[i] = auto;
                return i;
            }
        }

        // Return -1 if the garage is full
        if (takenSpots == cars.length) {
            return -1;
        }

        // Fallback line so there is still something to return
        return -1;
    } // End of park()

    /**
     * Remove a car from a parking spot
     * @param index     A car's specified index
     * @return          The car's elapsed time at its parking spot
     */
    public double remove(int index) {
        /*
         * "Caution" check if the index is valid and the bay is
         * occupied
         */
        if (index < 0 || index >= cars.length || cars[index] == null) {
            throw new IllegalArgumentException("The index is invalid " +
                                                "or there is no car " +
                                                "at the specified spot.");
        }

        // Get car at the specified index
        Car car = cars[index];

        // Compute the elapsed parking time
        double timeElapsed = car.getTime();

        // Take the car out of the spot
        cars[index] = null;

        // Then return the elapsed time
        return timeElapsed;
    } // End of remove()

    public int findBayOfCar(int carNumber) {
        // Variables declaration
        int index = -1;

        // Iterate up to the provided carNumber
        for (int i = 0; i < carNumber; i++) {
            // Update index
            index++;

            // Skip empty spots
            while (index < cars.length && isEmpty(index)) {
                index++;
            }
        }

        return index;
    } // End of findBayOfCar()
} // End of Garage
