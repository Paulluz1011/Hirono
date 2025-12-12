package hironocc.utils;

import javax.swing.*;
import java.awt.*;

public class UIHelper {

    // Color constants matching Hirono brand
    public static final Color CREAM = new Color(249, 240, 208);
    public static final Color BURGUNDY = new Color(153, 0, 0);
    public static final Color DARK_RED = new Color(204, 0, 51);
    public static final Color LIGHT_YELLOW = new Color(255, 255, 204);
    public static final Color GRAY = new Color(128, 128, 128);

    // Font constants
    public static final Font TITLE_FONT = new Font("PT Mono", Font.BOLD, 48);
    public static final Font HEADER_FONT = new Font("Helvetica Neue", Font.BOLD, 28);
    public static final Font BODY_FONT = new Font("Helvetica Neue", Font.PLAIN, 18);
    public static final Font BUTTON_FONT = new Font("Helvetica Neue", Font.BOLD, 20);
    public static final Font PRICE_FONT = new Font("Helvetica Neue", Font.BOLD, 24);

    /**
     * Load image from resources folder
     * @param filename Just the filename (e.g., "Prince.png")
     * @return ImageIcon or null if not found
     */

    public static ImageIcon loadImage(String filename) {
        try {
            java.net.URL imgURL = UIHelper.class.getResource("/images/" + filename);
            if (imgURL != null) {
                return new ImageIcon(imgURL);
            } else {
                System.err.println("Could not find image: " + filename);
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + filename);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Create a styled button with Hirono branding
     */
    public static JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(BUTTON_FONT);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    /**
     * Show Hirono-styled message dialog
     */
    public static void showHironoDialog(Component parent, String message,
                                        String title, int messageType) {
        // Apply Hirono styling
        UIManager.put("OptionPane.background", CREAM);
        UIManager.put("Panel.background", CREAM);
        UIManager.put("OptionPane.messageFont", BODY_FONT);
        UIManager.put("OptionPane.messageForeground", Color.BLACK);
        UIManager.put("Button.background", BURGUNDY);
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Helvetica Neue", Font.BOLD, 16));

        JOptionPane.showMessageDialog(parent, message, title, messageType);

        // Reset to defaults
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);
        UIManager.put("OptionPane.messageFont", null);
        UIManager.put("Button.background", null);
        UIManager.put("Button.foreground", null);
        UIManager.put("Button.font", null);
    }

    /**
     * Show Hirono-styled confirmation dialog
     * @return JOptionPane.YES_OPTION or JOptionPane.NO_OPTION
     */
    public static int showHironoConfirm(Component parent, String message, String title) {
        UIManager.put("OptionPane.background", CREAM);
        UIManager.put("Panel.background", CREAM);
        UIManager.put("OptionPane.messageFont", BODY_FONT);
        UIManager.put("Button.background", BURGUNDY);
        UIManager.put("Button.foreground", Color.WHITE);

        int result = JOptionPane.showConfirmDialog(
                parent, message, title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        // Reset
        UIManager.put("OptionPane.background", null);
        UIManager.put("Panel.background", null);

        return result;
    }

    /**
     * Create a styled label with specified font and color
     */
    public static JLabel createStyledLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    /**
     * Scale an ImageIcon to specified dimensions
     */
    public static ImageIcon scaleImage(ImageIcon icon, int width, int height) {
        if (icon == null) return null;
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}