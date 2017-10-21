/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.util.Theme;
import goran.controller.HibernateController;
import goran.model.Order;
import goran.model.Ticket;
import goran.model.Customer;
import goran.model.OrderedTicket;
import goran.util.PdfMaker;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Goran
 */
public class OrdersPanel extends javax.swing.JPanel {

    private Order order;
    private Customer customer;
    private Ticket ticket;
    private OrderedTicket ordTicket;
    private HibernateController<Customer> ctrlCustomer;
    private HibernateController<Ticket> ctrlTicket;
    private HibernateController<OrderedTicket> ctrlOrdTicket;
    private HibernateController<Order> ctrlOrder;
    private String sortTickets;
    private String sortOrders;

    public OrdersPanel() {

        initComponents();

        order = new Order();
        customer = new Customer();
        ticket = new Ticket();
        ctrlCustomer = new HibernateController<>();
        ctrlTicket = new HibernateController<>();
        ctrlOrdTicket = new HibernateController<>();
        ctrlOrder = new HibernateController<>();

        sortTickets = "name";
        sortOrders = "id";

        lstTickets.setComponentPopupMenu(ticketsMenu);
        ticketsMenuButtonGroup.setSelected(mnuName.getModel(), true);
        lstOrders.setComponentPopupMenu(ordersMenu);
        ordersMenuButtonGroup.setSelected(mnuId.getModel(), true);

        updateOrders(sortOrders);
        updateCustomers();
        updateTickets(sortTickets);
    }

    public void jumpToCustomer(Customer c) {
        cmbCustomer.setSelectedItem(c);
    }

    public void jumpToOrder(Order o) {
        lstOrders.setSelectedValue(o, true);
    }

    public void updateCustomers() {

        DefaultComboBoxModel<Customer> model = new DefaultComboBoxModel<>();
        cmbCustomer.setModel(model);
        for (Customer c : ctrlCustomer.getOrderedList(customer, "lastName")) {
            model.addElement(c);
        }
    }

    public void updateTickets(String sortBy) {

        DefaultListModel<Ticket> model = new DefaultListModel<>();
        lstTickets.setModel(model);
        for (Ticket t : ctrlTicket.getOrderedList(ticket, sortBy)) {
            model.addElement(t);
        }
        lstTickets.repaint();
    }

    private void updateOrderTickets() {

        DefaultListModel<OrderedTicket> model = new DefaultListModel<>();
        lstOrderTickets.setModel(model);
        for (OrderedTicket t : order.getTickets()) {
            model.addElement(t);
        }
    }

    private void updateOrders(String sortBy) {

        DefaultListModel<Order> model = new DefaultListModel<>();
        lstOrders.setModel(model);
        for (Order o : ctrlOrder.getOrderedList(order, sortBy)) {
            model.addElement(o);
        }
    }

    private void calcTotalPrice() {

        DefaultListModel<OrderedTicket> model = (DefaultListModel<OrderedTicket>) lstOrderTickets.getModel();
        Double tp = 0.0;

        for (int i = 0; i < model.getSize(); i++) {
            tp += (model.get(i).getTicket().getPrice() * model.get(i).getQuantity());
        }

        if (tp == 0.0) {
            lblTotalPrice.setText("0,00kn");
        } else {
            lblTotalPrice.setText(new DecimalFormat("#.00").format(tp) + "kn");
        }
    }

