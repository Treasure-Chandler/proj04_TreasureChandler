/*
 * (Not an honors student so this assignment was optional,
 * but I am deciding to do it anyway)
 * 
 * Treasure Chandler
 * CS 16000-01 – 02/03, Fall Semester 2024
 * Project 4: Parking Management
 * 
 * Description:
 * Represents the manager object, who runs the parking operations
 * The classes functionalities include:
 * • Knowing the garage (this class has a Garage type reference
 *   variable)
 * • Knows the number of cars currently in the garage, the hourly
 *   rate, the running total of collected fees
 * • Aggregates a Random object
 * • Asks the garage to park a car and manage the related messages
 * • Generates a random choice of a parked car to remove from the
 *   garage and can ask the garage to find and remove the selected
 *   car; computes and accumulates the parking fee of the leaving
 *   car
 * • Runs the parking operations as many times as allowed by the
 *   limit
 */

import java.util.*;         // Needed for the Random class
import javax.swing.*;       // Needed for the JOptionPane class

public class Manager {
    // Variables declaration
    Garage garage;
    double FEE_PER_HOUR = 1.50, feeTotal;
    int manyCars;

    /**
     * Parking a new car and parking spot validation
     */
    public void parkACar() {
        // Variables declaration
        int index;
        String title, message;
        
        // Stores the return value of the car's index in "index"
        index = garage.park(new Car());

        // Check if the index is not -1
        if (index != -1) {
            // Figure 4:
            title = "Garage Update";
            message = String.format("A car is arriving at bay #%.1f." + 
                                    "\nThe current garage is displayed " +
                                    "in the console.", index);
            JOptionPane.showMessageDialog(null, message, title,
                                            JOptionPane.INFORMATION_MESSAGE);

            // Update manyCars
            manyCars++;

            // Call displayState()
            garage.displayState();
        } else if (index == -1) {
            // Otherwise, the program terminates if the index isi -1
            // Figures 5 and 7:
            title = "Parking Management";
            message = "The garage is full." + 
                        "\nThe parking process terminates.";
            JOptionPane.showMessageDialog(null, message, title,
                                            JOptionPane.WARNING_MESSAGE);

            System.out.println(String.format("The total parking fee collected " +
                                                "is %.2f.", feeTotal));
            
            System.exit(0);
        }
    } // End of parkACar()

    public void chooseACarToLeave() {
        // Variables declaration
        String title, message;
        Random rd = new Random();
        

        // Check if the garage is empty
        if (manyCars == 0) {
            // Figures 6 and 8:
            title = "Parking Management";
            message = "The garage is empty." +
                        "The parking process terminates.";
            JOptionPane.showMessageDialog(null, message, title,
                                            JOptionPane.WARNING_MESSAGE);

            System.out.println("After 15 parking operations, the process is terminated.");

            System.exit(0);
        } else {
            // A parked car to leave is randomly selected
            int carNum = rd.nextInt(manyCars) + 1;

            // Call findBayOfCar() to find the car's spot
            int index = garage.findBayOfCar(carNum);

            // Call remove() to recieve the elapsed time
            garage.remove(index);

            // Computes the fee
            
        }
    }
} // End of Manager
