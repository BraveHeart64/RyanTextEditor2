/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryan
 */



import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class GuiObjects {
    
    private TextArea   ta_text;
    private MenuBar    m_bar;
    private MenuItem   mi_new,mi_save,mi_print,mi_exit, mi_open;
    private Menu       m_menu;
    private FileChooser myFileChooser;
    
  
    
    GuiObjects(){
       ta_text = new TextArea();
       ta_text.setWrapText(true);
       ta_text.setPrefWidth(100);
       
       myFileChooser = new FileChooser();
       
       m_bar = new MenuBar();
       mi_new = new MenuItem("New");
       mi_save = new MenuItem("Save");
       mi_open = new MenuItem("open");
       mi_print = new MenuItem("Print");
       mi_exit = new MenuItem("Exit");
       m_menu = new Menu("File");
       
       m_menu.getItems().add(mi_new);
       m_menu.getItems().add(mi_save);
       m_menu.getItems().add(mi_open);
       m_menu.getItems().add(mi_print);
       m_menu.getItems().add(mi_exit);
       m_bar.getMenus().add(m_menu);
    }
    
    public Object setMenuBar(){
        return m_bar;
    }
    
    public Node setTextArea(){
        return ta_text;
    }
   
    public String retrieveTextAreaData(){
        
       return ta_text.getText();
    }
    
    
    
  public MenuItem setEventOpenMenuItemAction(){
      
      return mi_open;
  }
    
  
  
  public MenuItem setEventPrintMenuItemAction(){
      
      return mi_print;
  }
    
  public MenuItem setEventSaveItemAction(){
      
      return mi_save;
  }
    
   public MenuItem setEventQuitMenuItemAction(){
      
      return mi_exit;
  }
    
        
   public MenuItem setMenuEventNewItemAction(){
      
      return mi_new;
  }
   
   public void  newWindow(){
       ta_text.clear(); // close file as well
       
   }
    
     public void loadData(String data){
       ta_text.setText(data); // close file as well
       
   }

}
