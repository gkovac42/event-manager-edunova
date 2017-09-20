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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Goran
 */
public class PdfMaker {
    
    public PdfMaker() {
        
    }
    
    public static void createPdf(Order order)
{
   PDPage singlePage = new PDPage();
   PDFont courierBoldFont = PDType1Font.COURIER_BOLD;
   int fontSize = 16;
   try (PDDocument document = new PDDocument())
   {
      document.addPage(singlePage);
      PDPageContentStream contentStream = new PDPageContentStream(document, singlePage);
      contentStream.beginText();
      contentStream.setFont(courierBoldFont, fontSize);
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
          contentStream.showText(t.getName() + " x" + t.getQuantity() + " = " + t.getTotalPrice());
          contentStream.newLine();
      }
      contentStream.showText("--------------------------------------------------");
      contentStream.newLine();
      contentStream.showText("UKUPNO: " + order.getTotalPrice());
      
      
      
      
      
      contentStream.endText();
      contentStream.close();  // Stream must be closed before saving document.
      document.save(order.getId() + ".pdf");
   }
   catch (IOException ioEx)
   {
      err.println(
         "Exception while trying to create simple document - " + ioEx);
   }
   
   if (Desktop.isDesktopSupported()) {
    try {
        File myFile = new File(order.getId() + ".pdf");
        Desktop.getDesktop().open(myFile);
    } catch (IOException ex) {
        // no application registered for PDFs
    }
}
}
    
}
