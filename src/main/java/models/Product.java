package models;

import java.util.HashMap;

public class Product{

    private String productId;
    private String productName;
    private String productCategory;
    private int productQty;
    private double price;


    public Product(String productId, String productName, String productCategory, int productQty, double price) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productQty = productQty;
        this.price = price;
    }

    public Product() {

    }



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productQty=" + productQty +
                ", price=" + price +
                '}';
    }
}
