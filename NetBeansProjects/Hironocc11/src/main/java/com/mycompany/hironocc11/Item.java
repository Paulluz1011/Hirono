package com.mycompany.hironocc11;

public class Item {
    private int id;
    private String itemName;
    private int price;
    private String collectionName;
    private String imagePath;
    private int quantity;
    
    // Constructor without ID (for new items before database insertion)
    public Item(int price, String itemName, int quantity, String collectionName, String imagePath) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.collectionName = collectionName;
        this.imagePath = imagePath;
    }
    
    // Constructor with ID (for items retrieved from database)
    public Item(int id, String itemName, int price, int quantity, String collectionName, String imagePath) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.collectionName = collectionName;
        this.imagePath = imagePath;
    }
    
    // Getters
    public int getId() {
        return id;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public int getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getCollectionName() {
        return collectionName;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}