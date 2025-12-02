package com.mycompany.hironocc11;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.*;

public final class MainFrame extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private final ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> checkoutItems = new ArrayList<>();
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    
    private static final java.util.logging.Logger logger = 
        java.util.logging.Logger.getLogger(MainFrame.class.getName());

    public MainFrame() {
        initComponents();
        setupPages();
        loadItems();
        showPage("Loading");
        
        setSize(1440, 750);
        setResizable(true);
        setLocationRelativeTo(null);

        // Timer to switch from Loading to Login page
        Timer timer = new Timer(5000, e -> showPage("Login"));
        timer.setRepeats(false);
        timer.start();
    }
    
    private void setupPages() {
    cardLayout = new CardLayout();
    mainPanel = new JPanel(cardLayout);

    mainPanel.add(new LoadingPage(this), "Loading");
    mainPanel.add(new LoginPage(this), "Login");
    
    homePage = new HomePage(this);
    mainPanel.add(homePage, "Home");
    
    // ADD THIS:
    checkoutPage = new CheckoutPage(this);
    mainPanel.add(checkoutPage, "Checkout");
    
    setContentPane(mainPanel);
    revalidate();
    repaint();
}
    
    private void loadItems() {
        // Fixed constructor calls: id, name, price, quantity, collection, imagePath
        items.add(new Item(0, "The Little Prince", 2500, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Prince.png"));
        items.add(new Item(1, "The Rose", 1600, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Rose.png"));
        items.add(new Item(2, "The Geographer", 1000, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Geo.png"));
        items.add(new Item(3, "The Tippler", 800, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Tippler.png"));
        items.add(new Item(4, "The Conceited Man", 800, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Conce.png"));
        items.add(new Item(5, "The Fox", 800, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Fox.png"));
        items.add(new Item(6, "The Merchant", 800, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/Merch.png"));
        items.add(new Item(7, "The King", 1000, 0, "Le Petit Prince Series",
            "src/main/resources/com/mycompany/hironocc11/King.png"));
    }
    
    // Getter for all items (catalog)
    public ArrayList<Item> getItems() {
        return items;
    }
    
    // Setter for checkout items (selected items with quantities)
    public void setCheckoutItems(ArrayList<Item> selectedItems) {
        this.checkoutItems = selectedItems;
    }
    
    // Getter for checkout items
    public ArrayList<Item> getCheckoutItems() {
        return checkoutItems;
    }

    // Show a page by name
    public void showPage(String name) {
        // If showing checkout page, update it with latest items
        if ("Checkout".equals(name) && checkoutPage != null) {
            checkoutPage.updateCheckoutItems(checkoutItems);
        }
        cardLayout.show(mainPanel, name);
    }
    
    // Alternative method for showing checkout (legacy support)
    public void showCheckoutPanel() {
        ArrayList<Item> selectedItems = homePage.getSelectedItems();
        
        if (selectedItems.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please select at least one item to checkout.",
                "No Items Selected",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        setCheckoutItems(selectedItems);
        showPage("Checkout");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : 
                    javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | 
                javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
    
    // Variables declaration - do not modify                     
    // End of variables declaration                   
public void showCheckoutPage(ArrayList<Item> selectedItems) {
    // Validate input
    if (selectedItems == null || selectedItems.isEmpty()) {
        JOptionPane.showMessageDialog(this,
            "Please select at least one item to checkout.",
            "No Items Selected",
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Store the selected items
    setCheckoutItems(selectedItems);
    
    // Update the checkout page with the selected items
    if (checkoutPage != null) {
        checkoutPage.updateCheckoutItems(selectedItems);
    }
    
    // Show the checkout page
    showPage("Checkout");
    
    System.out.println("Navigated to checkout with " + selectedItems.size() + " item(s)");
}
}