package com.engieApp;
 

@DatabaseTable(tableName = "products")
public class product {
    
    @DatabaseField
    private int iosPrice = 25;
    
    @DatabaseField
    private int androidPrice = 20;
    
    public product() {
        // ORMLite needs a no-arg constructor 
    }
    
    public int getIosPrice() {
        return this.iosPrice;
    }
    
    public int getAndroidPrice() {    
        return this.androidPrice;
    }
}