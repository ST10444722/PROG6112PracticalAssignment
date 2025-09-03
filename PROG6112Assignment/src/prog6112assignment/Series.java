/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog6112assignment;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
*
* @author lab_services_student
*/
/*
* Reference List:
* OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. https://chat.openai.com/chat [Accessed 31 August. 2025]
* Telusko 2023, #77 Exception Handling Using try catch in Java, YouTube video,[Online]. https://www.youtube.com/watch?v=osEjmECD8bI [Acessed: 26 August 2025]
* Route2basics 2018, Using Trim Function in Java, YouTube video.[Online]. https://www.youtube.com/watch?v=anRSu7bvu-E. [Accessed: 26 August 2025]
*Nathan S 2016, Classes Part 9: Helper Methods (Java), YouTube video.[Online]. https://www.youtube.com/watch?v=rXvEx9zPsRg.[Accessed: 29 August 2025]
*Max O'Didily 2023, Java JOptionPane Yes/No Confirm Dialog Box - Get User Input (Simple), YouTube video,[Online]. https://www.youtube.com/watch?v=TFBRiICqLeg [Accessed: 01 September 2025]
*/
public class Series {

    // This is to store all the TV series.
    public ArrayList<SeriesModel> seriesCollection;

    // Constructor
    public Series() {
        this.seriesCollection = new ArrayList<>();
    }

    // The purpose of this method is to  capture a new TV series from the user and add it to the collection.
    public void captureSeries() {
        //Trim() removins any leading or trailing spaces

        String seriesId = JOptionPane.showInputDialog(null, "Enter the Series ID: ").trim();
        String seriesName = JOptionPane.showInputDialog(null, "Enter the Series Name: ").trim();

        int seriesAgeRestriction = 0;
        boolean ageIsValid = false;

        // This will loop until a valid age restriction is entered.
        do {
            //Anywhere you see "try" it will run a block of code, and if something goes wrong, "catch" the error and handle it gracefully instead of letting the program terminate.
            try {
                String ageInput = JOptionPane.showInputDialog(null, "Enter the series age restriction: ");
                if (ageInput == null) {
                    JOptionPane.showMessageDialog(null, "Series creation canceled.");
                    return;
                }
                seriesAgeRestriction = Integer.parseInt(ageInput.trim());

                if (seriesAgeRestriction >= 2 && seriesAgeRestriction <= 18) {
                    ageIsValid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an incorrect age! Please re-enter a valid age restriction ranging between 2-18.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "You have entered an incorrect age. Please re-enter a valid age restriction being a number.");
            }
        } while (!ageIsValid);

        int seriesNumberOfEpisodes = 0;
        boolean episodesAreValid = false;

        // This will loop until a valid number of episodes is entered
        do {
            try {
                String episodesInput = JOptionPane.showInputDialog(null, "Enter the number of episodes for " + seriesName + ":");
                if (episodesInput == null) {
                    JOptionPane.showMessageDialog(null, "The series creation has been canceled.");
                    return;
                }
                seriesNumberOfEpisodes = Integer.parseInt(episodesInput.trim());
                episodesAreValid = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid number of episodes! Please enter a valid number.");
            }
        } while (!episodesAreValid);

        SeriesModel newSeries = new SeriesModel(seriesId, seriesName, seriesAgeRestriction, seriesNumberOfEpisodes);

        this.seriesCollection.add(newSeries);

        JOptionPane.showMessageDialog(null, "The series has been captured successfully!");
    }

    // The purpose of this method is to search for a series by its ID and displays its details.
    public void searchSeries() {
        if (seriesCollection.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No series data was found.");
            return;
        }

        String searchId = JOptionPane.showInputDialog(null, "Enter the series ID to search for the series: ");
        if (searchId == null) {
            return;
        }
        searchId = searchId.trim();

        SeriesModel foundSeries = null;

        // This will loop through the collection to find a matching series
        for (SeriesModel series : seriesCollection) {
            if (series.getSeriesId().equals(searchId)) {
                foundSeries = series;
                break;
            }
        }

        if (foundSeries != null) {
            String details = "Series ID: " + foundSeries.getSeriesId() + "\n"
                    + "Series Name: " + foundSeries.getSeriesName() + "\n"
                    + "Series Age Restriction: " + foundSeries.getSeriesAge() + "\n"
                    + "Series Number Of Episodes: " + foundSeries.getSeriesNumberOfEpisodes();

            JOptionPane.showMessageDialog(null, details);
        } else {

            JOptionPane.showMessageDialog(null, "Series with ID: " + searchId + " was not found!");
        }
    }
    //This method is for updating the details of the series

