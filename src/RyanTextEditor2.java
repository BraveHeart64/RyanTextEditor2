/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
//import java.awt.Desktop;


/**
 *
 * @author ryan
 */
public class RyanTextEditor2 extends Application {
    GuiObjects mygui = new GuiObjects();
    MenuEvents menu_events = new MenuEvents();
    private MenuItem[] items = new MenuItem[5];
    //private Desktop desk = Desktop.getDesktop();
   
    @Override
    public void start(Stage primaryStage) {
      int width = 500;
      int height = 500;
      Image icon = new Image("icon.gif");
      
   
      
          BorderPane bpane = new BorderPane();
          bpane.setTop((Node)placeMenuBar());
          bpane.setCenter((Node)placeTextArea());
          Scene scene = new Scene(bpane,width,height);
          
          
          items[0] = mygui.setMenuEventNewItemAction();
          items[1] = mygui.setEventSaveItemAction();
          items[2] = mygui.setEventOpenMenuItemAction();
          items[3] = mygui.setEventPrintMenuItemAction();
          items[4] = mygui.setEventQuitMenuItemAction();
          
       
         primaryStage.getIcons().add(icon);
         menu_events.MenuItemActions2(primaryStage, mygui,this);
  
      primaryStage.setTitle("RyanTextEditor");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
    
    

    public Object placeMenuBar(){
       //The MenuBar
         return mygui.setMenuBar();
    }
    
    
    
    public Object placeTextArea(){
        return  mygui.setTextArea();
    }

    public void returnStage( MenuItem[] item, int counter){
        
        while(counter != items.length){ // counter(n) or o(n)
             item[counter] =  items[counter];
             ++counter;
        }
      
     }
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
