/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Lecturers;

import DAO.ConnectDB;
import DAO.Interface_Class;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author trung
 */
public class Lecturers_Class_Management_Form extends javax.swing.JInternalFrame implements Interface_Class {

    /**
     * Creates new form Lecturers_Subject_Management_Form
     */
    public Lecturers_Class_Management_Form() {
        initComponents();
        this.loadToTable();
    }

    public boolean checkForm() {
        try {
            if (txt_malop.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không để trống mã lớp!");
                return false;
            }
            if (txt_malop.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng mã lớp!");
                return false;
            }
            if (txt_tenlop.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "không để trống tên lớp!");
                return false;
            }
            if (txt_tenlop.getText().matches("[ ]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên lớp!");
                return false;
            }
            for (int i = 0; i < tbl_view.getRowCount(); i++) {
                if (txt_malop.getText().equalsIgnoreCase(tbl_view.getValueAt(i, 0).toString())) {
                    JOptionPane.showMessageDialog(this, "mã môn đã tồn tại, hãy chọn mã lớp khác!");
                    return false;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
        return true;
    }

    public void loadToTable() {
        String head[] = {"Mã lớp", "Tên lớp"};
        DefaultTableModel tablemodel = new DefaultTableModel(head, 0);
        String sql = "	select * from lop";
        try {
            ResultSet rs = connect.querySQL(sql);
            while (rs.next()) {
                Object data[] = {rs.getString(1), rs.getString(2)};
                tablemodel.addRow(data);
            }
            tbl_view.setModel(tablemodel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load Combobox" + e);
        }
    }

    ConnectDB connect = new ConnectDB();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_malop = new javax.swing.JTextField();
        txt_tenlop = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_addnew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_view = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Mã lớp:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Tên lớp:");

        jButton1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/logouttt.png"))); // NOI18N
        jButton1.setText("Thoát");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_addnew.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_addnew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_Icon/add-file (1).png"))); // NOI18N
        btn_addnew.setText("Thêm");
        btn_addnew.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_addnew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_addnew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_addnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addnewActionPerformed(evt);
            }
        });

        tbl_view.setBackground(new java.awt.Color(255, 255, 204));
        tbl_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã lớp", "Tên lớp"
            }
        ));
        jScrollPane1.setViewportView(tbl_view);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_addnew)
                        .addGap(75, 75, 75)
                        .addComponent(jButton1)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tenlop)
                            .addComponent(txt_malop, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(55, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_malop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenlop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_addnew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_addnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addnewActionPerformed
        // TODO add your handling code here:
        this.AddNew();
    }//GEN-LAST:event_btn_addnewActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addnew;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_view;
    private javax.swing.JTextField txt_malop;
    private javax.swing.JTextField txt_tenlop;
    // End of variables declaration//GEN-END:variables

    @Override
    public void AddNew() {
        if (this.checkForm()) {
            try {
                String sql = "exec sp_addLop N'" + txt_malop.getText() + "',N'" + txt_tenlop.getText() + "'";
                connect.UpdateSQL(sql);
                loadToTable();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void Delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CleanForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LoadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
