package main.java.interfaces;

import main.java.utility.FileUtility;

import java.io.IOException;
import java.util.HashMap;

public interface iFileUtility {

    boolean checkDuplicate(HashMap<String, models.Product> productHashMap , String category);

    HashMap<String , models.Product> createCategoryInventory(HashMap<String, models.Product> categoryHashMap, FileUtility file, int categoryTotalQuantity, String categoryId, int idIncreament) throws IOException;

}
