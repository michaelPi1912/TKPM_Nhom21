package Entity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.EmployeeModel;

public class BillPDF {
	private EmployeeModel employeeModel = new EmployeeModel();

	public BillPDF(String idBill, String idCustomer, String nameCustomer, String idCar, String brand, String description, String[][] listInfoBills) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document();
		String pdfnameString = idBill+".pdf";
		PdfWriter.getInstance(document, new FileOutputStream(pdfnameString));
		document.open();
		
		
		Font fontCor = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		Font fontHel = FontFactory.getFont(FontFactory.HELVETICA, 24, BaseColor.BLACK);
		Font fontHel18 = FontFactory.getFont(FontFactory.HELVETICA, 18, BaseColor.BLACK);
		Font fontCor10  = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLACK);
		
		float[] colWidths = {8, 3};
        PdfPTable tableInfoGara = new PdfPTable(colWidths);
        
        PdfPCell infoCellCompany = new  PdfPCell();
        infoCellCompany.addElement(new Chunk("Address : No 1, Vo Van Ngan, Linh Trung, Thu Duc, Ho Chi Minh", fontCor));
        infoCellCompany.addElement(new Chunk("Phone : 0868704516", fontCor));
        infoCellCompany.addElement(new Chunk("Email : ongchuphat@gmail.com",fontCor));
        infoCellCompany.setBorder(0);
        tableInfoGara.addCell(infoCellCompany);
     
        Image code128Image =  Image.getInstance("logo.png");
        PdfPCell cell = new  PdfPCell();
        cell.addElement(code128Image);
        cell.setBorder(0);
        tableInfoGara.addCell(cell);
        
        float[] colWidths1 = {5, 5};
        PdfPTable tableInfoBill = new PdfPTable(colWidths1);
        
        PdfPCell infoCellCustomer = new PdfPCell();
        infoCellCustomer.addElement(new Chunk("Ma HD: "+idBill, fontCor));
        infoCellCustomer.addElement(new Chunk("Ma KH: "+idCustomer, fontCor));
        infoCellCustomer.addElement(new Chunk("Ten KH: "+nameCustomer, fontCor));
        infoCellCustomer.setBorder(0);
        tableInfoBill.addCell(infoCellCustomer);
        
        PdfPCell infoCellCar = new PdfPCell();
        infoCellCar.addElement(new Chunk("Ma Xe: "+idCar, fontCor));
        infoCellCar.addElement(new Chunk("Hang: "+brand, fontCor));
        infoCellCar.addElement(new Chunk("Mo ta: "+description, fontCor));
        infoCellCar.setBorder(0);
        tableInfoBill.addCell(infoCellCar);
        
        
        float[] colWidths2 = {1, 5, 2, 2, 3};
        PdfPTable tableInfoJob = new PdfPTable(colWidths2);
        
        PdfPCell cellSTT = new PdfPCell();
        cellSTT.addElement(new Chunk("STT", fontCor10));
        
        PdfPCell cellNameJob = new PdfPCell();
        cellNameJob.addElement(new Chunk("Ten Cong Viec",fontCor10));
        
        PdfPCell cellKhoiLuong = new PdfPCell();
        cellKhoiLuong.addElement(new Chunk("Khoi Luong", fontCor10));
        
        PdfPCell cellDis = new PdfPCell();
        cellDis.addElement(new Chunk("Giam gia", fontCor10));
        
        PdfPCell cellTotal = new PdfPCell();
        cellTotal.addElement(new Chunk("Tong", fontCor10));
        
        tableInfoJob.addCell(cellSTT);
        tableInfoJob.addCell(cellNameJob);
        tableInfoJob.addCell(cellKhoiLuong);
        tableInfoJob.addCell(cellDis);
        tableInfoJob.addCell(cellTotal);
        
        for(int i = 0;i < listInfoBills.length ;i++) {
        	PdfPCell cellSTTrow = new PdfPCell();
            cellSTTrow.addElement(new Chunk(listInfoBills[i][0], fontCor10));
            
            PdfPCell cellNameJobrow = new PdfPCell();
            cellNameJobrow.addElement(new Chunk(listInfoBills[i][2], fontCor10));
            
            PdfPCell cellKhoiLuongrow = new PdfPCell();
            cellKhoiLuongrow.addElement(new Chunk(listInfoBills[i][3], fontCor10));
            
            PdfPCell cellDisrow = new PdfPCell();
            cellDisrow.addElement(new Chunk(listInfoBills[i][4], fontCor10));
            
            PdfPCell cellTotalrow = new PdfPCell();
            cellTotalrow.addElement(new Chunk(listInfoBills[i][5], fontCor10));
            
            tableInfoJob.addCell(cellSTTrow);
            tableInfoJob.addCell(cellNameJobrow);
            tableInfoJob.addCell(cellKhoiLuongrow);
            tableInfoJob.addCell(cellDisrow);
            tableInfoJob.addCell(cellTotalrow);
        }
        
        Calendar cal = new GregorianCalendar();
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        
        
        document.add(new Chunk("NgocPhat Company", fontHel));
        document.add(tableInfoGara);
        document.add(new Paragraph("", fontHel));
        document.add(new Chunk("Thong Tin Hoa Don", fontHel18));
        document.add(tableInfoBill);
        document.add(new Paragraph("", fontHel));
        document.add(tableInfoJob);
        document.add(new Paragraph("", fontHel));
        document.add(new Paragraph("", fontHel));
        document.add(new Paragraph(hour + ":" + minute + " , " +dayOfMonth + "/" + (month + 1) + "/ " + year, fontCor10));
        document.add(new Paragraph("Nhan Vien thanh toan : "+ employeeModel.getNameEmployeebyID(), fontCor10));
        
		document.close();
	}
}
