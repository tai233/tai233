package com.raven.main;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.*;

public class InvoicePrinter extends JFrame {

    private JPanel contentPanel;
    private JButton printButton;

    public InvoicePrinter() {
        setTitle("Invoice Printer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(7, 2));

        JLabel titleLabel = new JLabel("Thông tin hóa đơn:");
        JLabel invoiceIdLabel = new JLabel("Mã hóa đơn:");
        JLabel customerLabel = new JLabel("Tên khách hàng:");
        JLabel productLabel = new JLabel("Thông tin chi tiết sản phẩm đã mua:");
        JLabel totalLabel = new JLabel("Tổng tiền:");
        JLabel discountLabel = new JLabel("Giảm giá:");
        JLabel totalAfterDiscountLabel = new JLabel("Tổng tiền sau giảm giá:");
        JLabel paymentLabel = new JLabel("Tiền khách trả:");
        JLabel changeLabel = new JLabel("Tiền thừa:");
        JLabel thankYouLabel = new JLabel("Lời cảm ơn đã mua hàng.");

        JTextField invoiceIdField = new JTextField();
        JTextField customerField = new JTextField();
        JTextArea productArea = new JTextArea();
        JTextField totalField = new JTextField();
        JTextField discountField = new JTextField();
        JTextField totalAfterDiscountField = new JTextField();
        JTextField paymentField = new JTextField();
        JTextField changeField = new JTextField();

        contentPanel.add(titleLabel);
        contentPanel.add(new JLabel());
        contentPanel.add(invoiceIdLabel);
        contentPanel.add(invoiceIdField);
        contentPanel.add(customerLabel);
        contentPanel.add(customerField);
        contentPanel.add(productLabel);
        contentPanel.add(productArea);
        contentPanel.add(totalLabel);
        contentPanel.add(totalField);
        contentPanel.add(discountLabel);
        contentPanel.add(discountField);
        contentPanel.add(totalAfterDiscountLabel);
        contentPanel.add(totalAfterDiscountField);
        contentPanel.add(paymentLabel);
        contentPanel.add(paymentField);
        contentPanel.add(changeLabel);
        contentPanel.add(changeField);
        contentPanel.add(thankYouLabel);
        contentPanel.add(new JLabel());

        printButton = new JButton("Print Invoice");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInvoice();
            }
        });

        add(contentPanel, BorderLayout.CENTER);
        add(printButton, BorderLayout.SOUTH);
    }

    private void printInvoice() {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
            document.open();

            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Font headingFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
            Font normalFont = FontFactory.getFont(FontFactory.HELVETICA, 12);

            Paragraph title = new Paragraph("Thông tin hóa đơn", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10);
            table.setSpacingAfter(10);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Mã hóa đơn", headingFont));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Ten khách hàng", headingFont));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Thông tin chi tiết sản phẩm đã mua", headingFont));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Tổng tiền", headingFont));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Giảm giá", headingFont));
            PdfPCell cell6 = new PdfPCell(new Paragraph("Tổng tiền sau giảm giá", headingFont));
            PdfPCell cell7 = new PdfPCell(new Paragraph("Tiền khách trả", headingFont));
            PdfPCell cell8 = new PdfPCell(new Paragraph("Tiền thừa", headingFont));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);

            table.addCell(new Paragraph(contentPanel.getComponent(1).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(3).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(5).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(7).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(9).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(11).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(13).toString(), normalFont));
            table.addCell(new Paragraph(contentPanel.getComponent(15).toString(), normalFont));

            document.add(table);

            Paragraph thankYou = new Paragraph(contentPanel.getComponent(19).toString(), normalFont);
            thankYou.setAlignment(Element.ALIGN_CENTER);
            document.add(thankYou);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                InvoicePrinter invoicePrinter = new InvoicePrinter();
                invoicePrinter.setVisible(true);
            }
        });
    }
}