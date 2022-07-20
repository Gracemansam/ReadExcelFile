package test;
import main.java.base.User;
import main.java.models.Customer;
import main.java.models.CustomerCompare;
import main.java.models.Product;
import main.java.services.CashierServiceImplementation;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceImplementationTest {

    CashierServiceImplementation cashier;
    Customer customer;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
       cashier  = new CashierServiceImplementation();
       customer = new Customer("ID" , "Vincent" , "Lagos" , 7000);
    }



    @org.junit.jupiter.api.Test
    void checkDuplicate_true() {

        HashMap<String , Product> testCart = new HashMap<>();
        testCart.put("Sugar" , new Product("P244" , "Brans" , "Cookies", 10 ,1.98));
        boolean actual = cashier.checkDuplicate("p244" , testCart);
        boolean expected = true;
        assertEquals(expected , actual);
    }

    @Test
    void checkDuplicate_false() {

        HashMap<String , Product> testCart = new HashMap<>();
        testCart.put("Sugar" , new Product("P244" , "Brans" , "Cookies", 10 ,1.98));
        boolean actual = cashier.checkDuplicate("p243" , testCart);
        boolean expected = false;
        assertEquals(expected , actual);
    }

    @org.junit.jupiter.api.Test
    void findProduct_real_product() {
        HashMap<String , Product> testCart = new HashMap<>();
        Product product = new Product("P244" , "Brans" , "Cookies", 10 ,1.98);
        testCart.put("Brans" , product);

        var actual = cashier.findProduct("Brans" , testCart);
        assertEquals(product , actual);
    }

    @org.junit.jupiter.api.Test
    void findProduct_null_product() {
        HashMap<String , Product> testCart = new HashMap<>();
        Product product = new Product("P244" , "Brans" , "Cookies", 10 ,1.98);
        testCart.put("Sugar" , product);
        var actual = cashier.findProduct("Brans" , testCart);
        Product expected = null;
        assertNull(actual);
    }

    @org.junit.jupiter.api.Test
    void addToCart_Product_Not_Found() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
        testInventory.put("Sugar" , product);

        var actual = cashier.addToCart("p243" , 20 , testInventory, customer);
        var expected = "NotFound";
        assertEquals(expected , actual);
    }

    @Test
    void addToCart_Product_Updated() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
        testInventory.put("Sugar" , product);
        cashier.addToCart("p244" , 2 , testInventory, customer);
        var actual = cashier.addToCart("p244" , 2 , testInventory, customer);
        var expected = "Updated";
        assertEquals(expected , actual);
    }

    @Test
    void addToCart_Product_Added() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
       testInventory.put("Sugar" , product);
      //  cashier.addToCart("p244" , 2 , testInventory, customer);
        var actual = cashier.addToCart("p244" , 2 , testInventory, customer);
        var expected = "Added";
        assertEquals(expected , actual);
    }

    @Test
    void addToCart_Product_NoStock() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
        testInventory.put("Sugar" , product);
        //  cashier.addToCart("p244" , 2 , testInventory, customer);
        var actual = cashier.addToCart("p244" , 200 , testInventory, customer);
        var expected = "NoStock";
        assertEquals(expected , actual);
    }

    @org.junit.jupiter.api.Test
    void sellProduct_Empty_cart() {
        var actual =  cashier.sellProduct(customer);
        var expected = "empty";

        assertEquals(expected , actual);
    }

    @Test
    void sellProduct_insufficient() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
        testInventory.put("Sugar" , product);
        Customer customerTest = new Customer("1" , "Vincent" , "Lagos" , 1);
       cashier.addToCart("p244" , 2 , testInventory, customerTest);
        var actual =  cashier.sellProduct(customerTest);
        var expected = "insufficient";

        assertEquals(expected , actual);
    }


    @Test
    void sellProduct_successfull() {
        HashMap<String , Product> testInventory = new HashMap<>();
        Product product = new Product("P244" , "Sugar" , "Cookies", 10 ,1.98);
        testInventory.put("Sugar" , product);
        Customer customerTest = new Customer("1" , "Vincent" , "Lagos" , 1000);
        cashier.addToCart("p244" , 2 , testInventory, customerTest);
        var actual =  cashier.sellProduct(customerTest);
        var expected = "successful";

        assertEquals(expected , actual);
    }

    @Test
    void sellByPriority_true(){
        //Given
        CashierServiceImplementation cashierServiceImplementation = new CashierServiceImplementation();
        Queue<Customer> queue = new PriorityQueue<>(new CustomerCompare());
        Customer customer = new Customer("1" , "Vincent" , "Lagos" , 50000);
        customer.getCart().put("Sugar" , new Product("P244" , "Sugar" , "Cookies", 10 ,1.98));
        queue.add(customer);
        var expected = true;
        //When
        var actual = cashierServiceImplementation.sellByPriority(queue);
        assertTrue(actual);
    }





}