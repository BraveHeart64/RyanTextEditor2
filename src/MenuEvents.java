
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RL
 */
public class MenuEvents extends GuiObjects {
    
     private  String datafromfile = "";
    
    
    
 
    
       public void MenuItemActions2(Stage pt_stage,GuiObjects gui,RyanTextEditor2 texteditor){
               int itemcounter = 0;
               MenuItem[] items = new MenuItem[5];
               texteditor.returnStage(items, itemcounter);
        
        
             items[0].setOnAction((final ActionEvent event) -> {
                   gui.newWindow();        
                 });
         
             
             
             
             items[1].setOnAction((final ActionEvent event) -> {
                      // retrieve text from textarea
                 
                 FileChooser fileview = new FileChooser();
                    fileview.setTitle("Open A File");
                    fileview.getExtensionFilters().
                    addAll(new FileChooser.ExtensionFilter(".txt","*.txt"),
                    new FileChooser.ExtensionFilter("windows","*.Doc"),
                    new FileChooser.ExtensionFilter("Rich Texts","*.Docx"),
                    new FileChooser.ExtensionFilter("Unix","*.odt"),
                    new FileChooser.ExtensionFilter("all","*"));
                    
                  File myfile =  fileview.showSaveDialog(pt_stage);
                  if(myfile != null){
                      FileHandleing filehandle = new FileHandleing();
                       datafromfile = gui.retrieveTextAreaData();
                       filehandle.saveAsFile(myfile, datafromfile);
                    
                     
                  }
         
                  //

                     
                 });
             
             
                items[2].setOnAction((final ActionEvent event) -> {
                    FileChooser fileview = new FileChooser();
                    fileview.setTitle("Open A File");
                    fileview.getExtensionFilters().
                    addAll(new FileChooser.ExtensionFilter(".txt","*.txt"),
                    new FileChooser.ExtensionFilter("windows","*.Doc"),
                    new FileChooser.ExtensionFilter("Rich Texts","*.Docx"),
                    new FileChooser.ExtensionFilter("Unix","*.odt"),
                    new FileChooser.ExtensionFilter("all","*"));
                    
                  File myfile =  fileview.showOpenDialog(pt_stage);
                  if(myfile != null){
                      FileHandleing filehandle = new FileHandleing();
                      datafromfile =  filehandle.readFile(myfile, datafromfile);
                      gui.loadData(datafromfile);
                     
                  }
                 
                  });
                
                 
                
                 
                  items[3].setOnAction((final ActionEvent event) -> {
                     
                     
                 });
                 
                  
                    items[4].setOnAction((final ActionEvent event) -> {
                    // needs to close the file and then close the program  
                    System.exit(0);
                    
                   });
                
              
                
    }
     
  
       
}