/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.u2team.huansync.view.staffView;

import com.u2team.huansync.event.staff.controller.StaffController;
import com.u2team.huansync.event.staff.model.classes.Staff;
import com.u2team.huansync.event.workerRoles.controller.WorkerRolesController;
import com.u2team.huansync.event.workerRoles.model.classes.WorkerRole;
import com.u2team.huansync.view.MenuView;
import com.u2team.huansync.view.activityView.AlertDelete;
import com.u2team.huansync.view.activityView.Successful;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ANGIE DURAN
 */
public class StaffView extends javax.swing.JFrame {

    private List<WorkerRole> workRoles;
    Long workId;

    /**
     * Creates new form StaffView
     */
    public StaffView() {
        workRoles = new ArrayList<>();
        initComponents();
        workRoles = WorkerRolesController.getAllWorkerRoles();

        for (WorkerRole workerRole : workRoles) {
            selectWorkRole.addItem(workerRole.getWorkerRoleName());
        }

        selectWorkRole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el ID del rol seleccionado
                String selectedRoleName = (String) selectWorkRole.getSelectedItem();
                if (selectedRoleName != null) {
                    for (WorkerRole workerRole : workRoles) {
                        if (selectedRoleName.equals(workerRole.getWorkerRoleName())) {
                            workId = workerRole.getWorkerRoleId();
                            break;
                        }
                    }
                }
            }
        });
    }

    private boolean validateFields() {
        if (txtName.getText().trim().isEmpty() || txtNumberId.getText().trim().isEmpty() || txtBirthday.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You must complete all fields", "Validation error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        numberId = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        workRole = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        selectWorkRole = new javax.swing.JComboBox<>();
        selectStatus = new javax.swing.JComboBox<>();
        txtName = new javax.swing.JTextField();
        txtNumberId = new javax.swing.JTextField();
        txtBirthday = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        tittelStaff = new javax.swing.JLabel();
        btnViewStaff = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 148, 50));

        name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        name.setForeground(new java.awt.Color(0, 0, 0));
        name.setText("Name:");

        numberId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        numberId.setForeground(new java.awt.Color(0, 0, 0));
        numberId.setText("Number id:");

        birthday.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        birthday.setForeground(new java.awt.Color(0, 0, 0));
        birthday.setText("Birthday");

        status.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 0, 0));
        status.setText("Status:");

        workRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        workRole.setForeground(new java.awt.Color(0, 0, 0));
        workRole.setText("Work Role:");

        btnAdd.setBackground(new java.awt.Color(8, 69, 106));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(8, 69, 106));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        selectWorkRole.setBackground(new java.awt.Color(255, 195, 114));
        selectWorkRole.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        selectWorkRole.setForeground(new java.awt.Color(51, 51, 51));

        selectStatus.setBackground(new java.awt.Color(255, 195, 114));
        selectStatus.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        selectStatus.setForeground(new java.awt.Color(51, 51, 51));
        selectStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TASK_ASSIGNED", "NO_TASK_ASSIGNED", "DISMISSED", "INCAPACITED" }));

        txtName.setBackground(new java.awt.Color(255, 195, 114));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(51, 51, 51));
        txtName.setText("Name:");

        txtNumberId.setBackground(new java.awt.Color(255, 195, 114));
        txtNumberId.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNumberId.setForeground(new java.awt.Color(51, 51, 51));
        txtNumberId.setText("id");

        txtBirthday.setBackground(new java.awt.Color(255, 195, 114));
        txtBirthday.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtBirthday.setForeground(new java.awt.Color(51, 51, 51));
        txtBirthday.setText("yyyy-mm-dd");

        jPanel3.setBackground(new java.awt.Color(144, 19, 33));

        tittelStaff.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tittelStaff.setForeground(new java.awt.Color(255, 255, 255));
        tittelStaff.setText("STAFF");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tittelStaff)
                .addGap(174, 174, 174))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tittelStaff)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnViewStaff.setBackground(new java.awt.Color(8, 69, 106));
        btnViewStaff.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnViewStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStaff.setText("View Staff");
        btnViewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnViewStaff))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(workRole)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(status, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(birthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numberId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNumberId, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(selectWorkRole, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtBirthday, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(selectStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, 168, Short.MAX_VALUE))))
                            .addComponent(btnBack))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numberId)
                    .addComponent(txtNumberId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthday)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(workRole)
                    .addComponent(selectWorkRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnViewStaff))
                .addGap(29, 29, 29)
                .addComponent(btnBack)
                .addContainerGap(29, Short.MAX_VALUE))
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (validateFields()) {
            String numberId = txtNumberId.getText();
            String nameStaff = txtName.getText();
            LocalDate birthday = LocalDate.parse(txtBirthday.getText());
            String statusStaff = (String) selectStatus.getSelectedItem();
            
            Staff staff = new Staff(0, numberId, nameStaff, birthday, statusStaff, workId);
            StaffController.insertStaff(staff);
            System.out.println(staff);
            Successful successful = new Successful();
            successful.setVisible(true);
            successful.setLocationRelativeTo(null);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MenuView menu = new MenuView();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStaffActionPerformed
        StaffShow staffview = new StaffShow();
        staffview.setVisible(true);
        staffview.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnViewStaffActionPerformed

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
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthday;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewStaff;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel name;
    private javax.swing.JLabel numberId;
    private javax.swing.JComboBox<String> selectStatus;
    private javax.swing.JComboBox<String> selectWorkRole;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tittelStaff;
    private javax.swing.JTextField txtBirthday;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberId;
    private javax.swing.JLabel workRole;
    // End of variables declaration//GEN-END:variables
}
