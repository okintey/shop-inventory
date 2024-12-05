package org.mycompany.shopinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopInventoryApplication.class, args);
        System.out.println("Shop Inventory Application is running...");
    }
}