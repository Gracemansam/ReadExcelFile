package main.java.models;

import main.java.services.CashierServiceImplementation;
import main.java.utility.Inventory;
import models.Product;
//import utility.Inventory;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        Inventory inventory = new Inventory();
        CashierServiceImplementation service = new CashierServiceImplementation();
        for (Map.Entry<String , Product> inventor : inventory.getBarsCategory().entrySet()){
                System.out.println(inventor.getValue());
        }
        Cashier cashier = new Cashier("bb" , "Vincent" , "24");
        Customer customer = new Customer("bb" , "Vincent" , "Lagos" , 5000);
        service.addToCart("P244" , 23, inventory.getBarsCategory(), customer);
        service.addToCart("P244" , 23, inventory.getBarsCategory(), customer);
        service.addToCart("P243" , 15, inventory.getBarsCategory(), customer);
        service.addToCart("P244" , 23, inventory.getBarsCategory(), customer);
        service.buyProduct(customer);
        System.out.println(customer.getCart());

    }

}
