import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.print.PrinterJob;
import javafx.scene.control.TextArea;

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
                       TextArea   tobeprinted = new TextArea();
                       tobeprinted =   gui.TextAreaToBePrinted(tobeprinted);
                       PrintTextOut(tobeprinted);
                     
                 });
                 
                  
                    items[4].setOnAction((final ActionEvent event) -> {
                    // needs to close the file and then close the program  
                    System.exit(0);
                    
                   });
                
              
                
    }
     
  
       private void PrintTextOut(Node node){
           PrinterJob printer = PrinterJob.createPrinterJob();
           
          
           
           if(printer != null){
               boolean print = printer.printPage(node);
               if(print){
                   printer.endJob();
               } else{
                   System.out.println("An error has occured");
               }
           }
           
           
       }
}
