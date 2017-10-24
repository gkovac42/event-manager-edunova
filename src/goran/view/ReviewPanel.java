/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.util.Theme;
import goran.controller.HibernateController;
import goran.model.Event;
import goran.model.Order;
import goran.model.Ticket;
import goran.util.ExcelMaker;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goran
 */
public class ReviewPanel extends javax.swing.JPanel {

    private Ticket ticket;
    private Order order;
    private Event event;
    private HibernateController<Ticket> ctrlTicket;
    private HibernateController<Order> ctrlOrder;
    private HibernateController<Event> ctrlEvent;

    public ReviewPanel() {

        initComponents();

        ticket = new Ticket();
        order = new Order();
        event = new Event();
        ctrlTicket = new HibernateController<>();
        ctrlOrder = new HibernateController<>();
        ctrlEvent = new HibernateController<>();

        paneEvents.setVisible(true);
        paneTickets.setVisible(false);
        paneOrders.setVisible(false);

        updateTickets();
        updateOrders();
        updateEvents();

        lblTotal.setText("Ukupan broj evenata u bazi: " + tblEvents.getRowCount());
    }

    public Order getOrder() {
        order = ctrlOrder.getList(order).get(tblOrders.convertRowIndexToModel(tblOrders.getSelectedRow()));
        return order;
    }

    public Ticket getTicket() {
        ticket = ctrlTicket.getOrderedList(ticket, "name").get(tblTickets.convertRowIndexToModel(tblTickets.getSelectedRow()));
        return ticket;
    }

    public Event getEvent() {
        event = ctrlEvent.getOrderedList(event, "name").get(tblEvents.convertRowIndexToModel(tblEvents.getSelectedRow()));
        return event;
    }

