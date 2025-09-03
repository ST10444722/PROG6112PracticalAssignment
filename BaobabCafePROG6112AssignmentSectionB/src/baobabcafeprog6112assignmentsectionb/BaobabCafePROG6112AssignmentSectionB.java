/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baobabcafeprog6112assignmentsectionb;

import javax.swing.JOptionPane;

/**
 *
 * @author lab_services_student
 * 
 * */
/*
*Keep On Coding (2022) 7 Must Know Java Array Methods. [Online]. Available from: http://www.youtube.com/watch?v=86B96Fy6j6U [Accessed: 03 September 2025].
7 Must Know Java Array Methods
*Bro Code (2020) Java inheritance. [Online video]. Available from: http://www.youtube.com/watch?v=Zs342ePFvRI [Accessed: 03 September 2025].
Java inheritance 
*Merlin Wellington (2020) Stage 5 #1 Information Hiding. [Online video]. Available from: http://www.youtube.com/watch?v=BD0I9o9RF8o [Accessed: 03 September 2025].
*  OpenAI. (2023). ChatGPT (Mar 14 version) [Large language model]. https://chat.openai.com/chat [Accessed 01 September. 2025]
 */
public class BaobabCafePROG6112AssignmentSectionB {

    /**
     * @param args the command line arguments
     */
    // This is an array to store all available menu items
    private static final MenuItem[] fullMenu = {
        new Drink("Coffee", 20.00),
        new Drink("Espresso", 20.00),
        new Drink("Cappuccino", 30.00),
        new Food("Croissant", 28.00),
        new Food("Muffin", 25.00),
        new Food("Toasted Cheese & Tomato", 55.00)
    };
    // This is an array to store all orders placed by customers
    private static final Order[] allOrders = new Order[50];
    private static int orderCount = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Baobab Café!");
// These are the menu options that the user can pick from
        int userChoice;
        do {
            String menuMessage = """
                                     Please select an option: 
                                     
                                     1. Place a new order
                                     2. View unpaid orders
                                     3. Exit""";
            String input = JOptionPane.showInputDialog(menuMessage);
            //The if-statement is to show the user's chosen action
            if (input == null) {
                userChoice = 3;
            } else {
                try {
                    userChoice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                    userChoice = 0;
                }
            }

            switch (userChoice) {
                case 1 ->
                    placeNewOrder();
                case 2 ->
                    viewUnpaidOrders();
                case 3 ->
                    JOptionPane.showMessageDialog(null, "Thank you for using the Baobab Café App. Hope to see you soon. Goodbye!");
                default ->
                    JOptionPane.showMessageDialog(null, "Invalid choice! Try again.");
            }
            // The loop will continue as long as the user does not choose to exit the program
        } while (userChoice != 3);
    }
