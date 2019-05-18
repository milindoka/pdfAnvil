package pdfanvil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class createBatchPdf
{
	ArrayList<String> roll=new ArrayList<String>();//creating new generic arraylist  

	//fylename=path+"/"+ReportName+"-Science.txt";
	
	int strength=25,requiredtables=0;
	 //Font normalFont = FontFactory.getFont(FontFactory.getFont("Liberation Serif", Font.NORMAL,10));
	 Font normal = new Font(Font.FontFamily.TIMES_ROMAN, 10,
             Font.NORMAL);
	 public String getJarPath()
    {
    	File f = new File(System.getProperty("java.class.path"));
     	File dir = f.getAbsoluteFile().getParentFile();
        String path=dir.toString();
     	return  path;
    }
	
	
	void FillSeatArray()
	{   roll.removeAll(roll);
	   
        int x=0;
        String str="M0215301";
		
		for(int i=0;i<strength;i++)
		  {
			
			
			roll.add(str); 
			str=Increment(str);
			
			
		  }
	
	}
	
	
	 void CardsPdf() throws DocumentException, IOException
	    {   if(strength>200) return;
		 	requiredtables=strength/30;
	        if(strength%30!=0) requiredtables++;

	        String filename="hello.pdf";
	    	Document document = new Document(PageSize.A4);
	    	document.setMargins(50, 30, 2, 2);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	        //com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	    	FillSeatArray();
	        AddHeader(document);
	        AddBody(document);
	    	
	       
         
	        //AddFooter(document);
	        
	        
	        document.close();
	    }
	   	

  void AddHeader(Document document) throws DocumentException, IOException
  {PdfPTable table = new PdfPTable(1);
   PdfPCell cell = new PdfPCell(new Phrase(" "));
   cell.setBorder(PdfPCell.NO_BORDER);
   table.setWidthPercentage(95);
   table.addCell(cell);
  	
  	
   cell = new PdfPCell(new Phrase("College Index Number",normal));cell.setBorder(PdfPCell.NO_BORDER);
   cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
   table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Maharashtra State Board of Secondary & Higher Secondary Education",normal));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	
  	cell = new PdfPCell(new Phrase("Mumbai Divisional Board, Vashi,Navi Mumbai - 400703",normal));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("HSC - Practical - Feb-2018",normal));
  	cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  	table.addCell(cell);
 	
  	
  	cell = new PdfPCell(new Phrase("Attendance Sheet",normal));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);
/*
  	cell = new PdfPCell(new Phrase("Date : 23/02/18"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);
    */
  	table.setSpacingAfter(10f);
  	
  	//////////   table row
  	
  	PdfPTable table2 = new PdfPTable(3);
  	 table2.setWidthPercentage(95);
    cell = new PdfPCell(new Phrase("School/College/Center : SIWS College",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);  	
  	
    cell = new PdfPCell(new Phrase(" ",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
    
    cell = new PdfPCell(new Phrase("Batch No : 01",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
  	
	//////////   table row
  	
    cell = new PdfPCell(new Phrase("Subject : MAthematics",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);  	
  	
    cell = new PdfPCell(new Phrase(" ",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
    
    cell = new PdfPCell(new Phrase("Date : 17-05-2019",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
    cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
  	

//////////table row
  	
cell = new PdfPCell(new Phrase("Seat No's From : M0231151-M0231175",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);  	

cell = new PdfPCell(new Phrase(" ",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);

cell = new PdfPCell(new Phrase("Time : 1 PM To 2 PM",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);

//////////table row
	
cell = new PdfPCell(new Phrase("Extra Seat No's: ",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);  	

cell = new PdfPCell(new Phrase(" ",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);

cell = new PdfPCell(new Phrase(" ",normal));
cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
cell.setBorder(PdfPCell.NO_BORDER);
table2.addCell(cell);
  	
    document.add(table);
    document.add(table2);
		  
  }
	  

  void AddBody(Document document) throws DocumentException, IOException
  {
  	
   float col[]={4,8,8,30};
  	
  	//////////   TITLE ROW
  	
  	PdfPTable table2 = new PdfPTable(col);
  	 table2.setWidthPercentage(95);
   PdfPCell cell = new PdfPCell(new Phrase("Sr No",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
  //  cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);  	
  	
    cell = new PdfPCell(new Phrase("Seat No",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    //cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
    
    cell = new PdfPCell(new Phrase("Session",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    //cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
  	
	  	
    cell = new PdfPCell(new Phrase("Student's Signature",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    //cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);  	
  	
    
//////////table rows
    String srno;
    for(int i=0;i<strength;i++)
    	
    {
    	srno=String.format("%d",i+1);
    cell = new PdfPCell(new Phrase(srno,normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    //cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
    
    cell = new PdfPCell(new Phrase(roll.get(i),normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    //cell.setBorder(PdfPCell.NO_BORDER);
    table2.addCell(cell);
  	
    cell = new PdfPCell(new Phrase("Afternoon",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    table2.addCell(cell);  	

    cell = new PdfPCell(new Phrase(" ",normal));
    cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
    table2.addCell(cell);
    }
////////table row
  	
    document.add(table2);
		  
  }

  
  
  
  
  
  
	  

	
	  	
		 
		 
		 
	 

	 
	 
	 

	  void AddFooter(Document document) throws DocumentException, IOException
	  {PdfPTable table = new PdfPTable(2);
	 
	  
	   PdfPCell cell = new PdfPCell(new Phrase("Key : AABBABABAADDDCCC"));
	   cell.setBorder(PdfPCell.NO_BORDER);
	   cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	   table.addCell(cell);
	  
	   cell = new PdfPCell(new Phrase(" "));
	   cell.setBorder(PdfPCell.NO_BORDER);
	   table.addCell(cell);
	   table.addCell(cell);
	   table.addCell(cell);
	   table.addCell(cell);
	   table.addCell(cell);

	   
	   cell = new PdfPCell(new Phrase("Page Total : "));
       cell.setBorder(PdfPCell.NO_BORDER);
	   cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
	   table.setWidthPercentage(95);
	   table.addCell(cell);
	  	
	  	
	   cell = new PdfPCell(new Phrase("Examiner's Signature ; ___________"));
	   cell.setBorder(PdfPCell.NO_BORDER);
	   cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	   table.addCell(cell);
	  

	   
	  	
	  
	  	
	   cell = new PdfPCell(new Phrase(" "));
	 //  cell.setBorder(PdfPCell.NO_BORDER);
	   table.addCell(cell);
	   
	   table.setSpacingBefore(10f);
	    document.add(table);
		  
		  }


	 
	  
	  private String Increment(String alphaNumericString)
	    {  char[] an = alphaNumericString.toCharArray();
	        int i = an.length - 1;
	        while (true)
	        {   if(an[i]<'0' || an[i]>'9') return new String(an);
	            if (i <= 0)
	                try { throw new Exception("Maxed out number!!!"); }
	                catch (Exception e)
	                { e.printStackTrace(); }
	            an[i]++;

	            if (an[i] - 1 == '9')
	            {
	                an[i] = '0';
	                i--;
	                continue;
	            }


	            return new String(an);
	        }
	    }

	  
	  
	 
}
