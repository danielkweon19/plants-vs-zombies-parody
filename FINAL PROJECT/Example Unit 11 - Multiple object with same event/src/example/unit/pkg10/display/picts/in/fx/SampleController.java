/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example.unit.pkg10.display.picts.in.fx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author rcortez
 */
public class SampleController implements Initializable {
    
    private ArrayList<String> blah = new ArrayList<>();
    @FXML
    private ImageView image1,image2;
    @FXML
    private Button firstButton,secondButton;
    @FXML
    private GridPane testPane;
    
    @FXML
    private void testMe(ActionEvent event) {
        blah.add("resources/Koala.jpg");
//        Image x = new Image(blah.get(0));
//        image1.setImage(x);
        ((Button) event.getSource()).setText("hello");  
        image2.setImage(new Image(blah.get(0)));
        image1.setImage(new Image(blah.get(0)));
//        System.out.println(event);
    }
    
    @FXML
    private void testEvent(MouseEvent event)
    {
        ((ImageView) event.getSource()).setImage(new Image("resources/Koala.jpg"));
        System.out.println("testme");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
