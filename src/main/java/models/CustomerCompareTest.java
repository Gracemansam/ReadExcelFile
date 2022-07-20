//package models;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class CustomerCompareTest {
//
//    @BeforeEach
//    void setUp() {
//    }
//
//
//    @Test
//    void totalQuantityOfProducts_Empty_Cart() {
//        //Given
//        Customer testCustomer = new Customer("1" , "vincent" , "Lagos" , 400000);
//        CustomerCompare customerCompare = new CustomerCompare();
//        //when
//        var expected = 0;
//        var actual = customerCompare.totalQuantityOfProducts(testCustomer);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void totalQuantityOfProducts_Total_Quantity_Of_Product_In_Cart() {
//        //Given
//        Customer testCustomer = new Customer("1" , "vincent" , "Lagos" , 400000);
//        testCustomer.getCart().put("Pretzels" , new Product("P189" , "Pretzels" , "Snacks" , 50 , 1.98 ));
//        CustomerCompare customerCompare = new CustomerCompare();
//        //when
//        var expected = 50;
//        var actual = customerCompare.totalQuantityOfProducts(testCustomer);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void compare_In_Descending_Order() {
//        //Given
//        Customer testCustomer1 = new Customer("1" , "vincent" , "Lagos" , 400000);
//        testCustomer1.getCart().put("Pretzels" , new Product("P189" , "Pretzels" , "Snacks" , 50 , 1.98 ));
//        Customer testCustomer2 = new Customer("1" , "Enwere" , "Lagos" , 400000);
//        testCustomer2.getCart().put("Pretzels" , new Product("P189" , "Pretzels" , "Snacks" , 70 , 1.98 ));
//        CustomerCompare customerCompare = new CustomerCompare();
//        //when
//        var expected = 1;
//        var actual = customerCompare.compare(testCustomer1, testCustomer2);
//        assertEquals(expected, actual);
//    }
//
//
//    @Test
//    void compare_In_Ascending_Order() {
//        //Given
//        Customer testCustomer1 = new Customer("1" , "vincent" , "Lagos" , 400000);
//        testCustomer1.getCart().put("Pretzels" , new Product("P189" , "Pretzels" , "Snacks" , 70 , 1.98 ));
//        Customer testCustomer2 = new Customer("1" , "Enwere" , "Lagos" , 400000);
//        testCustomer2.getCart().put("Pretzels" , new Product("P189" , "Pretzels" , "Snacks" , 50 , 1.98 ));
//        CustomerCompare customerCompare = new CustomerCompare();
//        //when
//        var expected = -1;
//        var actual = customerCompare.compare(testCustomer1, testCustomer2);
//        assertEquals(expected, actual);
//    }
//
//}