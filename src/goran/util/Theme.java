/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import java.awt.Color;

/**
 *
 * @author Goran
 */
public class Theme {

    public static final int DARK = 0;
    public static final int LIGHT = 1;

    public static Color color1 = new Color(15, 15, 15);
    public static Color color2 = new Color(40, 40, 40);
    public static Color color3 = new Color(0, 0, 0);
    public static Color color4 = new Color(60, 60, 60);
    public static Color font1 = new Color(255, 255, 255);

    // blue
//    public static void setLightTheme() {
//
//        color1 = new Color(50, 100, 160);
//        color2 = new Color(80, 160, 180);
//        color3 = new Color(40, 70, 120);
//        color4 = new Color(250, 250, 250);
//        font1 = new Color(0, 0, 0);
//    }
    
    // black
    public static void setDarkTheme() {

        color1 = new Color(15, 15, 15);
        color2 = new Color(40, 40, 40);
        color3 = new Color(0, 0, 0);
        color4 = new Color(60, 60, 60);
        font1 = new Color(255, 255, 255);
    }

    // green
    public static void setLightTheme() {

        color1 = new Color(90, 15, 0);
        color2 = new Color(135, 55, 10);
        color3 = new Color(80, 30, 5);
        color4 = new Color(220, 210, 200);
        font1 = new Color(60, 50, 30);

    }
}
