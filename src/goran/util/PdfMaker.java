/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import goran.model.Order;
import goran.model.Ticket;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.System.err;
import java.text.DecimalFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author Goran
 */
public class PdfMaker {

    public static void createPdf(Order order) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);
            PDType0Font font = PDType0Font.load(document, new File("ARIALUNI.ttf"));

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.setFont(font, 16);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 725);
            contentStream.showText(order.toString());
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Korisnik: " + order.getCustomer().toString());
            contentStream.newLine();
            contentStream.showText("Adresa: " + order.getCustomer().getAddress() + ", " + order.getCustomer().getLocality());
            contentStream.newLine();
            contentStream.showText("--------------------------------------------------");
            contentStream.newLine();

            for (Ticket t : order.getTickets()) {
                contentStream.showText(t.getName() + " x" + t.getQuantity() + " = " + new DecimalFormat("#.00").format(t.getTotalPrice()) + "kn");
                contentStream.newLine();
            }

            contentStream.showText("--------------------------------------------------");
            contentStream.newLine();
            contentStream.showText("UKUPNO: " + order.getTotalPrice());

            contentStream.endText();
            contentStream.close();  // Stream must be closed before saving document.
            document.save(order.getId() + ".pdf");
        } catch (IOException ioEx) {
            err.println(
                    "Exception while trying to create simple document - " + ioEx);
        }

        openPdf(order);

    }

    public static void openPdf(Order order) {

        if (Desktop.isDesktopSupported()) {
            try {
                File f = new File(order.getId() + ".pdf");
                Desktop.getDesktop().open(f);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

}
