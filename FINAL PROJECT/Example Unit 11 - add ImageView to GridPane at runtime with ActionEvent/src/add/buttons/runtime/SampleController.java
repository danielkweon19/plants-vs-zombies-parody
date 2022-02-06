/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package add.buttons.runtime;

import com.sun.prism.paint.Color;
import java.awt.Transparency;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author rcortez
 */
public class SampleController implements Initializable {
    ImageView[][] btn = new ImageView[10][10];
    //GridPane gPane = new GridPane();
    @FXML
    private AnchorPane aPane;

    @FXML
    private GridPane gPane;
    

    @FXML
    private void handleButtonAction(ActionEvent event) {

        //after adding the grdipane in scenebuilder, modify the fxml manually to eliminate
        // rows and columns
        

        
       
        
        //gPane.setPadding(new Insets(6));
        //gPane.setHgap(10);
        //gPane.setVgap(10);
        //gPane.setGridLinesVisible(true);
        //gPane.setAlignment(Pos.CENTER);

        for(int i=0; i<btn.length; i++){
                for(int j=0; j<btn.length;j++){
                       
                        //Initializing 2D buttons with values i,j
                        btn[i][j] = new ImageView();
                        btn[i][j].setImage(new Image("resources/Koala.jpg"));
                        btn[i][j].setFitHeight(50);
                        btn[i][j].setFitWidth(50);
                        //Paramters:  object, columns, rows
                        gPane.add(btn[i][j], j, i);
                        
                        }
        }
        
        gPane.setGridLinesVisible(true);
        
        gPane.setVisible(true);

        EventHandler z = new EventHandler<MouseEvent>() 
        {
            
            @Override
            public void handle(MouseEvent t) 
            {
                //ObservableList<Node> children = gPane.getChildren();
                //used to get a list of all children in gridpane
                System.out.println("hello"); 
                ((ImageView) t.getSource()).setImage(new Image("resources/Penguins.jpg"));
                
                System.out.println("Row:    " + GridPane.getRowIndex(((ImageView) t.getSource())));
                System.out.println("Column: " + GridPane.getColumnIndex(((ImageView) t.getSource())));
            }
            
        };
        for(int i=0; i<btn.length; i++){
                for(int j=0; j<btn.length;j++){
                    btn[i][j].setOnMouseClicked(z);
    
                        }
        }
    }
    public void doStuff()
    {
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
