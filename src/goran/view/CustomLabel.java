/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import goran.util.Theme;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Goran
 */
public class CustomLabel extends JLabel {

    public CustomLabel() {
        
        super();
        addListener();
        
    }
    
    private void addListener() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(Theme.color2);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(Theme.color1);
            }
        });
    }
    
    
}
