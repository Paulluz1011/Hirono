package com.mycompany.hironocc11;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class CheckoutPage extends JPanel {
    private MainFrame mainFrame;
    private ArrayList<Item> checkoutItems;
    
    // UI Components
    private JPanel headerPanel;
    private JPanel itemsPanel;
    private JScrollPane scrollPane;
    private JPanel summaryPanel;
    private JLabel totalLabel;
    private JButton confirmButton;
    private JButton backButton;
    
    public CheckoutPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.checkoutItems = new ArrayList<>();
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(new Color(249, 240, 208));
        setPreferredSize(new Dimension(1440, 800));
        
        // Header Panel
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(153, 0, 0));
        headerPanel.setPreferredSize(new Dimension(1440, 100));
        
        JLabel titleLabel = new JLabel("Checkout");
        titleLabel.setFont(new Font("PT Mono", Font.BOLD, 48));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        
        // Items Panel (scrollable)
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(new Color(249, 240, 208));
        
        scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(new Color(249, 240, 208));
        
        // Summary Panel (footer)
        summaryPanel = new JPanel();
        summaryPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        summaryPanel.setBackground(new Color(255, 255, 204));
        summaryPanel.setPreferredSize(new Dimension(1440, 120));
        
        backButton = new JButton("Back to Shopping");
        backButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        backButton.setPreferredSize(new Dimension(250, 60));
        backButton.setBackground(new Color(128, 128, 128));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(e -> mainFrame.showPage("Home"));
        
        totalLabel = new JLabel("Total: ₱0");
        totalLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 32));
        totalLabel.setForeground(new Color(153, 0, 0));
        
        confirmButton = new JButton("Confirm Purchase");
        confirmButton.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        confirmButton.setPreferredSize(new Dimension(250, 60));
        confirmButton.setBackground(new Color(204, 0, 51));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(e -> confirmPurchase());
        
        summaryPanel.add(backButton);
        summaryPanel.add(Box.createHorizontalStrut(200));
        summaryPanel.add(totalLabel);
        summaryPanel.add(Box.createHorizontalStrut(50));
        summaryPanel.add(confirmButton);
        
        // Add to main panel
        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(summaryPanel, BorderLayout.SOUTH);
    }
    
    public void updateCheckoutItems(ArrayList<Item> items) {
        this.checkoutItems = items;
        displayItems();
    }
    
    private void displayItems() {
        // Clear existing items
        itemsPanel.removeAll();
        
        if (checkoutItems == null || checkoutItems.isEmpty()) {
            JLabel emptyLabel = new JLabel("No items in cart");
            emptyLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 24));
            emptyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            itemsPanel.add(Box.createVerticalStrut(50));
            itemsPanel.add(emptyLabel);
        } else {
            int grandTotal = 0;
            
            // Add spacing at top
            itemsPanel.add(Box.createVerticalStrut(30));
            
            for (Item item : checkoutItems) {
                JPanel itemCard = createItemCard(item);
                itemsPanel.add(itemCard);
                itemsPanel.add(Box.createVerticalStrut(20));
                
                grandTotal += item.getPrice() * item.getQuantity();
            }
            
            // Add spacing at bottom
            itemsPanel.add(Box.createVerticalStrut(30));
            
            // Update total
            totalLabel.setText("Total: ₱" + grandTotal);
        }
        
        // Refresh the panel
        itemsPanel.revalidate();
        itemsPanel.repaint();
    }
    
    private JPanel createItemCard(Item item) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(20, 0));
        card.setBackground(Color.WHITE);
        card.setMaximumSize(new Dimension(1300, 180));
        card.setPreferredSize(new Dimension(1300, 180));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        
        // Left: Image
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.setPreferredSize(new Dimension(150, 150));
        
        try {
            ImageIcon originalIcon = new ImageIcon(item.getImagePath());
            Image scaledImage = originalIcon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
            imagePanel.add(imageLabel);
        } catch (Exception e) {
            JLabel noImage = new JLabel("No Image");
            noImage.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
            imagePanel.add(noImage);
        }
        
        // Center: Item Details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel nameLabel = new JLabel(item.getItemName());
        nameLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel collectionLabel = new JLabel(item.getCollectionName());
        collectionLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        collectionLabel.setForeground(new Color(102, 102, 102));
        collectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel priceLabel = new JLabel("Price: ₱" + item.getPrice());
        priceLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel quantityLabel = new JLabel("Quantity: " + item.getQuantity());
        quantityLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 20));
        quantityLabel.setForeground(new Color(153, 0, 0));
        quantityLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        detailsPanel.add(nameLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(collectionLabel);
        detailsPanel.add(Box.createVerticalStrut(10));
        detailsPanel.add(priceLabel);
        detailsPanel.add(Box.createVerticalStrut(5));
        detailsPanel.add(quantityLabel);
        
        // Right: Subtotal
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setPreferredSize(new Dimension(250, 150));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        
        JLabel subtotalTextLabel = new JLabel("Subtotal");
        subtotalTextLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 18));
        subtotalTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        int subtotal = item.getPrice() * item.getQuantity();
        JLabel subtotalLabel = new JLabel("₱" + subtotal);
        subtotalLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 32));
        subtotalLabel.setForeground(new Color(204, 0, 51));
        subtotalLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(subtotalTextLabel);
        rightPanel.add(Box.createVerticalStrut(5));
        rightPanel.add(subtotalLabel);
        rightPanel.add(Box.createVerticalGlue());
        
        // Assemble card
        card.add(imagePanel, BorderLayout.WEST);
        card.add(detailsPanel, BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);
        
        return card;
    }
    
    private void confirmPurchase() {
        if (checkoutItems == null || checkoutItems.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Your cart is empty!",
                "Empty Cart",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int total = 0;
        StringBuilder itemList = new StringBuilder();
        
        for (Item item : checkoutItems) {
            int subtotal = item.getPrice() * item.getQuantity();
            total += subtotal;
            itemList.append("• ")
                    .append(item.getItemName())
                    .append(" (x")
                    .append(item.getQuantity())
                    .append(") - ₱")
                    .append(subtotal)
                    .append("\n");
        }
        
        int confirm = JOptionPane.showConfirmDialog(this,
            "Purchase Summary:\n\n" + itemList.toString() + 
            "\nTotal Amount: ₱" + total + "\n\nConfirm purchase?",
            "Confirm Purchase",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this,
                "Thank you for your purchase!\n\n" +
                "Order Total: ₱" + total + "\n\n" +
                "Your order has been confirmed.\n" +
                "We'll process it shortly!",
                "Purchase Successful",
                JOptionPane.INFORMATION_MESSAGE);
            
            // Clear cart and return to home
            checkoutItems.clear();
            mainFrame.showPage("Home");
        }
    }
}