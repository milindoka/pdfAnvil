package pdfanvil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class createpdf
{
	
	ArrayList<String> roll=new ArrayList<String>();//creating new generic arraylist  
	ArrayList<String> mark=new ArrayList<String>();//creating new generic arraylist
	//fylename=path+"/"+ReportName+"-Science.txt";
	int strength=25;
	
	
	public String getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        String path=dir.toString();
     	return  path;
    }
	
	
	void FillMarksArray()
	{   roll.removeAll(roll);
	    mark.removeAll(mark);
        int x=0;
        String str;
		Random ran = new Random();
		for(int i=0;i<strength;i++)
		  {
			x = ran.nextInt(101);
			str=String.format("%d", 5001+i);
			roll.add(str); 
			str=String.format("%d", x);
			mark.add(str);
			
		  }

	
	
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
	    	FillMarksArray();
	        
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
    document.add(table);
		  
		  
	  }
	  

	  
	  void AddBody(Document document) throws DocumentException, IOException
	  {PdfPTable table = new PdfPTable(5);
	  float colwidth[]={6,3};
  	  
	  
	  ///Create 5 subtables
	  PdfPTable [] tab = new PdfPTable[5];
	  //initialize table 0
	  tab[0] = new PdfPTable(colwidth);
      tab[0].setWidthPercentage(96);
  	
  	  
  	  PdfPCell cell = new PdfPCell(new Phrase("Roll"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	  
  	  
  	  tab[0].addCell(cell);
  	  cell = new PdfPCell(new Phrase("Mrk"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	  tab[0].addCell(cell);
  	
  	for(int i=0;i<strength;i++)
  	{ cell = new PdfPCell(new Phrase(roll.get(i)));
  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	  tab[0].addCell(cell);
	  cell = new PdfPCell(new Phrase(mark.get(i)));
	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	  tab[0].addCell(cell);
  		
  	}
  	 
  	 PdfPCell firstTableCell = new PdfPCell();
  	 firstTableCell.setPadding(0);
  	// firstTableCell.setBorderWidth(0);
  	 firstTableCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
     firstTableCell.addElement(tab[0]);
     table.addCell(firstTableCell);
   //  table.setWidthPercentage(100);  	
     cell = new PdfPCell(new Phrase(""));
  
     for(int i=0;i<4;i++)
  	{
      table.addCell(cell);	
  	}
       	
     	document.add(table);
		  
		  
	  }
	  

	  
	  
	  
	  
	  
	 
}
