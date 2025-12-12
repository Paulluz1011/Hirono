package com.mycompany.hironocc11;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame {
    // Simple layout manager
    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    // Our product list and selected items
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> checkoutItems = new ArrayList<>();
    
    // Our pages
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private String loggedInUsername = "Guest User";

    public MainFrame() {
        initComponents();
        setupPages();
        loadItems();
        showPage("Loading");
        setSize(1440, 750);
        setResizable(true);
        setLocationRelativeTo(null);
        Timer timer = new Timer(5000, e -> showPage("Login"));
        timer.setRepeats(false);
        timer.start();
    }
    
    private void setupPages() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Add all our pages
        mainPanel.add(new LoadingPage(this), "Loading");
        mainPanel.add(new LoginPage(this), "Login");
        
        homePage = new HomePage(this);
        mainPanel.add(homePage, "Home");
        
        checkoutPage = new CheckoutPage(this);
        mainPanel.add(checkoutPage, "Checkout");
        
        setContentPane(mainPanel);
    }
    
    private void loadItems() {
        // Add all our products using ITERATION/LOOP
        String[][] itemData = {
            {"0", "The Little Prince", "2500", "Prince.png"},
            {"1", "The Rose", "1600", "Rose.png"},
            {"2", "The Geographer", "1000", "Geo.png"},
            {"3", "The Tippler", "800", "Tippler.png"},
            {"4", "The Conceited Man", "800", "Conce.png"},
            {"5", "The Fox", "800", "Fox.png"},
            {"6", "The Merchant", "800", "Merch.png"},
            {"7", "The King", "1000", "King.png"}
        };
        
        // ITERATION  Loop through all items
        for (String[] data : itemData) { // itemData re: 
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int price = Integer.parseInt(data[2]);
            String imagePath = "src/main/resources/com/mycompany/hironocc11/" + data[3];
            
            items.add(new Item(id, name, price, 0, "Le Petit Prince Series", imagePath));
        }
    }
    
    // Get all products
    public ArrayList<Item> getItems() {
        return items;
    }
    
    // Get items user wants to buy
    public ArrayList<Item> getCheckoutItems() {
        return checkoutItems;
    }
    
    // SWITCH STATEMENT: Navigate between pages
    public void showPage(String pageName) {
        switch (pageName) {
            case "Loading":
                cardLayout.show(mainPanel, "Loading");
                System.out.println("Showing Loading Page");
                break;
                
            case "Login":
                cardLayout.show(mainPanel, "Login");
                System.out.println("Showing Login Page");
                break;
                
            case "Home":
                cardLayout.show(mainPanel, "Home");
                System.out.println("Showing Home Page");
                break;
                
            case "Checkout":
                cardLayout.show(mainPanel, "Checkout");
                System.out.println("Showing Checkout Page");
                break;
                
            default:
                // Show error if page doesn't exist
                showHironoError("Page '" + pageName + "' not found!", "Navigation Error");
                break;
        }
    }
    
    // JOPTIONPANE: Custom Hirono-styled error message
    public void showHironoError(String message, String title) {
        UIManager.put("OptionPane.background", new Color(249, 240, 208));
        UIManager.put("Panel.background", new Color(249, 240, 208));
        UIManager.put("OptionPane.messageFont", new Font("Helvetica Neue", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(51, 51, 51));
        UIManager.put("Button.background", new Color(153, 0, 0));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Helvetica Neue", Font.BOLD, 16));
        
        JOptionPane.showMessageDialog(
            this,
            message,
            title,
            JOptionPane.ERROR_MESSAGE
        );
        
        // Reset UI defaults
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("Button.background", null);
        UIManager.put("Button.foreground", null);
        UIManager.put("Button.font", null);
    }
    
    // JOPTIONPANE: Custom Hirono-styled warning message
    public void showHironoWarning(String message, String title) {
        UIManager.put("OptionPane.background", new Color(249, 240, 208));
        UIManager.put("Panel.background", new Color(249, 240, 208));
        UIManager.put("OptionPane.messageFont", new Font("Helvetica Neue", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(51, 51, 51));
        UIManager.put("Button.background", new Color(153, 0, 0));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Helvetica Neue", Font.BOLD, 16));
        
        JOptionPane.showMessageDialog(
            this,
            message,
            title,
            JOptionPane.WARNING_MESSAGE
        );
        
        // Reset UI defaults
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("Button.background", null);
        UIManager.put("Button.foreground", null);
        UIManager.put("Button.font", null);
    }
    
    // JOPTIONPANE: Custom Hirono-styled info message
    public void showHironoInfo(String message, String title) {
        UIManager.put("OptionPane.background", new Color(249, 240, 208));
        UIManager.put("Panel.background", new Color(249, 240, 208));
        UIManager.put("OptionPane.messageFont", new Font("Helvetica Neue", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(51, 51, 51));
        UIManager.put("Button.background", new Color(153, 0, 0));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Helvetica Neue", Font.BOLD, 16));
        
        JOptionPane.showMessageDialog(
            this,
            message,
            title,
            JOptionPane.INFORMATION_MESSAGE
        );
        
        // Reset UI defaults
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("Button.background", null);
        UIManager.put("Button.foreground", null);
        UIManager.put("Button.font", null);
    }
    
    // JOPTIONPANE: Custom Hirono-styled confirmation dialog
    public int showHironoConfirm(String message, String title) {
        UIManager.put("OptionPane.background", new Color(249, 240, 208));
        UIManager.put("Panel.background", new Color(249, 240, 208));
        UIManager.put("OptionPane.messageFont", new Font("Helvetica Neue", Font.PLAIN, 18));
        UIManager.put("OptionPane.messageForeground", new Color(51, 51, 51));
        UIManager.put("Button.background", new Color(153, 0, 0));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Helvetica Neue", Font.BOLD, 16));
        
        int result = JOptionPane.showConfirmDialog(
            this,
            message,
            title,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        
        // Reset UI defaults
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("Button.background", null);
        UIManager.put("Button.foreground", null);
        UIManager.put("Button.font", null);
        
        return result;
    }
    
    // Go to checkout with selected items
    public void showCheckoutPage(ArrayList<Item> selectedItems) {
        // JOPTIONPANE: Make sure they selected something
        if (selectedItems == null || selectedItems.isEmpty()) {
            showHironoWarning(
                "Please add items to your cart first!",
                "Cart is Empty"
            );
            return;
        }
        
        // ITERATION: Count total items
        int totalItems = 0;
        for (Item item : selectedItems) {
            totalItems += item.getQuantity();
        }
        
        // JOPTIONPANE: Confirm before checkout
        int confirm = showHironoConfirm(
            "You have " + totalItems + " item(s) in your cart.\nProceed to checkout?",
            "Confirm Checkout"
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Save what they're buying
            checkoutItems = selectedItems;
            
            // Update checkout page
            checkoutPage.updateCheckoutItems(selectedItems);
            
            // Show checkout page
            showPage("Checkout");
            
            // Show success message
            showHironoInfo(
                "Successfully moved to checkout!",
                "Checkout"
            );
        }
    }
    
    // ITERATION: Print all items in cart (for debugging)
public void printCartSummary() {
    System.out.println("\n=== CART SUMMARY ===");
    
    // Check if cart is empty first
    if (checkoutItems.isEmpty()) {
        System.out.println("Your cart is empty!");
        return;
    }
    
    // Get delivery address - simplified version that actually shows up
    String address = JOptionPane.showInputDialog("Enter your delivery address:");
    
    // If user cancelled or didn't enter anything
    if (address == null || address.trim().isEmpty()) {
        System.out.println("Checkout cancelled - no address provided");
        return;
    }
    
    // Print each item and calculate total as we go
    System.out.println("Delivery Address: " + address);
    System.out.println();
    
    int total = 0;

    for (int i = 0; i < checkoutItems.size(); i++) {
        Item item = checkoutItems.get(i);
        int itemTotal = item.getPrice() * item.getQuantity();
        System.out.println(item.getItemName() + " x" + item.getQuantity() + " = ₱" + itemTotal);
        total += itemTotal;
    }
    
    // Show final total
    System.out.println("\nTOTAL: ₱" + total);
    System.out.println("==================\n");
}
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
    }
public void setLoggedInUsername(String username) {
    this.loggedInUsername = username;
}

public String getLoggedInUsername() {
    return loggedInUsername;
}


    public static void main(String args[]) {
        // Make it look nice
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Start the app
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}