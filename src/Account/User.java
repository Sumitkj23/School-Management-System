package Account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit Kumar
 */

import Action.Admin_Home;
import Helper.javaConnect;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel dtm;      // for holds jTable1
    
    String uname,utype;
    
    public User() {
        
    }
    
            // receive username and usertype
    public User(String uname, String utype) {
        super("Add New User...");
        
        this.uname = uname;         // stores username
        this.utype = utype;         // stores usertype
        
        initComponents();       
        
        setResizable(false);        // set Maximize button disable
        
        showData();            // all previous stored data display on jTablel
    }
    
        // method for fetching all the data from 'User' table and put into jTable1
    public void showData()
    {
        String sql = "select * from User";       // query for select all data from the 'User' table
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            dtm = (DefaultTableModel)jTable1.getModel();        // holds jTable1 reference
            dtm.setRowCount(0);             // remove all the previous row from the jTable1
            
            int s=1;        // stores S.No.
            
            while(rs.next())
            {
                Vector v = new Vector();        // for hold the data row by row

                v.add(s);       // add S.No.
                v.add(rs.getString("Name"));
                v.add(rs.getString("Contact_no"));
                v.add(rs.getString("Address"));
                v.add(rs.getString("Username"));
                v.add(rs.getString("User_Type"));

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
    public boolean validation()
    {
        boolean b = false;
        
        if(jTextField1.getText().trim().length() <2)      // check valid 'Username' will be entered or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Username");
            jTextField1.requestFocus();                  // cursor focus on 'Name' field
        }
        else if(jTextField2.getText().trim().length() <3)      // check valid 'Name' will be entered or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Name, Having Atleaast 3 Characters");
            jTextField2.requestFocus();
        }
        else if(jPasswordField1.getText().trim().length() <4)      // check valid 'Password' will be entered or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Password, Having Atleast 4 Characters");
            jPasswordField1.requestFocus();
        }
        else if(jTextField3.getText().trim().length() != 10)    // check entered Contact No. length equal to 10 or not
        {
            JOptionPane.showMessageDialog(null, "Plese Enter 10 Digit Contact Number");
            jTextField3.requestFocus();
        }
        else if(jTextField4.getText().trim().isEmpty())      // check 'Address' field empty or not
        {
            JOptionPane.showMessageDialog(null, "Plese Fill The Address Field");
            jTextField4.requestFocus();
        }
        else
        {
            try       // check 'Contact no.', in digits or not
            {
                Long.parseLong(jTextField3.getText().trim());
                b = true;
            }catch(NumberFormatException e)     // if not then exception occur
            {
                JOptionPane.showMessageDialog(null, "Plese Enter Valid 10 Digit Contact Number");
                jTextField3.requestFocus();
            }
        }
        
        return b;
    }
    
        // clear entered input data
    public void clearText()        
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField1.setText("");
        jComboBox1.setSelectedIndex(0);
        jTextField3.setText("");
        jTextField4.setText("");
        
        jTextField1.requestFocus();       // cursor focus on 'Name' field
        Save_User.setEnabled(true);       // set 'Save' button enable
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Save_User = new javax.swing.JButton();
        Edit_User_Data = new javax.swing.JButton();
        Delete_Data = new javax.swing.JButton();
        Clear_Data = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Name", "Contact No.", "Address", "Username", "User Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Teacher" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contact No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Address");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("User Type");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
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
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("User Creation");

        jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("User Information");

        Save_User.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Save_User.setText("Save");
        Save_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_UserActionPerformed(evt);
            }
        });

        Edit_User_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Edit_User_Data.setText("Edit");
        Edit_User_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_User_DataActionPerformed(evt);
            }
        });

        Delete_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Delete_Data.setText("Delete");
        Delete_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_DataActionPerformed(evt);
            }
        });

        Clear_Data.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Clear_Data.setText("Clear");
        Clear_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clear_DataActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        Back.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(168, 168, 168))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Clear_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Save_User, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182)
                .addComponent(Edit_User_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Delete_Data)
                .addGap(47, 47, 47)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save_User)
                    .addComponent(Edit_User_Data)
                    .addComponent(Delete_Data)
                    .addComponent(Clear_Data)
                    .addComponent(jButton5)
                    .addComponent(Back))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

                // Save button code
    private void Save_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_UserActionPerformed
        // TODO add your handling code here:
        if(validation())        // check validation
        {
            String sql = "insert into User(Username, Name, Password, User_Type, Contact_no, Address) values(?,?,?,?,?,?)";
            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jTextField2.getText().trim());
                pst.setString(3, jPasswordField1.getText().trim());
                pst.setString(4, (String)jComboBox1.getSelectedItem().toString());
                pst.setString(5, jTextField3.getText().trim());
                pst.setString(6, jTextField4.getText().trim());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "User Added Successfuly...");
                
                pst.close();
                conn.close();
                
                showData();     // fetch all the data from 'User' table and show all in jTable1
                clearText();    // clear all input field
                
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_Save_UserActionPerformed

                // when clicks on any row of jTable1
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
        int selectIndex = jTable1.getSelectedRow();         // store index number of selected row
        
                // set data into input fields from corresponding jTable1's column data
        jTextField1.setText(dtm.getValueAt(selectIndex, 4).toString());
        jTextField2.setText(dtm.getValueAt(selectIndex, 1).toString());
        jTextField3.setText(dtm.getValueAt(selectIndex, 2).toString());
        jTextField4.setText(dtm.getValueAt(selectIndex, 3).toString());
        jComboBox1.setSelectedItem(dtm.getValueAt(selectIndex, 5).toString());
        
        jPasswordField1.setText("1234");   // set bydefault password field, which are only use for validation in edit action
        
        jTextField1.setEnabled(false);          // set 'Username' field disable
        jPasswordField1.setEnabled(false);      // set 'Password' field disable
        Save_User.setEnabled(false);            // set 'save' button disable
        
        jTextField2.requestFocus();             // cursor focus on 'Name' field
        
    }//GEN-LAST:event_jTable1MouseClicked

                    // Edit button code
    private void Edit_User_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_User_DataActionPerformed
        // TODO add your handling code here:
        if(validation())        // check validation
        {
            dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
            int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

            String id = dtm.getValueAt(selectIndex, 4).toString();  // stores 'Id' (primary key of 'User' table) from jTable1

            String sql = "update User set Name=?, User_Type=?, Contact_no=?, Address=? where Username='"+id+"'";
            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField2.getText().trim());                            // 1 -- Name
                pst.setString(2, (String)jComboBox1.getSelectedItem().toString());         // 2 -- User_Type
                pst.setString(3, jTextField3.getText().trim());                            // 3 -- Contact_no
                pst.setString(4, jTextField4.getText().trim());                            // 4 -- Address
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Edited");

                jTextField1.setEnabled(true);       // set Username field enable
                jPasswordField1.setEnabled(true);   // set Password field enable

                pst.close();
                conn.close();

                showData();     // fetch all the data from 'Teacher' table and show all in jTable1
                clearText();    // clear all input field
                
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }//GEN-LAST:event_Edit_User_DataActionPerformed

            // clear button code 
    private void Clear_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clear_DataActionPerformed
        // TODO add your handling code here:
        jTextField1.setEnabled(true);       // set Username field enable
        jPasswordField1.setEnabled(true);   // set Password field enable

        clearText();        // clear all input fields
    }//GEN-LAST:event_Clear_DataActionPerformed

            //Exit button code
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(null, "Are You Sure??? You Want To Exit !!!", "School Management System", JOptionPane.YES_NO_OPTION);
        if(i == 0)
            System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

                // Delete button code
    private void Delete_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_DataActionPerformed
        // TODO add your handling code here:
        
        dtm = (DefaultTableModel)jTable1.getModel();        // holds reference of jTable1
        int selectIndex = jTable1.getSelectedRow();         // store index number of selected row

                // store Username (primary key of 'User' table) from selected jTable1's row 
        String id = dtm.getValueAt(selectIndex, 4).toString();
        
        String sql = "delete from User where Username='"+id+"'";        // deletion query
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "User Deleted Successfuly");
            
            jTextField1.setEnabled(true);
            jPasswordField1.setEnabled(true);
            
            pst.close();
            conn.close();
            
            showData();     // fetch all the data from 'Subject' table and show all in jTable1  
            clearText();    // clear input field
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }        
    }//GEN-LAST:event_Delete_DataActionPerformed

                // Back button code
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        new Admin_Home(uname,utype).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear_Data;
    private javax.swing.JButton Delete_Data;
    private javax.swing.JButton Edit_User_Data;
    private javax.swing.JButton Save_User;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
