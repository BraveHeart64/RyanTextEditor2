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

public class FileHandleing {
 
    private FileReader filereader;
    private  BufferedReader buffreader;
    
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
    
    
    
    
     public String saveFile(FileChooser choice, String data ){
        // retrieve path and read the data on the file
        
        return data;
    }
   
     
     
     
    
       public String readFile(File file, String data){
       String temp = "";
        try{
              this.filereader = new FileReader(file);
              this.buffreader = new BufferedReader(filereader);

               while((data = buffreader.readLine()) != null){
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
    
}
