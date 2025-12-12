package hironocc.models;

public class Item {
    private int id;
    private String itemName;
    private int price;
    private int quantity;
    private String collectionName;
    private String imagePath; // Just store filename like "Prince.png"

    // Single constructor
    public Item(int id, String itemName, int price, int quantity,
                String collectionName, String imagePath) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.collectionName = collectionName;
        this.imagePath = imagePath;
    }

    // Getters only (setters removed if not needed)
    public int getId() { return id; }
    public String getItemName() { return itemName; }
    public int getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCollectionName() { return collectionName; }
    public String getImagePath() { return imagePath; }
}