/*
 *
 * 
 * 
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class GuiObjects {
    
    private TextArea   ta_text;
    private MenuBar    m_bar;
    private MenuItem   mi_new,mi_save,mi_print,mi_exit, mi_open;
    private Menu       m_menu;
    private FileChooser myFileChooser;
    Image newIcon;
  ImageView imgview;
    
    GuiObjects(){
       ta_text = new TextArea();
       ta_text.setWrapText(true);
       ta_text.setPrefWidth(100);
     
      imgview = LoadImageIcon( imgview, newIcon,"file.bmp");
       myFileChooser = new FileChooser();
       
       m_bar = new MenuBar();
       mi_new = new MenuItem("New");
       mi_new.setGraphic(imgview);
       imgview = LoadImageIcon( imgview, newIcon,"save.gif");
       
       mi_save = new MenuItem("Save");
        mi_save.setGraphic(imgview);
        
        
       imgview = LoadImageIcon( imgview, newIcon,"open.gif");
       mi_open = new MenuItem("open");
        mi_open.setGraphic(imgview);
       
       mi_print = new MenuItem("Print");
       imgview = LoadImageIcon( imgview, newIcon,"printer.gif");
       mi_print.setGraphic(imgview);
       
       
       mi_exit = new MenuItem("Exit");
       imgview = LoadImageIcon( imgview, newIcon,"quit.gif");
       mi_exit.setGraphic(imgview);
       
       m_menu = new Menu("File");
       
       m_menu.getItems().add(mi_new);
       m_menu.getItems().add(mi_save);
       m_menu.getItems().add(mi_open);
       m_menu.getItems().add(mi_print);
       m_menu.getItems().add(mi_exit);
       m_bar.getMenus().add(m_menu);
    }
    
    
    
    public ImageView LoadImageIcon(ImageView imgview,Image item, String nameoffile){
         item = new Image(getClass().getResourceAsStream(nameoffile));
        imgview = new ImageView(item);
        return imgview;
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
    
    public TextArea TextAreaToBePrinted(TextArea t){
       t = ta_text;
     
       return t;
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
