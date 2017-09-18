/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.HibernateController;
import goran.model.Order;
import goran.model.Ticket;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goran
 */
public class ReviewPanel extends javax.swing.JPanel {

    private Ticket ticket;
    private Order order;
    private HibernateController<Ticket> ctrlTicket;
    private HibernateController<Order> ctrlOrder;

    public ReviewPanel() {

        initComponents();
        ticket = new Ticket();
        order = new Order();
        ctrlTicket = new HibernateController<>();
        ctrlOrder = new HibernateController<>();
        updateTickets();
        updateOrders();
    }

    public void updateTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Ticket ticket : ctrlTicket.getOrderedList(ticket, "name")) {
            rowData[0] = ticket.getName();
            rowData[1] = new DecimalFormat("#.00").format(ticket.getPrice());
            rowData[2] = ticket.getQuantity();
            rowData[3] = ticket.getEvent();
            model.addRow(rowData);
        }

    }

    public void updateOrders() {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy");

        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Order order : ctrlOrder.getOrderedList(order, "id")) {

            rowData[0] = order.getId();
            rowData[1] = df.format(order.getDateCreated());
            rowData[2] = order.getCustomer().toString();
            rowData[3] = new DecimalFormat("#.00").format(order.getTotalPrice());
            model.addRow(rowData);
        }
    }

    private void findTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[3];

        for (Ticket ticket : ctrlTicket.find(ticket, "name", txtFind.getText())) {
            rowData[0] = ticket.getName();
            rowData[1] = ticket.getPrice();
            rowData[2] = ticket.getQuantity();
            rowData[3] = ticket.getEvent();
            model.addRow(rowData);
        }
    }

    private void findOrders() {
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Order order : ctrlOrder.find(order, "id", txtFind.getText())) {

            rowData[0] = order.getId();
            rowData[1] = order.getDateCreated();
            rowData[2] = order.getCustomer().toString();
            rowData[3] = order.getTotalPrice();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneTickets = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();
        txtFind = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        btnTickets = new javax.swing.JButton();
        paneOrders = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTickets.setAutoCreateRowSorter(true);
        tblTickets.setBackground(new java.awt.Color(120, 120, 120));
        tblTickets.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        tblTickets.setForeground(new java.awt.Color(255, 255, 255));
        tblTickets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAZIV", "CIJENA", "KOLIČINA", "EVENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTickets.setRowHeight(24);
        tblTickets.getColumnModel().getColumn(0).setPreferredWidth(250);
        tblTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        paneTickets.setViewportView(tblTickets);

        add(paneTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        txtFind.setBackground(new java.awt.Color(120, 120, 120));
        txtFind.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtFind.setForeground(new java.awt.Color(255, 255, 255));
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 40));

        btnFind.setBackground(new java.awt.Color(0, 0, 0));
        btnFind.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFind.setText("TRAŽI");
        btnFind.setBorder(null);
        btnFind.setFocusPainted(false);
        btnFind.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 40));

        btnOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_add_event.png"))); // NOI18N
        btnOrders.setText("NARUDŽBE");
        btnOrders.setBorder(null);
        btnOrders.setFocusPainted(false);
        btnOrders.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdersActionPerformed(evt);
            }
        });
        add(btnOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 110, 40));

        btnTickets.setBackground(new java.awt.Color(0, 0, 0));
        btnTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnTickets.setForeground(new java.awt.Color(255, 255, 255));
        btnTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_add_ticket.png"))); // NOI18N
        btnTickets.setText("ULAZNICE");
        btnTickets.setBorder(null);
        btnTickets.setFocusPainted(false);
        btnTickets.setPreferredSize(new java.awt.Dimension(80, 80));
        btnTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsActionPerformed(evt);
            }
        });
        add(btnTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 110, 40));

        tblOrders.setAutoCreateRowSorter(true);
        tblOrders.setBackground(new java.awt.Color(120, 120, 120));
        tblOrders.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        tblOrders.setForeground(new java.awt.Color(255, 255, 255));
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "DATUM NARUDŽBE", "NARUČITELJ", "VRIJEDNOST"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.setRowHeight(24);
        tblOrders.getColumnModel().getColumn(0).setPreferredWidth(25);
        tblOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        paneOrders.setViewportView(tblOrders);

        add(paneOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        if (paneTickets.isVisible()) {

            if (txtFind.getText().matches("")) {
                updateTickets();
            } else {
                findTickets();
            }
        } else {

            if (txtFind.getText().matches("")) {
                updateOrders();
            } else {
                findOrders();
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersActionPerformed
        paneTickets.setVisible(false);
        paneOrders.setVisible(true);

    }//GEN-LAST:event_btnOrdersActionPerformed

    private void btnTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsActionPerformed
        paneOrders.setVisible(false);
        paneTickets.setVisible(true);
    }//GEN-LAST:event_btnTicketsActionPerformed

    public void applyTheme() {

        setBackground(Theme.color2);
        btnFind.setBackground(Theme.color3);
        txtFind.setBackground(Theme.color4);
        tblTickets.setBackground(Theme.color4);
        tblTickets.setForeground(Theme.font1);
        txtFind.setForeground(Theme.font1);
        btnOrders.setBackground(Theme.color3);
        btnTickets.setBackground(Theme.color3);
        tblOrders.setBackground(Theme.color4);
        tblTickets.setForeground(Theme.font1);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnTickets;
    private javax.swing.JScrollPane paneOrders;
    private javax.swing.JScrollPane paneTickets;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblTickets;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables
}
