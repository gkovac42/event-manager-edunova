/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.TicketController;
import goran.model.Ticket;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Goran
 */
public class TicketsPanel extends javax.swing.JPanel {

    private Ticket ticket;
    private TicketController ticketControl;

    /**
     * Creates new form TicketsPanel
     */
    public TicketsPanel() {
        initComponents();
        ticketControl = new TicketController();
        updateTickets();
    }

    public void updateTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[3];

        for (Ticket ticket : ticketControl.getTickets()) {
            rowData[0] = ticket.getName();
            rowData[1] = ticket.getPrice();
            rowData[2] = ticket.getEvent();
            model.addRow(rowData);
        }
    }

    public void findTickets() {

        DefaultTableModel model = (DefaultTableModel) tblTickets.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[3];

        for (Ticket ticket : ticketControl.findTickets(txtFindTickets.getText())) {
            rowData[0] = ticket.getName();
            rowData[1] = ticket.getPrice();
            rowData[2] = ticket.getEvent();
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblTickets = new javax.swing.JTable();
        txtFindTickets = new javax.swing.JTextField();
        btnFindTickets = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        btnAddTicket = new javax.swing.JButton();
        btnRemoveTicket = new javax.swing.JButton();

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
                "NAZIV", "CIJENA", "KOLIČINA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTickets.setRowHeight(24);
        tblTickets.getColumnModel().getColumn(0).setPreferredWidth(250);
        tblTickets.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane3.setViewportView(tblTickets);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 680, 380));

        txtFindTickets.setBackground(new java.awt.Color(120, 120, 120));
        txtFindTickets.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        txtFindTickets.setForeground(new java.awt.Color(255, 255, 255));
        add(txtFindTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 40));

        btnFindTickets.setBackground(new java.awt.Color(0, 0, 0));
        btnFindTickets.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFindTickets.setForeground(new java.awt.Color(255, 255, 255));
        btnFindTickets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_search.png"))); // NOI18N
        btnFindTickets.setText("TRAŽI");
        btnFindTickets.setBorder(null);
        btnFindTickets.setFocusPainted(false);
        btnFindTickets.setPreferredSize(new java.awt.Dimension(80, 80));
        btnFindTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindTicketsActionPerformed(evt);
            }
        });
        add(btnFindTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 40));

        btnHistory.setBackground(new java.awt.Color(0, 0, 0));
        btnHistory.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnHistory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_tickets.png"))); // NOI18N
        btnHistory.setText("POVIJEST");
        btnHistory.setBorder(null);
        btnHistory.setFocusPainted(false);
        btnHistory.setPreferredSize(new java.awt.Dimension(80, 80));
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });
        add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 300, 40));

        btnAddTicket.setBackground(new java.awt.Color(0, 0, 0));
        btnAddTicket.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAddTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnAddTicket.setText("DODAJ NA STANJE");
        btnAddTicket.setBorder(null);
        btnAddTicket.setFocusPainted(false);
        btnAddTicket.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAddTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTicketActionPerformed(evt);
            }
        });
        add(btnAddTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 180, 40));

        btnRemoveTicket.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveTicket.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemoveTicket.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnRemoveTicket.setText("UKLONI SA STANJA");
        btnRemoveTicket.setBorder(null);
        btnRemoveTicket.setFocusPainted(false);
        btnRemoveTicket.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemoveTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTicketActionPerformed(evt);
            }
        });
        add(btnRemoveTicket, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 180, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnFindTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindTicketsActionPerformed
        
        if (txtFindTickets.getText().matches("")) {
            updateTickets();
        } else {
            findTickets();
        }
    }//GEN-LAST:event_btnFindTicketsActionPerformed

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed

    }//GEN-LAST:event_btnHistoryActionPerformed

    private void btnAddTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddTicketActionPerformed

    private void btnRemoveTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveTicketActionPerformed

    public void applyTheme() {

        setBackground(Theme.color2);
        btnFindTickets.setBackground(Theme.color3);
        txtFindTickets.setBackground(Theme.color4);
        tblTickets.setBackground(Theme.color4);
        tblTickets.setForeground(Theme.font1);
        txtFindTickets.setForeground(Theme.font1);
        btnAddTicket.setBackground(Theme.color3);
        btnRemoveTicket.setBackground(Theme.color3);
        btnHistory.setBackground(Theme.color3);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTicket;
    private javax.swing.JButton btnFindTickets;
    private javax.swing.JButton btnHistory;
    private javax.swing.JButton btnRemoveTicket;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblTickets;
    private javax.swing.JTextField txtFindTickets;
    // End of variables declaration//GEN-END:variables
}
