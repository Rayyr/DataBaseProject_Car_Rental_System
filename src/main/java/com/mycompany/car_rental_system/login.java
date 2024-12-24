package com.mycompany.car_rental_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {
    
    Connection con;
   // Map<String, ImageIcon> map = new HashMap<>();

    // this is general function for set up the connection obj , so only we need to use it 
    public void make_connector() {
        
        try {
            
            DriverManager.registerDriver(new org.postgresql.Driver());
            String info = "jdbc:postgresql://localhost:5432/postgres";
            con = DriverManager.getConnection(info, "ban", "ban123");
            
        } catch (Exception ex) {
            //since we have an error with data base so we must to exit our application 
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);
        }
        
    }
    
    public login() {
        
        initComponents();
        
        
        load_img();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        
    }
    
   
    
    public void load_img(){
        
     
          make_connector();
        
        try {

            // first we need to check if it is the manger , we sure that only we have 1 manger 
            con.setAutoCommit(false);
            String q = "Select veichletypeid from veichle";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);
            
            while(r.next()==true){
                
           
               
            }
           
            
            con.commit();
            con.close();
            con = null;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            this.dispose();
        }
        
        
        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_fname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfp_password = new javax.swing.JPasswordField();
        Login_btn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtf_lname = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(20, 90, 127));
        Right.setForeground(new java.awt.Color(0, 102, 153));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Z&R CAR RENTAL COMPANY");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("copyright@company name All rightsresorved");

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("copyright@company name all rightreserved");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("copyright@company name all rightreserved");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(665, 665, 665)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(75, 75, 75)
                .addComponent(jLabel9)
                .addGap(88, 88, 88)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 410, 490);

        left.setBackground(new java.awt.Color(204, 204, 204));
        left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 90, 127));
        jLabel1.setText("LOGIN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(20, 90, 127));
        jLabel2.setText("First Name");

        jtf_fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_fname.setForeground(new java.awt.Color(20, 90, 127));
        jtf_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_fnameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(20, 90, 127));
        jLabel3.setText("Password");

        jtfp_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtfp_password.setForeground(new java.awt.Color(20, 90, 127));
        jtfp_password.setEnabled(false);
        jtfp_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfp_passwordActionPerformed(evt);
            }
        });

        Login_btn.setBackground(new java.awt.Color(20, 90, 127));
        Login_btn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        Login_btn.setForeground(new java.awt.Color(255, 255, 255));
        Login_btn.setText("Login");
        Login_btn.setEnabled(false);
        Login_btn.setFocusable(false);
        Login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_btnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(20, 90, 127));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Sign Up");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(20, 90, 127));
        jLabel4.setText("I Don’t Have An Account");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(20, 90, 127));
        jLabel10.setText("Last Name");

        jtf_lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_lname.setForeground(new java.awt.Color(20, 90, 127));
        jtf_lname.setEnabled(false);
        jtf_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_lnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfp_password, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_fname)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtf_lname))
                    .addGroup(leftLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jtf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtfp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButton3))
                .addGap(28, 28, 28))
        );

        jPanel1.add(left);
        left.setBounds(400, 0, 400, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_fnameActionPerformed
        // TODO add your handling code here:
        
        this.jtf_fname.setEnabled(false);
        this.jtf_lname.setEnabled(true);
    }//GEN-LAST:event_jtf_fnameActionPerformed

    private void jtfp_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfp_passwordActionPerformed
        // TODO add your handling code here:
        
        this.jtfp_password.setEnabled(false);
        this.Login_btn.setEnabled(true);
    }//GEN-LAST:event_jtfp_passwordActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        signup signupFrame = new signup();
        
        signupFrame.setVisible(true);
        signupFrame.pack();
        signupFrame.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed
    
    public boolean verify_strings(String x) {
        
        if ((x.contains(" ") == true) || (x.isEmpty() == true)) {
            return true;//has spaces
        }
        return false;// not has spaces
    }
    

    private void Login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_btnActionPerformed
        
        String fname = jtf_fname.getText();
        String lname = jtf_lname.getText();
        String password = jtfp_password.getText();
        
        if ((verify_strings(fname) == true) || (verify_strings(lname)) || (verify_strings(password))) {
            JOptionPane.showMessageDialog(null, "Please Enter Valid Information empty , Make Sure About Not Using Spaces !", "Invalid Input Login", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            reinitialize();
            
            return;
        }

        //when the compiler reaches this line all inputs are valid
        //the user who log in to the system either the manager ( admin ) or usual customer ( user ) 
        make_connector();
        
        try {

            // first we need to check if it is the manger , we sure that only we have 1 manger 
            con.setAutoCommit(false);
            String q = "Select fname,lname,pass_word from manger";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);
            
            r.next();
            
            if (fname.equals(r.getString("fname")) && lname.equals(r.getString("lname")) && password.equals(r.getString("pass_word"))) //so it is the manager ,so we will send it to admin dashboard
            {
                
                new Admin_dashboard().setVisible(true);
                this.dispose();
                return;
                
            } // then if not we need to check if it is customer(user)
            else {
                q = "Select fname,lname,customerid from customer where pass_word='" + password + "'";
                s = con.createStatement();
                r = s.executeQuery(q);
                
                if (r.next() == true) {

                    /*we have the user but we need to check if names are matchable */
                    if (fname.equals(r.getString("fname")) && lname.equals(r.getString("lname"))) //so it is the matchable ,so we will send it to customer dashboard
                    {
                        int cus_Id=r.getInt("customerid");
                        new Customer_dashboard(cus_Id).setVisible(true);
                        this.dispose();
                        return;
                    }
                    
                }
                
            }

            //invalid inputs 
            JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !", "Invalid Input Login", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            //so we need to reinitialize the textfeilds values 
            reinitialize();
            
            con.commit();
            con.close();
            con = null;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            this.dispose();
        }
        
    }
    
    public void reinitialize() {
        
        this.jtf_fname.setText(null);
        this.jtf_lname.setText(null);
        this.jtfp_password.setText(null);
        
        this.jtf_fname.setEnabled(true);
    
        this.Login_btn.setEnabled(false);
        
    }

// Method to validate the password (example using hashing)
    private boolean validatePassword(String enteredPassword, String storedHash) {
        // Implement your hashing logic here. This is just a placeholder.
        return enteredPassword.equals(storedHash); // Replace with actual hash comparison


    }//GEN-LAST:event_Login_btnActionPerformed

    private void jtf_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_lnameActionPerformed
        // TODO add your handling code here:
        this.jtf_lname.setEnabled(false);
        this.jtfp_password.setEnabled(true);
    }//GEN-LAST:event_jtf_lnameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_btn;
    private javax.swing.JPanel Right;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtf_fname;
    private javax.swing.JTextField jtf_lname;
    private javax.swing.JPasswordField jtfp_password;
    private javax.swing.JPanel left;
    // End of variables declaration//GEN-END:variables
}
