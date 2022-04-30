package application;

import entity.*;
import dao.*;

public class DeviceApp {

    public static void main(String[] args) {
    	
    	Dao dao = new Dao();
    	
        Device l1 = new Device(0, "Dell Latitude 7490");
        dao.saveDevice(l1);
        Device l2 = new Device(0, "Dell Latitude 7491");
        dao.saveDevice(l2);
        Device l3 = new Device(0, "Dell Latitude 7492");
        dao.saveDevice(l3);

        dao.deleteDevice(1);
        
        System.out.println("Device saved.ööööööööööö");
        
    }
}

