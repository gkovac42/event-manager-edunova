/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import goran.model.Customer;
import goran.model.Order;
import goran.model.Ticket;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Goran
 */
public class ExcelMaker {

    public static void ticketsToExcel(List<Ticket> tickets) {

        String filepath = getFilepath("Ulaznice " + new SimpleDateFormat("dd.MM.yy").format(new Date()));

        if (filepath == null) {

            return;
        }

        try {
            HSSFWorkbook wb = new HSSFWorkbook();

            // setting sheet name later
            Row row;
            Cell cell;
            int red = 0;
            int kolona;

            wb.createSheet("Ulaznice");
            kolona = 0;
            row = wb.getSheetAt(0).createRow(red++);
            cell = row.createCell(kolona++);
            cell.setCellValue("Naziv");
            cell = row.createCell(kolona++);
            cell.setCellValue("Cijena");
            cell = row.createCell(kolona++);
            cell.setCellValue("Količina");
            cell = row.createCell(kolona);
            cell.setCellValue("Event");

            for (Ticket t : tickets) {
                
                kolona = 0;
                row = wb.getSheetAt(0).createRow(red++);
                cell = row.createCell(kolona++);
                cell.setCellValue(t.getName());
                cell = row.createCell(kolona++);
                cell.setCellValue(t.getPrice());
                cell = row.createCell(kolona++);
                cell.setCellValue(t.getQuantity());
                cell = row.createCell(kolona);
                cell.setCellValue(t.getEvent().toString());

            }

            writeFile(wb, filepath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void ordersToExcel(List<Order> orders) {

        String filepath = getFilepath("Narudžbe " + new SimpleDateFormat("dd.MM.yy").format(new Date()));

        if (filepath == null) {

            return;
        }

        try {
            HSSFWorkbook wb = new HSSFWorkbook();

            // setting sheet name later
            Row row;
            Cell cell;
            int red = 0;
            int kolona;

            wb.createSheet("Narudžbe");
            kolona = 0;
            row = wb.getSheetAt(0).createRow(red++);
            cell = row.createCell(kolona++);
            cell.setCellValue("#");
            cell = row.createCell(kolona++);
            cell.setCellValue("Datum");
            cell = row.createCell(kolona++);
            cell.setCellValue("Naručitelj");
            cell = row.createCell(kolona);
            cell.setCellValue("Vrijednost");

            for (Order o : orders) {
                
                kolona = 0;
                row = wb.getSheetAt(0).createRow(red++);
                cell = row.createCell(kolona++);
                cell.setCellValue(o.getId());
                cell = row.createCell(kolona++);
                cell.setCellValue(new SimpleDateFormat("dd.MM.yy").format(o.getDateCreated()));
                cell = row.createCell(kolona++);
                cell.setCellValue(o.getCustomer().toString());
                cell = row.createCell(kolona);
                cell.setCellValue(o.getTotalPrice());

            }

            writeFile(wb, filepath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void customersToExcel(List<Customer> customers) {

        String filepath = getFilepath("Korisnici " + new SimpleDateFormat("dd.MM.yy").format(new Date()));

        if (filepath == null) {

            return;
        }

        try {
            HSSFWorkbook wb = new HSSFWorkbook();

            // setting sheet name later
            Row row;
            Cell cell;
            int red = 0;
            int kolona;

            wb.createSheet("Korisnici");
            kolona = 0;
            row = wb.getSheetAt(0).createRow(red++);
            cell = row.createCell(kolona++);
            cell.setCellValue("Prezime");
            cell = row.createCell(kolona++);
            cell.setCellValue("Ime");
            cell = row.createCell(kolona++);
            cell.setCellValue("Adresa");
            cell = row.createCell(kolona++);
            cell.setCellValue("Mjesto");
            cell = row.createCell(kolona);
            cell.setCellValue("E-mail");

            for (Customer c : customers) {
                
                kolona = 0;
                row = wb.getSheetAt(0).createRow(red++);
                cell = row.createCell(kolona++);
                cell.setCellValue(c.getLastName());
                cell = row.createCell(kolona++);
                cell.setCellValue(c.getFirstName());
                cell = row.createCell(kolona++);
                cell.setCellValue(c.getAddress());
                cell = row.createCell(kolona++);
                cell.setCellValue(c.getLocality());
                cell = row.createCell(kolona);
                cell.setCellValue(c.getEmail());

            }

            writeFile(wb, filepath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getFilepath(String name) {

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel datoteka(.xls)", "xls");

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Odaberite datoteku za pohranu");
        fileChooser.setSelectedFile(new File(name + ".xls"));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }

        return null;
    }

    private static void writeFile(HSSFWorkbook wb, String filepath) throws IOException {

        FileOutputStream fileOut = new FileOutputStream(filepath);
        wb.write(fileOut);
        wb.close();
        fileOut.close();
    }

}
