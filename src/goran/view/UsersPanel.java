/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.UserController;
import goran.model.User;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goran
 */
public class UsersPanel extends javax.swing.JPanel {

    private User user;
    private UserController userControl;

    /**
     * Creates new form UsersPanel
     */
    public UsersPanel() {
        initComponents();
        user = new User();
        userControl = new UserController();
        updateUsers();
    }

    private void updateUsers() {

        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];

        for (User user : userControl.getUsers()) {
            rowData[0] = user.getFirstName();
            rowData[1] = user.getLastName();
            rowData[2] = user.getEmail();
            rowData[3] = user.getAddress();
            rowData[4] = user.getLocality();
            model.addRow(rowData);
        }
    }

    private void findUsers() {

        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];

        for (User user : userControl.findUsers(txtFindUser.getText())) {
            rowData[0] = user.getFirstName();
            rowData[1] = user.getLastName();
            rowData[2] = user.getEmail();
            rowData[3] = user.getAddress();
            rowData[4] = user.getLocality();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameUsersUtil = new javax.swing.JFrame();
        pnlUsersUtilMain = new javax.swing.JPanel();
        txtLocality = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        pnlUsersUtilTitle = new MotionPanel(frameUsersUtil);
        lblUsersUtil = new javax.swing.JLabel();
        txtFindUser = new javax.swing.JTextField();
        btnFindUser = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();
        btnReviewOrders = new javax.swing.JButton();
        btnRemoveUser = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();

        frameUsersUtil.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameUsersUtil.setUndecorated(true);
        frameUsersUtil.setResizable(false);
        frameUsersUtil.setSize(new java.awt.Dimension(540, 390));
        frameUsersUtil.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUsersUtilMain.setBackground(new java.awt.Color(60, 60, 70));
        pnlUsersUtilMain.setPreferredSize(new java.awt.Dimension(550, 380));
        pnlUsersUtilMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLocality.setBackground(new java.awt.Color(153, 153, 153));
        txtLocality.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocality.setForeground(new java.awt.Color(255, 255, 255));
        pnlUsersUtilMain.add(txtLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 370, 40));

        btnConfirm.setBackground(new java.awt.Color(0, 0, 0));
        btnConfirm.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_confirm.png"))); // NOI18N
        btnConfirm.setText("POTVRDI");
        btnConfirm.setBorder(null);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setPreferredSize(new java.awt.Dimension(80, 80));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUsersUtilMain.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 120, 50));

        btnCancel.setBackground(new java.awt.Color(0, 0, 0));
        btnCancel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel.png"))); // NOI18N
        btnCancel.setText("NAZAD");
        btnCancel.setBorder(null);
        btnCancel.setFocusPainted(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlUsersUtilMain.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 120, 50));

        txtFirstName.setBackground(new java.awt.Color(153, 153, 153));
        txtFirstName.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(255, 255, 255));
        pnlUsersUtilMain.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 370, 40));

        txtLastName.setBackground(new java.awt.Color(153, 153, 153));
        txtLastName.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        pnlUsersUtilMain.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 370, 40));

        txtEmail.setBackground(new java.awt.Color(153, 153, 153));
        txtEmail.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        pnlUsersUtilMain.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 370, 40));

        txtAddress.setBackground(new java.awt.Color(153, 153, 153));
        txtAddress.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        pnlUsersUtilMain.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 370, 40));

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MJESTO");
        pnlUsersUtilMain.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 40));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("IME");
        pnlUsersUtilMain.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PREZIME");
        pnlUsersUtilMain.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 40));

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-MAIL");
        pnlUsersUtilMain.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 130, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ADRESA");
        pnlUsersUtilMain.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 130, 40));

        lblError.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        pnlUsersUtilMain.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 210, 30));

        frameUsersUtil.getContentPane().add(pnlUsersUtilMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 540, 350));

        pnlUsersUtilTitle.setBackground(new java.awt.Color(30, 30, 40));
        pnlUsersUtilTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsersUtil.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblUsersUtil.setForeground(new java.awt.Color(255, 255, 255));
        lblUsersUtil.setText("DODAJ NOVOG KORISNIKA");
        pnlUsersUtilTitle.add(lblUsersUtil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 40));

        frameUsersUtil.getContentPane().add(pnlUsersUtilTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFindUser.setBackground(new java.awt.Color(120, 120, 120));
        txtFindUser.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txtFindUser.setForeground(new java.awt.Color(255, 255, 255));
        add(txtFindUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 40));

        btnFindUser.setBackground(new java.awt.Color(0, 0, 0));
        btnFindUser.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFindUser.setForeground(new java.awt.Color(255, 255, 255));
        btnFindUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFindUser.setText("TRAŽI");
        btnFindUser.setBorder(null);
        btnFindUser.setFocusPainted(false);
        btnFindUser.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFindUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindUserActionPerformed(evt);
            }
        });
        add(btnFindUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 40));

        btnAddUser.setBackground(new java.awt.Color(0, 0, 0));
        btnAddUser.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAddUser.setForeground(new java.awt.Color(255, 255, 255));
        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnAddUser.setText("DODAJ");
        btnAddUser.setBorder(null);
        btnAddUser.setFocusPainted(false);
        btnAddUser.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 40));

        btnEditUser.setBackground(new java.awt.Color(0, 0, 0));
        btnEditUser.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEditUser.setForeground(new java.awt.Color(255, 255, 255));
        btnEditUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_edit.png"))); // NOI18N
        btnEditUser.setText("UREDI");
        btnEditUser.setBorder(null);
        btnEditUser.setFocusPainted(false);
        btnEditUser.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 40));

        btnReviewOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnReviewOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnReviewOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnReviewOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_tickets.png"))); // NOI18N
        btnReviewOrders.setText("PREGLEDAJ NARUDŽBE");
        btnReviewOrders.setBorder(null);
        btnReviewOrders.setFocusPainted(false);
        btnReviewOrders.setPreferredSize(new java.awt.Dimension(80, 80));
        btnReviewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewOrdersActionPerformed(evt);
            }
        });
        add(btnReviewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 350, 40));

        btnRemoveUser.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveUser.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemoveUser.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnRemoveUser.setText("UKLONI");
        btnRemoveUser.setBorder(null);
        btnRemoveUser.setFocusPainted(false);
        btnRemoveUser.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemoveUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveUserActionPerformed(evt);
            }
        });
        add(btnRemoveUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, 40));

        tblUsers.setBackground(new java.awt.Color(120, 120, 120));
        tblUsers.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 16));
        tblUsers.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        tblUsers.setForeground(new java.awt.Color(255, 255, 255));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IME", "PREZIME", "E-MAIL", "ADRESA", "MJESTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsers.setRowHeight(24);
        tblUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(tblUsers);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindUserActionPerformed

        if (txtFindUser.getText().matches("")) {
            updateUsers();
        } else {
            findUsers();
        }
    }//GEN-LAST:event_btnFindUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

        lblUsersUtil.setText(Utils.ADD_USER);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtLocality.setText("");

        frameUsersUtil.setVisible(true);
        frameUsersUtil.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed

        try {

            int selectedRow = tblUsers.getSelectedRow();
            user = userControl.getUsers().get(tblUsers.convertRowIndexToModel(selectedRow));
            
            lblUsersUtil.setText(Utils.EDIT_USER);
            txtFirstName.setText(user.getFirstName());
            txtLastName.setText(user.getLastName());
            txtEmail.setText(user.getEmail());
            txtAddress.setText(user.getAddress());
            txtLocality.setText(user.getLocality());

            frameUsersUtil.setVisible(true);
            frameUsersUtil.setLocationRelativeTo(this);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditUserActionPerformed

    private void btnReviewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewOrdersActionPerformed

    }//GEN-LAST:event_btnReviewOrdersActionPerformed

    private void btnRemoveUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveUserActionPerformed

        try {

            int selectedRow = tblUsers.getSelectedRow();
            user = userControl.getUsers().get(tblUsers.convertRowIndexToModel(selectedRow));
            userControl.removeUser(user);
            updateUsers();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRemoveUserActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        if (txtFirstName.getText().matches("") || txtLastName.getText().matches("") || txtEmail.getText().matches("")
                || txtAddress.getText().matches("") || txtLocality.getText().matches("")) {

            lblError.setText(Utils.INPUT_ERROR);

        } else {

            user.setFirstName(txtFirstName.getText());
            user.setLastName(txtLastName.getText());
            user.setEmail(txtEmail.getText());
            user.setAddress(txtAddress.getText());
            user.setLocality(txtLocality.getText());

            if (lblUsersUtil.getText().matches(Utils.ADD_USER)) {

                userControl.addUser(user);

            } else if (lblUsersUtil.getText().matches(Utils.EDIT_USER)) {

                userControl.editUser(user);
            }

            updateUsers();
            lblError.setText("");
            frameUsersUtil.dispose();
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        
        lblError.setText("");
        frameUsersUtil.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public void applyTheme() {

        setBackground(Theme.color2);
        btnAddUser.setBackground(Theme.color3);
        btnRemoveUser.setBackground(Theme.color3);
        btnEditUser.setBackground(Theme.color3);
        btnReviewOrders.setBackground(Theme.color3);
        btnFindUser.setBackground(Theme.color3);
        txtFindUser.setBackground(Theme.color4);
        tblUsers.setBackground(Theme.color4);
        tblUsers.setForeground(Theme.font1);
        pnlUsersUtilTitle.setBackground(Theme.color1);
        pnlUsersUtilMain.setBackground(Theme.color2);
        txtFirstName.setBackground(Theme.color4);
        txtLastName.setBackground(Theme.color4);
        txtAddress.setBackground(Theme.color4);
        txtEmail.setBackground(Theme.color4);
        txtLocality.setBackground(Theme.color4);
        btnConfirm.setBackground(Theme.color3);
        btnCancel.setBackground(Theme.color3);
        txtFindUser.setForeground(Theme.font1);
        txtFirstName.setForeground(Theme.font1);
        txtLastName.setForeground(Theme.font1);
        txtEmail.setForeground(Theme.font1);
        txtAddress.setForeground(Theme.font1);
        txtLocality.setForeground(Theme.font1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnFindUser;
    private javax.swing.JButton btnRemoveUser;
    private javax.swing.JButton btnReviewOrders;
    private javax.swing.JFrame frameUsersUtil;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblUsersUtil;
    private javax.swing.JPanel pnlUsersUtilMain;
    private javax.swing.JPanel pnlUsersUtilTitle;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFindUser;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLocality;
    // End of variables declaration//GEN-END:variables
}
