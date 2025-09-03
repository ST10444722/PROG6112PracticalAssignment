/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baobabcafeprog6112assignmentsectionb;

/**
 *
 * @author lab_services_student
 */
public class Order {

    private MenuItem[] items;
    private int itemCount;
    private String name;
    private String surname;
    private String phoneNumber;
    private boolean isPaid;

    // Constructor
    public Order(String name, String surname, String phoneNumber) {
        items = new MenuItem[10];
        itemCount = 0;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.isPaid = false;
    }
//Getters

    public MenuItem[] getItems() {
        return items;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isPaid() {
        return isPaid;
    }
//Setters

    public void setItems(MenuItem[] items) {
        this.items = items;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void addItem(MenuItem item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++; // This increases the count after adding an item
        } else {
            System.out.println("Order is full, cannot add more items.");
        }
    }

    public double calculateTotal() {
        double total = 0.0;

        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice(); 
        }
        return total;
    }

    public String getOrderDetails() {
        String details = "--- Order for: " + name + " " + surname + " ---\n";
        details += "Status: " + (isPaid ? "Paid" : "Unpaid") + "\n\n";
        details += "Items:\n";
        for (int i = 0; i < itemCount; i++) {
            details += (i + 1) + ". " + items[i].getName() + " - R" + items[i].getPrice() + "\n";
        }
        details += "\nTotal: R" + String.format("%.2f", calculateTotal());
        return details;
    }
}
