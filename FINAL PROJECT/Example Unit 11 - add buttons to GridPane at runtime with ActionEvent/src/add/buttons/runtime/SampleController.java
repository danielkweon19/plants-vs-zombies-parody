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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;

/**
 *
 * @author rcortez
 */
public class SampleController implements Initializable {
    Button[][] btn = new Button[2][6];
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
                for(int j=0; j<btn[0].length;j++){
                       
                        //Initializing 2D buttons with values i,j
                        btn[i][j] = new Button(""+i+","+""+j);
                        btn[i][j].setPrefSize(50, 50);
                        //Paramters:  object, columns, rows
                        gPane.add(btn[i][j], i, j);
                        
                        }
        }
        
        gPane.setGridLinesVisible(true);
        
        gPane.setVisible(true);
        EventHandler z = new EventHandler<ActionEvent>() 
        {
            
            @Override
            public void handle(ActionEvent t) 
            {
                //ObservableList<Node> children = gPane.getChildren();
                //used to get a list of all children in gridpane
                System.out.println("hello");
                System.out.println(((Button) t.getSource()).getText()); 
                ((Button) t.getSource()).setText("hello");
                
                System.out.println("Row:    " + GridPane.getRowIndex(((Button) t.getSource())));
                System.out.println("Column: " + GridPane.getColumnIndex(((Button) t.getSource())));
                int x = GridPane.getRowIndex(((Button) t.getSource()));
                int y = GridPane.getColumnIndex(((Button) t.getSource()));
               
            }
            
        };
        for(int i=0; i<btn.length; i++){
                for(int j=0; j<btn[0].length;j++){
                    btn[i][j].setOnAction(z);
    
                        }
        }
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
