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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Teacher extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs,rs1=null;
    DefaultTableModel dtm;      // for holds jTable1
    
    String uname,utype;
    /**
     * Creates new form Student
     */
    public Teacher() {
        
    }

            // receive username and usertype
    Teacher(String uname, String utype) {
        super("Teacher Registration...");
        
        this.uname = uname;         // stores username
        this.utype = utype;         // stores usertype
        
        initComponents();
        
        showData();            // all previous stored data display on jTablel
    }
    
        // method for fetching all the data from 'Teacher' table and put into jTable1
    public void showData()
    {
        String sql = "select * from Teacher";       // query for select all data from the 'Teacher' table
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
                Vector v = new Vector();        // for hold the data row by row
                
                v.add(s);              // add S.No.
                v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));                // pass database column name
                v.add(rs.getString("Qualification"));       // pass database column name
                v.add(rs.getString("Salary"));              // pass database column name
                v.add(rs.getString("Contact"));             // pass database column name
                v.add(rs.getString("Email"));               // pass database column name
                v.add(rs.getString("Address"));             // pass database column name

                dtm.addRow(v);          // add row in jTable1
                s++;           // after adding the new row in jTable1, S.No. should be update by 1 for next row
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
        
        if(jTextField1.getText().trim().isEmpty())            // check valid 'Name' will be entered or not
        {
            JOptionPane.showMessageDialog(null, "Plese Fill Name Field");
            jTextField1.requestFocus();            // cursor focus on 'Name' field
        }
        else if(jTextField2.getText().trim().isEmpty())      // check 'Qualification' field empty or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Higher Qualification");
            jTextField2.requestFocus();
        }
        else if(jTextField3.getText().trim().isEmpty())      // check 'Salary' field empty or not
        {
            JOptionPane.showMessageDialog(null, "Plese Fill The Salary Field");
            jTextField3.requestFocus();
        }
        else if(jTextField4.getText().trim().length() != 10)    // check entered Contact No. length equal to 10 or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter 10 Digit Contact Number");
            jTextField4.requestFocus();
        }
        else if(jTextField5.getText().trim().isEmpty())      // check 'E-Mail' field empty or not
        {
            JOptionPane.showMessageDialog(null, "Plese Fill The E-Mail Field");
            jTextField5.requestFocus();
        }
        else if(jTextField6.getText().trim().isEmpty())      // check 'Address' field empty or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Current Address");
            jTextField6.requestFocus();
        }
        else
        {
            int k = 0;
            try       // check 'Salary' and 'Contact no.', in digits or not
            {
                Integer.parseInt(jTextField3.getText().trim());       // try to convert 'Salary' into digits...
                
                k = 1;
                Integer.parseInt(jTextField4.getText().trim());      // try to convert 'contact no' into digits...
                
                b = true;
                
            }catch(Exception e)     // what caused the exception occur, it will be known from the value of k
            {
                if(k == 0)
                {
                    JOptionPane.showMessageDialog(null, "Plese Enter Salary In Digits");
                    jTextField3.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Plese Enter Valid 10 Digit Contact Number");
                    jTextField4.requestFocus();
                }
            }
        }
        
        return b;
    }
    
    void clear()        // clear entered input data
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        
        jTextField1.requestFocus();       // focus on 'Name' field
        jButton1.setEnabled(true);        // set 'Save' button enable
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("Teacher Registration");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Salary");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("E-Mail");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Qualification");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Address");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Contact No.");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jTextField5)
                    .addComponent(jTextField6))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Id", "Name", "Qualification", "Salary", "Contact No.", "Email", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(13);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setText("Clear");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setText("Exit");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton3)
                        .addGap(80, 80, 80)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(392, 392, 392))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

                // when clicks on any row of jTable1
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        // TODO add your handling code here:
        dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
        int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

                // set data into input fields from corresponding jTable1's column data
        jTextField1.setText(dtm.getValueAt(selectIndex, 2).toString());
        jTextField2.setText(dtm.getValueAt(selectIndex, 3).toString());
        jTextField3.setText(dtm.getValueAt(selectIndex, 4).toString());
        jTextField4.setText(dtm.getValueAt(selectIndex, 5).toString());
        jTextField5.setText(dtm.getValueAt(selectIndex, 6).toString());
        jTextField6.setText(dtm.getValueAt(selectIndex, 7).toString());

        jButton1.setEnabled(false);       // set 'Save' button disable
        jTextField1.requestFocus();       // focus on 'Name' field

    }//GEN-LAST:event_jTable1MouseClicked
    
                    // Edit button code
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(validation())        // check validation
        {
            dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
            int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

            String id = dtm.getValueAt(selectIndex, 1).toString(); // stores 'Id' (primary key of 'Teacher' table) from jTable1

            String sql = "update Teacher set Name=?, Qualification=?, Salary=?, Contact=?, Email=?, Address=? where id=?";

            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);

                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jTextField2.getText().trim());
                pst.setString(3, jTextField3.getText().trim());
                pst.setString(4, jTextField4.getText().trim());
                pst.setString(5, jTextField5.getText().trim());
                pst.setString(6, jTextField6.getText().trim());
                pst.setString(7, id);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Teacher Information Edit Successfuly");

                pst.close();
                conn.close();

                showData();     // fetch all the data from 'Teacher' table and show all in jTable1
                clear();        // clear all input field

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

                // Save button code
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(validation())        // check validation
        {
            String sql = "insert into Teacher(Id, Name, Qualification, Salary, Contact, Email, Address) values(?,?,?,?,?,?,?)";

            Random r = new Random();                             // random number 'for Student Id'
            String s = Integer.toString(r.nextInt(1000)+1);      // stores generated random number 

            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, s);
                pst.setString(2, jTextField1.getText().trim());
                pst.setString(3, jTextField2.getText().trim());
                pst.setString(4, jTextField3.getText().trim());
                pst.setString(5, jTextField4.getText().trim());
                pst.setString(6, jTextField5.getText().trim());
                pst.setString(7, jTextField6.getText().trim());
                pst.execute();
                JOptionPane.showMessageDialog(null, "New Teacher Added");

                pst.close();
                conn.close();

                showData();     // fetch all the data from 'Teacher' table and show all in jTable1
                clear();        // clear all input field

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

                // Clear button code
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton4ActionPerformed

                // Back button code
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin_Home(uname,utype).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

                // Delete button code
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
        int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

                // store id  (primary key of 'Teacher' table) from selected jTable1's row    
        String id = dtm.getValueAt(selectIndex, 1).toString();
        
        String sql = "delete from Teacher where Id=?";        // deletion query
        
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Teacher Deleted Successfuly");
            
            pst.close();
            conn.close();
            
            showData();     // fetch all the data from 'Teacher' table and show all in jTable1  
            clear();        // clear input field
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
                // Exit button code
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null, "Are You Sure??? You Want To Exit !!!", "School Management System", JOptionPane.YES_NO_OPTION);
        if(i == 0)
            System.exit(0);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
