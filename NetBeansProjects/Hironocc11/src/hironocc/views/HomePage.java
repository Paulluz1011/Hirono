package hironocc.views;

import hironocc.models.Item;
import hironocc.controllers.MainFrame;
import hironocc.utils.UIHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomePage extends JPanel {
    private MainFrame mainFrame;
    private JLabel[] itemImages;
    private JLabel[] itemNames;
    private JLabel[] itemPrices;
    private JSpinner[] spinners;
    private ArrayList<Item> items;

    public HomePage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        setBackground(UIHelper.CREAM);

        initComponents();
        loadItems();
    }

    private void initComponents() {
        // Header
        JPanel header = createHeader();
        add(header, BorderLayout.NORTH);

        // Scrollable content
        JScrollPane scrollPane = new JScrollPane(createItemsPanel());
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel panel = new JPanel();
        panel.setBackground(UIHelper.BURGUNDY);
        panel.setPreferredSize(new Dimension(1440, 100));

        JLabel title = new JLabel("Browse Hirono");
        title.setFont(UIHelper.TITLE_FONT);
        title.setForeground(Color.WHITE);
        panel.add(title);

        return panel;
    }

    private JPanel createItemsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(UIHelper.CREAM);

        // Initialize arrays
        itemImages = new JLabel[8];
        itemNames = new JLabel[8];
        itemPrices = new JLabel[8];
        spinners = new JSpinner[8];

        // Create 2 rows of 4 items each
        for (int row = 0; row < 2; row++) {
            panel.add(createItemRow(row * 4));
        }

        // Checkout button
        JButton checkoutBtn = UIHelper.createStyledButton("Checkout", UIHelper.DARK_RED);
        checkoutBtn.setPreferredSize(new Dimension(200, 50));
        checkoutBtn.addActionListener(e -> checkout());

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setBackground(UIHelper.CREAM);
        btnPanel.add(checkoutBtn);
        panel.add(btnPanel);

        return panel;
    }

    private JPanel createItemRow(int startIndex) {
        JPanel row = new JPanel(new GridLayout(1, 4, 20, 20));
        row.setBackground(UIHelper.CREAM);
        row.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        for (int i = 0; i < 4 && (startIndex + i) < 8; i++) {
            int index = startIndex + i;
            row.add(createItemCard(index));
        }

        return row;
    }

    private JPanel createItemCard(int index) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

        // Image
        itemImages[index] = new JLabel();
        itemImages[index].setPreferredSize(new Dimension(300, 300));
        itemImages[index].setAlignmentX(Component.CENTER_ALIGNMENT);

        // Name
        itemNames[index] = new JLabel();
        itemNames[index].setFont(UIHelper.HEADER_FONT);
        itemNames[index].setAlignmentX(Component.CENTER_ALIGNMENT);

        // Price
        itemPrices[index] = new JLabel();
        itemPrices[index].setFont(UIHelper.BODY_FONT);
        itemPrices[index].setAlignmentX(Component.CENTER_ALIGNMENT);

        // Quantity spinner
        spinners[index] = new JSpinner(new SpinnerNumberModel(0, 0, 99, 1));
        spinners[index].setMaximumSize(new Dimension(100, 30));
        spinners[index].setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(Box.createVerticalStrut(10));
        card.add(itemImages[index]);
        card.add(Box.createVerticalStrut(10));
        card.add(itemNames[index]);
        card.add(itemPrices[index]);
        card.add(new JLabel("Quantity:"));
        card.add(spinners[index]);
        card.add(Box.createVerticalStrut(10));

        return card;
    }

    private void loadItems() {
        items = mainFrame.getItems();
        if (items == null) return;

        for (int i = 0; i < Math.min(items.size(), 8); i++) {
            Item item = items.get(i);
            itemImages[i].setIcon(UIHelper.loadImage(item.getImagePath()));
            itemNames[i].setText(item.getItemName());
            itemPrices[i].setText("₱" + item.getPrice());
        }
    }

    private void checkout() {
        ArrayList<Item> selected = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            int qty = (Integer) spinners[i].getValue();
            if (qty > 0) {
                Item item = items.get(i);
                selected.add(new Item(item.getId(), item.getItemName(),
                        item.getPrice(), qty, item.getCollectionName(), item.getImagePath()));
            }
        }

        if (selected.isEmpty()) {
            UIHelper.showHironoDialog(this,
                    "Please select at least one item!",
                    "Empty Cart", JOptionPane.WARNING_MESSAGE);
            return;
        }

        mainFrame.showCheckoutPage(selected);
        resetSpinners();
    }

    public void resetSpinners() {
        for (JSpinner spinner : spinners) {
            spinner.setValue(0);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}