package main.java.interfaces;

import main.java.models.Product;
import main.java.utility.FileUtility;

import java.io.IOException;
import java.util.HashMap;

public interface iFileUtility {

    boolean checkDuplicate(HashMap<String, Product> productHashMap , String category);

    HashMap<String , Product> createCategoryInventory(HashMap<String, Product> categoryHashMap, FileUtility file, int categoryTotalQuantity, String categoryId, int idIncreament) throws IOException;

}
