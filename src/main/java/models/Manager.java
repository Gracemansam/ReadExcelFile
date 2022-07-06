package main.java.models;

import main.java.base.User;
import main.java.interfaces.iManager;

public class Manager extends User {

    private static  Manager MANAGER = null;

    public Manager(String id, String name) {
        super(id, name);
    }





    public static Manager getMANAGER(String id, String name) {
        if (MANAGER == null){
            MANAGER = new Manager(id , name);
        }
        return MANAGER;
    }
}
