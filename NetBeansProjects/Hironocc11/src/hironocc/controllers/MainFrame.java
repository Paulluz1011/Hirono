package hironocc.controllers;

import hironocc.models.Item;
import hironocc.views.*;
import hironocc.utils.UIHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ArrayList<Item> items;
    private HomePage homePage;
    private CheckoutPage checkoutPage;

    public MainFrame() {
        setTitle("Hirono Shop");
        setSize(1440, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loadItems();
        setupPages();
        showPage("Loading");

        // Auto-transition from loading to login after 5 seconds
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

        checkoutPage = new CheckoutPage(this);
        mainPanel.add(checkoutPage, "Checkout");

        setContentPane(mainPanel);
    }

    private void loadItems() {
        items = new ArrayList<>();
        String[][] data = {
                {"0", "The Little Prince", "2500", "Prince.png"},
                {"1", "The Rose", "1600", "Rose.png"},
                {"2", "The Geographer", "1000", "Geo.png"},
                {"3", "The Tippler", "800", "Tippler.png"},
                {"4", "The Conceited Man", "800", "Conce.png"},
                {"5", "The Fox", "800", "Fox.png"},
                {"6", "The Merchant", "800", "Merch.png"},
                {"7", "The King", "1000", "King.png"}
        };

        for (String[] d : data) {
            items.add(new Item(
                    Integer.parseInt(d[0]), d[1], Integer.parseInt(d[2]),
                    0, "Le Petit Prince Series", d[3]
            ));
        }
    }

    public void showPage(String pageName) {
        cardLayout.show(mainPanel, pageName);
    }

    public void showCheckoutPage(ArrayList<Item> selectedItems) {
        if (selectedItems.isEmpty()) {
            UIHelper.showHironoDialog(this,
                    "Cart is empty!", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        checkoutPage.updateCheckoutItems(selectedItems);
        showPage("Checkout");
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() ->
                new MainFrame().setVisible(true)
        );
    }
}