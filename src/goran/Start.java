/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran;

import goran.util.NaseljaRH;
import goran.view.StartFrame;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Goran
 */
public class Start {

    public static void main(String[] args) {

        BasicLookAndFeel laf = new NimbusLookAndFeel();
        try {
            UIManager.setLookAndFeel(laf);
        } catch (Exception ex) {
        }

        new StartFrame().setVisible(true);
        //new LoadData();
        new NaseljaRH();

    }

}