//This method is for handling the process of placing a new order
    private static void placeNewOrder() {
        if (orderCount >= allOrders.length) {
            JOptionPane.showMessageDialog(null, "Sorry to inform you but we can't take any more orders right now.");
            return;
        }

        String name = JOptionPane.showInputDialog(null, "Enter your name: ");
        String surname = JOptionPane.showInputDialog(null, "Enter your surname: ");
        String phone;
        // I made use of the while-loop to ensure the phone number is in the correct format
        while (true) {
            phone = JOptionPane.showInputDialog(null, "Enter your phone number including an international code: ");
            if (phone == null) {
                return;
            }
            // This is a regex pattern which checks for a '+' then followed by 10 to 15 digits depending on the country
            if (phone.matches("^\\+\\d{10,15}$")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Error!!Invalid phone number format. Phone number must start with '+' and include 10-15 digits.");
            }
        }

        Order newOrder = new Order(name, surname, phone);
        boolean addingItems = true;
        //I made use of a while loop to add items to the order.
        while (addingItems) {
            String menuMessage = "Please select an item to add to your order: \n\n";
            for (int i = 0; i < fullMenu.length; i++) {
                menuMessage += (i + 1) + ". " + fullMenu[i].getName() + "(R" + fullMenu[i].getPrice() + "  )\n";
            }
            menuMessage += "\nType 'Place Order' to pay for your order.";
            String userChoice = JOptionPane.showInputDialog(null, menuMessage);
            if (userChoice == null || userChoice.equalsIgnoreCase("Place Order")) {
                addingItems = false;
            } else {
                //Anywhere you see "try" it will run a block of code, and if something goes wrong, "catch" the error and handle it gracefully instead of letting the program terminate.
                try {
                    int choiceIndex = Integer.parseInt(userChoice) - 1;
                    if (choiceIndex >= 0 && choiceIndex < fullMenu.length) {
                        newOrder.addItem(fullMenu[choiceIndex]);
                        JOptionPane.showMessageDialog(null, fullMenu[choiceIndex].getName() + " has been added.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid selection!!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input!!");
                }
            }
        }

        allOrders[orderCount] = newOrder;
        orderCount++;
        JOptionPane.showMessageDialog(null, "Your order has been successfully placed!");
    }
//This method is to display a list of all unpaid orders and allow the user to pick which order they want to pay for
    private static void viewUnpaidOrders() {
        String unpaidOrdersMessage = "----------  Unpaid Orders ----------\n\n";
        boolean foundUnpaid = false;
        for (int i = 0; i < orderCount; i++) {
            if (!allOrders[i].isPaid()) {
                unpaidOrdersMessage += (i + 1) + " . " + allOrders[i].getName() + "  " + allOrders[i].getSurname() + "\n";
                foundUnpaid = true;
            }
        }
        if (!foundUnpaid) {
            JOptionPane.showMessageDialog(null, "There are no unpaid orders.");
        } else {
            String choiceString = JOptionPane.showInputDialog(null, unpaidOrdersMessage + "'\nType the number of the order you want to pay for, or cancel to go back");
            if (choiceString != null && !choiceString.equalsIgnoreCase("cancel")) {
                try {
                    int choiceIndex = Integer.parseInt(choiceString) - 1;
                    if (choiceIndex >= 0 && choiceIndex < orderCount && !allOrders[choiceIndex].isPaid()) {
                        processPayment(allOrders[choiceIndex]);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid selection");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        }
    }
//This method is about the payment process for a given order which also includes the input validation
    private static void processPayment(Order order) {
        JOptionPane.showMessageDialog(null, order.getOrderDetails());
        JOptionPane.showMessageDialog(null, "Please enter your payment details: ");
        String cardNumber;
        // I used the while loop to ensure a valid 16-digit card number has been entered
        while (true) {
            cardNumber = JOptionPane.showInputDialog(null, "Enter card number: ");
            if (cardNumber == null) {
                return;
            }
            if (cardNumber.matches("\\d{16}")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number entered! Number must be 16 digits long.");
            }
        }
        String CVC;
        // I used a while loop to ensure a valid 3-digit CVC has been entered
        while (true) {
            CVC = JOptionPane.showInputDialog(null, "Enter your CVC number: ");
            if (CVC == null) {
                return;
            }
            if (CVC.matches("\\d{3}")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid CVC! Number must be 3 digits");
            }
        }

        String expiryDate;
        // I used a while loop to ensure a valid expiry date in the MM/YY format has been entered
        while (true) {
            expiryDate = JOptionPane.showInputDialog(null, "Enter the expiry date of the card in this format MM/YY: ");
            if (expiryDate == null) {
                return;
            }
            if (expiryDate.matches("(0[1-9]|1[0-2])/\\d{2}")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid expiry date! It should be a month and year entered from the card.");
            }
        }

        String cardholderName = JOptionPane.showInputDialog(null, "Enter the cardholder 's name: ");
        order.setPaid(true);
        // Once the order is set as paid it will display this message then go back to the start of the program
        JOptionPane.showMessageDialog(null, "Payment is successful. Please check for an SMS we just send thefor order number you will provide at the till, Thank You :)");
    }
}
