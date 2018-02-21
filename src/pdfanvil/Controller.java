package pdfanvil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class Controller {

    private Model model;
    private View view;
    private ActionListener actionListener;
    
    private createpdf cp=new createpdf();
    
    
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
    }
    
    private void linkBtnAndLabel()
    {
    //    model.incX();                
    //    view.setText(Integer.toString(model.getX()));
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
}