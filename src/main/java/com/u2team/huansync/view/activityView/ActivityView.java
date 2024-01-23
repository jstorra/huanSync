/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.u2team.huansync.view.activityView;

import com.u2team.huansync.view.MenuView;

/**
 *
 * @author ANGIE DURAN
 */
public class ActivityView extends javax.swing.JFrame {

    /**
     * Creates new form Activity
     */
    public ActivityView() {
        initComponents();
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
        tittleActivities = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblActivities = new javax.swing.JTable();
        btnUpdaActivity = new javax.swing.JButton();
        btnDelActivity = new javax.swing.JButton();
        btnCreateActivity = new javax.swing.JButton();
        btnBackActivities = new javax.swing.JButton();
        btnViewCosplay = new javax.swing.JButton();
        btnViewTrivia = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        starTime = new javax.swing.JLabel();
        nParticipants = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtType = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtStartTime = new javax.swing.JTextField();
        txtNParticipants = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(650, 430));

        tittleActivities.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tittleActivities.setText("ACTIVITIES");

        jScrollPane1.setToolTipText("");
        jScrollPane1.setAutoscrolls(true);

        tblActivities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Type", "Category", "Start Time", "N° Participants"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblActivities);

        btnUpdaActivity.setText("Update");
        btnUpdaActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdaActivityActionPerformed(evt);
            }
        });

        btnDelActivity.setText("Delete");
        btnDelActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActivityActionPerformed(evt);
            }
        });

        btnCreateActivity.setText("Create Activity");
        btnCreateActivity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActivityActionPerformed(evt);
            }
        });

        btnBackActivities.setText("Back");
        btnBackActivities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActivitiesActionPerformed(evt);
            }
        });

        btnViewCosplay.setText("View Cosplay");
        btnViewCosplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCosplayActionPerformed(evt);
            }
        });

        btnViewTrivia.setText("View Trivia");
        btnViewTrivia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTriviaActionPerformed(evt);
            }
        });

        name.setText("Name:");

        type.setText("Type:");

        category.setText("Category:");

        starTime.setText("Start Time:");

        nParticipants.setText("N° Participants:");

        txtName.setText("jTextField1");

        txtType.setText("jTextField2");

        txtCategory.setText("jTextField3");

        txtStartTime.setText("jTextField4");

        txtNParticipants.setText("jTextField5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelActivity)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUpdaActivity)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtType, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                        .addComponent(txtStartTime)
                                        .addComponent(txtCategory)
                                        .addComponent(txtNParticipants))))
                            .addComponent(starTime, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nParticipants, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnViewCosplay)
                                .addGap(49, 49, 49)
                                .addComponent(btnViewTrivia))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBackActivities)
                .addGap(129, 129, 129))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(tittleActivities, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tittleActivities)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(type)
                            .addComponent(txtType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(category)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(starTime)
                            .addComponent(txtStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nParticipants)
                            .addComponent(txtNParticipants, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateActivity)
                            .addComponent(btnDelActivity)
                            .addComponent(btnUpdaActivity)
                            .addComponent(btnViewTrivia)
                            .addComponent(btnViewCosplay)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnBackActivities)
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdaActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdaActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdaActivityActionPerformed

    private void btnDelActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActivityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelActivityActionPerformed

    private void btnViewTriviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTriviaActionPerformed
        TriviaList viewTrivia = new TriviaList();
        viewTrivia.setVisible(true);
        viewTrivia.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnViewTriviaActionPerformed

    private void btnBackActivitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActivitiesActionPerformed
         MenuView menu = new MenuView();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActivitiesActionPerformed

    private void btnViewCosplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCosplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewCosplayActionPerformed

    private void btnCreateActivityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActivityActionPerformed
        CreateActivity createActi = new CreateActivity();
        createActi.setVisible(true);
        createActi.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnCreateActivityActionPerformed

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
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActivityView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ActivityView activity = new ActivityView();
                activity.setVisible(true);
                activity.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackActivities;
    private javax.swing.JButton btnCreateActivity;
    private javax.swing.JButton btnDelActivity;
    private javax.swing.JButton btnUpdaActivity;
    private javax.swing.JButton btnViewCosplay;
    private javax.swing.JButton btnViewTrivia;
    private javax.swing.JLabel category;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nParticipants;
    private javax.swing.JLabel name;
    private javax.swing.JLabel starTime;
    private javax.swing.JTable tblActivities;
    private javax.swing.JLabel tittleActivities;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtNParticipants;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStartTime;
    private javax.swing.JTextField txtType;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
