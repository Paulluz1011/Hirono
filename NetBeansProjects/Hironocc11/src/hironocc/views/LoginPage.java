package hironocc.views;
import hironocc.controllers.MainFrame;

import javax.swing.*;
import java.awt.event.*; 

public class LoginPage extends javax.swing.JPanel {
    private MainFrame mainFrame;

    // Hardcoded credentials (temporary - should use database)
    private static final String CORRECT_USERNAME = "paul";
    private static final String CORRECT_PASSWORD = "10111011";

    public LoginPage(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;

        // Enable double buffering to prevent flickering
        setDoubleBuffered(true);
        jleft.setDoubleBuffered(true);
        jright.setDoubleBuffered(true);

        // Add Enter key support for password field
        pas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        // Add Enter key support for username field
        use.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                pas.requestFocus(); // Move to password field
            }
        });
    }

    // Validate login credentials
    private boolean validateLogin(String username, String password) {
        // Input validation
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Username cannot be empty.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Password cannot be empty.",
                "Validation Error",
                JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Direct comparison (not secure, but functional)
        return username.equals(CORRECT_USERNAME) &&
               password.equals(CORRECT_PASSWORD);
    }

    private void logActionPerformed(java.awt.event.ActionEvent evt) {
        String username = use.getText().trim();
        String password = new String(pas.getPassword());

        if (validateLogin(username, password)) {
            // Clear password field for security
            pas.setText("");

            // Navigate to home page
            mainFrame.showPage("Home");

            // Optional: Log successful login
            System.out.println("User '" + username + "' logged in successfully.");
        } else {
            // Clear password field
            pas.setText("");

            // Display error message
            JOptionPane.showMessageDialog(this,
                "Invalid username or password.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE);

            // Return focus to username field
            use.requestFocus();
        }
    }

    private void pasActionPerformed(java.awt.event.ActionEvent evt) {
        // Trigger login when Enter is pressed in password field
        logActionPerformed(evt);
    }

    private void useActionPerformed(java.awt.event.ActionEvent evt) {
        // Move focus to password field when Enter is pressed
        pas.requestFocus();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jleft = new javax.swing.JPanel();
        pos = new javax.swing.JLabel();
        jright = new javax.swing.JPanel();
        jrightContent = new javax.swing.JPanel();
        jrightScroll = new javax.swing.JScrollPane();
        log = new javax.swing.JButton();
        pas = new javax.swing.JPasswordField();
        use = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        // Enable double buffering and set opaque
        setDoubleBuffered(true);
        setOpaque(true);

        jleft.setBackground(new java.awt.Color(245, 245, 245));
        jleft.setPreferredSize(new java.awt.Dimension(580, 700));
        jleft.setDoubleBuffered(true);
        jleft.setOpaque(true);

        // FIXED: Use UIHelper instead of getClass().getResource()
        pos.setIcon(hironocc.utils.UIHelper.loadImage("poster.png"));
        pos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jleftLayout = new javax.swing.GroupLayout(jleft);
        jleft.setLayout(jleftLayout);
        jleftLayout.setHorizontalGroup(
                jleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pos, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );
        jleftLayout.setVerticalGroup(
                jleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jright.setBackground(new java.awt.Color(255, 255, 255));
        jright.setPreferredSize(new java.awt.Dimension(820, 700));
        jright.setDoubleBuffered(true);
        jright.setOpaque(true);

        // Create content panel for scrolling
        jrightContent = new javax.swing.JPanel();
        jrightContent.setBackground(new java.awt.Color(255, 255, 255));
        jrightContent.setDoubleBuffered(true);
        jrightContent.setOpaque(true);

        // Create scroll pane
        jrightScroll = new javax.swing.JScrollPane();
        jrightScroll.setBorder(null);
        jrightScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jrightScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jrightScroll.getVerticalScrollBar().setUnitIncrement(16);

        log.setBackground(new java.awt.Color(255, 102, 51));
        log.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        log.setForeground(new java.awt.Color(255, 255, 255));
        log.setText("Log In");
        log.setFocusPainted(false);
        log.setBorderPainted(false);
        log.setPreferredSize(new java.awt.Dimension(400, 55));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        pas.setFont(new java.awt.Font("DecoType Naskh", 1, 18));
        pas.setPreferredSize(new java.awt.Dimension(500, 55));
        pas.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        pas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasActionPerformed(evt);
            }
        });

        use.setFont(new java.awt.Font("DecoType Naskh", 1, 18));
        use.setPreferredSize(new java.awt.Dimension(500, 55));
        use.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("PT Mono", 1, 40));
        jLabel1.setText("LOG IN PAGE");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 24));
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 24));
        jLabel3.setText("Password");

        // FIXED: Use UIHelper instead of getClass().getResource()
        jLabel4.setIcon(hironocc.utils.UIHelper.loadImage("hironologo.png"));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jrightContentLayout = new javax.swing.GroupLayout(jrightContent);
        jrightContent.setLayout(jrightContentLayout);
        jrightContentLayout.setHorizontalGroup(
                jrightContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(jrightContentLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addGroup(jrightContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(use, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addComponent(pas, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                                        .addComponent(log, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(160, 160, 160))
        );
        jrightContentLayout.setVerticalGroup(
                jrightContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jrightContentLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(pas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
        );

        // Add content panel to scroll pane
        jrightScroll.setViewportView(jrightContent);

        javax.swing.GroupLayout jrightLayout = new javax.swing.GroupLayout(jright);
        jright.setLayout(jrightLayout);
        jrightLayout.setHorizontalGroup(
                jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jrightScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jrightLayout.setVerticalGroup(
                jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jrightScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jleft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jleft, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                        .addComponent(jright, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jleft;
    private javax.swing.JPanel jright;
    private javax.swing.JPanel jrightContent;
    private javax.swing.JScrollPane jrightScroll;
    private javax.swing.JButton log;
    private javax.swing.JPasswordField pas;
    private javax.swing.JLabel pos;
    private javax.swing.JTextField use;
    // End of variables declaration
}