/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.controller.GoogleMapsController;
import goran.controller.LocationController;
import goran.model.Location;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Goran
 */
public class LocationsPanel extends javax.swing.JPanel {

    private Location location;
    private LocationController locationControl;
    private GoogleMapsController mapControl;
    private String[] mapData;
    private String imageUrl;
    private URL url;
    private int zoomLevel;

    public LocationsPanel() {

        initComponents();
        location = new Location();
        locationControl = new LocationController();
        mapControl = new GoogleMapsController();
        zoomLevel = Utils.DEFAULT_ZOOM_LEVEL;
        updateLocations();
    }

    private void updateLocations() {

        DefaultListModel<Location> model = new DefaultListModel<>();
        lstLocations.setModel(model);
        for (Location location : locationControl.getLocations()) {
            model.addElement(location);
        }
    }

    private void downloadMap(String lat, String lng, int zoomLevel) {

        imageUrl = "http://maps.googleapis.com/maps/api/staticmap?center="
                + lat + ",%20" + lng + "&zoom=" + zoomLevel + "&size=680x270&scale=1&markers="
                + lat + ",%20" + lng + "&sensor=true";
        try {

            url = new URL(imageUrl);
            lblMap.setIcon(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(680, 270, java.awt.Image.SCALE_SMOOTH)));

        } catch (MalformedURLException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        setBackground(new java.awt.Color(60, 60, 70));
        setMinimumSize(new java.awt.Dimension(700, 500));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstLocations.setBackground(new java.awt.Color(153, 153, 153));
        lstLocations.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        lstLocations.setForeground(new java.awt.Color(255, 255, 255));
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
        add(txtLocationName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 210, 30));

        txtLocationAddress.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationAddress.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationAddress.setForeground(new java.awt.Color(255, 255, 255));
        add(txtLocationAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 210, 30));

        txtLocationLocality.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationLocality.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationLocality.setForeground(new java.awt.Color(255, 255, 255));
        add(txtLocationLocality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, 30));

        txtLocationCountry.setBackground(new java.awt.Color(120, 120, 120));
        txtLocationCountry.setFont(new java.awt.Font("Lucida Sans", 0, 16)); // NOI18N
        txtLocationCountry.setForeground(new java.awt.Color(255, 255, 255));
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
        btnNewLocation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/goran/resources/icons/btn_cancel.png"))); // NOI18N
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
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblError.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 250, 50));

        lblTitle6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblTitle6.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle6.setText("DRŽAVA");
        add(lblTitle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void lstLocationsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstLocationsValueChanged

        try {

            location = lstLocations.getSelectedValue();

            txtLocationAddress.setText(location.getAddress());
            txtLocationLocality.setText(location.getLocality());
            txtLocationCountry.setText(location.getCountry());
            txtLocationName.setText(location.getName());

            downloadMap(location.getLat(), location.getLng(), Utils.DEFAULT_ZOOM_LEVEL);
            
            lblError.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_lstLocationsValueChanged

    private void btnFindOnMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindOnMapActionPerformed

        try {
            
            location.setName(txtLocationName.getText());
            location.setAddress(txtLocationAddress.getText());
            location.setLocality(txtLocationLocality.getText());
            location.setCountry(txtLocationCountry.getText());
            
            mapData = mapControl.getGoogleMapsData(mapControl.generateUrl(location));
            
            location.setLat(mapData[0]);
            location.setLng(mapData[1]);
            
            downloadMap(location.getLat(), location.getLng(), Utils.DEFAULT_ZOOM_LEVEL);
            
            txtLocationAddress.setText(mapData[3] + " " + mapData[2]);
            txtLocationLocality.setText(mapData[4]);
            txtLocationCountry.setText(mapData[5]);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnFindOnMapActionPerformed

    private void btnZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomOutActionPerformed

        try {
            
            zoomLevel--;
            downloadMap(location.getLat(), location.getLng(), zoomLevel);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnZoomOutActionPerformed

    private void btnZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomInActionPerformed

        try {
            
            zoomLevel++;
            downloadMap(location.getLat(), location.getLng(), zoomLevel);
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnZoomInActionPerformed

    private void btnAddLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLocationActionPerformed

        if (txtLocationName.getText().matches("")
                || txtLocationAddress.getText().matches("")
                || txtLocationLocality.getText().matches("")
                || txtLocationCountry.getText().matches("")) {

            lblError.setText(Utils.INPUT_ERROR);

        } else {

            location.setName(txtLocationName.getText());
            location.setAddress(txtLocationAddress.getText());
            location.setLocality(txtLocationLocality.getText());
            location.setCountry(txtLocationCountry.getText());

            locationControl.addLocation(location);

            updateLocations();

            lblError.setText("");
        }

    }//GEN-LAST:event_btnAddLocationActionPerformed

    private void btnEditLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditLocationActionPerformed

        if (txtLocationName.getText().matches("")
                || txtLocationAddress.getText().matches("")
                || txtLocationLocality.getText().matches("")
                || txtLocationCountry.getText().matches("")) {
            
            lblError.setText(Utils.INPUT_ERROR);
            
        } else {
            
            location.setName(txtLocationName.getText());
            location.setAddress(txtLocationAddress.getText());
            location.setLocality(txtLocationLocality.getText());
            location.setCountry(txtLocationCountry.getText());
            
            locationControl.editLocation(location);
            
            updateLocations();
            
            lblError.setText("");
        }
    }//GEN-LAST:event_btnEditLocationActionPerformed

    private void btnRemoveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveLocationActionPerformed

        try {
            
            locationControl.removeLocation(location);
            
            txtLocationName.setText("");
            txtLocationAddress.setText("");
            txtLocationLocality.setText("");
            txtLocationCountry.setText("");
            
            lblMap.setIcon(null);
            
            updateLocations();
            
            location = new Location();
            
            lblError.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRemoveLocationActionPerformed

    private void btnNewLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewLocationActionPerformed

        txtLocationName.setText("");
        txtLocationAddress.setText("");
        txtLocationLocality.setText("");
        txtLocationCountry.setText("");
        
        lblMap.setIcon(null);

        lblError.setText("");
    }//GEN-LAST:event_btnNewLocationActionPerformed

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
    private javax.swing.JList<Location> lstLocations;
    private javax.swing.JTextField txtLocationAddress;
    private javax.swing.JTextField txtLocationCountry;
    private javax.swing.JTextField txtLocationLocality;
    private javax.swing.JTextField txtLocationName;
    // End of variables declaration//GEN-END:variables
}
