package com.mycompany.car_rental_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class signup extends javax.swing.JFrame {

    Connection con;
    Integer cus_id = 0;

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

    public signup() {

        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtf_lname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        signup_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jtfp_password = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jtf_fname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtf_phone = new javax.swing.JTextField();
        jtf_id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("signup");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("signup");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(20, 90, 127));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Z&R CAR RENTAL COMPANY");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("copyright@company name all rightreserved");

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(20, 90, 127));
        jButton3.setText("ABOUT US");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-10, 0, 430, 670);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(20, 90, 127));
        jLabel3.setText("SIGN UP");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(440, 10, 170, 32);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(20, 90, 127));
        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(440, 240, 100, 20);

        jtf_lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_lname.setForeground(new java.awt.Color(20, 90, 127));
        jtf_lname.setEnabled(false);
        jtf_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_lnameActionPerformed(evt);
            }
        });
        jPanel1.add(jtf_lname);
        jtf_lname.setBounds(440, 270, 330, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(20, 90, 127));
        jLabel5.setText("Email");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(440, 400, 70, 21);

        jtf_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_email.setForeground(new java.awt.Color(20, 90, 127));
        jtf_email.setEnabled(false);
        jtf_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_emailActionPerformed(evt);
            }
        });
        jPanel1.add(jtf_email);
        jtf_email.setBounds(440, 430, 330, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(20, 90, 127));
        jLabel6.setText("Password");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(440, 470, 80, 20);

        signup_btn.setBackground(new java.awt.Color(20, 90, 127));
        signup_btn.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        signup_btn.setForeground(new java.awt.Color(255, 255, 255));
        signup_btn.setText("Sign Up");
        signup_btn.setEnabled(false);
        signup_btn.setFocusable(false);
        signup_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_btnActionPerformed(evt);
            }
        });
        jPanel1.add(signup_btn);
        signup_btn.setBounds(440, 560, 100, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(20, 90, 127));
        jLabel7.setText(" I’ve an account");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(440, 620, 110, 20);

        jButton2.setBackground(new java.awt.Color(20, 90, 127));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Login");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(560, 620, 90, 31);

        jtfp_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtfp_password.setForeground(new java.awt.Color(20, 90, 127));
        jtfp_password.setEnabled(false);
        jtfp_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfp_passwordActionPerformed(evt);
            }
        });
        jPanel1.add(jtfp_password);
        jtfp_password.setBounds(440, 500, 330, 40);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(20, 90, 127));
        jLabel9.setText("ID");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(440, 80, 90, 20);

        jtf_fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_fname.setForeground(new java.awt.Color(20, 90, 127));
        jtf_fname.setEnabled(false);
        jtf_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_fnameActionPerformed(evt);
            }
        });
        jPanel1.add(jtf_fname);
        jtf_fname.setBounds(440, 190, 330, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(20, 90, 127));
        jLabel10.setText("Phone");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(440, 320, 70, 21);

        jtf_phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_phone.setForeground(new java.awt.Color(20, 90, 127));
        jtf_phone.setEnabled(false);
        jtf_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_phoneActionPerformed(evt);
            }
        });
        jPanel1.add(jtf_phone);
        jtf_phone.setBounds(440, 350, 330, 40);

        jtf_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_id.setForeground(new java.awt.Color(20, 90, 127));
        jtf_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_idActionPerformed(evt);
            }
        });
        jPanel1.add(jtf_id);
        jtf_id.setBounds(440, 110, 330, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(20, 90, 127));
        jLabel11.setText("First Name");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(440, 160, 90, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{8}");
    }


    private void jtf_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_lnameActionPerformed
        // TODO add your handling code here:
        
        
            if(verify_strings(this.jtf_lname.getText())==true)
        {
           JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Input Signup", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            
          
           
           this.jtf_lname.setText(null);
           
           return;

        }
        
        this.jtf_lname.setEnabled(false);
        this.jtf_phone.setEnabled(true);
    }//GEN-LAST:event_jtf_lnameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        login loginFrame = new login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean verify_strings(String x) {

        if ((x.contains(" ") == true) || (x.isEmpty() == true)) {
            return true;//has spaces
        }
        return false;// not has spaces
    }

 
    public void reinitialize() {

        this.jtf_id.setText(null);
        this.jtf_fname.setText(null);
        this.jtf_lname.setText(null);
        this.jtf_phone.setText(null);
        this.jtf_email.setText(null);
        this.jtfp_password.setText(null);

        this.jtf_id.setEnabled(true);

        this.signup_btn.setEnabled(false);

    }


    private void signup_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_btnActionPerformed
        
        //when he clicks on sign up all tthe inputs are valid 
      
        String fname = this.jtf_fname.getText();
        String lname = this.jtf_lname.getText();
        String phone = this.jtf_phone.getText();
        String email = this.jtf_email.getText();
        String password = this.jtfp_password.getText();

   
        
        //we need ti insert ( resgiter up the new customer )  only
        make_connector();

        try {

            // first we need to check if it is the manger , we sure that only we have 1 manger 
            con.setAutoCommit(false);
            String q = "Insert into customer values('" + cus_id + "','" + fname + "','" + lname + "','" + phone + "','" + email + "','" + password + "')";
            Statement s = con.createStatement();
            s.executeUpdate(q);

            JOptionPane.showMessageDialog(null, "You Have Been Successfully Registered Into Our System !", "Valid Reisteration(Sign Up)", JOptionPane.PLAIN_MESSAGE + JOptionPane.OK_OPTION);

            con.commit();
            con.close();
            con = null;
            
            this.signup_btn.setEnabled(false);

        } catch (Exception ex) {
            //the errors may be araised is due to duplicated pasword,email,phone since thee are unique ar due to duplicated in the chosen ID since it is PK
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection , Due To A Duplication Either In Chosen Password Or Email Or Phone !", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            this.dispose();
        }

        //added today
        this.dispose();
        //allow him to start using the system bu loogin in to the first time or if the input data is duplicated 
        new login().setVisible(true);
    
    }//GEN-LAST:event_signup_btnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        aboutus aboutusFrame = new aboutus();
        aboutusFrame.setVisible(true);
        aboutusFrame.pack();
        aboutusFrame.setLocationRelativeTo(null);
       // this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtf_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_emailActionPerformed


        // TODO add your handling code here:
        
        
             if (verify_strings(this.jtf_email.getText()) == true) {
            //first check if it contain spaces 
            JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !", "Invalid Input Signup", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            
            this.jtf_email.setText(null);

            return;
        } else {

          
            if (isValidEmail(this.jtf_email.getText()) == false) { 
                JOptionPane.showMessageDialog(null, "Please Make Sure About Email Format !", "Invalid Email Format", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
                
                this.jtf_email.setText(null);
                return;
            }

        }
        
         
        this.jtf_email.setEnabled(false);
        this.jtfp_password.setEnabled(true);
    }//GEN-LAST:event_jtf_emailActionPerformed

    private void jtf_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_fnameActionPerformed
        // TODO add your handling code here:
        
        if(verify_strings(this.jtf_fname.getText())==true)
        {
           JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Input Signup", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            
            
           
           this.jtf_fname.setText(null);
           
           return;

        }
        
        this.jtf_fname.setEnabled(false);
        this.jtf_lname.setEnabled(true);
    }//GEN-LAST:event_jtf_fnameActionPerformed

    private void jtf_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_idActionPerformed
        // TODO add your handling code here:

        try {
            cus_id = Integer.parseInt(this.jtf_id.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Enter Numaric ID !", "Invalid Customer ID", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
           
           this.jtf_id.setText(null);
           
           return;

        }

        if (verify_strings(this.jtf_id.getText()) == true) {

            JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !", "Invalid Input Signup", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
           //reinitialize();
           this.jtf_id.setText(null);
           return;
        }

        this.jtf_id.setEnabled(false);
        this.jtf_fname.setEnabled(true);
    }//GEN-LAST:event_jtf_idActionPerformed

    private void jtf_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_phoneActionPerformed
        // TODO add your handling code here:

        /*verify the phone length didits 8 , the DB constraint will check if its 8 length & unique 
        but here i will also check the phone length , so the constraint in the DB aill be actually check if  it 
         not ynique among the customers */ 
        
        if (verify_strings(this.jtf_phone.getText()) == true) {
            //first check if it contain spaces 
            JOptionPane.showMessageDialog(null, "Please Enter Valid Information , Make Sure About Not Using Spaces !", "Invalid Input Signup", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
             
            this.jtf_phone.setText(null);

            return;
        } else {

            //phone not has spaces so we need to check its length
            if (isValidPhone(this.jtf_phone.getText()) == false) {//not =8 length
                JOptionPane.showMessageDialog(null, "Please Make Sure About Phone Length , It Must Be Strictlly 8 Digits !", "Invalid Phone Input Length", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
                 
                this.jtf_phone.setText(null);
                return;
            }

        }

        this.jtf_phone.setEnabled(false);
        this.jtf_email.setEnabled(true);


    }//GEN-LAST:event_jtf_phoneActionPerformed

    private void jtfp_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfp_passwordActionPerformed
        // TODO add your handling code here:
 
        this.jtfp_password.setEnabled(false);
        this.signup_btn.setEnabled(true);


    }//GEN-LAST:event_jtfp_passwordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_fname;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_lname;
    private javax.swing.JTextField jtf_phone;
    private javax.swing.JPasswordField jtfp_password;
    private javax.swing.JButton signup_btn;
    // End of variables declaration//GEN-END:variables
}
