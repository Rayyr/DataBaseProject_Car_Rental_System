 
package com.mycompany.car_rental_system;

import com.mycompany.car_rental_system.brandlist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

 
public class Brand extends javax.swing.JFrame {
          
      Connection con;
      int lastind=0;
      String brandName;
    
    // this is general function for set up the connection obj , so only we need to use it 
    public void make_connector(){
        
        
        try {
          
            DriverManager.registerDriver(new org.postgresql.Driver());
            String info="jdbc:postgresql://localhost:5432/postgres";
            con=DriverManager.getConnection(info,"ban","ban123");
      
            
        } 
        catch ( Exception ex) {
            //since we have an error with data base so we must to exit our application 
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!","Data Base Error",JOptionPane.ERROR_MESSAGE+JOptionPane.OK_OPTION);
            System.exit(0);
        }
         
    } 
    
     /* Creates new form Brand */
    public Brand() {
        initComponents();
        set_last_added_pk_for_idjtf();
        this.jtf_id.setText(String.valueOf(lastind));
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    
    
    public void set_last_added_pk_for_idjtf(){
        
          make_connector();
              
        try {
              
              con.setAutoCommit(false);
              //fetch the pk column
              String q="select MAX(veichletypeid) AS max_value from veichletype";
              Statement s=con.createStatement();
              ResultSet r = s.executeQuery(q);
             
              //here we dont move the r pointer to the first row since we need here to count the rows num not to get their content
              // check it if we have only 1 row ( this is the edge case only , else no because we initialize the lastind with the pk value 
              //not make it as this lastind++
              while(r.next()==true){
                  lastind=r.getInt("max_value");//or lastind++
              }
              lastind++;
           
              con.commit();
              con.close();
              con=null;
          } 
        catch ( Exception ex) {
            JOptionPane.showMessageDialog(null,"Error Happens With Your Data Base Connection!","Data Base Error",JOptionPane.ERROR_MESSAGE+JOptionPane.OK_OPTION);
            System.exit(0);

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtf_n = new javax.swing.JTextField();
        addbrandbtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtf_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Brands");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(82, 140, 197));
        jLabel2.setText("ID");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(82, 140, 197));
        jLabel3.setText("Brand Name");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jtf_n.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jtf_n.setForeground(new java.awt.Color(137, 123, 203));
        jtf_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_nActionPerformed(evt);
            }
        });

        addbrandbtn.setBackground(new java.awt.Color(82, 140, 197));
        addbrandbtn.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        addbrandbtn.setForeground(new java.awt.Color(255, 255, 255));
        addbrandbtn.setText("Add Brand");
        addbrandbtn.setEnabled(false);
        addbrandbtn.setFocusable(false);
        addbrandbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbrandbtnActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(82, 140, 197));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Brands List");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtf_id.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jtf_id.setForeground(new java.awt.Color(137, 123, 203));
        jtf_id.setText("1");
        jtf_id.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtf_n, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(addbrandbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jtf_n, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(addbrandbtn))
                .addContainerGap(92, Short.MAX_VALUE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // move to brandlist page
        new brandlist().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void addbrandbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbrandbtnActionPerformed
        // add new Brand to the company
              
        make_connector();
        
        // the taken text neither emty nor blank
      //  String brandName=this.jtf_n.getText();
        
        
        try {
              con.setAutoCommit(false);
              String q="insert into veichletype values('"+lastind+"','"+brandName+"')";
              Statement s=con.createStatement();
              s.executeUpdate(q);
              //increament the id for the next id brand
              lastind++;
              this.jtf_id.setText(String.valueOf(lastind));
              con.commit();
              con.close();
              con=null;
              this.jtf_n.setText(null);
              this.addbrandbtn.setEnabled(false);
              JOptionPane.showMessageDialog(null, "New Brand Has Been Successfully Added To Your Comapny !","Brand Added",JOptionPane.OK_OPTION+JOptionPane.PLAIN_MESSAGE);
               
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error Happens With Your Data Base Connection!","Data Base Error",JOptionPane.ERROR_MESSAGE+JOptionPane.OK_OPTION);
            this.dispose();
          }
        
    }//GEN-LAST:event_addbrandbtnActionPerformed

    
    private void jtf_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_nActionPerformed
        // verify the input name 
        brandName=this.jtf_n.getText();
    
        
        if((brandName.contains(" ")==true)||(brandName.isEmpty()==true))
            JOptionPane.showMessageDialog(null, "The Entered Value has blank spaces or it is Empty !","Blank Value",JOptionPane.OK_OPTION+JOptionPane.ERROR_MESSAGE);

         else 
                this.addbrandbtn.setEnabled(true);
        
        return ;
    }//GEN-LAST:event_jtf_nActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Brand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Brand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Brand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Brand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Brand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbrandbtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jtf_id;
    private javax.swing.JTextField jtf_n;
    // End of variables declaration//GEN-END:variables
}