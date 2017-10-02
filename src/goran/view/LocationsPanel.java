/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.util.Theme;
import goran.util.TxtUtil;
import goran.controller.GoogleMapsController;
import goran.controller.HibernateController;
import goran.controller.InputController;
import goran.model.Location;
import javax.swing.DefaultListModel;

/**
 *
 * @author Goran
 */
public class LocationsPanel extends javax.swing.JPanel {

    private Location location;
    private HibernateController<Location> hc;
    private GoogleMapsController mapControl;
    private int mapZoom;
    private String sortLocations;

    public LocationsPanel() {

        initComponents();
        
        lstLocations.setComponentPopupMenu(locationsMenu);
        menuButtonGroup.setSelected(mnuNam.getModel(), true);
        location = new Location();
        hc = new HibernateController<>();
        mapControl = new GoogleMapsController();
        sortLocations = "name";
        mapZoom = 16;
        
        updateLocations(sortLocations);
    }

    private void updateLocations(String orderBy) {

        DefaultListModel<Location> model = new DefaultListModel<>();
        lstLocations.setModel(model);
        for (Location location : hc.getOrderedList(location, orderBy)) {
            model.addElement(location);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        locationsMenu = new javax.swing.JPopupMenu();
        mnuNam = new javax.swing.JRadioButtonMenuItem();
        mnuLocality = new javax.swing.JRadioButtonMenuItem();
        mnuDateCreated = new javax.swing.JRadioButtonMenuItem();
        menuButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstLocations = new javax.swing.JList<>();
        txtLocationName = new javax.swing.JTextField();
        txtLocationAddress = new javax.swing.JTextField();
        txtLocationLocality = new javax.swing.JTextField();
        txtLocationCountry = new javax.swing.JTextField();
        btnFindOnMap = new javax.swing.JButton();
        btnZoomOut = new javax.swing.JButton();
        btnZoomIn = new javax.swing.JButton();
        btnAddLocation = new javax.swing.JButton();
        btnEditLocation = new javax.swing.JButton();
        btnRemoveLocation = new javax.swing.JButton();
        btnNewLocation = new javax.swing.JButton();
        lblMap = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();
        lblTitle6 = new javax.swing.JLabel();

        locationsMenu.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        locationsMenu.setToolTipText("");

        menuButtonGroup.add(mnuNam);
        mnuNam.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuNam.setText("Po nazivu");
        mnuNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNamActionPerformed(evt);
            }
        });
        locationsMenu.add(mnuNam);

        menuButtonGroup.add(mnuLocality);
        mnuLocality.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuLocality.setText("Po mjestu");
        mnuLocality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLocalityActionPerformed(evt);
            }
        });
        locationsMenu.add(mnuLocality);

        menuButtonGroup.add(mnuDateCreated);
        mnuDateCreated.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        mnuDateCreated.setSelected(true);
        mnuDateCreated.setText("Po unosu");
        mnuDateCreated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDateCreatedActionPerformed(evt);
            }
        });
        locationsMenu.add(mnuDateCreated);

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstLocations.setBackground(new java.awt.Color(120, 120, 120));
        lstLocations.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lstLocations.setForeground(new java.awt.Color(255, 255, 255));
        lstLocations.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstLocations.setFocusable(false);
        lstLocations.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstLocationsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstLocations);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 380, 150));

        txtLocationName.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationName.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationName.setForeground(new java.awt.Color(255, 255, 255));
        txtLocationName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOnMapActionPerformed(evt);
            }
        });
        add(txtLocationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 210, 30));

        txtLocationAddress.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationAddress.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationAddress.setForeground(new java.awt.Color(255, 255, 255));
        txtLocationAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOnMapActionPerformed(evt);
            }
        });
        add(txtLocationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 210, 30));

        txtLocationLocality.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationLocality.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationLocality.setForeground(new java.awt.Color(255, 255, 255));
        txtLocationLocality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOnMapActionPerformed(evt);
            }
        });
        add(txtLocationLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, 30));

        txtLocationCountry.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationCountry.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationCountry.setForeground(new java.awt.Color(255, 255, 255));
        txtLocationCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOnMapActionPerformed(evt);
            }
        });
        add(txtLocationCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 210, 30));

        btnFindOnMap.setBackground(new java.awt.Color(0, 0, 0));
        btnFindOnMap.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnFindOnMap.setForeground(new java.awt.Color(255, 255, 255));
        btnFindOnMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_locate.png"))); // NOI18N
        btnFindOnMap.setText("PRONAĐI NA KARTI");
        btnFindOnMap.setBorder(null);
        btnFindOnMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindOnMapActionPerformed(evt);
            }
        });
        add(btnFindOnMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 290, 40));

        btnZoomOut.setBackground(new java.awt.Color(0, 0, 0));
        btnZoomOut.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnZoomOut.setForeground(new java.awt.Color(255, 255, 255));
        btnZoomOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnZoomOut.setBorder(null);
        btnZoomOut.setBorderPainted(false);
        btnZoomOut.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnZoomOut.setIconTextGap(0);
        btnZoomOut.setOpaque(false);
        btnZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomOutActionPerformed(evt);
            }
        });
        add(btnZoomOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 440, 40, 40));

        btnZoomIn.setBackground(new java.awt.Color(0, 0, 0));
        btnZoomIn.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnZoomIn.setForeground(new java.awt.Color(255, 255, 255));
        btnZoomIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnZoomIn.setBorder(null);
        btnZoomIn.setBorderPainted(false);
        btnZoomIn.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnZoomIn.setIconTextGap(0);
        btnZoomIn.setOpaque(false);
        btnZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomInActionPerformed(evt);
            }
        });
        add(btnZoomIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 40, 40));

        btnAddLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnAddLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnAddLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnAddLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_add.png"))); // NOI18N
        btnAddLocation.setText("DODAJ");
        btnAddLocation.setBorder(null);
        btnAddLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLocationActionPerformed(evt);
            }
        });
        add(btnAddLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 100, 40));

        btnEditLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnEditLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnEditLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnEditLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_edit.png"))); // NOI18N
        btnEditLocation.setText("UREDI");
        btnEditLocation.setBorder(null);
        btnEditLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditLocationActionPerformed(evt);
            }
        });
        add(btnEditLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 100, 40));

        btnRemoveLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoveLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnRemoveLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_remove.png"))); // NOI18N
        btnRemoveLocation.setText("UKLONI");
        btnRemoveLocation.setBorder(null);
        btnRemoveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveLocationActionPerformed(evt);
            }
        });
        add(btnRemoveLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 100, 40));

        btnNewLocation.setBackground(new java.awt.Color(0, 0, 0));
        btnNewLocation.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        btnNewLocation.setForeground(new java.awt.Color(255, 255, 255));
        btnNewLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_new.png"))); // NOI18N
        btnNewLocation.setBorder(null);
        btnNewLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewLocationActionPerformed(evt);
            }
        });
        add(btnNewLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, 50, 40));

        lblMap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblMap.setPreferredSize(new java.awt.Dimension(460, 460));
        add(lblMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 680, 270));

        lblTitle1.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setText("ADRESA");
        add(lblTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        lblTitle2.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setText("MJESTO");
        add(lblTitle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        lblTitle4.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle4.setText("NAZIV");
        add(lblTitle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        lblError.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 40));

        lblTitle6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle6.setText("DRŽAVA");
        add(lblTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void lstLocationsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstLocationsValueChanged

        if (lstLocations.getSelectedIndex() == -1) {
        } else {

            location = lstLocations.getSelectedValue();

            txtLocationAddress.setText(location.getAddress());
            txtLocationLocality.setText(location.getLocality());
            txtLocationCountry.setText(location.getCountry());
            txtLocationName.setText(location.getName());

            mapControl.openOrDownloadMap(location, 16, lblMap);

            lblError.setText("");
        }


    }//GEN-LAST:event_lstLocationsValueChanged

    private void btnFindOnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindOnMapActionPerformed

        try {

            location.setName(txtLocationName.getText());
            location.setAddress(txtLocationAddress.getText());
            location.setLocality(txtLocationLocality.getText());
            location.setCountry(txtLocationCountry.getText());

            String[] mapData = mapControl.getGoogleMapsData(mapControl.generateUrl(location));

            location.setLat(mapData[0]);
            location.setLng(mapData[1]);

            mapControl.openOrDownloadMap(location, 16, lblMap);

            txtLocationAddress.setText(mapData[3] + " " + mapData[2]);
            txtLocationLocality.setText(mapData[4]);
            txtLocationCountry.setText(mapData[5]);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnFindOnMapActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed

        try {

            mapZoom--;
            mapControl.openOrDownloadMap(location, mapZoom, lblMap);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed

        try {

            mapZoom++;
            mapControl.openOrDownloadMap(location, mapZoom, lblMap);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnAddLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLocationActionPerformed

        location.setName(txtLocationName.getText());
        location.setAddress(txtLocationAddress.getText());
        location.setLocality(txtLocationLocality.getText());
        location.setCountry(txtLocationCountry.getText());

        if (InputController.locationInputError(location)) {

            lblError.setText(TxtUtil.INPUT_ERROR);

        } else {

            hc.save(location);
            updateLocations(sortLocations);
            lblError.setText("");
            location = new Location();
        }
    }//GEN-LAST:event_btnAddLocationActionPerformed

    private void btnEditLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLocationActionPerformed

        if (lstLocations.getSelectedIndex() == -1) {
        } else {

            location.setName(txtLocationName.getText());
            location.setAddress(txtLocationAddress.getText());
            location.setLocality(txtLocationLocality.getText());
            location.setCountry(txtLocationCountry.getText());

            if (InputController.locationInputError(location)) {

                lblError.setText(TxtUtil.INPUT_ERROR);

            } else {

                hc.save(location);
                updateLocations(sortLocations);
                lblError.setText("");
                location = new Location();
            }
        }
    }//GEN-LAST:event_btnEditLocationActionPerformed

    private void btnRemoveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLocationActionPerformed

        if (lstLocations.getSelectedIndex() == -1) {
        } else {

            hc.delete(location);

            txtLocationName.setText("");
            txtLocationAddress.setText("");
            txtLocationLocality.setText("");
            txtLocationCountry.setText("");

            lblMap.setIcon(null);
            updateLocations(sortLocations);
            lblError.setText("");
            location = new Location();

        }
    }//GEN-LAST:event_btnRemoveLocationActionPerformed

    private void btnNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLocationActionPerformed

        lstLocations.setSelectedIndex(-1);

        txtLocationName.setText("");
        txtLocationAddress.setText("");
        txtLocationLocality.setText("");
        txtLocationCountry.setText("");

        lblError.setText("");
        lblMap.setIcon(null);
        location = new Location();
    }//GEN-LAST:event_btnNewLocationActionPerformed

    private void mnuLocalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLocalityActionPerformed
        sortLocations = "locality";
        updateLocations(sortLocations);
    }//GEN-LAST:event_mnuLocalityActionPerformed

    private void mnuNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNamActionPerformed
        sortLocations = "name";
        updateLocations(sortLocations);
    }//GEN-LAST:event_mnuNamActionPerformed

    private void mnuDateCreatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDateCreatedActionPerformed
        sortLocations = "dateCreated";
        updateLocations(sortLocations);
    }//GEN-LAST:event_mnuDateCreatedActionPerformed

    public void applyTheme() {

        setBackground(Theme.color2);
        btnAddLocation.setBackground(Theme.color3);
        btnEditLocation.setBackground(Theme.color3);
        btnRemoveLocation.setBackground(Theme.color3);
        btnNewLocation.setBackground(Theme.color3);
        btnFindOnMap.setBackground(Theme.color3);
        btnZoomIn.setBackground(Theme.color3);
        btnZoomOut.setBackground(Theme.color3);
        txtLocationName.setBackground(Theme.color4);
        txtLocationAddress.setBackground(Theme.color4);
        txtLocationLocality.setBackground(Theme.color4);
        txtLocationCountry.setBackground(Theme.color4);
        lstLocations.setBackground(Theme.color4);
        lstLocations.setForeground(Theme.font1);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLocation;
    private javax.swing.JButton btnEditLocation;
    private javax.swing.JButton btnFindOnMap;
    private javax.swing.JButton btnNewLocation;
    private javax.swing.JButton btnRemoveLocation;
    private javax.swing.JButton btnZoomIn;
    private javax.swing.JButton btnZoomOut;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle6;
    private javax.swing.JPopupMenu locationsMenu;
    private javax.swing.JList<Location> lstLocations;
    private javax.swing.ButtonGroup menuButtonGroup;
    private javax.swing.JRadioButtonMenuItem mnuDateCreated;
    private javax.swing.JRadioButtonMenuItem mnuLocality;
    private javax.swing.JRadioButtonMenuItem mnuNam;
    private javax.swing.JTextField txtLocationAddress;
    private javax.swing.JTextField txtLocationCountry;
    private javax.swing.JTextField txtLocationLocality;
    private javax.swing.JTextField txtLocationName;
    // End of variables declaration//GEN-END:variables

}