    private OrderedTicket getExistingTicket(Ticket ticket, List<OrderedTicket> tickets) {

        OrderedTicket exTicket = null;
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getTicket().getName().equals(ticket.getName())) {
                exTicket = tickets.get(i);
                break;
            }
        }
        return exTicket;
    }

    private void emptyCart() {

        DefaultListModel<Ticket> model = (DefaultListModel) lstTickets.getModel();
        for (OrderedTicket t1 : order.getTickets()) {
            for (int i = 0; i < model.getSize(); i++) {
                if (t1.getTicket().equals(model.get(i))) {
                    model.get(i).setQuantity(model.get(i).getQuantity() + t1.getQuantity());
                    ctrlTicket.save(model.get(i));
                    break;
                }
            }
        }
        lstTickets.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ordersMenu = new javax.swing.JPopupMenu();
        mnuId = new javax.swing.JRadioButtonMenuItem();
        mnuDateCreated = new javax.swing.JRadioButtonMenuItem();
        mnuCustomer = new javax.swing.JRadioButtonMenuItem();
        ticketsMenu = new javax.swing.JPopupMenu();
        mnuName = new javax.swing.JRadioButtonMenuItem();
        mnuDate = new javax.swing.JRadioButtonMenuItem();
        mnuPrice = new javax.swing.JRadioButtonMenuItem();
        mnuQuantity = new javax.swing.JRadioButtonMenuItem();
        ticketsMenuButtonGroup = new javax.swing.ButtonGroup();
        ordersMenuButtonGroup = new javax.swing.ButtonGroup();
        lblEmail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblLocality = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTickets = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstOrderTickets = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        lblOrder = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        txtQuantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        btnFinishOrder = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnNewOrder = new javax.swing.JButton();
        cmbCustomer = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOrders = new javax.swing.JList<>();
        lblTitle10 = new javax.swing.JLabel();
        btnCancelOrder = new javax.swing.JButton();
        lblTitle11 = new javax.swing.JLabel();
        btnPlus = new javax.swing.JButton();
        btnMinus = new javax.swing.JButton();
        btnViewPdf = new javax.swing.JButton();
        lblTitle12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        ordersMenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ordersMenu.setToolTipText("");

        ordersMenuButtonGroup.add(mnuId);
        mnuId.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuId.setText("Po šifri");
        mnuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuIdActionPerformed(evt);
            }
        });
        ordersMenu.add(mnuId);

        ordersMenuButtonGroup.add(mnuDateCreated);
        mnuDateCreated.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuDateCreated.setText("Po datumu");
        mnuDateCreated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDateCreatedActionPerformed(evt);
            }
        });
        ordersMenu.add(mnuDateCreated);

        ordersMenuButtonGroup.add(mnuCustomer);
        mnuCustomer.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuCustomer.setText("Po kupcu");
        mnuCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCustomerActionPerformed(evt);
            }
        });
        ordersMenu.add(mnuCustomer);

        ticketsMenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ticketsMenu.setToolTipText("");

        ticketsMenuButtonGroup.add(mnuName);
        mnuName.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuName.setText("Po nazivu");
        mnuName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNameActionPerformed(evt);
            }
        });
        ticketsMenu.add(mnuName);

        ticketsMenuButtonGroup.add(mnuDate);
        mnuDate.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuDate.setText("Po datumu");
        mnuDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDateActionPerformed(evt);
            }
        });
        ticketsMenu.add(mnuDate);

        ticketsMenuButtonGroup.add(mnuPrice);
        mnuPrice.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuPrice.setSelected(true);
        mnuPrice.setText("Po cijeni");
        mnuPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPriceActionPerformed(evt);
            }
        });
        ticketsMenu.add(mnuPrice);

        ticketsMenuButtonGroup.add(mnuQuantity);
        mnuQuantity.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuQuantity.setText("Po količini");
        mnuQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuQuantityActionPerformed(evt);
            }
        });
        ticketsMenu.add(mnuQuantity);

        setBackground(new java.awt.Color(60, 60, 70));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmail.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 260, 30));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/ic_email_white_24dp_1x.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 50, 30));

        lblAddress.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(255, 255, 255));
        add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 260, 30));

        lblLocality.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lblLocality.setForeground(new java.awt.Color(255, 255, 255));
        add(lblLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 260, 30));

        lstTickets.setBackground(new java.awt.Color(120, 120, 120));
        lstTickets.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lstTickets.setForeground(new java.awt.Color(255, 255, 255));
        lstTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstTickets);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 370, 210));

        lstOrderTickets.setBackground(new java.awt.Color(120, 120, 120));
        lstOrderTickets.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lstOrderTickets.setForeground(new java.awt.Color(255, 255, 255));
        lstOrderTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstOrderTickets);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 370, 110));

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add_order.png"))); // NOI18N
        btnAdd.setText("DODAJ");
        btnAdd.setBorder(null);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 90, 40));

        lblOrder.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(255, 255, 255));
        lblOrder.setText("NOVA NARUDŽBA");
        add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 40));

        btnRemove.setBackground(new java.awt.Color(0, 0, 0));
        btnRemove.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove_order.png"))); // NOI18N
        btnRemove.setText("UKLONI");
        btnRemove.setBorder(null);
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 90, 40));

        txtQuantity.setBackground(new java.awt.Color(120, 120, 120));
        txtQuantity.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        txtQuantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtQuantity.setText("1");
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 70, 30));

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("UKUPNO:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, 30));

        lblTotalPrice.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        lblTotalPrice.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalPrice.setText("0.00kn");
        add(lblTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 90, 30));

        btnFinishOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnFinishOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFinishOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnFinishOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_finish_order.png"))); // NOI18N
        btnFinishOrder.setText("ZAVRŠI");
        btnFinishOrder.setBorder(null);
        btnFinishOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishOrderActionPerformed(evt);
            }
        });
        add(btnFinishOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 170, 40));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/ic_person_white_24dp_1x.png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 50, 30));

        btnNewOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnNewOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnNewOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnNewOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_new.png"))); // NOI18N
        btnNewOrder.setText("NOVA N.");
        btnNewOrder.setBorder(null);
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });
        add(btnNewOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 40));

        cmbCustomer.setBackground(new java.awt.Color(120, 120, 120));
        cmbCustomer.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });
        add(cmbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 260, 30));

        lstOrders.setBackground(new java.awt.Color(120, 120, 120));
        lstOrders.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lstOrders.setForeground(new java.awt.Color(255, 255, 255));
        lstOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstOrders.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOrdersValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstOrders);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 300, 210));

        lblTitle10.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        lblTitle10.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle10.setText("RASPOLOŽIVE ULAZNICE");
        add(lblTitle10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 250, 40));

        btnCancelOrder.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelOrder.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCancelOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel_order.png"))); // NOI18N
        btnCancelOrder.setText("PONIŠTI");
        btnCancelOrder.setBorder(null);
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        add(btnCancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 100, 40));

        lblTitle11.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        lblTitle11.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle11.setText("KOŠARICA");
        add(lblTitle11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 250, 40));

        btnPlus.setBackground(new java.awt.Color(0, 0, 0));
        btnPlus.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnPlus.setForeground(new java.awt.Color(255, 255, 255));
        btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnPlus.setBorder(null);
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });
        add(btnPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 50, 30));

        btnMinus.setBackground(new java.awt.Color(0, 0, 0));
        btnMinus.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnMinus.setForeground(new java.awt.Color(255, 255, 255));
        btnMinus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnMinus.setBorder(null);
        btnMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinusActionPerformed(evt);
            }
        });
        add(btnMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 50, 30));

        btnViewPdf.setBackground(new java.awt.Color(0, 0, 0));
        btnViewPdf.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnViewPdf.setForeground(new java.awt.Color(255, 255, 255));
        btnViewPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_jump_to.png"))); // NOI18N
        btnViewPdf.setText("PDF");
        btnViewPdf.setBorder(null);
        btnViewPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPdfActionPerformed(evt);
            }
        });
        add(btnViewPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 80, 40));

        lblTitle12.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        lblTitle12.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle12.setText("POVIJEST NARUDŽBI");
        add(lblTitle12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 40));

        jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/ic_location_city_white_24dp_1x.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 50, 30));

        jLabel15.setFont(new java.awt.Font("Lucida Sans", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/ic_location_on_white_24dp_1x.png"))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 50, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/bg_main.jpg"))); // NOI18N
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        if (lstOrderTickets.getSelectedIndex() != -1) {

            ordTicket = lstOrderTickets.getSelectedValue();

            DefaultListModel<Ticket> m = (DefaultListModel) lstTickets.getModel();
            Ticket t = null;
            for (int i = 0; i < m.getSize(); i++) {
                if (m.get(i).equals(ordTicket.getTicket())) {
                    t = m.get(i);
                    break;
                }
            }
            if (t == null) {
                return;
            }

            t.setQuantity(t.getQuantity() + ordTicket.getQuantity());

            calcTotalPrice();
            lstTickets.setSelectedValue(t, true);
            order.getTickets().remove(ordTicket);

            updateOrderTickets();
            lstOrderTickets.repaint();
            lstTickets.repaint();

        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        if (lstTickets.getSelectedIndex() != -1 && cmbCustomer.getSelectedIndex() != -1) {

            ticket = lstTickets.getSelectedValue();
            ticket.setQuantity(ticket.getQuantity() - Integer.parseInt(txtQuantity.getText()));

            lstTickets.repaint();
            lstTickets.setSelectedValue(ticket, true);

            ordTicket = getExistingTicket(ticket, order.getTickets());

            if (ordTicket == null) {
                ordTicket = new OrderedTicket();
                ordTicket.setTicket(ticket);
                ordTicket.setQuantity(Integer.parseInt(txtQuantity.getText()));
                order.getTickets().add(ordTicket);
            } else {
                ordTicket.setQuantity(ordTicket.getQuantity() + Integer.parseInt(txtQuantity.getText()));
            }
            ordTicket.setDeleted(true);
            updateOrderTickets();

            calcTotalPrice();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnFinishOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishOrderActionPerformed

        Thread t = new Thread(() -> {

            order.setCustomer(customer);
            ctrlOrdTicket.saveList(order.getTickets());
            ctrlOrder.save(order);
            PdfMaker.savePdf(order);
            PdfMaker.openPdf(order);
            updateOrders(sortOrders);

            order = new Order();
            cmbCustomer.setSelectedIndex(0);
            updateOrderTickets();
            calcTotalPrice();

        });
        t.start();

    }//GEN-LAST:event_btnFinishOrderActionPerformed

    private void lstOrdersValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOrdersValueChanged

        if (lstOrders.getSelectedIndex() == -1) {
            lblOrder.setText("NOVA NARUDŽBA");
            cmbCustomer.setSelectedIndex(0);
            order = new Order();
            btnAdd.setEnabled(true);
            btnRemove.setEnabled(true);
            btnFinishOrder.setEnabled(true);
            cmbCustomer.setEnabled(true);
            btnPlus.setEnabled(true);
            btnMinus.setEnabled(true);
            txtQuantity.setEnabled(true);

        } else {

            if (lblOrder.getText().equals("NOVA NARUDŽBA") && lstOrderTickets.getModel().getSize() > 0) {

                emptyCart();
            }

            order = lstOrders.getSelectedValue();
            lblOrder.setText("NARUDŽBA #" + order.getId());
            cmbCustomer.setSelectedItem(order.getCustomer());
            btnAdd.setEnabled(false);
            btnRemove.setEnabled(false);
            btnFinishOrder.setEnabled(false);
            cmbCustomer.setEnabled(false);
            btnPlus.setEnabled(false);
            btnMinus.setEnabled(false);
            txtQuantity.setEnabled(false);
        }

        updateOrderTickets();
        calcTotalPrice();

    }//GEN-LAST:event_lstOrdersValueChanged

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed

        if (lblOrder.getText().equals("NOVA NARUDŽBA")) {

            emptyCart();
        }

        updateOrders(sortOrders);
        order = new Order();
        updateOrderTickets();
        calcTotalPrice();

    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed

        if (lstOrders.getSelectedIndex() != -1) {

            DefaultListModel<Ticket> model = (DefaultListModel) lstTickets.getModel();

            for (OrderedTicket t : order.getTickets()) {
                for (int i = 0; i < model.getSize(); i++) {
                    if (t.getTicket().getName().equals(model.get(i).getName())) {
                        model.get(i).setQuantity(model.get(i).getQuantity() + t.getQuantity());
                        ctrlTicket.save(model.get(i));
                        break;
                    }
                }
            }

            ctrlOrder.delete(order);
            updateOrders(sortOrders);
            order = new Order();
            updateOrderTickets();
            lstTickets.repaint();
            calcTotalPrice();
        }
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed

        if (cmbCustomer.getSelectedIndex() == -1) {
            lblAddress.setText("");
            lblLocality.setText("");
            lblEmail.setText("");

        } else {

            customer = (Customer) cmbCustomer.getSelectedItem();
            lblAddress.setText(customer.getAddress());
            lblLocality.setText(customer.getLocality());
            lblEmail.setText(customer.getEmail());
        }
    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed

        txtQuantity.setText(String.valueOf(Integer.parseInt(txtQuantity.getText()) + 1));

    }//GEN-LAST:event_btnPlusActionPerformed

    private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinusActionPerformed
        if (Integer.parseInt(txtQuantity.getText()) > 1) {
            txtQuantity.setText(String.valueOf(Integer.parseInt(txtQuantity.getText()) - 1));
        }
    }//GEN-LAST:event_btnMinusActionPerformed

    private void btnViewPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPdfActionPerformed
        if (lstOrders.getSelectedIndex() == -1) {

        } else {
            try {
                PdfMaker.openPdf(order);

            } catch (Exception e) {
                PdfMaker.savePdf(order);
                PdfMaker.openPdf(order);
            }
        }
    }//GEN-LAST:event_btnViewPdfActionPerformed

    private void mnuCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCustomerActionPerformed
        sortOrders = "customer";
        updateOrders(sortOrders);
    }//GEN-LAST:event_mnuCustomerActionPerformed

    private void mnuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuIdActionPerformed
        sortOrders = "id";
        updateOrders(sortOrders);
    }//GEN-LAST:event_mnuIdActionPerformed

    private void mnuDateCreatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDateCreatedActionPerformed
        sortOrders = "dateCreated";
        updateOrders(sortOrders);
    }//GEN-LAST:event_mnuDateCreatedActionPerformed

    private void mnuNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNameActionPerformed
        sortTickets = "name";
        updateTickets(sortTickets);
    }//GEN-LAST:event_mnuNameActionPerformed

    private void mnuPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPriceActionPerformed
        sortTickets = "price";
        updateTickets(sortTickets);
    }//GEN-LAST:event_mnuPriceActionPerformed

    private void mnuDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDateActionPerformed
        sortTickets = "dateCreated";
        updateTickets(sortTickets);
    }//GEN-LAST:event_mnuDateActionPerformed

    private void mnuQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuQuantityActionPerformed
        sortTickets = "quantity";
        updateTickets(sortTickets);
    }//GEN-LAST:event_mnuQuantityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JButton btnFinishOrder;
    private javax.swing.JButton btnMinus;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnViewPdf;
    private javax.swing.JComboBox<Customer> cmbCustomer;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddress;
    public javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLocality;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JLabel lblTitle10;
    private javax.swing.JLabel lblTitle11;
    private javax.swing.JLabel lblTitle12;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JList<OrderedTicket> lstOrderTickets;
    private javax.swing.JList<goran.model.Order> lstOrders;
    private javax.swing.JList<Ticket> lstTickets;
    private javax.swing.JRadioButtonMenuItem mnuCustomer;
    private javax.swing.JRadioButtonMenuItem mnuDate;
    private javax.swing.JRadioButtonMenuItem mnuDateCreated;
    private javax.swing.JRadioButtonMenuItem mnuId;
    private javax.swing.JRadioButtonMenuItem mnuName;
    private javax.swing.JRadioButtonMenuItem mnuPrice;
    private javax.swing.JRadioButtonMenuItem mnuQuantity;
    private javax.swing.JPopupMenu ordersMenu;
    private javax.swing.ButtonGroup ordersMenuButtonGroup;
    private javax.swing.JPopupMenu ticketsMenu;
    private javax.swing.ButtonGroup ticketsMenuButtonGroup;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables

    public void applyTheme() {
        setBackground(Theme.color2);
        btnAdd.setBackground(Theme.color3);
        btnRemove.setBackground(Theme.color3);
        btnFinishOrder.setBackground(Theme.color3);
        btnPlus.setBackground(Theme.color3);
        btnMinus.setBackground(Theme.color3);
        btnNewOrder.setBackground(Theme.color3);
        btnCancelOrder.setBackground(Theme.color3);
        btnViewPdf.setBackground(Theme.color3);
        lstOrders.setBackground(Theme.color4);
        lstOrders.setForeground(Theme.font1);
        lstOrderTickets.setBackground(Theme.color4);
        lstOrderTickets.setForeground(Theme.font1);
        lstTickets.setBackground(Theme.color4);
        lstTickets.setForeground(Theme.font1);
        txtQuantity.setBackground(Theme.color4);
        txtQuantity.setForeground(Theme.font1);
    }
}
