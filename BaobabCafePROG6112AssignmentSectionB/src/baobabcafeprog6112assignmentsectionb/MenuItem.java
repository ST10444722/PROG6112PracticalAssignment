/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baobabcafeprog6112assignmentsectionb;

/**
 *
 * @author lab_services_student
 */
public class MenuItem {
    private String name;
    private double price;
//Constructer
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
//Gtters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
//Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
