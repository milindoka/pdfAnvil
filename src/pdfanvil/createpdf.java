package pdfanvil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class createpdf
{
	
	
	//fylename=path+"/"+ReportName+"-Science.txt";
	public String getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        String path=dir.toString();
     	return  path;
    }
	
	
	
	 void CardsPdf() throws DocumentException, IOException
	    {
	    	
	    	String filename="hello.pdf";
	    		
	    	Document document = new Document(PageSize.A4);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	    	
	    	
	         com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	        	 
	    	 
	     //    Font TNR=new Font(TNR16)
	     // Phrase phr=new Phrase("Test",TNR16);
	      
	    	PdfPTable table = new PdfPTable(3);
	    	
	    	PdfPCell cell = new PdfPCell(new Phrase("Test"));
	    	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	    	table.addCell(cell);
	    	
	    	
	    	cell = new PdfPCell(new Phrase("SIWS College"));
	    	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	    	table.addCell(cell);
	    

	    	cell = new PdfPCell(new Phrase("Test"));
	    	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	    	table.addCell(cell);
	    	

	    	 Float padding = 5f;    

	    	 cell.setPaddingBottom(padding);
	    	 
	    /*	 
	    	 for(int i=0;i<3;i++)
	    	{
	    	table.addCell(cell);
	    	}
	    */    	
	    	document.add(table);
	    
	    	document.close();
	    	
	    }
	   	

}
