package pdfanvil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
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
	
	int strength=147,requiredtables=0;
	
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
		 	requiredtables=strength/40;
	        if(strength%40!=0) requiredtables++;

	        String filename="hello.pdf";
	    	Document document = new Document(PageSize.A4);
	    	document.setMargins(50, 2, 2, 2);
	    	PdfWriter.getInstance(document, new FileOutputStream(filename));
	    	document.open();
	    	
	     //    com.itextpdf.text.Font NORMAL = new com.itextpdf.text.Font(FontFamily.TIMES_ROMAN, 12);
	        AddHeader(document);
	    	FillMarksArray();
	        AddBody(document);
         
	        AddFooter(document);
	        
	        
	        document.close();
	    }
	   	

  void AddHeader(Document document) throws DocumentException, IOException
  {PdfPTable table = new PdfPTable(3);
   PdfPCell cell = new PdfPCell(new Phrase(" "));
   cell.setBorder(PdfPCell.NO_BORDER);
   table.setWidthPercentage(95);
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

  	cell = new PdfPCell(new Phrase("Examiner : PADMAVAT"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Examination :"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);
  	table.addCell(cell);
  	
  	
  	cell = new PdfPCell(new Phrase("Total :"));
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);cell.setBorder(PdfPCell.NO_BORDER);
  	table.addCell(cell);

  	cell = new PdfPCell(new Phrase("Date : 23/02/18"));cell.setBorder(PdfPCell.NO_BORDER);
  	cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
  	table.addCell(cell);
    
  	table.setSpacingAfter(10f);
    document.add(table);
		  
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
	  	
	  	for(int i=0;i<40;i++)
	  	{ if(i+index*40>=strength) break;
	  
	  	  cell = new PdfPCell(new Phrase(roll.get(i+index*40)));
	  	  cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
	      cell.setPaddingBottom(3f);
	      cell.setPaddingTop(1f);
		  tbl.addCell(cell);
		  cell = new PdfPCell(new Phrase(mark.get(i+index*40)));
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
