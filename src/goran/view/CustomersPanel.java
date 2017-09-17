/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.HibernateController;
import goran.util.StringUtil;
import goran.model.Customer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goran
 */
public class CustomersPanel extends javax.swing.JPanel {

    private Customer customer;
    private HibernateController<Customer> ctrlCustomer;

    /**
     * Creates new form CustomerPanel
     */
    public CustomersPanel() {
        initComponents();
        customer = new Customer();
        ctrlCustomer = new HibernateController<>();
        updateCustomers();
    }

    private void updateCustomers() {

        DefaultTableModel model = (DefaultTableModel) tblCustomers.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];

        for (Customer customer : ctrlCustomer.getList(customer)) {
            rowData[0] = customer.getFirstName();
            rowData[1] = customer.getLastName();
            rowData[2] = customer.getEmail();
            rowData[3] = customer.getAddress();
            rowData[4] = customer.getLocality();
            model.addRow(rowData);
        }
    }

    private void findCustomers() {

        DefaultTableModel model = (DefaultTableModel) tblCustomers.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];

        String findBy = "";

        switch (cmbFindBy.getSelectedItem().toString()) {
            case "IME":
                findBy = "firstName";
                break;
            case "PREZIME":
                findBy = "lastName";
                break;
            case "E-MAIL":
                findBy = "email";
                break;
            case "ADRESA":
                findBy = "address";
                break;
            case "MJESTO":
                findBy = "locality";
                break;

        }

        for (Customer customer : ctrlCustomer.find(customer, findBy, txtFindCustomer.getText())) {
            rowData[0] = customer.getFirstName();
            rowData[1] = customer.getLastName();
            rowData[2] = customer.getEmail();
            rowData[3] = customer.getAddress();
            rowData[4] = customer.getLocality();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameCustomersUtil = new javax.swing.JFrame();
        pnlUtil = new javax.swing.JPanel();
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
        pnlUtilTitle = new MotionPanel(frameCustomersUtil);
        lblCustomersUtil = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFindCustomer = new javax.swing.JTextField();
        btnFindCustomer = new javax.swing.JButton();
        btnAddCustomer = new javax.swing.JButton();
        btnEditCustomer = new javax.swing.JButton();
        btnReviewOrders = new javax.swing.JButton();
        btnRemoveCustomer = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        cmbFindBy = new javax.swing.JComboBox<>();

        frameCustomersUtil.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameCustomersUtil.setAlwaysOnTop(true);
        frameCustomersUtil.setUndecorated(true);
        frameCustomersUtil.setResizable(false);
        frameCustomersUtil.setSize(new java.awt.Dimension(400, 350));
        frameCustomersUtil.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUtil.setBackground(new java.awt.Color(60, 60, 70));
        pnlUtil.setPreferredSize(new java.awt.Dimension(550, 380));
        pnlUtil.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtLocality.setBackground(new java.awt.Color(153, 153, 153));
        txtLocality.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocality.setForeground(new java.awt.Color(255, 255, 255));
        txtLocality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUtil.add(txtLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 300, 40));

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
        pnlUtil.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 100, 40));

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
        pnlUtil.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 100, 40));

        txtFirstName.setBackground(new java.awt.Color(153, 153, 153));
        txtFirstName.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(255, 255, 255));
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUtil.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 300, 40));

        txtLastName.setBackground(new java.awt.Color(153, 153, 153));
        txtLastName.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(255, 255, 255));
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUtil.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 300, 40));

        txtEmail.setBackground(new java.awt.Color(153, 153, 153));
        txtEmail.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUtil.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 300, 40));

        txtAddress.setBackground(new java.awt.Color(153, 153, 153));
        txtAddress.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        pnlUtil.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 300, 40));

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("MJESTO");
        pnlUtil.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 80, 40));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("IME");
        pnlUtil.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PREZIME");
        pnlUtil.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 40));

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-MAIL");
        pnlUtil.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 80, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ADRESA");
        pnlUtil.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, 40));

        lblError.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        pnlUtil.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 40));

        frameCustomersUtil.getContentPane().add(pnlUtil, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 310));

        pnlUtilTitle.setBackground(new java.awt.Color(30, 30, 40));
        pnlUtilTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomersUtil.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblCustomersUtil.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomersUtil.setText("DODAJ NOVOG KORISNIKA");
        pnlUtilTitle.add(lblCustomersUtil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 230, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_add_user.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlUtilTitle.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        frameCustomersUtil.getContentPane().add(pnlUtilTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFindCustomer.setBackground(new java.awt.Color(120, 120, 120));
        txtFindCustomer.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtFindCustomer.setForeground(new java.awt.Color(255, 255, 255));
        txtFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCustomerActionPerformed(evt);
            }
        });
        add(txtFindCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 40));

        btnFindCustomer.setBackground(new java.awt.Color(0, 0, 0));
        btnFindCustomer.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFindCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnFindCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFindCustomer.setText("TRAŽI");
        btnFindCustomer.setBorder(null);
        btnFindCustomer.setFocusPainted(false);
        btnFindCustomer.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFindCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindCustomerActionPerformed(evt);
            }
        });
        add(btnFindCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 40));

        btnAddCustomer.setBackground(new java.awt.Color(0, 0, 0));
        btnAddCustomer.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnAddCustomer.setText("DODAJ");
        btnAddCustomer.setBorder(null);
        btnAddCustomer.setFocusPainted(false);
        btnAddCustomer.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });
        add(btnAddCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 40));

        btnEditCustomer.setBackground(new java.awt.Color(0, 0, 0));
        btnEditCustomer.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEditCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_edit.png"))); // NOI18N
        btnEditCustomer.setText("UREDI");
        btnEditCustomer.setBorder(null);
        btnEditCustomer.setFocusPainted(false);
        btnEditCustomer.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEditCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerActionPerformed(evt);
            }
        });
        add(btnEditCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 40));

        btnReviewOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnReviewOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnReviewOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnReviewOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_tickets.png"))); // NOI18N
        btnReviewOrders.setText("NARUČI");
        btnReviewOrders.setBorder(null);
        btnReviewOrders.setFocusPainted(false);
        btnReviewOrders.setPreferredSize(new java.awt.Dimension(80, 80));
        btnReviewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewOrdersActionPerformed(evt);
            }
        });
        add(btnReviewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 350, 40));

        btnRemoveCustomer.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveCustomer.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemoveCustomer.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnRemoveCustomer.setText("UKLONI");
        btnRemoveCustomer.setBorder(null);
        btnRemoveCustomer.setFocusPainted(false);
        btnRemoveCustomer.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemoveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCustomerActionPerformed(evt);
            }
        });
        add(btnRemoveCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, 40));

        tblCustomers.setAutoCreateRowSorter(true);
        tblCustomers.setBackground(new java.awt.Color(120, 120, 120));
        tblCustomers.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblCustomers.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        tblCustomers.setForeground(new java.awt.Color(255, 255, 255));
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCustomers.setRowHeight(24);
        tblCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane5.setViewportView(tblCustomers);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        cmbFindBy.setBackground(new java.awt.Color(120, 120, 120));
        cmbFindBy.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        cmbFindBy.setForeground(new java.awt.Color(255, 255, 255));
        cmbFindBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PREZIME", "IME", "E-MAIL", "ADRESA", "MJESTO" }));
        cmbFindBy.setMinimumSize(new java.awt.Dimension(90, 25));
        cmbFindBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFindByActionPerformed(evt);
            }
        });
        add(cmbFindBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindCustomerActionPerformed

        if (txtFindCustomer.getText().equals("")) {
            updateCustomers();
        } else {
            findCustomers();
        }
    }//GEN-LAST:event_btnFindCustomerActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed

        lblCustomersUtil.setText(StringUtil.ADD_CUSTOMER);
        txtFirstName.setText("");
        txtLastName.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        txtLocality.setText("");

        frameCustomersUtil.setVisible(true);
        frameCustomersUtil.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnEditCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerActionPerformed

        try {

            customer = ctrlCustomer.getList(customer).get(tblCustomers.convertRowIndexToModel(tblCustomers.getSelectedRow()));

            lblCustomersUtil.setText(StringUtil.EDIT_CUSTOMER);
            txtFirstName.setText(customer.getFirstName());
            txtLastName.setText(customer.getLastName());
            txtEmail.setText(customer.getEmail());
            txtAddress.setText(customer.getAddress());
            txtLocality.setText(customer.getLocality());

            frameCustomersUtil.setVisible(true);
            frameCustomersUtil.setLocationRelativeTo(this);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEditCustomerActionPerformed

    private void btnReviewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewOrdersActionPerformed
          
    }//GEN-LAST:event_btnReviewOrdersActionPerformed

    private void btnRemoveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCustomerActionPerformed

        try {

            customer = ctrlCustomer.getList(customer).get(tblCustomers.convertRowIndexToModel(tblCustomers.getSelectedRow()));
            ctrlCustomer.delete(customer);
            updateCustomers();
            customer = new Customer();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRemoveCustomerActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed

        if (txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtEmail.getText().equals("")
                || txtAddress.getText().equals("") || txtLocality.getText().equals("")) {

            lblError.setText(StringUtil.INPUT_ERROR);

        } else {

            customer.setFirstName(txtFirstName.getText());
            customer.setLastName(txtLastName.getText());
            customer.setEmail(txtEmail.getText());
            customer.setAddress(txtAddress.getText());
            customer.setLocality(txtLocality.getText());

            ctrlCustomer.save(customer);
            updateCustomers();
            lblError.setText("");
            frameCustomersUtil.dispose();
            customer = new Customer();
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed

        lblError.setText("");
        frameCustomersUtil.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cmbFindByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFindByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFindByActionPerformed

    public void applyTheme() {

        setBackground(Theme.color2);
        btnAddCustomer.setBackground(Theme.color3);
        btnRemoveCustomer.setBackground(Theme.color3);
        btnEditCustomer.setBackground(Theme.color3);
        btnReviewOrders.setBackground(Theme.color3);
        btnFindCustomer.setBackground(Theme.color3);
        txtFindCustomer.setBackground(Theme.color4);
        tblCustomers.setBackground(Theme.color4);
        tblCustomers.setForeground(Theme.font1);
        pnlUtilTitle.setBackground(Theme.color1);
        pnlUtil.setBackground(Theme.color2);
        txtFirstName.setBackground(Theme.color4);
        txtLastName.setBackground(Theme.color4);
        txtAddress.setBackground(Theme.color4);
        txtEmail.setBackground(Theme.color4);
        txtLocality.setBackground(Theme.color4);
        btnConfirm.setBackground(Theme.color3);
        btnCancel.setBackground(Theme.color3);
        txtFindCustomer.setForeground(Theme.font1);
        txtFirstName.setForeground(Theme.font1);
        txtLastName.setForeground(Theme.font1);
        txtEmail.setForeground(Theme.font1);
        txtAddress.setForeground(Theme.font1);
        txtLocality.setForeground(Theme.font1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEditCustomer;
    private javax.swing.JButton btnFindCustomer;
    private javax.swing.JButton btnRemoveCustomer;
    private javax.swing.JButton btnReviewOrders;
    private javax.swing.JComboBox<String> cmbFindBy;
    private javax.swing.JFrame frameCustomersUtil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblCustomersUtil;
    private javax.swing.JLabel lblError;
    private javax.swing.JPanel pnlUtil;
    private javax.swing.JPanel pnlUtilTitle;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFindCustomer;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLocality;
    // End of variables declaration//GEN-END:variables
}
