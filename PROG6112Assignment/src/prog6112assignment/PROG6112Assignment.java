/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog6112assignment;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 */
/*
 * Reference:
 *  Telusko 2023, #77 Exception Handling Using try catch in Java, YouTube video,[Online]. https://www.youtube.com/watch?v=osEjmECD8bI [Accessed: 26 August 2025]
 */
public class PROG6112Assignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Instantiating class
        Series seriesManager = new Series();

        int choice = 0;
        do {
            //Display the menu choice that the user should use to choose from 
            String menu = """
                  LATEST SERIES - 2025
                  ************************************** 
                  
                  Please select one of the following menu items:
                  (1) Capture a new series.
                  (2) Search for a series.
                  (3) Update series age restriction.
                  (4) Delete a series.
                  (5) Display the series report for 2025
                  (6) Exit Application.""";
            String input = JOptionPane.showInputDialog(null, menu);
            if (input == null) {
                choice = 6;
            } else {
                //Anywhere you see "try" it will run a block of code, and if something goes wrong, "catch" the error and handle it gracefully instead of letting the program terminate.
                try { 
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number from the menu.");
                    choice = 0; //It will loop again when choice is set to 0
                }
                switch (choice) {
                    case 1 ->
                        seriesManager.captureSeries();
                    case 2 ->
                        seriesManager.searchSeries();
                    case 3 ->
                        seriesManager.updateSeries();
                    case 4 ->
                        seriesManager.deleteSeries();
                    case 5 ->
                        seriesManager.seriesReport();
                    case 6 ->
                        seriesManager.exitApplication();
                    default ->
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please input numbers between 1-6.  Thank You :)");
                }
            }
        } while (choice != 6);
    }
}
