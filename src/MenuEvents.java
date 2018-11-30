import javafx.event.ActionEvent;
import javafx.print.PageLayout;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.print.PrinterJob;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/*
 *
 * 
 * 
 */

/**
 *
 * @author RL
 */
public class MenuEvents extends GuiObjects {
    
     private  String datafromfile = "";
     private FileHandleing filehandle = new FileHandleing();
     private TextArea   tobeprinted = new TextArea();
    
 
  
     
     
       public void MenuItemActions2(Stage pt_stage,GuiObjects gui,RyanTextEditor2 texteditor){
               int itemcounter = 0;
               MenuItem[] items = new MenuItem[5];
               texteditor.returnStage(items, itemcounter);
        
        
             items[0].setOnAction((final ActionEvent event) -> {
                   gui.newWindow();        
                 });
         
             
             
             
             items[1].setOnAction((final ActionEvent event) -> {
                      // retrieve text from textarea
                 filehandle.SetSaveingStateTrue();
                  filehandle.fileManagmentMenu(datafromfile, gui, pt_stage);  
                 });
             
             
                items[2].setOnAction((final ActionEvent event) -> {
                    filehandle.SetSaveingStateFalse();
                    filehandle.fileManagmentMenu( datafromfile, gui, pt_stage);
                  });
                
                 
                
                 
                  items[3].setOnAction((final ActionEvent event) -> {
                       
                       tobeprinted =   gui.TextAreaToBePrinted(tobeprinted);
                       PrintTextOut();
                     
                 });
                 
                  
                    items[4].setOnAction((final ActionEvent event) -> {
                  //close the file
                    System.exit(0);
                    
                   });
                
              
                
    }
     
 
       private void PrintTextOut(){
           TextFlow text = new TextFlow(new Text(tobeprinted.getText()));
           PrinterJob printer = PrinterJob.createPrinterJob();
           
          
           
           if(printer != null && printer.showPrintDialog(tobeprinted.getScene().getWindow())){
               PageLayout layout = printer.getJobSettings().getPageLayout();
               text.setMaxWidth(layout.getPrintableWidth());
               text.setMaxHeight(layout.getPrintableHeight());
               
               //boolean print = printer.printPage(node);
               if(printer.printPage(text)){
                   printer.endJob();
               } else{
                   System.out.println("An error has occured");
               }
           }
           
           
       }
}
