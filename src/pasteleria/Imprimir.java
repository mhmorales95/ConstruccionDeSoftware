/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.FontMetrics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author Mauricio
 */
public class Imprimir extends javax.swing.JFrame {

    
    public static String finalidad;
    public static ArrayList<String> datos;

    public static String correlativo;
    public static String cliente;
    public static String fechaEntrega;
    public static String horaEntrega;
    public static String total;
    public static String abono;
    public static String porPagar;
    public static String ciudad;

    public Imprimir() {

    }


    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(215);      
        double height = convert_CM_To_PPI(297);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );   

        pf.setOrientation(PageFormat.PORTRAIT);           
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public class BillPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {

            int result = NO_SUCH_PAGE;
            if (pageIndex == 0) {

                Graphics2D g2d = (Graphics2D) graphics;

                double width = pageFormat.getImageableWidth();

                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

                FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));
       
                int idLength = metrics.stringWidth("000");
                int amtLength = metrics.stringWidth("000000");
                int qtyLength = metrics.stringWidth("00000");
                int priceLength = metrics.stringWidth("000000");
                int prodLength = (int) width - idLength - amtLength - qtyLength - priceLength - 17;

                int productPosition = 0;
                int discountPosition = prodLength + 5;
                int pricePosition = discountPosition + idLength + 10;
                int qtyPosition = pricePosition + priceLength + 4;
                int amtPosition = qtyPosition + qtyLength;

                try {
                    int y = 20;
                    int yShift = 10;
                    int headerRectHeight = 15;
                    int headerRectHeighta = 40;

                    int pp1a = Integer.valueOf("125");
                    int sum = pp1a;
                    if (finalidad.equals("pedido")) {
                        
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 18));

                        y = 40;
                        g2d.drawString("    Pastelería Amada J&M" + "            ", 200, y);
                        y += yShift;
                        g2d.drawString("                  ", 12, y);
                      
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 13));
                        g2d.drawString("         San Vicente T.T." + "          ", 200, y);
                        y += yShift;
                        
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 10));
                        y += headerRectHeight;

                        java.util.Date date = new java.util.Date();
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        java.sql.Time horaActual = new java.sql.Time(date.getTime());
                        String fechaActual = dateFormat.format(date);
                        g2d.drawString("" + fechaActual + "", 10, y);
                        y += yShift;
                        g2d.drawString("" + horaActual + "", 10, y);
                        y += yShift;
                        g2d.drawString("Pedido: " + correlativo + "", 10, y);
                        y += yShift;
                        g2d.drawString("Cliente: " + cliente + "", 10, y);
                        y += yShift;
                        g2d.drawString("Fecha de entrega: " + fechaEntrega + "", 10, y);
                        y += yShift;
                        g2d.drawString("Hora de entrega: " + horaEntrega + "", 10, y);
                        y += yShift;
                        int contador = 0;
                       
                      
                        
                        g2d.drawString("-----------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += yShift;
                        g2d.drawString("Cantidad      Código                   Producto                                        Unitario    Total      ", 10, y);
                        y += yShift;
                        g2d.drawString("------------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += headerRectHeight;

                        for (int i = 0; i < datos.size(); i++) {
                            y += yShift;
                        g2d.drawString(datos.get(2), 10, y);
                        
                        g2d.drawString(datos.get(0), 100, y);
                        
                        g2d.drawString(datos.get(1), 250, y);
                        
                        g2d.drawString(datos.get(4), 600, y);
                        
                        g2d.drawString(datos.get(5), 700, y);
                        
                        y += yShift;
                        g2d.drawString("Comentario: "+datos.get(3), 10, y);
                        y += yShift;
                             i += 5;
                        }

                        y += yShift;
                        
                        g2d.drawString("---------------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += yShift;
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 18));
                        
                            g2d.drawString("  Total: $" + total + "  ", 600, y);
                            y += yShift;
                            y += yShift;
                            g2d.drawString("   Abono: $" + abono + "  ", 600, y);
                            y += yShift;
                            y += yShift;
                            g2d.drawString(" Por pagar: $" + porPagar + "  ", 600, y);
                            y += yShift;
                         y += yShift;
                        y += yShift;
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
                        g2d.drawString("*******************************************************************************************************************", 10, y);
                        y += yShift;
                        


                            g2d.drawString("                                     Gracias por su preferencia         ", 10, y);
                            y += yShift;
                        
                        g2d.drawString("*************************************************************************************************************************", 10, y);
                        y += yShift;
                        g2d.drawString("                                     ", 10, y);
                        y += yShift;
                        g2d.drawString("                                     ", 10, y);
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 5));
                        g2d.drawString("                             .....      ", 10, y);
                        y += yShift;
                        y += yShift;
                        y += yShift;
                    }else if (finalidad.equals("venta")) {
                        
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 18));

                        y = 40;
                        g2d.drawString("Pastelería Amada J&M" + "            ", 200, y);
                        y += yShift;
                        g2d.drawString("                  ", 12, y);
                      
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 13));
                        g2d.drawString("     San Vicente T.T." + "          ", 200, y);
                        y += yShift;
                        
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 10));
                        y += headerRectHeight;

                        java.util.Date date = new java.util.Date();
                        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        java.sql.Time horaActual = new java.sql.Time(date.getTime());
                        String fechaActual = dateFormat.format(date);
                        g2d.drawString("" + fechaActual + "", 10, y);
                        y += yShift;
                        g2d.drawString("" + horaActual + "", 10, y);
                        y += yShift;
                        g2d.drawString("Documento: " + correlativo + "", 10, y);
                        y += yShift;
                        g2d.drawString("Cliente: " + cliente + "", 10, y);
                        y += yShift;
                       
                      
                        
                        g2d.drawString("-----------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += yShift;
                        g2d.drawString("Cantidad      Código                   Producto                                                Unitario    Total      ", 10, y);
                        y += yShift;
                        g2d.drawString("------------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += headerRectHeight;

                        for (int i = 0; i < datos.size(); i++) {
                            y += yShift;
                        g2d.drawString(datos.get(2), 10, y);
                        
                        g2d.drawString(datos.get(0), 100, y);
                        
                        g2d.drawString(datos.get(1), 250, y);
                        
                        g2d.drawString(datos.get(3), 600, y);
                        
                        g2d.drawString(datos.get(4), 700, y);
                        
                     
                        y += yShift;
                             i += 4;
                        }

                        y += yShift;
                        
                        g2d.drawString("---------------------------------------------------------------------------------------------------------------------------------------", 10, y);
                        y += yShift;
                        y += yShift;
                        
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 18));
                        
                            g2d.drawString("  Total: $" + total + "  ", 600, y);
                            
                            y += yShift;
                         y += yShift;
                        y += yShift;
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 12));
                        g2d.drawString("*******************************************************************************************************************", 10, y);
                        y += yShift;
                        


                            g2d.drawString("                                     Gracias por su preferencia         ", 10, y);
                            y += yShift;
                        
                        g2d.drawString("*************************************************************************************************************************", 10, y);
                        y += yShift;
                        g2d.drawString("                                     ", 10, y);
                        y += yShift;
                        g2d.drawString("                                     ", 10, y);
                        y += yShift;
                        g2d.setFont(new Font("Monospaced", Font.BOLD, 5));
                        g2d.drawString("                             .....      ", 10, y);
                        y += yShift;
                        y += yShift;
                        y += yShift;
                    }
                   
                } catch (Exception r) {
                    r.printStackTrace();
                }

                result = PAGE_EXISTS;
            }
            return result;
        }

    }


    public void imprime(String imp) {
        if (imp.equals("nula")){
            
        }else{
        PrintService ps = impresora(imp);
        PrinterJob pj = PrinterJob.getPrinterJob();
        try {
            pj.setPrintService(ps);
        } catch (PrinterException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        pj.setPrintable(new BillPrintable(), getPageFormat(pj));
        try {
            pj.print();

        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
     }
    }

    public PrintService impresora(String nombre) {

        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null); //Obtenemos los servicios de impresion del sistema 
        for (PrintService impresora : printServices) { //Recorremos el array de servicios de impresion
            if (impresora.getName().contentEquals(nombre)) { // Si el nombre del servicio es el mismo que el que buscamos
                return impresora; // Nos devuelve el servicio 
            }
        }
        return null;    // Si no lo encuentra nos devuelve un null
    }
    /**
     * @param args the command line arguments
     */

}
