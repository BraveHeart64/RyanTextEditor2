/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RL
 */

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileHandleing {
 // need to keep file open until you press new,open or saveas is implemented
    private FileReader filereader;
    private  BufferedReader buffreader;
    private static boolean filesave;
    private File myfile;
    
      public void SetSaveingStateTrue(){
     filesave = true;
       
    }
     
      public void SetSaveingStateFalse(){
        
        filesave  = false;
    }
    
    
    
    public void saveAsFile(File file, String data ){
        // retrieve path and read the data on the file
      
        try{
       file.createNewFile();
       FileWriter filewrite = new FileWriter(file);
       filewrite.write(data);
       filewrite.flush();
       filewrite.close();
        }
        catch(IOException ex){
            System.out.println("The file was not Saved");
        }
          
       
    }
    
    
     public String readFile(File file, String data){
       String temp = "";
        try{
              this.filereader = new FileReader(file);
              this.buffreader = new BufferedReader(filereader);

               while((data = buffreader.readLine()) != null){// o(n)
                temp = temp + data+"\n";
               } 
             
           buffreader.close(); 
           filereader.close();
          
        }
        catch(IOException error){
              Logger.getLogger(
              MenuEvents.class.getName()).log(
              Level.SEVERE,null,error);
          }
            data = temp;
            return data;
       }
    
    
    
    
    public void fileManagmentMenu(String data,GuiObjects gui,Stage pt_stage){
        
         FileChooser fileview = new FileChooser();
                  
         if(filesave == true){
                    fileview.setTitle("Save A File");
                   
                   }
         else if(filesave == false){
                       fileview.setTitle("Open A File");
                   }
                   
                    fileview.getExtensionFilters().
                    addAll(new FileChooser.ExtensionFilter("txt","*.txt"),
                    new FileChooser.ExtensionFilter("windows","*.Doc"),
                    new FileChooser.ExtensionFilter("Rich Texts","*.Docx"),
                    new FileChooser.ExtensionFilter("Unix","*.odt"),
                    new FileChooser.ExtensionFilter("all","*"));

                    if(filesave == true){
                         myfile =  fileview.showSaveDialog(pt_stage);
                        if(myfile != null){
                          data = gui.retrieveTextAreaData();
                          saveAsFile(myfile, data);
                        }
                    }
                    
                      if(filesave == false){
                          myfile =  fileview.showOpenDialog(pt_stage);
                           if(myfile != null){
                            data =  readFile(myfile, data);
                            gui.loadData(data);
                           }
                    
                    }
                    
                 
        
        
    }
    
     public String saveFile(FileChooser choice, String data ){
        // retrieve path and read the data on the file
        
        return data;
    }
   
      
    
}
