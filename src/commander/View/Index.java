/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package commander.View;

import commander.DAO.UserDAO;


/**
 *
 * @author dm200
 */
public class Index extends javax.swing.JFrame {

    /**
     * Creates new form Index
     */
    public Index() {
        initComponents();
        
        this.setLocationRelativeTo(null);
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
        btnUsersView = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnProductsView = new javax.swing.JButton();
        btnDishesView = new javax.swing.JButton();
        btnOrderView = new javax.swing.JButton();
        btnCommanderView = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("Bienvenido");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnUsersView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUsersView.setText("Usuarios");
        btnUsersView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersViewActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Administrar:");

        btnProductsView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnProductsView.setText("Productos");
        btnProductsView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsViewActionPerformed(evt);
            }
        });

        btnDishesView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDishesView.setText("Platos");
        btnDishesView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDishesViewActionPerformed(evt);
            }
        });

        btnOrderView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOrderView.setText("Ordenes");
        btnOrderView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderViewActionPerformed(evt);
            }
        });

        btnCommanderView.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCommanderView.setText("Comanda");
        btnCommanderView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommanderViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnUsersView)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnProductsView)
                                .addGap(42, 42, 42)
                                .addComponent(btnDishesView, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnOrderView)
                        .addGap(51, 51, 51)
                        .addComponent(btnCommanderView)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsersView)
                    .addComponent(btnProductsView)
                    .addComponent(btnDishesView))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrderView)
                    .addComponent(btnCommanderView))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersViewActionPerformed
        UserView myUsersView = new UserView();
        myUsersView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUsersViewActionPerformed

    private void btnProductsViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsViewActionPerformed
        ProductView myProductView = new ProductView();
        myProductView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProductsViewActionPerformed

    private void btnDishesViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDishesViewActionPerformed
        DishView myDishesView = new DishView();
        myDishesView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDishesViewActionPerformed

    private void btnOrderViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderViewActionPerformed
        OrderView myOrderView = new OrderView();
        myOrderView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOrderViewActionPerformed

    private void btnCommanderViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommanderViewActionPerformed
        CommanderView myCommanderView = new CommanderView();
        myCommanderView.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCommanderViewActionPerformed

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
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCommanderView;
    private javax.swing.JButton btnDishesView;
    private javax.swing.JButton btnOrderView;
    private javax.swing.JButton btnProductsView;
    private javax.swing.JButton btnUsersView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
