/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran;

import goran.view.MainFrame;
import goran.view.StartFrame;

/**
 *
 * @author Goran
 */
public class Start {

    public Start() {

        //new LoadData();
        new MainFrame().setVisible(true);

    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        }

        new StartFrame().setVisible(true);

    }

}
