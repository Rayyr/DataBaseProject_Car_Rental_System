package com.mycompany.car_rental_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CustomerProfile extends javax.swing.JFrame {

    Connection con;
    int cus_id;

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

    //Creates new form CustomerProfile
    public CustomerProfile() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    //parameterized constructor
    public CustomerProfile(int cus_id) {
        initComponents();
        initializetxtfeilds(cus_id);
        this.cus_id=cus_id;

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    public void initializetxtfeilds(int cus_id) {
        //the idea here since we have multiple customers(users) , so first we need which user has log in to the system
        make_connector();

        try {

            // first we need to check if it is the manger , we sure that only we have 1 manger 
            con.setAutoCommit(false);
            String q = "Select fname,lname,pass_word , email,phone from customer where customerid='" + cus_id + "'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);
            //the result will be only 1 row 
            r.next();

            this.jtf_fn.setText(r.getString("fname"));
            this.jtf_ln.setText(r.getString("lname"));
            this.jtf_phone.setText(r.getString("phone"));
            this.jtf_email.setText(r.getString("email"));
            this.jtfp_password.setText(r.getString("pass_word"));

            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            this.dispose();
        }

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_fn = new javax.swing.JTextField();
        jtf_ln = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        save_btn = new javax.swing.JButton();
        jtf_phone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfp_password = new javax.swing.JPasswordField();
        change_password_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer Profile Information");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(82, 140, 197));
        jLabel2.setText("First Name");

        jtf_fn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_fn.setForeground(new java.awt.Color(137, 123, 203));
        jtf_fn.setCaretColor(new java.awt.Color(137, 123, 203));

        jtf_ln.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_ln.setCaretColor(new java.awt.Color(137, 123, 203));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(82, 140, 197));
        jLabel3.setText("Last Name");

        jtf_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_email.setCaretColor(new java.awt.Color(137, 123, 203));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(82, 140, 197));
        jLabel4.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(82, 140, 197));
        jLabel6.setText("Phone");

        save_btn.setBackground(new java.awt.Color(82, 140, 197));
        save_btn.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        save_btn.setForeground(new java.awt.Color(255, 255, 255));
        save_btn.setText("Save");
        save_btn.setFocusable(false);
        save_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        jtf_phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_phone.setCaretColor(new java.awt.Color(137, 123, 203));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(82, 140, 197));
        jLabel5.setText("Password");

        jtfp_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtfp_password.setCaretColor(new java.awt.Color(137, 123, 203));
        jtfp_password.setEnabled(false);

        change_password_btn.setBackground(new java.awt.Color(82, 140, 197));
        change_password_btn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        change_password_btn.setForeground(new java.awt.Color(255, 255, 255));
        change_password_btn.setText("Change");
        change_password_btn.setFocusable(false);
        change_password_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_password_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_email, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jtf_fn, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addComponent(jtf_ln)
                            .addComponent(jtf_phone))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change_password_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtf_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtf_ln, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfp_password, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(change_password_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_phone))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(save_btn)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
      public boolean verify_strings(String x) {

        if ((x.contains(" ") == true) || (x.isEmpty() == true)) {
            return true;//has spaces
        }
        return false;// not has spaces
    } 
    
    
    
    
    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        // when save btn is pressed , i will close the customer profile and return back ti cutomer dashboarg form , 
        // since i gutntee that the customer profile form will nor be open only through the customer dashboard 
        // that's why i will go back to cusyomer dashboard form 
        
        
        
            // fetch the values from the textfeilds to be changed 
        String fname = this.jtf_fn.getText();
        String lname = this.jtf_ln.getText();
        String password = this.jtfp_password.getText();
        String email = this.jtf_email.getText();
        String phone = this.jtf_phone.getText();

        //we need to verify that each string neither empty nor has spaces
        String temp[] = {fname, lname, password, email, phone};

        for (int c = 0; c < 5; c++) {
            boolean flag = verify_strings(temp[c]);
            if (flag == true) {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Update Profile", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
               this.dispose();
                return ;
            }

        }
        
        
           make_connector();

        try {

            con.setAutoCommit(false);
            String q = "update customer set fname='" + fname + "' , lname='" + lname + "' ,pass_word='" + password + "'  ,phone='" + phone + "'  ,email='" + email + "' where customerid='"+cus_id+"' ";
            Statement s = con.createStatement();
            s.executeUpdate(q);
            con.commit();
            con.close();
            con = null;//so we need to reinitialze it again when we use it 
            JOptionPane.showMessageDialog(null, "Profile Information Was Successfully Updated", "Profile Info Save", JOptionPane.OK_OPTION + JOptionPane.PLAIN_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
        }
        
        //in each time the customer needs to update his profile he will click on profile 

        this.dispose();
    }//GEN-LAST:event_save_btnActionPerformed

    private void change_password_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_password_btnActionPerformed
        // change the password
        
        
        //its uniquticity it will validated from the DB itself , so if its duplicated with other customers catch statment will be 
        //exucted 
        
        
        
        String x=JOptionPane.showInputDialog(null,"Enter New Password ");
        if(verify_strings(x)==true){
                JOptionPane.showMessageDialog(null,"Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Password", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
 
        }
        else 
        this.jtfp_password.setText(JOptionPane.showInputDialog(null,"Enter New Password "));
        return;
       
    }//GEN-LAST:event_change_password_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_password_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_email;
    private javax.swing.JTextField jtf_fn;
    private javax.swing.JTextField jtf_ln;
    private javax.swing.JTextField jtf_phone;
    private javax.swing.JPasswordField jtfp_password;
    private javax.swing.JButton save_btn;
    // End of variables declaration//GEN-END:variables
}
