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
import java.util.Random;
import java.util.Vector;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Student extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs,rs1=null;
    DefaultTableModel dtm;
    
    
    String uname, utype;
    /**
     * Creates new form Student
     */
    public Student() {
        
    }

    Student(String uname, String utype) {
    
        super("Student Registration...");
        
        this.uname = uname;
        this.utype = utype;
        
        initComponents();
        
        loadComboBoxData();
        showData();
    }
    
    public void loadComboBoxData()
    {
        try
        {
            conn = javaConnect.connectDb();
            
            String sql = "select Distinct Name from Class";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox2.removeAllItems();
            while(rs.next())
                jComboBox2.addItem(rs.getString("Name"));
            rs.close();
            pst.close();
            
            sql = "select Distinct Section from Class";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jComboBox3.removeAllItems();
            while(rs.next())
                jComboBox3.addItem(rs.getString("Section"));
            rs.close();
            pst.close();
            
            conn.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void showData()
    {
        String sql = "select * from Student";
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            dtm = (DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);
            
            int s=1;
            while(rs.next())
            {
                Vector v = new Vector();
                
                v.add(s);
                v.add(rs.getString("Id"));
                v.add(rs.getString("Name"));    // pass database column name
                v.add(rs.getString("F_Name"));  // pass database column name
                v.add(rs.getString("DOB"));    // pass database column name
                v.add(rs.getString("Gender"));  // pass database column name
                v.add(rs.getString("Contact"));    // pass database column name
                v.add(rs.getString("Address"));  // pass database column name
                v.add(rs.getString("Class"));    // pass database column name
                v.add(rs.getString("Section"));    // pass database column name

                dtm.addRow(v);
                s++;
            }
            
            /*
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
    
    boolean validation()
    {
        boolean b = false;
        
        Date d = jDateChooser1.getDate();
        
        if(jTextField1.getText().trim().length() <3)
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Name, Having Atleast 3 Characters");
            jTextField1.requestFocus();
        }
        else if(jTextField2.getText().trim().length() <3)
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Valid Father's Name, Having Atleast 3 Characters");
            jTextField2.requestFocus();
        }
        else if(d == null)
            JOptionPane.showMessageDialog(null, "Plese Fill Date Of Birth Field");
        else if(jTextField3.getText().trim().length() != 10)
        {
            JOptionPane.showMessageDialog(null, "Plese Enter 10 Digit Contact Number");
            jTextField3.requestFocus();
        }
        else if(jTextField4.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Plese Fill The Address Field");
            jTextField4.requestFocus();
        }
        else
        {
            try
            {
                Integer.parseInt(jTextField3.getText().trim());
                b = true;
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Plese Enter Valid 10 Digit Contact Number");
                jTextField3.requestFocus();
            }
        }
        
        return b;
    }
    
    void clear()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        jDateChooser1.setCalendar(null);
        jTextField3.setText("");
        jTextField4.setText("");
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        
        jTextField1.requestFocus();
        jButton1.setEnabled(true);
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
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
        jLabel1.setText("Student Registration");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Date Of Birth");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Contact No.");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Father Name");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Address");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Class");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Section");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jTextField4)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, 158, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 33, Short.MAX_VALUE))))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Id", "Name", "Father Name", "Date Of Birth", "Gender", "Contact No.", "Address", "Class", "Section"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(5).setMinWidth(50);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(55);
            jTable1.getColumnModel().getColumn(8).setMinWidth(50);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(55);
            jTable1.getColumnModel().getColumn(9).setMinWidth(60);
            jTable1.getColumnModel().getColumn(9).setMaxWidth(70);
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
                        .addGap(55, 55, 55)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(jButton3)
                        .addGap(141, 141, 141)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(423, 423, 423))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jButton5)
                    .addComponent(jButton1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        try {
            // TODO add your handling code here:
            dtm = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            
            //String id = dtm.getValueAt(selectIndex, 1).toString();
            
            jTextField1.setText(dtm.getValueAt(selectIndex, 2).toString());
            jTextField2.setText(dtm.getValueAt(selectIndex, 3).toString());
            
            jComboBox1.setSelectedItem(dtm.getValueAt(selectIndex, 5).toString());
            jTextField3.setText(dtm.getValueAt(selectIndex, 6).toString());
            jTextField4.setText(dtm.getValueAt(selectIndex, 7).toString());
            jComboBox2.setSelectedItem(dtm.getValueAt(selectIndex, 8).toString());
            jComboBox3.setSelectedItem(dtm.getValueAt(selectIndex, 9).toString());
            
            Date d = new SimpleDateFormat("dd-MM-yyyy").parse((String)dtm.getValueAt(selectIndex, 4));  // import java.util.date then it works properly...
            
            jDateChooser1.setDate(d);
            
            jButton1.setEnabled(false);
            jTextField1.requestFocus();
            
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(validation())
        {
            dtm = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();

            String id = dtm.getValueAt(selectIndex, 1).toString();

            String sql = "update Student set Name=?, F_Name=?, DOB=?, Gender=?, Contact=?, Address=?, Class=?, Section=? where Id=?";
            SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
            String date = df1.format(jDateChooser1.getDate());

            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jTextField2.getText().trim());
                pst.setString(3, date);
                pst.setString(4, (String)jComboBox1.getSelectedItem().toString());
                pst.setString(5, jTextField3.getText().trim());
                pst.setString(6, jTextField4.getText().trim());
                pst.setString(7, (String)jComboBox2.getSelectedItem().toString());
                pst.setString(8, (String)jComboBox3.getSelectedItem().toString());
                pst.setString(9, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Student Edit Successfuly");

                pst.close();
                conn.close();

                showData();
                clear();
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(validation())
        {
            String sql = "insert into Student(Id, Name, F_Name, DOB, Gender, Contact, Address, Class, Section) values(?,?,?,?,?,?,?,?,?)";
            SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
            String date = df1.format(jDateChooser1.getDate());

            Random r = new Random();
            String s = Integer.toString(r.nextInt(1000)+1);

            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, s);
                pst.setString(2, jTextField1.getText().trim());
                pst.setString(3, jTextField2.getText().trim());
                pst.setString(4, date);
                pst.setString(5, (String)jComboBox1.getSelectedItem().toString());
                pst.setString(6, jTextField3.getText().trim());
                pst.setString(7, jTextField4.getText().trim());
                pst.setString(8, (String)jComboBox2.getSelectedItem().toString());
                pst.setString(9, (String)jComboBox3.getSelectedItem().toString());
                pst.execute();
                JOptionPane.showMessageDialog(null, "New Student Added");

                pst.close();
                conn.close();

                showData();
                clear();

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clear();
        jTextField1.requestFocus();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        if(utype.equals("Admin"))
            new Admin_Home(uname,utype).setVisible(true);
        else
            new Teacher_Home(uname,utype).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        dtm = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
        
        String id = dtm.getValueAt(selectIndex, 1).toString();
        
        String sql = "delete from Student where Id=?";
        
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Student Deleted Successfuly");
            
            pst.close();
            conn.close();
            
            jTextField1.requestFocus();
            clear();
            showData();
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
