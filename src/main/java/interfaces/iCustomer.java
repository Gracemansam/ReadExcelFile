package main.java.interfaces;

import main.java.models.Customer;
import main.java.models.Product;

import java.util.HashMap;

public interface iCustomer {

    boolean checkDuplicate(String productId, HashMap<String, Product> cart);

    Product findProduct(String productKey, HashMap<String, Product> cart);

    String addToCart(String productToBeAdded, int quantityToAdd, HashMap<String, Product> inventory, Customer customer);

    String buyProduct(Customer customer);
}
