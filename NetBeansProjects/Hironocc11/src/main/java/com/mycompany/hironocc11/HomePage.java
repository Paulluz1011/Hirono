package com.mycompany.hironocc11;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class HomePage extends JPanel {
    private MainFrame mainFrame;
    
    // Arrays for easy mapping
    private JLabel[] itemImages;
    private JLabel[] itemNames;
    private JLabel[] itemPrices;
    private JSpinner[] spinners;
    
    private ArrayList<Item> items;

    public HomePage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();

        // Initialize arrays
        itemImages = new JLabel[] {
            item_imgpth0, item_imgpth1, item_imgpth2, item_imgpth3,
            item_imgpth4, item_imgpth5, item_imgpth6, item_imgpth7
        };
        
        itemNames = new JLabel[] {
            item_name0, item_name1, item_name2, item_name3,
            item_name4, item_name5, item_name6, item_name7
        };

        itemPrices = new JLabel[] {
            item_price0, item_price1, item_price2, item_price3,
            item_price4, item_price5, item_price6, item_price7
        };
        
        spinners = new JSpinner[] {
            quanprince, quanrose, quangeo, quantippler,
            quanconce, quanfox, quanmerch, quanking
        };
        
        // Initialize spinners with default values and limits
        for (JSpinner spinner : spinners) {
            spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 99, 1));
        }
        
        loadItems();
    }
    
   private void loadItems() {
    items = mainFrame.getItems();
    
    if (items == null) {
        items = new ArrayList<>();
        return;
    }

    for (int i = 0; i < items.size() && i < itemImages.length; i++) {
        Item item = items.get(i);
        
        if (item == null) continue;

        // Set image
        if (item.getImagePath() != null && !item.getImagePath().isEmpty()) {
            try {
                itemImages[i].setIcon(new ImageIcon(item.getImagePath()));
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }
        }

        // Set name & price
        itemNames[i].setText(item.getItemName() != null ? item.getItemName() : "");
        itemPrices[i].setText("₱" + item.getPrice());
    }
}
    
    // Get selected items with quantities for checkout
    public ArrayList<Item> getSelectedItems() {
        ArrayList<Item> selectedItems = new ArrayList<>();
        
        for (int i = 0; i < items.size() && i < spinners.length; i++) {
            int quantity = (Integer) spinners[i].getValue();
            
            if (quantity > 0) {
                Item item = items.get(i);
                // Create a new Item with the selected quantity
                Item selectedItem = new Item(
                    item.getId(),
                    item.getItemName(),
                    item.getPrice(),
                    quantity,  // Use the spinner value
                    item.getCollectionName(),
                    item.getImagePath()
                );
                selectedItems.add(selectedItem);
            }
        }
        
        return selectedItems;
    }
    
    // Reset all spinners to 0
    public void resetSpinners() {
        for (JSpinner spinner : spinners) {
            spinner.setValue(0);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        hero = new javax.swing.JPanel();
        hero_vid = new javax.swing.JPanel();
        vid = new javax.swing.JLabel();
        top = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bottom = new javax.swing.JPanel();
        itemJ = new javax.swing.JPanel();
        item_imgpth0 = new javax.swing.JLabel();
        item_imgpth1 = new javax.swing.JLabel();
        item_imgpth2 = new javax.swing.JLabel();
        item_imgpth3 = new javax.swing.JLabel();
        item_imgpth4 = new javax.swing.JLabel();
        item_imgpth5 = new javax.swing.JLabel();
        item_imgpth6 = new javax.swing.JLabel();
        item_imgpth7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        item_details = new javax.swing.JPanel();
        item_name0 = new javax.swing.JLabel();
        textq = new javax.swing.JLabel();
        item_price0 = new javax.swing.JLabel();
        quanprince = new javax.swing.JSpinner();
        textq1 = new javax.swing.JLabel();
        item_name1 = new javax.swing.JLabel();
        item_price1 = new javax.swing.JLabel();
        quanrose = new javax.swing.JSpinner();
        textq2 = new javax.swing.JLabel();
        item_name2 = new javax.swing.JLabel();
        item_price2 = new javax.swing.JLabel();
        quangeo = new javax.swing.JSpinner();
        textq3 = new javax.swing.JLabel();
        item_name3 = new javax.swing.JLabel();
        item_price3 = new javax.swing.JLabel();
        quantippler = new javax.swing.JSpinner();
        item_details2 = new javax.swing.JPanel();
        item_name4 = new javax.swing.JLabel();
        textq4 = new javax.swing.JLabel();
        item_price4 = new javax.swing.JLabel();
        quanconce = new javax.swing.JSpinner();
        textq5 = new javax.swing.JLabel();
        item_name5 = new javax.swing.JLabel();
        item_price5 = new javax.swing.JLabel();
        quanfox = new javax.swing.JSpinner();
        textq6 = new javax.swing.JLabel();
        item_name6 = new javax.swing.JLabel();
        item_price6 = new javax.swing.JLabel();
        quanmerch = new javax.swing.JSpinner();
        textq7 = new javax.swing.JLabel();
        item_name7 = new javax.swing.JLabel();
        item_price7 = new javax.swing.JLabel();
        quanking = new javax.swing.JSpinner();

        setMaximumSize(new java.awt.Dimension(1440, 2000));
        setPreferredSize(new java.awt.Dimension(1440, 1500));
        setLayout(new java.awt.BorderLayout());

        scrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        hero.setBackground(new java.awt.Color(249, 240, 208));
        hero.setPreferredSize(new java.awt.Dimension(1440, 2500));

        hero_vid.setBackground(new java.awt.Color(255, 255, 255));
        
        hero_vid.setLayout(new java.awt.BorderLayout());

        vid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/vidgif.gif")));
        vid.setMaximumSize(new java.awt.Dimension(1440, 300));
        vid.setMinimumSize(new java.awt.Dimension(1440, 300));
        vid.setPreferredSize(new java.awt.Dimension(1440, 300));
        hero_vid.add(vid, java.awt.BorderLayout.CENTER);

        top.setBackground(new java.awt.Color(153, 0, 0));
        top.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Homepage");

        jButton3.setFont(new java.awt.Font("Helvetica Neue", 0, 24));
        jButton3.setText("Le Petit Prince Series");

        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 24));
        jButton2.setText("12.15.2025 Coming Soon");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(topLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
            topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(19, 19, 19))
        );

        bottom.setBackground(new java.awt.Color(249, 240, 208));
        bottom.setPreferredSize(new java.awt.Dimension(1440, 1200));

        itemJ.setBackground(new java.awt.Color(255, 255, 204));
        itemJ.setPreferredSize(new java.awt.Dimension(1440, 1110));

        item_imgpth0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Prince.png")));
        item_imgpth1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Rose.png")));
        item_imgpth2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Geo.png")));
        item_imgpth3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Tippler.png")));
        item_imgpth4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Conce.png")));
        item_imgpth5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Fox.png")));
        item_imgpth6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/Merch.png")));
        item_imgpth7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/King.png")));

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 24));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Checkout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 42));
        jLabel3.setText("Browse Hirono");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 20));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Shop Now");

        item_details.setBackground(new java.awt.Color(255, 255, 204));
        item_details.setPreferredSize(new java.awt.Dimension(1440, 150));

        item_name0.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name0.setText("The Little Prince");

        textq.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq.setText("Quantity");

        item_price0.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price0.setText("2500");

        quanprince.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq1.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq1.setText("Quantity");

        item_name1.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name1.setText("The Rose");

        item_price1.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price1.setText("1600");

        quanrose.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq2.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq2.setText("Quantity");

        item_name2.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name2.setText("The Geographer");

        item_price2.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price2.setText("2500");

        quangeo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq3.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq3.setText("Quantity");

        item_name3.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name3.setText("The Tippler");

        item_price3.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price3.setText("800");

        quantippler.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout item_detailsLayout = new javax.swing.GroupLayout(item_details);
        item_details.setLayout(item_detailsLayout);
        item_detailsLayout.setHorizontalGroup(
            item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(item_detailsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name0)
                    .addComponent(item_price0)
                    .addComponent(textq)
                    .addComponent(quanprince, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name1)
                    .addComponent(item_price1)
                    .addComponent(textq1)
                    .addComponent(quanrose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name2)
                    .addComponent(item_price2)
                    .addComponent(textq2)
                    .addComponent(quangeo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name3)
                    .addComponent(item_price3)
                    .addComponent(textq3)
                    .addComponent(quantippler, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        item_detailsLayout.setVerticalGroup(
            item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(item_detailsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_name0)
                    .addComponent(item_name1)
                    .addComponent(item_name2)
                    .addComponent(item_name3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_price0)
                    .addComponent(item_price1)
                    .addComponent(item_price2)
                    .addComponent(item_price3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textq)
                    .addComponent(textq1)
                    .addComponent(textq2)
                    .addComponent(textq3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(item_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quanprince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quanrose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quangeo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantippler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        item_details2.setBackground(new java.awt.Color(255, 255, 204));
        item_details2.setPreferredSize(new java.awt.Dimension(1440, 150));

        item_name4.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name4.setText("The Conceited Man");

        textq4.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq4.setText("Quantity");

        item_price4.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price4.setText("800");

        quanconce.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq5.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq5.setText("Quantity");

        item_name5.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name5.setText("The Fox");

        item_price5.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price5.setText("1000");

        quanfox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq6.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq6.setText("Quantity");

        item_name6.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name6.setText("The Merchant");

        item_price6.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price6.setText("800");

        quanmerch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        textq7.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        textq7.setText("Quantity");

        item_name7.setFont(new java.awt.Font("Helvetica Neue", 0, 18));
        item_name7.setText("The King");

        item_price7.setFont(new java.awt.Font("Helvetica Neue", 1, 18));
        item_price7.setText("1500");

        quanking.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout item_details2Layout = new javax.swing.GroupLayout(item_details2);
        item_details2.setLayout(item_details2Layout);
        item_details2Layout.setHorizontalGroup(
            item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(item_details2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name4)
                    .addComponent(item_price4)
                    .addComponent(textq4)
                    .addComponent(quanconce, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name5)
                    .addComponent(item_price5)
                    .addComponent(textq5)
                    .addComponent(quanfox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name6)
                    .addComponent(item_price6)
                    .addComponent(textq6)
                    .addComponent(quanmerch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(180, 180, 180)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_name7)
                    .addComponent(item_price7)
                    .addComponent(textq7)
                    .addComponent(quanking, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        item_details2Layout.setVerticalGroup(
            item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(item_details2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_name4)
                    .addComponent(item_name5)
                    .addComponent(item_name6)
                    .addComponent(item_name7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_price4)
                    .addComponent(item_price5)
                    .addComponent(item_price6)
                    .addComponent(item_price7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textq4)
                    .addComponent(textq5)
                    .addComponent(textq6)
                    .addComponent(textq7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(item_details2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quanconce, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quanfox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quanmerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout itemJLayout = new javax.swing.GroupLayout(itemJ);
        itemJ.setLayout(itemJLayout);
        itemJLayout.setHorizontalGroup(
            itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemJLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemJLayout.createSequentialGroup()
                        .addComponent(item_imgpth0, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(item_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(itemJLayout.createSequentialGroup()
                        .addComponent(item_imgpth4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(item_imgpth7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(item_details2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemJLayout.createSequentialGroup()
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemJLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(580, 580, 580))
        );
itemJLayout.setVerticalGroup(
    itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    .addGroup(itemJLayout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addGroup(itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(jLabel6))
        .addGap(20, 20, 20)
                .addGroup(itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_imgpth0, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(item_details, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                .addGroup(itemJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(item_imgpth4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(item_imgpth7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(item_details2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        bottom.add(itemJ);
        hero.setLayout(new java.awt.BorderLayout());
                hero.add(top, java.awt.BorderLayout.PAGE_START);  // Add this line
        hero.add(hero_vid, java.awt.BorderLayout.NORTH);
        hero.add(bottom, java.awt.BorderLayout.CENTER);

        scrollPane1.add(hero);

        add(scrollPane1, java.awt.BorderLayout.CENTER);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Checkout button action
        ArrayList<Item> selectedItems = getSelectedItems();
        if (selectedItems.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select at least one item to checkout.", "No Items Selected", JOptionPane.WARNING_MESSAGE);
        } else {
            mainFrame.showCheckoutPage(selectedItems);
            resetSpinners();
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // Coming soon button action
        JOptionPane.showMessageDialog(this, "This collection will be available on 12.15.2025!", "Coming Soon", JOptionPane.INFORMATION_MESSAGE);
    }


    // Variables declaration - do not modify
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel hero;
    private javax.swing.JPanel hero_vid;
    private javax.swing.JPanel itemJ;
    private javax.swing.JPanel item_details;
    private javax.swing.JPanel item_details2;
    private javax.swing.JLabel item_imgpth0;
    private javax.swing.JLabel item_imgpth1;
    private javax.swing.JLabel item_imgpth2;
    private javax.swing.JLabel item_imgpth3;
    private javax.swing.JLabel item_imgpth4;
    private javax.swing.JLabel item_imgpth5;
    private javax.swing.JLabel item_imgpth6;
    private javax.swing.JLabel item_imgpth7;
    private javax.swing.JLabel item_name0;
    private javax.swing.JLabel item_name1;
    private javax.swing.JLabel item_name2;
    private javax.swing.JLabel item_name3;
    private javax.swing.JLabel item_name4;
    private javax.swing.JLabel item_name5;
    private javax.swing.JLabel item_name6;
    private javax.swing.JLabel item_name7;
    private javax.swing.JLabel item_price0;
    private javax.swing.JLabel item_price1;
    private javax.swing.JLabel item_price2;
    private javax.swing.JLabel item_price3;
    private javax.swing.JLabel item_price4;
    private javax.swing.JLabel item_price5;
    private javax.swing.JLabel item_price6;
    private javax.swing.JLabel item_price7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner quanconce;
    private javax.swing.JSpinner quanfox;
    private javax.swing.JSpinner quangeo;
    private javax.swing.JSpinner quanking;
    private javax.swing.JSpinner quanmerch;
    private javax.swing.JSpinner quanprince;
    private javax.swing.JSpinner quanrose;
    private javax.swing.JSpinner quantippler;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JLabel textq;
    private javax.swing.JLabel textq1;
    private javax.swing.JLabel textq2;
    private javax.swing.JLabel textq3;
    private javax.swing.JLabel textq4;
    private javax.swing.JLabel textq5;
    private javax.swing.JLabel textq6;
    private javax.swing.JLabel textq7;
    private javax.swing.JPanel top;
    private javax.swing.JLabel vid;
    // End of variables declaration
}