    public void updateSeries() {
        if (seriesCollection.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There was not series updated.");
            return;
        }
        String updateId = JOptionPane.showInputDialog(null, "Enter series ID to update the series: ");
        if (updateId == null) {
            return;
        }
        SeriesModel foundSeries = null;
        for (SeriesModel series : seriesCollection) {
            if (series.getSeriesId().equals(updateId)) {
                foundSeries = series;
                break;
            }
        }
        if (foundSeries != null) {
            String newSeriesName = JOptionPane.showInputDialog(null, "Enter the new Series Name: ");
            int newAge = 0;
            boolean ageIsValid = false;
            do {
                try {
                    String ageInput = JOptionPane.showInputDialog(null, "Enter new the new age restriction: ");
                    if (ageInput == null) {
                        JOptionPane.showMessageDialog(null, "The series update has been canceled.");
                        return;

                    }

                    newAge = Integer.parseInt(ageInput);
                    if (newAge >= 2 && newAge <= 18) {
                        ageIsValid = true;

                    } else {
                        JOptionPane.showMessageDialog(null, "Invaild age has been entered! Please enter the correct age which ranges between 2-18");

                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invaild age has been entered! Please enter the correct number");
                }
            } while (!ageIsValid);
            int newEpisodes = 0;
            boolean episodesAreValid = false;
            do {
                try {
                    String episodesInput = JOptionPane.showInputDialog(null, "Enter the new number of episodes: ");
                    if (episodesInput == null) {
                        JOptionPane.showMessageDialog(null, "The series update has been canceled.");
                        return;
                    }
                    newEpisodes = Integer.parseInt(episodesInput);
                    episodesAreValid = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid number of episodes! Please enter a valid number.");
                }
            } while (!episodesAreValid);
            //Setters for updating the object
            foundSeries.setSeriesName(newSeriesName);
            foundSeries.setSeriesAge(newAge);
            foundSeries.setSeriesNumberOfEpisodes(newEpisodes);
            JOptionPane.showMessageDialog(null, "Series with ID: " + updateId + " has been updated.");
        } else {
            JOptionPane.showMessageDialog(null, "No series with ID: " + updateId + " was found.");
        }

    }

    // This method is for deleting a series from the collection after the confirmation.
    public void deleteSeries() {
        if (seriesCollection.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There was no series data that was found.");
            return;
        }

        String deleteId = JOptionPane.showInputDialog(null, "Enter the series ID to delete it: ");

        if (deleteId == null) {
            return;
        }

        deleteId = deleteId.trim();

        SeriesModel foundSeries = null;
        for (SeriesModel series : seriesCollection) {
            if (series.getSeriesId().equals(deleteId)) {
                foundSeries = series;
                break;
            }
        }

        if (foundSeries != null) {
            // The purpose of the  JOption Pane.showConfirmDialog  is to ask the user for a confirmation of yes or no
            int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to delete " + foundSeries.getSeriesId()
                    + " from the system?", " Confirm delete.", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                seriesCollection.remove(foundSeries);
                JOptionPane.showMessageDialog(null, "Please note that the series " + deleteId + " has been deleted.");
            } else {
                JOptionPane.showMessageDialog(null, "The process of deleting the series " + deleteId + " has been canceled.");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Series with ID: " + deleteId + " was not found!");
        }
    }

    public void seriesReport() {
        if (seriesCollection.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There was no series data that was found.");
            return;
        }
        //This how the layout of the report will be
        String report = """
                        LATEST SERIES - 2025
                        ***********************************************************
                        
                        Series ID: \t\t\tSeries Name: \t\t\tAge Restriction: \t\t\tEpisodes: \t\t\t***************************************
                        
                        """;
        // This will loop through the collection and add each series to the report string
        for (SeriesModel series : seriesCollection) {
            report += String.format("%-15s", series.getSeriesId())
                    + String.format("%-30s", series.getSeriesName())
                    + String.format("%-20s", series.getSeriesAge())
                    + String.format("%-10s", series.getSeriesNumberOfEpisodes())
                    + "\n";
        }
        // The report will be displayed in a single message dialog
        JOptionPane.showMessageDialog(null, report);
    }

    // This method end  the application
    public void exitApplication() {
        JOptionPane.showMessageDialog(null, "Hope to see you again soon. Goodbye!");
        System.exit(0);
    }
    // These are new helper methods to make the code testable as they perform the core logic without using JOptionPane.

    public SeriesModel findSeriesById(String id) {
        for (SeriesModel s : seriesCollection) {
            if (s.getSeriesId().equals(id)) {
                return s;
            }
        }
        return null;
    }

// Delete a series by ID (used by tests)
    public boolean deleteSeriesById(String id) {
        SeriesModel s = findSeriesById(id);
        if (s != null) {
            seriesCollection.remove(s);
            return true;
        }
        return false;
    }

// Count how many series are stored (used by tests)
    public int getSeriesCount() {
        return seriesCollection.size();
    }

// Validate the age restriction (used by tests)
    public boolean isAgeValid(int age) {
        return age >= 2 && age <= 18;
    }

}
