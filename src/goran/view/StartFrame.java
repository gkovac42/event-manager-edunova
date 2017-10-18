/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.util.Theme;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Goran
 */
public class StartFrame extends javax.swing.JFrame {

    public static String user;

    public StartFrame() {
        initComponents();

        drawBorder();
        lblLoading.setVisible(false);

        startMySQL(getMySQLPath());
    }

    private String getMySQLPath() {

        String path = "";
        Properties properties = new Properties();

        try {

            FileInputStream in = new FileInputStream("properties");
            properties.load(in);
            in.close();

            path = properties.getProperty("mysql_path");
            return path;

        } catch (IOException iOException) {

            try {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("All files", "exe");

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogTitle("Odaberite datoteku MySQL servera (mysql\\bin)");
                fileChooser.setSelectedFile(new File("mysqld.exe"));
                int userSelection = fileChooser.showSaveDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    path = fileChooser.getSelectedFile().getAbsolutePath();
                    properties.setProperty("mysql_path", path);
                    FileOutputStream out = new FileOutputStream("properties");
                    properties.store(out, "MySQL path added.");
                    return path;

                } else if (userSelection == JFileChooser.CANCEL_OPTION) {
                    System.exit(0);
                }

            } catch (HeadlessException | IOException ex) {
            }

            return null;
        }
    }

    private void startMySQL(String path) {

        try {
            Runtime.getRuntime().exec("cmd /c start /B " + path);
        } catch (IOException ex) {
            new JOptionPane("Greška pri pokretanju MySQL servera!");
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        lblPassword = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        lblUser1 = new javax.swing.JLabel();
        pnlTitle = new MotionPanel(this);
        lblIcon = new javax.swing.JLabel();
        lblClose = new CustomLabel();
        lblTitle = new javax.swing.JLabel();
        lblMinimize = new CustomLabel();
        lblLoading = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setOpacity(0.97F);
        setSize(new java.awt.Dimension(310, 290));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(25, 25, 25));
        pnlLogin.setMinimumSize(new java.awt.Dimension(300, 250));
        pnlLogin.setPreferredSize(new java.awt.Dimension(312, 250));
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPassword.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("ZAPORKA");
        pnlLogin.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 80, 40));

        lblUser.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("KORISNIK");
        pnlLogin.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 40));

        txtUsername.setBackground(new java.awt.Color(120, 120, 120));
        txtUsername.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 200, 40));

        txtPassword.setBackground(new java.awt.Color(120, 120, 120));
        txtPassword.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 200, 40));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_confirm.png"))); // NOI18N
        btnLogin.setText("PRIJAVA");
        btnLogin.setBorder(null);
        btnLogin.setFocusPainted(false);
        btnLogin.setPreferredSize(new java.awt.Dimension(80, 80));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 100, 40));

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel.png"))); // NOI18N
        btnExit.setText("IZLAZ");
        btnExit.setBorder(null);
        btnExit.setFocusPainted(false);
        btnExit.setPreferredSize(new java.awt.Dimension(80, 80));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlLogin.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 100, 40));

        lblError.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        pnlLogin.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 290, 40));

        lblUser1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblUser1.setForeground(new java.awt.Color(255, 255, 255));
        lblUser1.setText("Unesite korisničko ime i zaporku :");
        pnlLogin.add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 250, 40));

        pnlTitle.setBackground(new java.awt.Color(10, 10, 15));
        pnlTitle.setForeground(new java.awt.Color(255, 255, 255));
        pnlTitle.setPreferredSize(new java.awt.Dimension(310, 40));
        pnlTitle.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_icon.png"))); // NOI18N
        pnlTitle.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        lblClose.setBackground(new java.awt.Color(10, 10, 15));
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_close.png"))); // NOI18N
        lblClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblClose.setOpaque(true);
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        pnlTitle.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 30, 40));

        lblTitle.setFont(new java.awt.Font("Lucida Sans", 1, 16)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("EVENT MANAGER");
        pnlTitle.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 150, 40));

        lblMinimize.setBackground(new java.awt.Color(10, 10, 15));
        lblMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/title_minimize.png"))); // NOI18N
        lblMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblMinimize.setOpaque(true);
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        pnlTitle.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, 50));

        pnlLogin.add(pnlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 40));

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 290));

        lblLoading.setBackground(new java.awt.Color(25, 25, 25));
        lblLoading.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblLoading.setForeground(new java.awt.Color(180, 180, 180));
        lblLoading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/ajax-loader.gif"))); // NOI18N
        lblLoading.setText("UČITAVANJE PODATAKA...");
        lblLoading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLoading.setIconTextGap(0);
        lblLoading.setOpaque(true);
        lblLoading.setPreferredSize(new java.awt.Dimension(312, 292));
        lblLoading.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblLoading, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 290));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        this.setState(StartFrame.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        if (txtUsername.getText().equals("edunova")) {
            if (new String(txtPassword.getPassword()).equals("edunova")) {

                user = txtUsername.getText();
                lblLoading.setVisible(true);
                pnlLogin.setVisible(false);

                Thread t = new Thread(() -> {
                    new MainFrame().setVisible(true);
                    dispose();
                });
                t.start();

            } else {
                lblError.setText("Pogrešna zaporka, pokušajte ponovo!");
            }

        } else {
            lblError.setText("Korisnik ne postoji, pokušajte ponovo!");
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblLoading;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void drawBorder() {
        getRootPane().setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.DARK_GRAY));
    }
}