    public void updateTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Ticket t : ctrlTicket.getOrderedList(ticket, "name")) {
            rowData[0] = t.getName();
            rowData[1] = t.getPrice() + "kn";
            rowData[2] = t.getQuantity();
            rowData[3] = t.getEvent();
            model.addRow(rowData);
        }
    }

    public void updateOrders() {

        DateFormat df = new SimpleDateFormat("dd.MM.yy");

        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Order o : ctrlOrder.getOrderedList(order, "id")) {

            rowData[0] = o.getId();
            rowData[1] = df.format(o.getDateCreated());
            rowData[2] = o.getCustomer().toString();
            rowData[3] = o.getTotalPrice();
            model.addRow(rowData);
        }
    }

    public void updateEvents() {

        DateFormat df = new SimpleDateFormat("dd.MM.yy");

        DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Event e : ctrlEvent.getOrderedList(event, "name")) {
            rowData[0] = e.getName();

            if (e.getLocation() == null) {
                rowData[1] = "";
                rowData[2] = "";
            } else {
                rowData[1] = e.getLocation().getName();
                rowData[2] = e.getLocation().getLocality();
            }
            if (e.getStartDate() == null) {
                rowData[3] = "";
            } else {
                rowData[3] = df.format(e.getStartDate());
            }

            model.addRow(rowData);
        }
    }

    private void findTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[3];

        for (Ticket t : ctrlTicket.find(ticket, "name", txtFind.getText())) {
            rowData[0] = t.getName();
            rowData[1] = t.getPrice();
            rowData[2] = t.getQuantity();
            rowData[3] = t.getEvent();
            model.addRow(rowData);
        }
    }

    private void findOrders() {

        DateFormat df = new SimpleDateFormat("dd.MM.yy");

        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Order o : ctrlOrder.find(order, "id", txtFind.getText())) {

            rowData[0] = o.getId();
            rowData[1] = df.format(o.getDateCreated());
            rowData[2] = o.getCustomer().toString();
            rowData[3] = o.getTotalPrice();
            model.addRow(rowData);
        }
    }

    public void findEvents() {

        DateFormat df = new SimpleDateFormat("dd.MM.yy");

        DefaultTableModel model = (DefaultTableModel) tblEvents.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];

        for (Event e : ctrlEvent.find(event, "name", txtFind.getText())) {
            rowData[0] = e.getName();

            if (e.getLocation() == null) {
                rowData[1] = "";
                rowData[2] = "";
            } else {
                rowData[1] = e.getLocation().getName();
                rowData[2] = e.getLocation().getLocality();
            }
            if (e.getStartDate() == null) {
                rowData[3] = "";
            } else {
                rowData[3] = df.format(e.getStartDate());
            }

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
        btnEvents = new javax.swing.JButton();
        btnTickets = new javax.swing.JButton();
        paneOrders = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnExportToExcel = new javax.swing.JButton();
        btnJumpTo = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        paneEvents = new javax.swing.JScrollPane();
        tblEvents = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblTickets.setAutoCreateRowSorter(true);
        tblTickets.setBackground(new java.awt.Color(120, 120, 120));
        tblTickets.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblTickets.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
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
        tblTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTicketsMouseClicked(evt);
            }
        });
        paneTickets.setViewportView(tblTickets);

        add(paneTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        txtFind.setBackground(new java.awt.Color(120, 120, 120));
        txtFind.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        txtFind.setForeground(new java.awt.Color(255, 255, 255));
        txtFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(txtFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 180, 40));

        btnFind.setBackground(new java.awt.Color(0, 0, 0));
        btnFind.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFind.setForeground(new java.awt.Color(255, 255, 255));
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFind.setBorder(null);
        btnFind.setFocusPainted(false);
        btnFind.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        add(btnFind, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 40, 40));

        btnEvents.setBackground(new java.awt.Color(0, 0, 0));
        btnEvents.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEvents.setForeground(new java.awt.Color(255, 255, 255));
        btnEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_events.png"))); // NOI18N
        btnEvents.setText("EVENTI");
        btnEvents.setBorder(null);
        btnEvents.setFocusPainted(false);
        btnEvents.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventsActionPerformed(evt);
            }
        });
        add(btnEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        btnTickets.setBackground(new java.awt.Color(0, 0, 0));
        btnTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnTickets.setForeground(new java.awt.Color(255, 255, 255));
        btnTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_tickets.png"))); // NOI18N
        btnTickets.setText("ULAZNICE");
        btnTickets.setBorder(null);
        btnTickets.setFocusPainted(false);
        btnTickets.setPreferredSize(new java.awt.Dimension(80, 80));
        btnTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketsActionPerformed(evt);
            }
        });
        add(btnTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 140, 40));

        tblOrders.setAutoCreateRowSorter(true);
        tblOrders.setBackground(new java.awt.Color(120, 120, 120));
        tblOrders.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblOrders.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
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
        tblOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrdersMouseClicked(evt);
            }
        });
        paneOrders.setViewportView(tblOrders);

        add(paneOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        btnExportToExcel.setBackground(new java.awt.Color(0, 0, 0));
        btnExportToExcel.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnExportToExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportToExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_save.png"))); // NOI18N
        btnExportToExcel.setText("EXCEL");
        btnExportToExcel.setBorder(null);
        btnExportToExcel.setFocusPainted(false);
        btnExportToExcel.setPreferredSize(new java.awt.Dimension(80, 80));
        btnExportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportToExcelActionPerformed(evt);
            }
        });
        add(btnExportToExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 90, 40));

        btnJumpTo.setBackground(new java.awt.Color(0, 0, 0));
        btnJumpTo.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnJumpTo.setForeground(new java.awt.Color(255, 255, 255));
        btnJumpTo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_jump_to.png"))); // NOI18N
        btnJumpTo.setText("TRAŽI ODABRANO");
        btnJumpTo.setBorder(null);
        btnJumpTo.setFocusPainted(false);
        btnJumpTo.setPreferredSize(new java.awt.Dimension(80, 80));
        btnJumpTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJumpToActionPerformed(evt);
            }
        });
        add(btnJumpTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 170, 40));

        btnOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_orders.png"))); // NOI18N
        btnOrders.setText("NARUDŽBE");
        btnOrders.setBorder(null);
        btnOrders.setFocusPainted(false);
        btnOrders.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdersActionPerformed(evt);
            }
        });
        add(btnOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 40));

        tblEvents.setAutoCreateRowSorter(true);
        tblEvents.setBackground(new java.awt.Color(120, 120, 120));
        tblEvents.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        tblEvents.getTableHeader().setFont(new java.awt.Font("Lucida Sans", 1, 14));
        tblEvents.setForeground(new java.awt.Color(255, 255, 255));
        tblEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAZIV", "LOKACIJA", "MJESTO", "DATUM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEvents.setRowHeight(24);
        tblEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tblEvents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEventsMouseClicked(evt);
            }
        });
        paneEvents.setViewportView(tblEvents);

        add(paneEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        lblTotal.setFont(new java.awt.Font("Lucida Sans", 0, 15)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setText("ukupno");
        add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 380, 40));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/bg_main.jpg"))); // NOI18N
        lblBackground.setOpaque(true);
        add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed

        if (paneTickets.isVisible()) {

            if (txtFind.getText().matches("")) {
                updateTickets();
            } else {
                findTickets();
            }
        } else if (paneEvents.isVisible()) {

            if (txtFind.getText().matches("")) {
                updateEvents();
            } else {
                findEvents();
            }
        } else if (paneOrders.isVisible()) {

            if (txtFind.getText().matches("")) {
                updateOrders();
            } else {
                findOrders();
            }
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventsActionPerformed
        paneTickets.setVisible(false);
        paneOrders.setVisible(false);
        paneEvents.setVisible(true);
        lblTotal.setText("Ukupan broj evenata u bazi: " + tblEvents.getRowCount());
    }//GEN-LAST:event_btnEventsActionPerformed

    private void btnTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketsActionPerformed
        paneEvents.setVisible(false);
        paneOrders.setVisible(false);
        paneTickets.setVisible(true);
        lblTotal.setText("Ukupan broj ulaznica u bazi: " + tblTickets.getRowCount());
    }//GEN-LAST:event_btnTicketsActionPerformed

    private void btnExportToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportToExcelActionPerformed
        if (paneTickets.isVisible()) {
            ExcelMaker.ticketsToExcel(ctrlTicket.getOrderedList(ticket, "name"));
        } else if (paneOrders.isVisible()) {
            ExcelMaker.ordersToExcel(ctrlOrder.getList(order));
        } else if (paneEvents.isVisible()) {
            ExcelMaker.eventsToExcel(ctrlEvent.getOrderedList(event, "name"));
        }
    }//GEN-LAST:event_btnExportToExcelActionPerformed

    private void btnJumpToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJumpToActionPerformed
        if (paneOrders.isVisible()) {
            MainFrame.pnlOrders.jumpToOrder(getOrder());
            MainFrame.setActivePanel(MainFrame.pnlOrders);

        } else if (paneTickets.isVisible()) {
            MainFrame.pnlEvents.jumpToTicket(getTicket().getEvent(), getTicket());
            MainFrame.setActivePanel(MainFrame.pnlEvents);

        } else if (paneEvents.isVisible()) {
            MainFrame.pnlEvents.jumpToEvent(getEvent());
            MainFrame.setActivePanel(MainFrame.pnlEvents);
        }
    }//GEN-LAST:event_btnJumpToActionPerformed

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersActionPerformed
        paneEvents.setVisible(false);
        paneTickets.setVisible(false);
        paneOrders.setVisible(true);
        lblTotal.setText("Ukupan broj narudžbi u bazi: " + tblOrders.getRowCount());
    }//GEN-LAST:event_btnOrdersActionPerformed

    private void tblEventsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEventsMouseClicked
        if (evt.getClickCount() == 2) {
            MainFrame.pnlEvents.jumpToEvent(getEvent());
            MainFrame.setActivePanel(MainFrame.pnlEvents);
        }
    }//GEN-LAST:event_tblEventsMouseClicked

    private void tblTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTicketsMouseClicked
        if (evt.getClickCount() == 2) {
            MainFrame.pnlEvents.jumpToTicket(getTicket().getEvent(), getTicket());
            MainFrame.setActivePanel(MainFrame.pnlEvents);
        }
    }//GEN-LAST:event_tblTicketsMouseClicked

    private void tblOrdersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrdersMouseClicked
        if (evt.getClickCount() == 2) {
            MainFrame.pnlOrders.jumpToOrder(getOrder());
            MainFrame.setActivePanel(MainFrame.pnlOrders);
        }
    }//GEN-LAST:event_tblOrdersMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEvents;
    private javax.swing.JButton btnExportToExcel;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnJumpTo;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnTickets;
    public javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JScrollPane paneEvents;
    private javax.swing.JScrollPane paneOrders;
    private javax.swing.JScrollPane paneTickets;
    private javax.swing.JTable tblEvents;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblTickets;
    private javax.swing.JTextField txtFind;
    // End of variables declaration//GEN-END:variables

    public void applyTheme() {

        setBackground(Theme.color2);
        btnFind.setBackground(Theme.color3);
        txtFind.setBackground(Theme.color4);
        tblTickets.setBackground(Theme.color4);
        tblTickets.setForeground(Theme.font1);
        txtFind.setForeground(Theme.font1);
        btnEvents.setBackground(Theme.color3);
        btnTickets.setBackground(Theme.color3);
        tblOrders.setBackground(Theme.color4);
        tblOrders.setForeground(Theme.font1);
        tblTickets.setForeground(Theme.font1);
        tblEvents.setBackground(Theme.color4);
        tblEvents.setForeground(Theme.font1);
        btnOrders.setBackground(Theme.color3);
        btnJumpTo.setBackground(Theme.color3);
        btnExportToExcel.setBackground(Theme.color3);
        
        paneEvents.getViewport().setBackground(Theme.color4);
        paneOrders.getViewport().setBackground(Theme.color4);
        paneTickets.getViewport().setBackground(Theme.color4);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(Theme.color2);
        headerRenderer.setForeground(Color.WHITE);
        headerRenderer.setBorder(new EtchedBorder(Theme.color2, Theme.color1));
        for (int i = 0; i < tblEvents.getModel().getColumnCount(); i++) {
            tblEvents.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < tblOrders.getModel().getColumnCount(); i++) {
            tblOrders.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < tblTickets.getModel().getColumnCount(); i++) {
            tblTickets.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

    }
}
