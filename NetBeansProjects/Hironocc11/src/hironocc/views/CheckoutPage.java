package hironocc.views;

import hironocc.models.Item;
import hironocc.controllers.MainFrame;
import hironocc.utils.UIHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CheckoutPage extends JPanel {
    private MainFrame mainFrame;
    private ArrayList<Item> checkoutItems;
    private JPanel itemsPanel;
    private JLabel totalLabel;

    public CheckoutPage(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.checkoutItems = new ArrayList<>();

        setLayout(new BorderLayout());
        setBackground(UIHelper.CREAM);

        add(createHeader(), BorderLayout.NORTH);
        add(createItemsScrollPane(), BorderLayout.CENTER);
        add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setBackground(UIHelper.BURGUNDY);
        header.setPreferredSize(new Dimension(1440, 100));

        JLabel title = new JLabel("Checkout");
        title.setFont(UIHelper.TITLE_FONT);
        title.setForeground(Color.WHITE);
        header.add(title);

        return header;
    }

    private JScrollPane createItemsScrollPane() {
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        itemsPanel.setBackground(UIHelper.CREAM);

        JScrollPane scroll = new JScrollPane(itemsPanel);
        scroll.setBorder(null);
        scroll.getViewport().setBackground(UIHelper.CREAM);
        return scroll;
    }

    private JPanel createFooter() {
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        footer.setBackground(UIHelper.LIGHT_YELLOW);
        footer.setPreferredSize(new Dimension(1440, 120));

        JButton backBtn = UIHelper.createStyledButton("Back", Color.GRAY);
        backBtn.addActionListener(e -> mainFrame.showPage("Home"));

        totalLabel = new JLabel("Total: ₱0");
        totalLabel.setFont(UIHelper.TITLE_FONT);
        totalLabel.setForeground(UIHelper.BURGUNDY);

        JButton confirmBtn = UIHelper.createStyledButton("Confirm", UIHelper.DARK_RED);
        confirmBtn.addActionListener(e -> confirmPurchase());

        footer.add(backBtn);
        footer.add(Box.createHorizontalStrut(200));
        footer.add(totalLabel);
        footer.add(Box.createHorizontalStrut(50));
        footer.add(confirmBtn);

        return footer;
    }

    public void updateCheckoutItems(ArrayList<Item> items) {
        this.checkoutItems = items;
        itemsPanel.removeAll();

        if (items.isEmpty()) {
            itemsPanel.add(new JLabel("No items in cart"));
        } else {
            int total = 0;
            for (Item item : items) {
                itemsPanel.add(createItemCard(item));
                itemsPanel.add(Box.createVerticalStrut(20));
                total += item.getPrice() * item.getQuantity();
            }
            totalLabel.setText("Total: ₱" + total);
        }

        itemsPanel.revalidate();
        itemsPanel.repaint();
    }

    private JPanel createItemCard(Item item) {
        JPanel card = new JPanel(new BorderLayout(20, 0));
        card.setBackground(Color.WHITE);
        card.setMaximumSize(new Dimension(1300, 150));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        // Image
        JLabel imageLabel = new JLabel(new ImageIcon(
                UIHelper.loadImage(item.getImagePath()).getImage()
                        .getScaledInstance(120, 120, Image.SCALE_SMOOTH)
        ));

        // Details
        JPanel details = new JPanel();
        details.setLayout(new BoxLayout(details, BoxLayout.Y_AXIS));
        details.setBackground(Color.WHITE);
        details.add(new JLabel(item.getItemName()));
        details.add(new JLabel("Qty: " + item.getQuantity()));

        // Subtotal
        JLabel subtotal = new JLabel("₱" + (item.getPrice() * item.getQuantity()));
        subtotal.setFont(UIHelper.HEADER_FONT);
        subtotal.setForeground(UIHelper.DARK_RED);

        card.add(imageLabel, BorderLayout.WEST);
        card.add(details, BorderLayout.CENTER);
        card.add(subtotal, BorderLayout.EAST);

        return card;
    }

    private void confirmPurchase() {
        if (checkoutItems.isEmpty()) return;

        int total = checkoutItems.stream()
                .mapToInt(i -> i.getPrice() * i.getQuantity())
                .sum();

        UIHelper.showHironoDialog(this,
                "Purchase confirmed!\nTotal: ₱" + total,
                "Success", JOptionPane.INFORMATION_MESSAGE);

        checkoutItems.clear();
        mainFrame.showPage("Home");
    }
}