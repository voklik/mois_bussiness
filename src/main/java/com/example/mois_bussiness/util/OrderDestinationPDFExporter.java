package com.example.mois_bussiness.util;

import com.example.mois_bussiness.domain.OrderDestination;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@AllArgsConstructor
public class OrderDestinationPDFExporter {


    public OrderDestinationPDFExporter(OrderDestination orderDestination) {
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setPhrase(new Phrase("Číslo objednávky"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Datum objednávky"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("nabidka"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Stav obj."));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Cena objednávky"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Mena objednávky"));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        OrderDestination orderDestination = new OrderDestination();
        table.addCell(String.valueOf(orderDestination.getId()));
        table.addCell(String.valueOf(orderDestination.getDateOrder()));
        table.addCell(orderDestination.getOffer().getDestination().getName());
        table.addCell(orderDestination.getOrderState().getName());
        table.addCell(String.valueOf(orderDestination.getPrice()));
        table.addCell(orderDestination.getCurrencyType().getName());
    }

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(new Paragraph("Smlouva k objednání zájezdu"));

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
