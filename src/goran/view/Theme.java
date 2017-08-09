/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.view;

import java.awt.Color;

/**
 *
 * @author Goran
 */
public class Theme {

    public static final int DARK = 0;
    public static final int LIGHT = 1;
    public static int checkTheme = 0;

    public static Color color1 = new Color(30, 30, 40);
    public static Color color2 = new Color(75, 75, 85);
    public static Color color3 = new Color(0, 0, 0);
    public static Color color4 = new Color(120, 120, 120);
    public static Color font1 = new Color(255, 255, 255);

    // blue
    public static void setLightTheme() {

        color1 = new Color(10, 100, 150);
        color2 = new Color(20, 120, 160);
        color3 = new Color(30, 80, 140);
        color4 = new Color(250, 250, 250);
        font1 = new Color(0, 0, 0);
    }

    // black
    public static void setDarkTheme() {

        color1 = new Color(30, 30, 40);
        color2 = new Color(75, 75, 85);
        color3 = new Color(0, 0, 0);
        color4 = new Color(120, 120, 120);
        font1 = new Color(255, 255, 255);
    }

    // green
    /*public static void setLightTheme() {
    
    color1 = new Color(60, 110, 10);
    color2 = new Color(90, 170, 40);
    color3 = new Color(40, 90, 0);
    color4 = new Color(250, 250, 250);
    font1 = new Color(0, 0, 0);
    }*/
}
