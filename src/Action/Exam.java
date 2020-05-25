package Action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit Kumar
 */

import Helper.javaConnect;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Exam extends javax.swing.JFrame {
    
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel dtm;      // for holds jTable1
    
    String uname,utype;

    /**
     * Creates new form Exam
     */
    public Exam() {
        
    }
    
            // receive username and usertype
    Exam(String uname, String utype) {
        super("Exam Details");
        
        this.uname = uname;     // stores username
        this.utype = utype;     // stores usertype
        
        initComponents();
        
        loadComboBoxData();     //  fetch all the data from database and set into corresponding jComboBox
        showData();             // all previous stored data display on jTablel
    }
    
    //  method for fetching all the data from 'Class', 'Section' and 'Subject' table and set into corresponding jComboBox
    public void loadComboBoxData()  
    {
        try
        {
            conn = javaConnect.connectDb();
            String sql = "select Distinct Name from Class";     // query for fetch distinct className from 'Class' table
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox2.removeAllItems();        // clear all previous stored data from jComboBox2
            while(rs.next())
                jComboBox2.addItem(rs.getString("Name"));           // set all data in jCombox2 from database
            rs.close();
            pst.close();
            
            sql = "select Distinct Section from Class";         // query for fetch distinct Section from 'Class' table
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox3.removeAllItems();        // clear all previous stored data from jComboBox3
            while(rs.next())
                jComboBox3.addItem(rs.getString("Section"));        // set all data in jCombox3 from database
            rs.close();
            pst.close();
            
            sql = "select Distinct Name from Subject";          // query for fetch distinct subjectName from 'Subject' table
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox4.removeAllItems();        // clear all previous stored data from jComboBox4
            while(rs.next())
                jComboBox4.addItem(rs.getString("Name"));           // set all data in jCombox4 from database
            rs.close();
            pst.close();
            
            conn.close();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    // method for fetching all the data from 'Exam' table and put into jTable1
    public void showData()
    {
        String sql = "select * from Exam";      // query for select all data from the 'Exam' table
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            dtm = (DefaultTableModel)jTable1.getModel();        // holds jTable1 reference
            dtm.setRowCount(0);                                 // remove all the previous row from the jTable1
            
            int s=1;        // stores S.No.
            
            while(rs.next())
            {
                Vector v = new Vector();    // for hold the data row by row
                
                v.add(s);      // add S.No.
                v.add(rs.getString("Exam_Name"));    // pass database column name
                v.add(rs.getString("Shift"));        // pass database column name
                v.add(rs.getString("Date"));         // pass database column name
                v.add(rs.getString("Class"));        // pass database column name
                v.add(rs.getString("Section"));      // pass database column name
                v.add(rs.getString("Subject"));      // pass database column name
                
                dtm.addRow(v);      // add row in jTable1
                s++;        // after adding the new row in jTable1, S.No. should be update by 1 for next row
            }
            
            /*       another way for display the data into jTable1
            
            ResultSetMetaData rsd = rs.getMetaData();
            int c = rsd.getColumnCount();
            
            dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            
            int s=1;
            
            while(rs.next())
            {
                Vector v = new Vector();
            
                v.add(s);
            
                for(int i=1; i<=c; i++)
                    v.add(rs.getString(i));
            
                dtm.addRow(v);
                s++;
            }
            */
            
            rs.close();
            pst.close();
            conn.close();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        // validate to all input fields
    boolean validation()
    {
        boolean b = false;
        
        Date date =  jDateChooser1.getDate();   // store date from jDateChooser1 field
        
        if(jTextField1.getText().trim().isEmpty())  // check Exam name will be entered or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Exam Name");
            jTextField1.requestFocus();
        }
        else if(date == null)       // check date
            JOptionPane.showMessageDialog(null, "Plese Select Exam Date");
        else
            b = true;
        
        return b;
    }
    
        // method for clear all the input fields
    void clear()
    {
        jTextField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jDateChooser1.setCalendar(null);        // set jDateChooser1 field as empty
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        
        jTextField1.requestFocus();     // focus on 'Exam Name' field
        jButton1.setEnabled(true);      // set save button enable
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Exam");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Exam Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Shift");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Class");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Section");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Subject");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jComboBox1, 0, 136, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Exam Name", "Shift", "Date", "Class", "Section", "Subject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(8);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(12);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(354, 354, 354)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

            // Back button code
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin_Home(uname,utype).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

            // Save button code
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(validation())        // check validation
        {
            String sql = "insert into Exam(Exam_Name, Shift, Date, Class, Section, Subject) values(?,?,?,?,?,?)";
            SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");      // set date format
            String date = df1.format(jDateChooser1.getDate());              // store date in above format
            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jComboBox1.getSelectedItem().toString());
                pst.setString(3, date);
                pst.setString(4, jComboBox2.getSelectedItem().toString());
                pst.setString(5, jComboBox3.getSelectedItem().toString());
                pst.setString(6, jComboBox4.getSelectedItem().toString());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Exam Added Successfuly");

                pst.close();
                conn.close();

                showData();     // fetch all the data from 'Exam' table and put into jTable1
                clear();        //  clear all the input fields

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

            // Delete button code
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dtm = (DefaultTableModel)jTable1.getModel();        // store jTable1 reference
        int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

                 // get data from selected jTable1's row
        String ename = dtm.getValueAt(selectIndex, 1).toString();
        String shift = dtm.getValueAt(selectIndex, 2).toString();
        String date = dtm.getValueAt(selectIndex, 3).toString();
        String classn = dtm.getValueAt(selectIndex, 4).toString();
        String section = dtm.getValueAt(selectIndex, 5).toString();
        String subject = dtm.getValueAt(selectIndex, 6).toString();

        String sql = "delete from Exam where Exam_Name='"+ename+"' and Shift='"+shift+"' and Date='"+date+"' and Class='"+classn+"' and Section='"+section+"' and Subject='"+subject+"'";
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Exam Info Deleted Successfuly");

            pst.close();
            conn.close();
            
            showData();     // fetch all the data from 'Exam' table and show all in jTable1
            clear();        // clear all the input fields
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

                // when clicks on any row of jTable1
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            // TODO add your handling code here:
            
            dtm = (DefaultTableModel)jTable1.getModel();    // holds reference of jTable1
            
            int selectIndex = jTable1.getSelectedRow();     // store index number of selected row
            
                // set data into input field from corresponding jTable1's column data
            jTextField1.setText(dtm.getValueAt(selectIndex, 1).toString());
            jComboBox1.setSelectedItem(dtm.getValueAt(selectIndex, 2).toString());
            
            Date d = new SimpleDateFormat("dd-MM-yyyy").parse((String)dtm.getValueAt(selectIndex, 3));
            jDateChooser1.setDate(d);
            
            jDateChooser1.setDateFormatString(dtm.getValueAt(selectIndex, 3).toString());
            jComboBox2.setSelectedItem(dtm.getValueAt(selectIndex, 4).toString());
            jComboBox3.setSelectedItem(dtm.getValueAt(selectIndex, 5).toString());
            jComboBox4.setSelectedItem(dtm.getValueAt(selectIndex, 6).toString());
            
            jButton1.setEnabled(false);     // set Save button disable
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
