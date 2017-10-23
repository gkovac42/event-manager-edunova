/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import com.bulenkov.darcula.DarculaLaf;
import goran.view.MainFrame;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static Session session = null;

    protected HibernateUtil() {

    }

    public static Session getSession() {
        if (session == null) {
            try {

                File f = new File("hibernate.cfg.xml");
                SessionFactory sessionFactory = new Configuration().configure(f).buildSessionFactory();
                session = sessionFactory.openSession();

            } catch (Throwable ex) {

                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        return session;
    }

    public static void exit() {
        getSession().close();
        try {
            Runtime.getRuntime().exec("cmd /c Taskkill /IM mysqld.exe /F");
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }

    public static void startMySQL() {
        try {
            Runtime.getRuntime().exec("cmd /c start /B " + getMySQLPath());
        } catch (IOException ex) {
            new JOptionPane("Greška pri pokretanju MySQL servera!");
            System.exit(0);
        }
    }

    public static String getMySQLPath() {

        String path;
        Properties properties = new Properties();

        try {
            FileInputStream in = new FileInputStream("properties");
            properties.load(in);
            in.close();

            path = properties.getProperty("mysql_path");
            return path;

        } catch (IOException iOException) {

            try {
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".exe", "exe");

                try {
                    UIManager.setLookAndFeel(new DarculaLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(ExcelMaker.class.getName()).log(Level.SEVERE, null, ex);
                }
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
                try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(ExcelMaker.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (HeadlessException | IOException ex) {
            }
            return null;
        }
    }

}
