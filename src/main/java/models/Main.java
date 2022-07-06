package main.java.models;

import main.java.services.CashierServiceImplementation;
import main.java.services.CustomerServiceImpl;
import main.java.services.ManagerServiceImpl;
import main.java.utility.Inventory;
import main.java.models.Product;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Inventory inventory = new Inventory();
        CashierServiceImplementation cashierService = new CashierServiceImplementation();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        ManagerServiceImpl managerService = new ManagerServiceImpl();
        Customer customer = new Customer("bb" , "Vincent" , "Lagos" , 5000);
        Cashier cashier = new Cashier();

        //******* Start Of Manager Service **********//

        System.out.print("Enter Applicant's  Name: ");
        String ApplicantName = input.nextLine();
        System.out.print("Enter Applicant's  Age: ");
        int ApplicantAge = input.nextInt();

        managerService.hireCashier(ApplicantName,ApplicantAge, cashier );

        //******* End Of Manager Service **********//




     //   searchByCategory("Crackers" , inventory.getBarsCategory());
        getAllCategory(inventory.getBarsCategory());
        String productId = null;
        int quantityToBuy = 0;

        do{
            System.out.print("Enter Product ID to Add to Cart(Press Q to Proceed To CheckOut) :");
            productId = input.next();
            if (productId.equalsIgnoreCase("Q")){
                System.out.println("Proceeding To CheckOut...");
                break;
            }
            System.out.print("Enter Quantity To Buy: ");
            quantityToBuy = input.nextInt();

            cashierService.addToCart(productId , quantityToBuy, inventory.getBarsCategory(), customer);


        }while(productId.equalsIgnoreCase("P244") || productId.equalsIgnoreCase("P243") || productId.equalsIgnoreCase("P237") || productId.equalsIgnoreCase("P240") || productId.equalsIgnoreCase("P224") || productId.equalsIgnoreCase("P241") || productId.equalsIgnoreCase("P213") || productId.equalsIgnoreCase("P242") || productId.equalsIgnoreCase("P189"));

        cashierService.sellProduct(customer);
        customerService.buyProduct(customer);
    }


    public static void searchByCategory(String categoryName , HashMap<String , Product> inventory){
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-8s %20s %20s %20s %20s %n" , "PRODUCT ID", "PRODUCT NAME", "CATEGORY" ,  "PRICE", "QUANTITY");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println();
        for (Map.Entry<String, Product> categoryProduct : inventory.entrySet()){
            if (categoryProduct.getValue().getProductCategory().equalsIgnoreCase(categoryName)){
                System.out.printf("%-8s %20s %20s %20s %20s %n" , categoryProduct.getValue().getProductId(), categoryProduct.getValue().getProductName(), categoryProduct.getValue().getProductCategory() , categoryProduct.getValue().getPrice() , categoryProduct.getValue().getProductQty());
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------");

    }

    public static void getAllCategory( HashMap<String , Product> inventory){
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.printf("%-8s %20s %20s %20s %20s %n" , "PRODUCT ID", "PRODUCT NAME", "CATEGORY" ,  "PRICE", "QUANTITY");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println();
        for (Map.Entry<String, Product> categoryProduct : inventory.entrySet()){
                System.out.printf("%-8s %20s %20s %20s %20s %n" , categoryProduct.getValue().getProductId(), categoryProduct.getValue().getProductName(), categoryProduct.getValue().getProductCategory() , categoryProduct.getValue().getPrice() , categoryProduct.getValue().getProductQty());
        }
        System.out.println("----------------------------------------------------------------------------------------------");

    }
}


