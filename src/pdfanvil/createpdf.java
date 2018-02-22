package pdfanvil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Chunk;
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
	    	   document.setMargins(2, 2, 2, 2);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	     //    com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	        AddHeader(document);
	    	
            AddBody(document);
            document.close();
	    }
	   	

	  void AddHeader(Document document) throws DocumentException, IOException
	  {PdfPTable table = new PdfPTable(3);
	   
  	PdfPCell cell = new PdfPCell(new Phrase(" "));
  	cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("SIWS College"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);
  

  	cell = new PdfPCell(new Phrase(" "));cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	
  	cell = new PdfPCell(new Phrase("Class-Div :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Subject :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Examiner :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Examination :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Total :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Date :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);
    
  	table.setSpacingAfter(10f);
//  	 Float padding = 5f;    

  //	 cell.setPaddingBottom(padding);
  	 
  /*	 
  	 for(int i=0;i<3;i++)
  	{
  	table.addCell(cell);
  	}
  */    	
     	document.add(table);
		  
		  
	  }
	  

	  
	  void AddBody(Document document) throws DocumentException, IOException
	  {PdfPTable table = new PdfPTable(5);
  	
  	PdfPCell cell = new PdfPCell(new Phrase("Test"));
  	
  	 PdfPTable table1 = new PdfPTable(2);
  	for(int i=0;i<20;i++)
  	{
  	table1.addCell(cell);
  	}
  	 
  	 PdfPCell firstTableCell = new PdfPCell();
  	 firstTableCell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
     firstTableCell.addElement(table1);
     table.addCell(firstTableCell);
  	
     cell = new PdfPCell(new Phrase(""));
  	for(int i=0;i<4;i++)
  	{
      table.addCell(cell);	
  	}
  	
  	/*
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("SIWS College"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);
  

  	cell = new PdfPCell(new Phrase(" "));
  	table.addCell(cell);

  	
  	cell = new PdfPCell(new Phrase("Class-Div :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Subject :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);
  

  	cell = new PdfPCell(new Phrase("Examiner :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);



  	cell = new PdfPCell(new Phrase("Examination :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Total :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);
  

  	cell = new PdfPCell(new Phrase("Date :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);
    

//  	 Float padding = 5f;    

  //	 cell.setPaddingBottom(padding);
  	 
 */ 
  	 
     	
     	document.add(table);
		  
		  
	  }
	  

	  
	  
	  
	  
	  
	 
}
