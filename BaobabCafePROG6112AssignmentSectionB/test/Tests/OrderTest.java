/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import baobabcafeprog6112assignmentsectionb.Drink;
import baobabcafeprog6112assignmentsectionb.Food;
import baobabcafeprog6112assignmentsectionb.MenuItem;
import baobabcafeprog6112assignmentsectionb.Order;
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
public class OrderTest {

    private MenuItem createCoffee() {
        return new Drink("Coffee", 20.00);
    }

    private MenuItem createMuffin() {
        return new Food("Muffin", 25.00);
    }

    // This test is to test that a new order is created with no items and that it is unpaid
    @Test
    public void testOrderInitialization() {
        Order order = new Order("John", "Doe", "1234567890");

        assertFalse("A new order should be unpaid by default.", order.isPaid());
    }

    // This test is for adding items and calculating the total
    @Test
    public void testAddItemsAndCalculateTotal() {
        // Arrange (set up the test)
        Order order = new Order("Jane", "Doe", "0987654321");

        order.addItem(createCoffee());
        order.addItem(createMuffin());

        double total = order.calculateTotal();

        assertEquals("The total price should be 45.00", 45.00, total, 0.001);
    }

    // This test is to test that the payment status can be changed correctly
    @Test
    public void testPaymentStatus() {

        Order order = new Order("Peter", "Pan", "1112223334");

        assertFalse("Order should be unpaid initially.", order.isPaid());

        order.setPaid(true);

        assertTrue("Order should be marked as paid.", order.isPaid());
    }

    // This test is for trying to add more items than the array can hold
    @Test
    public void testOrderCapacity() {
        Order order = new Order("Test", "User", "1234567890");

        for (int i = 0; i < 10; i++) {
            order.addItem(createCoffee());
        }

        order.addItem(createMuffin());

        assertEquals("Order should not add more than 10 items.", 200.00, order.calculateTotal(), 0.001);
    }
}
