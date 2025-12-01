package com.mycompany.hironocc11;
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
        log = new javax.swing.JButton();
        pas = new javax.swing.JPasswordField();
        use = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jleft.setPreferredSize(new java.awt.Dimension(580, 700));

        pos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/poster.png"))); // NOI18N

        javax.swing.GroupLayout jleftLayout = new javax.swing.GroupLayout(jleft);
        jleft.setLayout(jleftLayout);
        jleftLayout.setHorizontalGroup(
            jleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jleftLayout.setVerticalGroup(
            jleftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jright.setBackground(new java.awt.Color(255, 255, 255));
        jright.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jright.setPreferredSize(new java.awt.Dimension(820, 700));

        log.setBackground(new java.awt.Color(255, 102, 51));
        log.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        log.setText("Log In");
        log.setMaximumSize(new java.awt.Dimension(400, 55));
        log.setMinimumSize(new java.awt.Dimension(400, 55));

        log.setPreferredSize(new java.awt.Dimension(400, 55));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });

        pas.setFont(new java.awt.Font("DecoType Naskh", 1, 18)); // NOI18N
        pas.setPreferredSize(new java.awt.Dimension(500, 55));
        pas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasActionPerformed(evt);
            }
        });

        use.setFont(new java.awt.Font("DecoType Naskh", 1, 18)); // NOI18N
        use.setPreferredSize(new java.awt.Dimension(500, 55));
        use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("PT Mono", 1, 40)); // NOI18N
        jLabel1.setText("LOG IN PAGE");

        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 30)); // NOI18N
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Helvetica", 1, 30)); // NOI18N
        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("PT Mono", 1, 48)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/hironocc11/hironologo.png"))); // NOI18N
        jLabel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        jLabel4.setMinimumSize(new java.awt.Dimension(103, 172));

        javax.swing.GroupLayout jrightLayout = new javax.swing.GroupLayout(jright);
        jright.setLayout(jrightLayout);
        jrightLayout.setHorizontalGroup(
            jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jrightLayout.createSequentialGroup()
                .addGroup(jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jrightLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jrightLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(jrightLayout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jrightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(256, 256, 256))
        );
        jrightLayout.setVerticalGroup(
            jrightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jrightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(log, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jleft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jleft, javax.swing.GroupLayout.PREFERRED_SIZE, 749, Short.MAX_VALUE)
            .addComponent(jright, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jleft;
    private javax.swing.JPanel jright;
    private javax.swing.JButton log;
    private javax.swing.JPasswordField pas;
    private javax.swing.JLabel pos;
    private javax.swing.JTextField use;
    // End of variables declaration
}