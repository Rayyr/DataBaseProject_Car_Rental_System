
package com.mycompany.car_rental_system;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class colorResults extends javax.swing.JFrame {

    // Creates new form colorResults
    Connection con;
    DefaultTableModel model;
    Date startrent, endrent;
    int lastind=0,car_IDD;
    int cus_iD;

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

    public colorResults(String color_chosen_value, Date s, Date e,int cus_iD) {
        // the color_chosen_value is the one to search based to 
        initComponents();
        model = (DefaultTableModel) this.color_table.getModel();
        show_cars_with_this_color_on_table(color_chosen_value);
        
        
        
        color_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        startrent = s;
        endrent = e;
        this.cus_iD=cus_iD;

        //anynomous class for event handling
        color_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {

                select_car_btn.setEnabled(true);
               // car_IDD= Integer.parseInt(model.getValueAt(color_table.getSelectedRow(),1).toString());
            }

        });

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
    }

    public void show_cars_with_this_color_on_table(String color_chosen_value) {

        make_connector();

        try {
            String car_model;
            Integer car_id;

            con.setAutoCommit(false);
            String q = "select  veichleid,model from veichle where color='" + color_chosen_value + "'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            //to fetch the rows 
            while (r.next() == true) {
                car_id = r.getInt("veichleid");
                car_model = r.getString("model");

                //we will show this row to the table
                model.addRow(new Object[]{color_chosen_value, car_id, car_model});

            }

            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        color_table = new javax.swing.JTable();
        select_car_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Color Filteration Results");

        color_table.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        color_table.setForeground(new java.awt.Color(137, 123, 203));
        color_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Color", "Car ID", "Model"
            }
        ));
        jScrollPane1.setViewportView(color_table);

        select_car_btn.setBackground(new java.awt.Color(82, 140, 197));
        select_car_btn.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        select_car_btn.setForeground(new java.awt.Color(255, 255, 255));
        select_car_btn.setText("Select Car");
        select_car_btn.setEnabled(false);
        select_car_btn.setFocusable(false);
        select_car_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                select_car_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(select_car_btn)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(select_car_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void select_car_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_car_btnActionPerformed
        // TODO add your handling code here:

        int selected_row = this.color_table.getSelectedRow();
        car_IDD = Integer.parseInt(this.model.getValueAt(selected_row, 1).toString());

        check(car_IDD);

    }//GEN-LAST:event_select_car_btnActionPerformed

    public void check(int car_IDD) {
        //first we need find out in the bookings about the rented car using its id then if found we check the dates 
        make_connector();
        int res = 0;

        try {

            con.setAutoCommit(false);
            String q1 = "select COUNT(*) from booking where ( (veichleid='" + car_IDD + "')   AND  rentalstartdate < '" + endrent + "'  AND '" + startrent + "'<rentalreturndate ) ";

            //if count !=0 that means we have this car has being rentd during the time onterval which is entered by the user so 
            //we will show massege to prevent them 
            Statement s = con.createStatement();
            ResultSet r1 = s.executeQuery(q1);

               
                r1.next();
                res = r1.getInt(1);

             

            if (res != 0) {
                JOptionPane.showMessageDialog(null, "Sorry , This Car Is Rented During This Period Time !", "Invalid Date", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
           
              con.commit();
            con.close();
            con = null;
            
            } else {

                 make_booking_id();
                 add_booking();
            }

            //since we call the previous func so con is global so it will be closed by the m
            /*
            con.commit();
            con.close();
            con = null; */

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }

        this.dispose();

    }
 
    
    

    public  int calculateDaysBetween(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        long startTime = start.getTimeInMillis();
        long endTime = end.getTimeInMillis();

        long diffInMillis = endTime - startTime;
        int daysBetween = (int) (diffInMillis / (1000 * 60 * 60 * 24));

        return daysBetween;
    
    
}
    
    
    public void make_booking_id() {

        make_connector();

        try {

            con.setAutoCommit(false);
            //fetch the pk column
            String q = "select MAX(bookingid) AS max_value from booking";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            while (r.next() == true) {
                lastind = r.getInt("max_value");
            }
            lastind++;

            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }
        
        return;

    }

    public void add_booking() {

        make_connector();

        int booking_id = lastind;
        int car_id = car_IDD;
        Date sDate=startrent;
        Date eDate=endrent;
        
        int days=calculateDaysBetween(sDate,eDate);
        int numFeatures=count_features(car_id);
        int totalcost=0;
        
 
        try {

            con.setAutoCommit(false);
            
            String q1="Select priceperday from veichle where veichleid='"+car_IDD+"'";
             Statement s = con.createStatement();
             ResultSet r=s.executeQuery(q1);
             r.next();
             totalcost=days*r.getInt("priceperday")+10*numFeatures;
             
            //fetch the pk column
            String q = "insert into booking values('"+booking_id+"','"+sDate+"','"+eDate+"','"+totalcost+"','"+days+"','"+1+"','"+cus_iD+"','"+car_id+"')";
              s = con.createStatement();
            s.executeUpdate(q);

            JOptionPane.showMessageDialog(null, "Your Reservation Is Done !", "Make Booking", JOptionPane.PLAIN_MESSAGE + JOptionPane.OK_OPTION);


            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }
        
        return;
        //it will retun back to check fun which will dispose this frame once we click on select car btn

    }
 
  public int count_features(int car_id){
      
      make_connector();
      String f="";
       int num=0;
        try {

            con.setAutoCommit(false);
            
             String q1="Select features from veichle where veichleid='"+car_id+"'";
             Statement s = con.createStatement();
             ResultSet r=s.executeQuery(q1);
             r.next();
            
             
               Array array = r.getArray("features"); // Replace with your array column name
                String[] items = (String[]) array.getArray();
                
               
                 for (String x : items) {
                    if (x.equals("null") == false) {
                        num++;
                        f+=x+" ";
                    }

                }
 

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }
        
        String context=String.format("Your Chosen Veichle Contains "+num+" Features as listed "+f+"\n The Cost Of Each is 10$");
       JOptionPane.showMessageDialog(null,context , "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);

      
      return  num;
  }
    
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
        java.util.logging.Logger.getLogger(colorResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(colorResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(colorResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(colorResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            //dummy passed value
            //this costructor will be called only if we run the file indivisually since it will start to be excuted from 
            // main function
            new colorResults("", null, null,0).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable color_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton select_car_btn;
    // End of variables declaration//GEN-END:variables
}
