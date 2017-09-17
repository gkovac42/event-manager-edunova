/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.HibernateController;
import goran.model.Order;
import goran.model.Ticket;
import goran.model.Customer;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;

/**
 *
 * @author Goran
 */
public class OrdersPanel extends javax.swing.JPanel {

    private Order order;
    private Customer customer;
    private Ticket ticket;
    private HibernateController<Customer> ctrlCustomer;
    private HibernateController<Ticket> ctrlTicket;
    private HibernateController<Order> ctrlOrder;
    private double totalPrice;

    public OrdersPanel() {

        initComponents();

        order = new Order();
        customer = new Customer();
        ticket = new Ticket();
        ctrlCustomer = new HibernateController<>();
        ctrlTicket = new HibernateController<>();
        ctrlOrder = new HibernateController<>();
        totalPrice = 0;

        updateCustomers();
        updateTickets();
    }

    public void updateCustomers() {

        DefaultListModel<Customer> model = new DefaultListModel<>();
        lstCustomers.setModel(model);
        for (Customer customer : ctrlCustomer.getOrderedList(customer, "lastName")) {
            model.addElement(customer);
        }
    }

    public void updateTickets() {

        DefaultListModel<Ticket> model = new DefaultListModel<>();
        lstTickets.setModel(model);
        for (Ticket ticket : ctrlTicket.getOrderedList(ticket, "name")) {
            model.addElement(ticket);
        }
    }

    public void updateOrderTickets() {

        DefaultListModel<Ticket> model = new DefaultListModel<>();
        lstOrderTickets.setModel(model);
        for (Ticket ticket : order.getTickets()) {
            if (ticket.isDeleted()) {
                continue;
            }
            model.addElement(ticket);
        }
    }

