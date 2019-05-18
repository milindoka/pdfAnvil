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

//Font MyFont = new Font("Liberation Serif", Font.PLAIN,10);
//pg.setFont(MyFont); 


public class createBatchPdf
{
	ArrayList<String> roll=new ArrayList<String>();//creating new generic arraylist  
	ArrayList<String> mark=new ArrayList<String>();//creating new generic arraylist
	//fylename=path+"/"+ReportName+"-Science.txt";
	
	int strength=95,requiredtables=0;
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
			str=String.format("%02d", x);
			mark.add(str);
			
		  }
	
	}
	
	
	 void CardsPdf() throws DocumentException, IOException
	    {   if(strength>200) return;
		 	requiredtables=strength/30;
	        if(strength%30!=0) requiredtables++;

	        String filename="hello.pdf";
	    	Document document = new Document(PageSize.A4);
	    	document.setMargins(50, 2, 2, 2);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	        //com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	    	
	        AddHeader(document);
	    	FillMarksArray();
	        AddBody(document);
         
	        AddFooter(document);
	        
	        
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
	  {PdfPTable table = new PdfPTable(5);
	   table.setWidthPercentage(95);
	//   table.getDefaultCell().setFixedHeight(150);
	  ///Create 5 subtables
	  float colwidth[]={6,3};
	  PdfPTable [] tab = new PdfPTable[5];
	  //initialize subtables..
	  for(int i=0;i<5;i++)
	   { tab[i] = new PdfPTable(colwidth);
         tab[i].setWidthPercentage(95);
         
	   }
  	
      //Fill and Add Subtables as required, skip extra subtables by inserting empty cell 
    for(int j=0;j<5;j++)
  	  {if(j<requiredtables) 
  		  { FillSubTable(tab[j],j); 
  		    PdfPCell cellfortable = new PdfPCell();
  		    cellfortable.setPadding(0);
  		  cellfortable.setBorder(PdfPCell.NO_BORDER);
  		    cellfortable.addElement(tab[j]);
  		    table.addCell(cellfortable);
  		  }
  	  else
  	  {  
  		PdfPCell cell= new PdfPCell(new Phrase(""));
  		cell.setBorder(PdfPCell.NO_BORDER);
  		table.addCell(cell);
  	  }
  	}
       	
     	document.add(table);
		  
		  
	  }
	  

	 void FillSubTable(PdfPTable tbl,int index)
	 {
		 PdfPCell cell = new PdfPCell(new Phrase("ROLL"));
		  cell.setPaddingBottom(4f);
		  
	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	  	  tbl.addCell(cell);
	  	  cell = new PdfPCell(new Phrase("MRK"));
	  	  cell.setPaddingBottom(4f);
	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	  	  tbl.addCell(cell);
	  	
	  	for(int i=0;i<30;i++)
	  	{ if(i+index*30>=strength) break;
	  
	  	  cell = new PdfPCell(new Phrase(roll.get(i+index*30)));
	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	      cell.setPaddingBottom(3f);
	      cell.setPaddingTop(1f);
		  tbl.addCell(cell);
		  cell = new PdfPCell(new Phrase(mark.get(i+index*30)));
		  cell.setPaddingBottom(3f);	
		  cell.setPaddingTop(1f);
		  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
		  
		  tbl.addCell(cell);
	  		
	  	}
	  	
		 
		 
		 
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


	 
	  
	  
	 
}
