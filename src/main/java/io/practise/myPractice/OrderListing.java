package io.practise.myPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderListing {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        // Create customers and their orders
        Customer customer1 = new Customer("Alice");
        customer1.addOrder(new Order("Laptop"));
        customer1.addOrder(new Order("Mouse"));
        customers.add(customer1);

        Customer customer2 = new Customer("Bob");
        customer2.addOrder(new Order("Keyboard"));
        customer2.addOrder(new Order("Monitor"));

        customer2.addOrder(new Order("Test1"));

        customers.add(customer2);

        Customer customer3 = new Customer("Charlie");
        customer3.addOrder(new Order("Printer"));

        customers.add(customer3);


        System.out.println(Stream.of(customer1, customer2, customer3).flatMap(customer -> customer.getOrders().stream().map(eachItem -> eachItem.getName())).collect(Collectors.toList()));


        //output: Laptop, Mouse, Keyboard, Monitor, Printer


    }
}

class Customer {
    private List<Order> orders = new ArrayList<>();
    private String name;

    Customer(String name) {
        this.name = name;
    }


    public void addOrder(Order printer) {
        this.orders.add(printer);
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}

class Order {
    private String name;

    Order(String orderName) {
        this.name = orderName;
    }

    public String getName() {
        return this.name;
    }

}