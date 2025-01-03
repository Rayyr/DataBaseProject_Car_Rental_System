package com.mycompany.car_rental_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class adminProfile extends javax.swing.JFrame {

    Connection con;

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

    /**
     * Creates new form adminProfile
     */

    public adminProfile() {
        initComponents();
        initializetxtfeilds();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

    }

    public boolean verify_strings(String x) {

        if ((x.contains(" ") == true) || (x.isEmpty() == true)) {
            return true;//has spaces
        }
        return false;// not has spaces
    } 

    public void initializetxtfeilds() {

        make_connector();

        try {

            //we will guranteee that only we will have one row ( one manager)
            con.setAutoCommit(false);
            String q = "Select * from manger";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);
            r.next();

            this.jtf_fn.setText(r.getString(2));
            this.jtf_ln.setText(r.getString(3));
            this.jpf_p.setText(r.getString(4));
            this.jtf_ph.setText(r.getString(5));
            this.jtf_e.setText(r.getString(6));

            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Unexcepted Error With Data Base!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
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

        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtf_fn = new javax.swing.JTextField();
        jtf_ln = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtf_e = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        savebtn = new javax.swing.JButton();
        jtf_ph = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jpf_p = new javax.swing.JPasswordField();
        change_btn = new javax.swing.JButton();

        jLabel5.setText("Email");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin Profile Information");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(82, 140, 197));
        jLabel2.setText("First Name");

        jtf_fn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_fn.setForeground(new java.awt.Color(137, 123, 203));

        jtf_ln.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_ln.setForeground(new java.awt.Color(137, 123, 203));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(82, 140, 197));
        jLabel3.setText("Last Name");

        jtf_e.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_e.setForeground(new java.awt.Color(137, 123, 203));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(82, 140, 197));
        jLabel4.setText("Email");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(82, 140, 197));
        jLabel6.setText("Phone");

        savebtn.setBackground(new java.awt.Color(82, 140, 197));
        savebtn.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.setFocusable(false);
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });

        jtf_ph.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jtf_ph.setForeground(new java.awt.Color(137, 123, 203));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(82, 140, 197));
        jLabel7.setText("Password");

        jpf_p.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jpf_p.setForeground(new java.awt.Color(137, 123, 203));
        jpf_p.setEnabled(false);

        change_btn.setBackground(new java.awt.Color(82, 140, 197));
        change_btn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        change_btn.setForeground(new java.awt.Color(255, 255, 255));
        change_btn.setText("Change");
        change_btn.setFocusable(false);
        change_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_e, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jtf_fn)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                .addGap(26, 26, 26))
                            .addComponent(jtf_ln)
                            .addComponent(jtf_ph)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jpf_p, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(change_btn))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_ln))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpf_p, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(change_btn))))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtf_ph, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jtf_e))
                .addGap(54, 54, 54)
                .addComponent(savebtn)
                .addContainerGap(54, Short.MAX_VALUE))
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

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        // go back to admin dashboard page since he finish edit his profile
        // by default it will retuern to the previous caller frame which is here the admindashboard ( we dont have other 
        // frame will open adminprofile frame thats why the caller is admin dashboard . 

        // fetch the values from the textfeilds to be changed 
        String fname = this.jtf_fn.getText();
        String lname = this.jtf_ln.getText();
        String password = this.jpf_p.getText();
        String email = this.jtf_e.getText();
        String phone = this.jtf_ph.getText();

        //we need to verify that each string neither empty nor has spaces
        String temp[] = {fname, lname, password, email, phone};

        for (int c = 0; c < 5; c++) {
            boolean flag = verify_strings(temp[c]);
            if (flag == true) {
                JOptionPane.showMessageDialog(null,"Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Update Profile", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
                return ;
            }

        }

        //initialize con obj
        make_connector();

        try {

            con.setAutoCommit(false);
            String q = "update manger set fname='" + fname + "' , lname='" + lname + "',pass_word='" + password + "',phone='" + phone + "',email='" + email + "'";
            Statement s = con.createStatement();
            s.executeUpdate(q);
            con.commit();
            con.close();
            con = null;//so we need to reinitialze it again when we use it 
            JOptionPane.showMessageDialog(null, "Profile Information Was Successfully Updated", "Profile Info Save", JOptionPane.OK_OPTION + JOptionPane.PLAIN_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!","Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
        }

        this.dispose();
    }//GEN-LAST:event_savebtnActionPerformed

    
    
    
    private void change_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_btnActionPerformed
        // change password
        String x=JOptionPane.showInputDialog(null,"Enter New Password ");
        if(verify_strings(x)==true){
                JOptionPane.showMessageDialog(null,"Please Enter Valid Information , Make Sure About Not Using Spaces !","Invalid Password", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
 
        }
        else 
        this.jpf_p.setText(JOptionPane.showInputDialog(null,"Enter New Password "));
        return;
    }//GEN-LAST:event_change_btnActionPerformed

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
            java.util.logging.Logger.getLogger(adminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminProfile().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPasswordField jpf_p;
    private javax.swing.JTextField jtf_e;
    private javax.swing.JTextField jtf_fn;
    private javax.swing.JTextField jtf_ln;
    private javax.swing.JTextField jtf_ph;
    private javax.swing.JButton savebtn;
    // End of variables declaration//GEN-END:variables
}
