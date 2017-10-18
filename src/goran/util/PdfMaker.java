/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goran.util;

import goran.model.Order;
import goran.model.OrderedTicket;
import goran.view.StartFrame;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.System.err;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author Goran
 */
public class PdfMaker {

    private static final String FONT_PATH = "data/ARIALUNI.ttf";
    private static final String PDF_PATH = "data/pdf/";

    public static void savePdf(Order order) {

        try (PDDocument document = new PDDocument()) {

            PDPage page = new PDPage();
            document.addPage(page);
            PDType0Font font = PDType0Font.load(document, new File(FONT_PATH));

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();
            contentStream.setFont(font, 16);
            contentStream.setLeading(14.5f);
            contentStream.newLineAtOffset(25, 725);
            contentStream.showText(order.toString());
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Kupac: " + order.getCustomer().toString());
            contentStream.newLine();
            contentStream.showText("Adresa: " + order.getCustomer().getAddress() + ", " + order.getCustomer().getLocality());
            contentStream.newLine();
            contentStream.showText("--------------------------------------------------");
            contentStream.newLine();

            for (OrderedTicket t : order.getTickets()) {
                contentStream.showText(t.getTicket().getName() + " x" + t.getQuantity() + " = "
                        + new DecimalFormat("#.00").format(t.getTicket().getTotalPrice()) + "kn");
                contentStream.newLine();
            }

            contentStream.showText("--------------------------------------------------");
            contentStream.newLine();
            contentStream.showText("UKUPNO: " + order.getTotalPrice());
            contentStream.newLine();
            contentStream.newLine();
            contentStream.showText("Izradio: " + StartFrame.user + ", vrijeme: "
                    + new SimpleDateFormat("HH:mm").format(order.getDateCreated()));

            contentStream.endText();
            contentStream.close();

            document.save(PDF_PATH + order.getId() + ".pdf");

        } catch (IOException ioEx) {
            err.println(
                    "Exception while trying to create simple document - " + ioEx);
        }

    }

    public static void openPdf(Order order) {

        if (Desktop.isDesktopSupported()) {
            try {
                File f = new File(PDF_PATH + order.getId() + ".pdf");
                Desktop.getDesktop().open(f);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

}
