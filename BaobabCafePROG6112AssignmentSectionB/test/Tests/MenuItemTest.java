/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import baobabcafeprog6112assignmentsectionb.Drink;
import baobabcafeprog6112assignmentsectionb.Food;
import baobabcafeprog6112assignmentsectionb.MenuItem;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
/*
 * Reference List:
 *  OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. https://chat.openai.com/chat [Accessed 03 September. 2025]
*qanilq (2013) JUnit Test Suite - Grouping multiple test cases. [Online].Available at: https://www.youtube.com/watch?v=GMQsIVRpl98 [Accessed: 03 September 2025]
*IIE. (2016). Login and Registration System using Java - Part 4 [YouTube Video].
 */
public class MenuItemTest {

// This test is used to test the MenuItem constructor and the getter methods
    @Test
    public void testMenuItemCreation() {

        MenuItem coffee = new MenuItem("Coffee", 20.00);

        assertEquals("The name should be 'Coffee'", "Coffee", coffee.getName());
        assertEquals("The price should be 20.00", 20.00, coffee.getPrice(), 0.001); // The delta is required for double comparison
    }

    // This tests the Drink class
    @Test
    public void testDrinkInheritance() {

        Drink espresso = new Drink("Espresso", 20.00);

        // This checks if it inherits the getName() and getPrice() methods correctly
        assertEquals("The name should be 'Espresso'", "Espresso", espresso.getName());
        assertEquals("The price should be 20.00", 20.00, espresso.getPrice(), 0.001);
    }

    // This tests the Food class
    @Test
    public void testFoodInheritance() {

        Food muffin = new Food("Muffin", 25.00);

        // This checks if it inherits the getName() and getPrice() methods correctly
        assertEquals("The name should be 'Muffin'", "Muffin", muffin.getName());
        assertEquals("The price should be 25.00", 25.00, muffin.getPrice(), 0.001);
    }
}
