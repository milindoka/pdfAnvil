package pdfanvil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
    private ActionListener AttendanceButtonListener;
    
    private createpdf cp=new createpdf();
    private createBatchPdf cbp=new createBatchPdf();
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
       // String path;
     
	    // System.out.println(model.getJarPath()); ///set JAR path in model variable path;

                          
    }
    
    public void contol()
    {        
        actionListener = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  linkBtnAndLabel();
              }
        };                
        view.getButton().addActionListener(actionListener); 
        
        AttendanceButtonListener = new ActionListener()
        {
              public void actionPerformed(ActionEvent actionEvent) {                  
                  PrintAttendanceReport();
              }
        };                
        view.getAttendanceButton().addActionListener(AttendanceButtonListener); 
        
        
        
    }
    
    private void linkBtnAndLabel()
    {
    	try {
			cp.CardsPdf();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }    
    
    private void PrintAttendanceReport()
    {
    	try {
			cbp.CardsPdf();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }    
    
    
    
    
    
}