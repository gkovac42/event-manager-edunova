/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import java.io.IOException;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Goran
 */
public class MainFrame extends javax.swing.JFrame {

    private EventsPanel pnlEvents;
    private ReviewPanel pnlReview;
    private CustomersPanel pnlCustomers;
    private LocationsPanel pnlLocations;
    private OrdersPanel pnlOrders;
    private AbsoluteConstraints panelPosition;
    
    private int theme = Theme.DARK;
    
    public MainFrame() {
        
        initComponents();
        panelPosition = new AbsoluteConstraints(100, 40, 700, 560);
        pnlEvents = new EventsPanel();
        getContentPane().add(pnlEvents, panelPosition); 
        pnlReview = new ReviewPanel();
        getContentPane().add(pnlReview, panelPosition);
        pnlCustomers = new CustomersPanel();
        getContentPane().add(pnlCustomers, panelPosition);
        pnlLocations = new LocationsPanel();
        getContentPane().add(pnlLocations, panelPosition);
        pnlOrders = new OrdersPanel();
        getContentPane().add(pnlOrders, panelPosition);
        
        setActivePanel(pnlEvents);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new MotionPanel(this);
        lblIcon = new javax.swing.JLabel();
        lblLightSwitch = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        btnGit = new javax.swing.JButton();
        pnlSide = new MotionPanel(this);
        btnEvents = new javax.swing.JButton();
        btnReview = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnLocations = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setOpacity(0.97F);
        setSize(new java.awt.Dimension(800, 540));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTitle.setBackground(new java.awt.Color(30, 30, 40));
        pnlTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlTitle.setPreferredSize(new java.awt.Dimension(800, 40));
        pnlTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_icon.png"))); // NOI18N
        pnlTitle.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblLightSwitch.setBackground(new java.awt.Color(30, 30, 40));
        lblLightSwitch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLightSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/light_off.png"))); // NOI18N
        lblLightSwitch.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblLightSwitch.setOpaque(true);
        lblLightSwitch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLightSwitchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLightSwitchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLightSwitchMouseExited(evt);
            }
        });
        pnlTitle.add(lblLightSwitch, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 30, 40));

        lblClose.setBackground(new java.awt.Color(30, 30, 40));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_close.png"))); // NOI18N
        lblClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCloseMouseExited(evt);
            }
        });
        pnlTitle.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 30, 40));

        lblTitle.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("EVENT MANAGER");
        pnlTitle.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 40));

        lblMinimize.setBackground(new java.awt.Color(30, 30, 40));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_minimize.png"))); // NOI18N
        lblMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMinimize.setOpaque(true);
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseExited(evt);
            }
        });
        pnlTitle.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 30, 50));

        btnGit.setBackground(new java.awt.Color(0, 0, 0));
        btnGit.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnGit.setForeground(new java.awt.Color(255, 255, 255));
        btnGit.setText("GITHUB");
        btnGit.setBorder(null);
        btnGit.setBorderPainted(false);
        btnGit.setFocusPainted(false);
        btnGit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGit.setPreferredSize(new java.awt.Dimension(80, 80));
        btnGit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGitActionPerformed(evt);
            }
        });
        pnlTitle.add(btnGit, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 20));

        getContentPane().add(pnlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

        pnlSide.setBackground(new java.awt.Color(0, 0, 0));
        pnlSide.setForeground(new java.awt.Color(255, 255, 255));
        pnlSide.setPreferredSize(new java.awt.Dimension(100, 560));
        pnlSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEvents.setBackground(new java.awt.Color(0, 0, 0));
        btnEvents.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEvents.setForeground(new java.awt.Color(255, 255, 255));
        btnEvents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_events.png"))); // NOI18N
        btnEvents.setText("EVENTI");
        btnEvents.setBorder(null);
        btnEvents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEvents.setPreferredSize(new java.awt.Dimension(80, 80));
        btnEvents.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEvents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventsActionPerformed(evt);
            }
        });
        pnlSide.add(btnEvents, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 100));

        btnReview.setBackground(new java.awt.Color(0, 0, 0));
        btnReview.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnReview.setForeground(new java.awt.Color(255, 255, 255));
        btnReview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_tickets.png"))); // NOI18N
        btnReview.setText("PREGLED");
        btnReview.setBorder(null);
        btnReview.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReview.setPreferredSize(new java.awt.Dimension(80, 80));
        btnReview.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReviewActionPerformed(evt);
            }
        });
        pnlSide.add(btnReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 100, 100));

        btnCustomers.setBackground(new java.awt.Color(0, 0, 0));
        btnCustomers.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_users.png"))); // NOI18N
        btnCustomers.setText("KORISNICI");
        btnCustomers.setBorder(null);
        btnCustomers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomers.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCustomers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        pnlSide.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 100, 100));

        btnLocations.setBackground(new java.awt.Color(0, 0, 0));
        btnLocations.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnLocations.setForeground(new java.awt.Color(255, 255, 255));
        btnLocations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_locations.png"))); // NOI18N
        btnLocations.setText("LOKACIJE");
        btnLocations.setBorder(null);
        btnLocations.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLocations.setPreferredSize(new java.awt.Dimension(80, 80));
        btnLocations.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLocations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocationsActionPerformed(evt);
            }
        });
        pnlSide.add(btnLocations, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 100, 100));

        btnOrders.setBackground(new java.awt.Color(0, 0, 0));
        btnOrders.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnOrders.setForeground(new java.awt.Color(255, 255, 255));
        btnOrders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/menu_orders.png"))); // NOI18N
        btnOrders.setText("NARUDŽBE");
        btnOrders.setBorder(null);
        btnOrders.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnOrders.setPreferredSize(new java.awt.Dimension(80, 80));
        btnOrders.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdersActionPerformed(evt);
            }
        });
        pnlSide.add(btnOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 100, 100));

        getContentPane().add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void setActivePanel(JPanel panel) {

        pnlEvents.setVisible(false);
        pnlReview.setVisible(false);
        pnlCustomers.setVisible(false);
        pnlLocations.setVisible(false);
        pnlOrders.setVisible(false);

        panel.setVisible(true);

    }
        
    private void btnReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReviewActionPerformed
        pnlReview.updateTickets();
        pnlReview.updateOrders();
        setActivePanel(pnlReview);
    }//GEN-LAST:event_btnReviewActionPerformed

    private void btnEventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventsActionPerformed
        setActivePanel(pnlEvents);
    }//GEN-LAST:event_btnEventsActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        setActivePanel(pnlCustomers);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void lblMinimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseExited
        lblMinimize.setBackground(Theme.color1);
    }//GEN-LAST:event_lblMinimizeMouseExited

    private void lblMinimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseEntered
        lblMinimize.setBackground(Theme.color2);
    }//GEN-LAST:event_lblMinimizeMouseEntered

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(this.ICONIFIED);        // TODO add your handling code here:
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseExited
        lblClose.setBackground(Theme.color1);
    }//GEN-LAST:event_lblCloseMouseExited

    private void lblCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseEntered
        lblClose.setBackground(Theme.color2);
    }//GEN-LAST:event_lblCloseMouseEntered

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
        
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblLightSwitchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLightSwitchMouseExited
        lblLightSwitch.setBackground(Theme.color1);
    }//GEN-LAST:event_lblLightSwitchMouseExited

    private void lblLightSwitchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLightSwitchMouseEntered
        lblLightSwitch.setBackground(Theme.color2);
    }//GEN-LAST:event_lblLightSwitchMouseEntered

    private void lblLightSwitchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLightSwitchMouseClicked

        if (theme == Theme.DARK) {
            
            theme = Theme.LIGHT;
            lblLightSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/light_on.png")));
            Theme.setLightTheme();

        } else {

            theme = Theme.DARK;
            lblLightSwitch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/light_off.png")));
            Theme.setDarkTheme();
        }
        
        applyTheme();
    }//GEN-LAST:event_lblLightSwitchMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
    }//GEN-LAST:event_formWindowClosed

    private void btnLocationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocationsActionPerformed
        setActivePanel(pnlLocations);
    }//GEN-LAST:event_btnLocationsActionPerformed

    private void btnGitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGitActionPerformed

        try {
            Runtime.getRuntime().exec("cmd /c start https://github.com/gkovac42/event-manager-edunova");
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnGitActionPerformed

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersActionPerformed
        pnlOrders.updateTickets();
        pnlOrders.updateCustomers();
        setActivePanel(pnlOrders);
    }//GEN-LAST:event_btnOrdersActionPerformed
        
    private void applyTheme() {

        pnlTitle.setBackground(Theme.color1);
        lblMinimize.setBackground(Theme.color1);
        lblClose.setBackground(Theme.color1);
        lblLightSwitch.setBackground(Theme.color1);

        pnlSide.setBackground(Theme.color3);
        btnEvents.setBackground(Theme.color3);
        btnReview.setBackground(Theme.color3);
        btnCustomers.setBackground(Theme.color3);
        btnOrders.setBackground(Theme.color3);
        btnLocations.setBackground(Theme.color3);
        btnGit.setBackground(Theme.color3);

        pnlEvents.applyTheme();
        pnlReview.applyTheme();
        pnlCustomers.applyTheme();
        pnlLocations.applyTheme();
        pnlOrders.applyTheme();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnEvents;
    private javax.swing.JButton btnGit;
    private javax.swing.JButton btnLocations;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnReview;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLightSwitch;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