    private void updateOrders() {
        DefaultListModel<Order> model = new DefaultListModel<>();
        lstOrders.setModel(model);
        for (Order order : ctrlOrder.getList(order)) {
            model.addElement(order);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameOrdersUtil = new javax.swing.JFrame();
        pnlOrdersUtilMain = new javax.swing.JPanel();
        btnConfirmLocation = new javax.swing.JButton();
        btnCancelLocation = new javax.swing.JButton();
        txtFindOrder = new javax.swing.JTextField();
        lblErrorLocation = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<>();
        btnFindOrder = new javax.swing.JButton();
        pnlOrdersUtilTitle = new MotionPanel(frameOrdersUtil);
        lblLocations = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblOrder = new javax.swing.JLabel();
        lblTitle9 = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblLocality = new javax.swing.JLabel();
        btnViewOrders = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCustomers = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTickets = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOrderTickets = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        lblTitle8 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        btnFinishOrder = new javax.swing.JButton();
        lblFirstName = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnNewOrder = new javax.swing.JButton();

        frameOrdersUtil.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frameOrdersUtil.setAlwaysOnTop(true);
        frameOrdersUtil.setUndecorated(true);
        frameOrdersUtil.setResizable(false);
        frameOrdersUtil.setSize(new java.awt.Dimension(400, 420));
        frameOrdersUtil.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOrdersUtilMain.setBackground(new java.awt.Color(60, 60, 70));
        pnlOrdersUtilMain.setPreferredSize(new java.awt.Dimension(400, 380));
        pnlOrdersUtilMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnConfirmLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnConfirmLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnConfirmLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_confirm.png"))); // NOI18N
        btnConfirmLocation.setText("POTVRDI");
        btnConfirmLocation.setBorder(null);
        btnConfirmLocation.setFocusPainted(false);
        btnConfirmLocation.setPreferredSize(new java.awt.Dimension(80, 80));
        btnConfirmLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmLocationActionPerformed(evt);
            }
        });
        pnlOrdersUtilMain.add(btnConfirmLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 100, 40));

        btnCancelLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCancelLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel.png"))); // NOI18N
        btnCancelLocation.setText("NAZAD");
        btnCancelLocation.setBorder(null);
        btnCancelLocation.setFocusPainted(false);
        btnCancelLocation.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCancelLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelLocationActionPerformed(evt);
            }
        });
        pnlOrdersUtilMain.add(btnCancelLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 100, 40));

        txtFindOrder.setBackground(new java.awt.Color(153, 153, 153));
        txtFindOrder.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtFindOrder.setForeground(new java.awt.Color(255, 255, 255));
        txtFindOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOrderActionPerformed(evt);
            }
        });
        pnlOrdersUtilMain.add(txtFindOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 40));

        lblErrorLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblErrorLocation.setForeground(new java.awt.Color(255, 0, 0));
        pnlOrdersUtilMain.add(lblErrorLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 170, 40));

        lstOrders.setBackground(new java.awt.Color(153, 153, 153));
        lstOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lstOrders.setForeground(new java.awt.Color(255, 255, 255));
        lstOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstOrdersMouseClicked(evt);
            }
        });
        lstOrders.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOrdersValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstOrders);

        pnlOrdersUtilMain.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 260));

        btnFindOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnFindOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFindOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnFindOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFindOrder.setBorder(null);
        btnFindOrder.setFocusPainted(false);
        btnFindOrder.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFindOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOrderActionPerformed(evt);
            }
        });
        pnlOrdersUtilMain.add(btnFindOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 40));

        frameOrdersUtil.getContentPane().add(pnlOrdersUtilMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 400, 380));

        pnlOrdersUtilTitle.setBackground(new java.awt.Color(30, 30, 40));
        pnlOrdersUtilTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLocations.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblLocations.setForeground(new java.awt.Color(255, 255, 255));
        lblLocations.setText("POVIJEST NARUDŽBI");
        pnlOrdersUtilTitle.add(lblLocations, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 230, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_add_location.png"))); // NOI18N
        pnlOrdersUtilTitle.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 40));

        frameOrdersUtil.getContentPane().add(pnlOrdersUtilTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 40));

        setBackground(new java.awt.Color(60, 60, 70));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(255, 255, 255));
        lblOrder.setText("DETALJI NARUDŽBE");
        add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 250, 30));

        lblTitle9.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle9.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle9.setText("KORISNIK");
        add(lblTitle9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 30));

        lblEmail.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 250, 40));

        jLabel15.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("IME");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 100, 40));

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MJESTO");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 100, 40));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("E-MAIL");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 100, 40));

        lblLastName.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblLastName.setForeground(new java.awt.Color(255, 255, 255));
        add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 250, 40));

        lblAddress.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 40));

        lblLocality.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblLocality.setForeground(new java.awt.Color(255, 255, 255));
        add(lblLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 250, 40));

        btnViewOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnViewOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnViewOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnViewOrders.setText("POVIJEST");
        btnViewOrders.setBorder(null);
        btnViewOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOrdersActionPerformed(evt);
            }
        });
        add(btnViewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 30));

        lstCustomers.setBackground(new java.awt.Color(120, 120, 120));
        lstCustomers.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lstCustomers.setForeground(new java.awt.Color(255, 255, 255));
        lstCustomers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCustomersValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstCustomers);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, 190));

        lstTickets.setBackground(new java.awt.Color(120, 120, 120));
        lstTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lstTickets.setForeground(new java.awt.Color(255, 255, 255));
        lstTickets.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTicketsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstTickets);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 330, 190));

        lstOrderTickets.setBackground(new java.awt.Color(120, 120, 120));
        lstOrderTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lstOrderTickets.setForeground(new java.awt.Color(255, 255, 255));
        lstOrderTickets.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOrderTicketsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstOrderTickets);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 340, 190));

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnAdd.setText("DODAJ");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 40));

        lblTitle8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle8.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle8.setText("RASPOLOŽIVE ULAZNICE");
        add(lblTitle8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 30));

        btnRemove.setBackground(new java.awt.Color(0, 0, 0));
        btnRemove.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnRemove.setText("UKLONI");
        btnRemove.setBorder(null);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 100, 40));

        txtQuantity.setBackground(new java.awt.Color(120, 120, 120));
        txtQuantity.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setText("1");
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 70, 40));

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("UKUPNO :");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, 40));

        lblTotalPrice.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setText("0.00kn");
        add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 100, 40));

        btnFinishOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnFinishOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFinishOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnFinishOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_orders.png"))); // NOI18N
        btnFinishOrder.setText("ZAVRŠI");
        btnFinishOrder.setBorder(null);
        btnFinishOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishOrderActionPerformed(evt);
            }
        });
        add(btnFinishOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, -1, 40));

        lblFirstName.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblFirstName.setForeground(new java.awt.Color(255, 255, 255));
        add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ADRESA");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 100, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PREZIME");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 100, 40));

        btnNewOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnNewOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnNewOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel.png"))); // NOI18N
        btnNewOrder.setText("NOVA");
        btnNewOrder.setBorder(null);
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        add(btnNewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, 100, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if (lstOrderTickets.getSelectedIndex() != -1) {

            order.getTickets().remove(lstOrderTickets.getSelectedValue());
            updateOrderTickets();

            totalPrice -= lstOrderTickets.getSelectedValue().getPrice() * lstOrderTickets.getSelectedValue().getQuantity();
            lblTotalPrice.setText(new DecimalFormat("#.00").format(totalPrice) + "kn");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (lstTickets.getSelectedIndex() != -1 && lstCustomers.getSelectedIndex() != -1) {

            ticket = lstTickets.getSelectedValue();
            ticket.setQuantity(ticket.getQuantity() - Integer.parseInt(txtQuantity.getText()));
            ctrlTicket.save(ticket);
            updateTickets();

            order.setCustomer(customer);
            order.getTickets().add(ticket);
            updateOrderTickets();

            totalPrice += ticket.getPrice() * ticket.getQuantity();
            lblTotalPrice.setText(new DecimalFormat("#.00").format(totalPrice) + "kn");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFinishOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishOrderActionPerformed

        ctrlOrder.save(order);
        updateOrders();
        lstOrderTickets.removeAll();
    }//GEN-LAST:event_btnFinishOrderActionPerformed

    private void lstCustomersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCustomersValueChanged
        if (lstCustomers.getSelectedIndex() == -1) {
            lblFirstName.setText("");
            lblLastName.setText("");
            lblAddress.setText("");
            lblLocality.setText("");
            lblEmail.setText("");
        } else {
            customer = lstCustomers.getSelectedValue();
            lblFirstName.setText(customer.getFirstName());
            lblLastName.setText(customer.getLastName());
            lblAddress.setText(customer.getAddress());
            lblLocality.setText(customer.getLocality());
            lblEmail.setText(customer.getEmail());
        }
    }//GEN-LAST:event_lstCustomersValueChanged

    private void lstTicketsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTicketsValueChanged

    }//GEN-LAST:event_lstTicketsValueChanged

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void lstOrderTicketsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOrderTicketsValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstOrderTicketsValueChanged

    private void btnConfirmLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmLocationActionPerformed
        order = lstOrders.getSelectedValue();
        lstCustomers.setSelectedValue(order.getCustomer(), true);
        updateOrderTickets();
        lblOrder.setText("DETALJI NARUDŽBE #" + order.getId());
        frameOrdersUtil.dispose();

    }//GEN-LAST:event_btnConfirmLocationActionPerformed

    private void btnCancelLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelLocationActionPerformed

        frameOrdersUtil.dispose();
    }//GEN-LAST:event_btnCancelLocationActionPerformed

    private void btnFindOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindOrderActionPerformed

        if (txtFindOrder.getText().equals("")) {

            updateOrders();

        } else {

            DefaultListModel<Order> model = new DefaultListModel<>();
            lstOrders.setModel(model);
            for (Order order : ctrlOrder.find(order, "id", txtFindOrder.getText())) {
                model.addElement(order);
            }
        }
    }//GEN-LAST:event_btnFindOrderActionPerformed

    private void btnViewOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOrdersActionPerformed
        updateOrders();
        frameOrdersUtil.setVisible(true);
        frameOrdersUtil.setLocationRelativeTo(this);
    }//GEN-LAST:event_btnViewOrdersActionPerformed

    private void lstOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOrdersMouseClicked
        
        if (evt.getClickCount() == 2) {
            
            order = lstOrders.getSelectedValue();
            lstCustomers.setSelectedValue(order.getCustomer(), true);
            updateOrderTickets();
            lblOrder.setText("DETALJI NARUDŽBE #" + order.getId());
            frameOrdersUtil.dispose();
        }
    }//GEN-LAST:event_lstOrdersMouseClicked

    private void lstOrdersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOrdersValueChanged


    }//GEN-LAST:event_lstOrdersValueChanged

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        
        order = new Order();
        updateOrderTickets();
        
        lblOrder.setText("DETALJI NARUDŽBE");
        lblFirstName.setText("");
        lblLastName.setText("");
        lblAddress.setText("");
        lblLocality.setText("");
        lblEmail.setText("");
    }//GEN-LAST:event_btnNewOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelLocation;
    private javax.swing.JButton btnConfirmLocation;
    private javax.swing.JButton btnFindOrder;
    private javax.swing.JButton btnFinishOrder;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnViewOrders;
    private javax.swing.JFrame frameOrdersUtil;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorLocation;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblLocality;
    private javax.swing.JLabel lblLocations;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblTitle8;
    private javax.swing.JLabel lblTitle9;
    private javax.swing.JLabel lblTotalPrice;
    private static javax.swing.JList<goran.model.Customer> lstCustomers;
    private javax.swing.JList<Ticket> lstOrderTickets;
    private javax.swing.JList<goran.model.Order> lstOrders;
    private javax.swing.JList<Ticket> lstTickets;
    private javax.swing.JPanel pnlOrdersUtilMain;
    private javax.swing.JPanel pnlOrdersUtilTitle;
    private javax.swing.JTextField txtFindOrder;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
