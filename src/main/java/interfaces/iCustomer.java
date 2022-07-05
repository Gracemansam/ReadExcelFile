package main.java.interfaces;

import main.java.models.Customer;

import java.util.HashMap;

public interface iCustomer {

    boolean checkDuplicate(String productId, HashMap<String, models.Product> cart);

    models.Product findProduct(String productKey, HashMap<String, models.Product> cart);

    String addToCart(String productToBeAdded, int quantityToAdd, HashMap<String, models.Product> inventory, Customer customer);

    String buyProduct(Customer customer);
}
