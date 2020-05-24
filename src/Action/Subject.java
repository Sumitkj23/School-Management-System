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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Subject extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel dtm;
    
    String uname, utype;
    /**
     * Creates new form Subject
     */
    public Subject() {
        
    }

    Subject(String uname, String utype) {
        super("Subject Information");
        
        this.uname = uname;
        this.utype = utype;
        
        initComponents();
        
        showData();
    }
    
    public void showData()
    {
        String sql = "select * from Subject";
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
                v.add(rs.getString("Id"));    // pass database column name
                v.add(rs.getString("Name"));  // pass database column name
                
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
        
        if(jTextField1.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Subject Id");
            jTextField1.requestFocus();
        }
        else if(jTextField2.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Plese Enter Subject Name");
            jTextField2.requestFocus();
        }
        else
            b = true;
        
        return b;
    }
    
    void clear()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField1.requestFocus();
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        saveSubject_Button = new javax.swing.JButton();
        deleteSubject_Button = new javax.swing.JButton();
        back_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Subject");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Subject Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Subject Name");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Subject Id", "Subject Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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

        saveSubject_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saveSubject_Button.setText("Save");
        saveSubject_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubject_ButtonActionPerformed(evt);
            }
        });

        deleteSubject_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteSubject_Button.setText("Delete");
        deleteSubject_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSubject_ButtonActionPerformed(evt);
            }
        });

        back_Button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        back_Button.setText("Back");
        back_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(back_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(saveSubject_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(deleteSubject_Button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(back_Button)
                            .addComponent(saveSubject_Button)
                            .addComponent(deleteSubject_Button)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        dtm = (DefaultTableModel)jTable1.getModel();
        
        int selectIndex = jTable1.getSelectedRow();
        
        jTextField1.setText(dtm.getValueAt(selectIndex, 1).toString());
        jTextField2.setText(dtm.getValueAt(selectIndex, 2).toString());
        
        saveSubject_Button.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void saveSubject_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubject_ButtonActionPerformed
        // TODO add your handling code here:
        if(validation())
        {
            String sql = "insert into Subject(Id, Name) values(?,?)";
            try
            {
                conn = javaConnect.connectDb();
                pst = conn.prepareStatement(sql);
                pst.setString(1, jTextField1.getText().trim());
                pst.setString(2, jTextField2.getText().trim());

                pst.execute();
                JOptionPane.showMessageDialog(null, "Subject Added");

                pst.close();
                conn.close();

                showData();
                clear();

            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_saveSubject_ButtonActionPerformed

    private void deleteSubject_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSubject_ButtonActionPerformed
        // TODO add your handling code here:

        dtm = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        String id = dtm.getValueAt(selectIndex, 1).toString();  // primary key

        String sql = "delete from Subject where Id='"+id+"'";
        try
        {
            conn = javaConnect.connectDb();
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Subject Deleted Successfuly");

            saveSubject_Button.setEnabled(true);

            pst.close();
            conn.close();
            
            showData();
            clear();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_deleteSubject_ButtonActionPerformed

    private void back_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_ButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        if(utype.equals("Admin"))
            new Admin_Home(uname,utype).setVisible(true);
        else
            new Teacher_Home(uname,utype).setVisible(true);
    }//GEN-LAST:event_back_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Subject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_Button;
    private javax.swing.JButton deleteSubject_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton saveSubject_Button;
    // End of variables declaration//GEN-END:variables
}
