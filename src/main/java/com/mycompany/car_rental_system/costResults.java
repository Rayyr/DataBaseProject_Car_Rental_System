package com.mycompany.car_rental_system;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class costResults extends javax.swing.JFrame {

    Connection con;
    DefaultTableModel model;
    Date startrent, endrent;
    int cus_id;
    int car_IDD;
    int lastind=0;

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

    //Creates new form costResults
    public costResults(Integer cost_chosen_value, Date s, Date e, int cus_id) {
        initComponents();

        model = (DefaultTableModel) this.cost_table.getModel();
        show_cars_with_this_cost_on_table(cost_chosen_value);

        cost_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //anynomous class for event handling
        cost_table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent event) {

                select_car_btn.setEnabled(true);
            }

        });

        startrent = s;
        endrent = e;
        this.cus_id = cus_id;

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

    }

    public void show_cars_with_this_cost_on_table(Integer cost_chosen_value) {

        make_connector();

        try {
            String car_model;
            Integer car_id;
            String color;

            con.setAutoCommit(false);
            String q = "select  veichleid,model,color from veichle where priceperday='" + cost_chosen_value + "'";
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery(q);

            //to fetch the rows 
            while (r.next() == true) {
                car_id = r.getInt("veichleid");
                car_model = r.getString("model");
                color = r.getString("color");

                //we will show this row to the table
                model.addRow(new Object[]{cost_chosen_value, car_id, car_model, color});

            }

            con.commit();
            con.close();
            con = null;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }
        return;

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
        cost_table = new javax.swing.JTable();
        select_car_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cost Filteration Results ");

        cost_table.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        cost_table.setForeground(new java.awt.Color(137, 123, 203));
        cost_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "priceperday(Cost)", "Car ID", "Model", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(cost_table);
        if (cost_table.getColumnModel().getColumnCount() > 0) {
            cost_table.getColumnModel().getColumn(0).setResizable(false);
            cost_table.getColumnModel().getColumn(1).setResizable(false);
            cost_table.getColumnModel().getColumn(2).setResizable(false);
            cost_table.getColumnModel().getColumn(3).setResizable(false);
        }

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
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_car_btn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(select_car_btn)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_car_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_select_car_btnActionPerformed
        // TODO add your handling code here:
        int selected_row = this.cost_table.getSelectedRow();
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

            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Happens With Your Data Base Connection!", "Data Base Error", JOptionPane.ERROR_MESSAGE + JOptionPane.OK_OPTION);
            System.exit(0);

        }

        this.dispose();

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
            String q = "insert into booking values('"+booking_id+"','"+sDate+"','"+eDate+"','"+totalcost+"','"+days+"','"+1+"','"+cus_id+"','"+car_id+"')";
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
            java.util.logging.Logger.getLogger(costResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(costResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(costResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(costResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //dummy passed value
                new costResults(2, null, null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cost_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton select_car_btn;
    // End of variables declaration//GEN-END:variables
}
