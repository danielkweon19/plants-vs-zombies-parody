/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 *
 * @author kweon1412
 */

//Things to talk about:
//1.) Archers moving vs zombies moving
//2.) 3D array
//3.) Passing objects as parameters
//4.) Trying to use numerous arrays at once (imageview array, 3d array, object array)
//5.) Color adjusting
//6.) Copying objects/passing objects as parameters
//7.) Textfiles = in RPS, it was easy because all you need to do is save strings. For this one, you need to catenate the strings in ints and string and put it pack into an object
 

public class FXMLDocumentController implements Initializable {
    ImageView[][] btn = new ImageView[6][11]; //Imageviews for the main board
    ImageView[][] characterBtn = new ImageView[4][1]; //ImageViews for the character selection gridpane (in Game)
    ImageView[][] selectionBtn = new ImageView[2][4]; //ImageViews for the character selection (before game starts)
    ImageView[][] healthBtn = new ImageView[1][4]; //Imageviews to display the amount of health a character has left
    
    private int multi[][][] = new int[6][11][2]; //Used to keep track of the avability of room on the board
    private Characters objects[][] = new Characters[6][11]; //This array is used to keep track of the characters on the board as objects
    private Characters tempObjects[][] = new Characters[4][1]; //Used to contain the objects of heroes that will be used throughout the game
    private Characters tempVillians[][] = new Characters[4][1]; //Used to contain the objects of the villians that will be used throughout the game
    private int[][] colors = new int[2][4]; //Used to keep track of which positions on the gridpane are selected when the user is selecting characters to use
    private int flagPosition[][] = new int[6][1]; //Used to track the positions of flags that have been burned down by the enemy
    
    ColorAdjust colorAdjustGrayscale = new ColorAdjust(); //Used to set colors of charcters to grey when they are not selected
    ColorAdjust colorAdjustGrayscale2 = new ColorAdjust(); //Used to set colors of characters to a bright color when they are selected
    ColorAdjust colorAdjustGrayscale3 = new ColorAdjust(); //Used to set colors of charcters to grey when they are not selected
    ColorAdjust colorAdjustGrayscale4 = new ColorAdjust(); //Used to set colors of characters to a bright color when they are selected
    
    //Images used in this project
    private Image grass = new Image("resources/grass.png");
    private Image flag = new Image("resources/flag.gif");
    private Image tree = new Image("resources/tree.gif");
    private Image tomb = new Image("resources/tomb.jpg");
    private Image knight = new Image("resources/knight.gif");
    private Image archer = new Image("resources/archer.gif");
    private Image castle = new Image("resources/castle.png");
    private Image dragon = new Image("resources/dragon.gif");
    private Image land = new Image("resources/land.png");
    private Image manna = new Image("resources/manna.gif");
    private Image arrow = new Image("resources/arrow.png");
    private Image sword = new Image("resources/sword.png");
    private Image bow = new Image("resources/bow.png");
    private Image heart = new Image("resources/heart.png");
    private Image fire = new Image("resources/fire.png");
    private Image zombie = new Image("resources/zombie.gif");
    private Image flames = new Image("resources/flames.gif");
    private Image evilDragon = new Image("resources/evilDragon.gif");
    private Image ghost = new Image("resources/ghost.gif");
    private Image darkKnight = new Image("resources/darkknight.gif");
    private Image zombieHead = new Image("resources/zombieHead.jpg");
    private Image ghostHead = new Image("resources/ghostHead.png");
    private Image darkFire = new Image("resources/darkFire.jpg");
    private Image darkSword = new Image("resources/darkSword.png");
    private Image egg = new Image("resources/egg.png");
    private Image babyDragon = new Image("resources/babyDragon.gif"); 
    private Image startBackground = new Image("resources/startBackground.jpg");
    private Image water = new Image("resources/water.png");
    private Image sea = new Image("resources/sea.png");
    private Image seaWeed = new Image("resources/seaweed.gif");
    private Image pirate = new Image("resources/pirate.gif");
    private Image island = new Image("resources/island.png");
    private Image gyarados = new Image("resources/gyarados.gif");
    private Image battleShip = new Image("resources/battleShip.gif");
    private Image cannonBall = new Image("resources/cannonBall.png");
    private Image horse = new Image("resources/horse.gif");
    private Image slingShot = new Image("resources/slingShot.gif");
    private Image healer = new Image("resources/healer.gif");
    private Image garchomp = new Image("resources/garchomp.gif");
    private Image shark = new Image("resources/shark.gif");
    private Image kraken = new Image("resources/kraken.gif");
    private Image mermaid = new Image("resources/mermaid.gif");
    private Image scuba = new Image("resources/scuba.gif");
    private Image trooper = new Image("resources/trooper.gif");
    private Image lightHouse = new Image("resources/lighthouse.png");
    private Image aqua = new Image("resources/aqua.gif");
    private Image waterDragon = new Image("resources/waterDragon.gif");
    private Image horseHead = new Image("resources/horseHead.png");
    private Image sling = new Image("resources/sling.png");
    private Image pirateHead = new Image("resources/pirateHead.jpg");
    private Image shipBattle = new Image("resources/shipBattle.jpg");    
    private Image scubaMask =  new Image("resources/scubaMask.jpg");
    private Image gun =  new Image("resources/gun.jpg");
    private Image light =  new Image("resources/light.jpg");
    private Image droplet =  new Image("resources/droplet.png");
    private Image laser =  new Image("resources/laser.png");
    private Image mermaidHead = new Image("resources/mermaidHead.jpg");
    private Image squid = new Image("resources/squid.jpg");
    private Image waterDragonHead = new Image("resources/waterDragonHead.png");
    private Image sharkFin = new Image("resources/sharkFin.jpg");
    
    //Now, the following Images lines 141-152 are used as temporary images that will contain other images when necessary
    private Image c1 = new Image("resources/sharkFin.jpg");
    private Image c2 = new Image("resources/sharkFin.jpg");
    private Image c3 = new Image("resources/sharkFin.jpg");
    private Image c4 = new Image("resources/sharkFin.jpg");
    private Image v1 = new Image("resources/sharkFin.jpg");
    private Image v2 = new Image("resources/sharkFin.jpg");
    private Image v3 = new Image("resources/sharkFin.jpg");
    private Image v4 = new Image("resources/sharkFin.jpg");
    private Image t1 = new Image("resources/sharkFin.jpg");
    private Image a1 = new Image("resources/sharkFin.jpg");
    private Image g1 = new Image("resources/sharkFin.jpg");
    
    private int chosen = 4;//This int keeps track of which character is chosen in the character selection list
    private int rowPos = 0; //Keeping track of row position on gridPane
    private int colPos = 0; //Keeping track of col Position of gridPane
    private int waveNum = 1; //Used to keep track of which wave the game is currently on
    private int userHealth = 4; //This is the amount of health that the user have (Same as the number of flags
    private int numberOfVillians1 = 0; //Used to keep track of the number of villians that are spawned
    private int zombieLimit = 10; //The amount of villians allowed per wave. Increases by 10 each time a wave increases
    private int unitsKilled = 0; //Used to track the number of your own units that are killed
    private int villiansKilled = 0; //Used to track the number of villians that are killed
    private String winOrLose = ""; //Used to save if the user won or lost the game
    private String playerName = ""; //Used to contain the name of the user
    private int fourSelected = 0; //Used to keep track of the number of characters the user selects for the game. Max: 4
    private int rowSelected = 0; //Row position that user chooses for character selection
    private int colSelected = 0; //Col position that user chooses for character selection
    private int powerChosen = 0;
    private int incPower = 0;
    
    private boolean playTime = false; //used to stop animation timer
    private boolean startGame = false;//Used to keep track of if the game started or not
    
    //These two next variables can be local if you wanted
    private int rowCharacter = 0; //Keeping track of row Position on character gridPane 
    private int colCharacter = 0; //Keeping track of col Position on character gridPane
    
    private int chosenMap = 0; //Used to keep track of which map the user selected (1- land, 2 - water)
    
    //These are used to keep track of the times certain methods will run
    private long startTime;  //Used to keep track of when the game starts
    private long cardTime; //used to keep track of when manna regenerates for the user to use
    private long zombieTime; //This is used to keep track of the zombies that will spawn as the game progresses
    private long moveTime; //This is used to move the zombies on the board every couple of seconds
    private long arrowTime; //This is used to spawn an arrow that the 
    private long arrowTime2; //This is used to keep track of the arrows that be shot
    private long increaseTime; 
    private long powerIncrease;
    
    private Manna tracker = new Manna(200); //Used to initialize the amount of manna that the user will start off with (200)

    private ArrayList<Person> list = new ArrayList<Person>(); //Used to contain the stats of the user after the game ends
    private ArrayList<PowerUps> powerList = new ArrayList<PowerUps>();
    private ObservableList displayList = FXCollections.observableArrayList(); //Used to allow the user to view their stats in a listview
    private ArrayList<String> topScores = new ArrayList<>(); //Used to contain the user's information in a string that can later be parsed and moved into an object
    private ArrayList<String> classSaver = new ArrayList<>(); //Used to save the user's stats after a game ends
    
    @FXML //Labels that will used
    private Label powerLabel,gameResult, nameLabel, wavesLabel,villiansKilledLabel, unitsKilledLabel, charLabel,charLabel2,attackLabel,mannaLabel, typeLabel, attackShowLabel,label2,gameStatsLabel,typeLabel1,attackShowLabel1,label21;
    
    @FXML //Anchor Pane
    private AnchorPane aPane;
    
    @FXML //Panes for the project (Not gridpane)
    private Pane itemPane, powerUpPane, healthLeftPane,statsPane,villiansPane;
        
    @FXML //GridPanes for the project (Character selction pane and main board)
    private GridPane gPane, characterPane, healthGridPane, leftGridPane, mapSelection, characterGridPane;
    
    @FXML //Imageview used for the game
    //Keep in mind that the grid panes use imageviews as well
    private ImageView backgroundImage, mannaImage, logoImage, logoImage1,logoImage2, map1,map2;
    
    @FXML //Progress bar for the waves 
    private ProgressBar waveChecker, powerBar;
    
    @FXML //Textfields
    private TextField nameTextField;
     
    @FXML //Buttons
    private Button button, startButton, questionButton;
    
    @FXML //Listviews
    private ListView listView;
    
    @FXML //MenuButtons
    private MenuButton powerUpMenuBar;
    
    @FXML
    private TextArea textArea;
    
    @FXML //This method is used to see if the initial textfield is empty or not. 
    private void starter(){ //Once the user enters their name and presses this button, the game begins
        if(!nameTextField.getText().equals("")){
            setZeroes(); //This method initializes and resets values to zero
            startButton.setVisible(false); //Start button will not appear until the user finishes all the pre-game requirements
            nameTextField.setVisible(false);       
            playerName = nameTextField.getText();//Get the user's name
            nameLabel.setText("Player: " + playerName); //Display user's name
            nameLabel.setTranslateX(800);
            textArea.setText("Hey, " + playerName + ". Now, choose the map\nyou would like to play in. Your\noptions are the land map, or the\nsea map. \n\nThe map you choose will change\nwhich characters and villians\nyou will encounter.");
            selectionOfMap();//Next, move unto selecting the map for the user
        }
    }
    public void setZeroes(){ //This method is used to reset the values of the game that will change which characters are used and such
        fourSelected = 0;
        for(int i = 0; i < colors.length; i++){
            for(int j = 0; j < colors[0].length; j++){
                colors[i][j] =0;
            }
        }
    }
    @FXML
    private void selectionOfMap(){ //This method is used to display the different maps that the user can paly
        mapSelection.setVisible(true); //Make the maps visible for the user to see
        mapSelection.setGridLinesVisible(true);
        mapSelection.setTranslateX(500);
        mapSelection.setTranslateY(0);
        map1.setImage(land); //The user can play as the land map
        map2.setImage(sea); //or the sea map
    }
    
    //**The next two following methods are used as mouseclicks for the game**
    
    @FXML
    private void selectedMap1(){ //If the user selects (clicks) the left hand imageview
        chosenMap = 1; //They are choosing the land map to play
        mapSelection.setVisible(false); 
        //If you choose the land map, you are stuck with the following villians
        v1 = zombie; //zombie
        v2 = ghost; //ghost
        v3 = evilDragon; //evil Dragon
        v4 = darkKnight; //Dark Knight
        g1 = grass; //B/c this is the land map, the land terrain is grass
        t1 = tree; //and trees        
        //Lines 257 - 261, you are setting the objects for the villians that will be used throughout the game
        tempVillians[0][0] = new Characters("zombie",0,100);
        tempVillians[1][0] = new Characters("ghost",0,25);
        tempVillians[2][0] = new Characters("evilDragon",0,125);
        tempVillians[3][0] = new Characters("darkKnight",0,150);
        characterSelection(); //Next, the user is allowed to begin to select their own characters
    }
    
    @FXML
    private void selectedMap2(){//If the user selects (clicks) the right hand imageview        
        chosenMap = 2; //They are playing in the ocean map
        g1 = water; //Water terrain
        t1 = seaWeed; //Seaweed instead of trees
        //B/C this is the sea terrain, the villians you use change as well
        v1 = mermaid; //Mermaid
        v2 = shark; //Shark
        v3 = waterDragon; //Water Dragon
        v4 = kraken;//Kraken
        //Lines 276-280 change the objects to match the villians of water that will be used
        tempVillians[0][0] = new Characters("mermaid",0,100);
        tempVillians[1][0] = new Characters("shark",0,25);
        tempVillians[2][0] = new Characters("waterDragon",0,125);
        tempVillians[3][0] = new Characters("kraken",0,150);        
        mapSelection.setVisible(false);
        characterSelection(); //Next, the user is allowed to begin to select their own characters
    }
    @FXML
    private void characterSelection(){
        String mapper = "";
        if(chosenMap == 1){ //If the chosen map is Land
            mapper = "Land";
        }
        else if(chosenMap == 2){//If the chosen map is sea
            mapper = "Sea";
        }                    
        textArea.setText("You have chosen the " + mapper + " map!\n\nNow, you must decide which\ncharacters you want to play as.\nRemember, you must choose 4\ncharacters to play as, and can only\nchoose one character per column.\n\nOnce you have chosen 4, press the \nstart button in the upper lefthand\ncorner.");
        //This method is used to display the gridpane of which the available characters that can be used are displayed
        for(int i=0; i<selectionBtn.length; i++){
            for(int j=0; j<selectionBtn[0].length;j++){
                selectionBtn[i][j] = new ImageView();
                selectionBtn[i][j].setFitHeight(70);
                selectionBtn[i][j].setFitWidth(70);
                colorAdjustGrayscale.setSaturation(-100); //Negative saturation makes the colors darker
                selectionBtn[i][j].setEffect(colorAdjustGrayscale); //Used to display all the characters are grey before they are chosen
                if(chosenMap == 1){ //If they selected the land map, they can only used characters that correspond with land characters
                    landChose(i, j);
                }
                else if(chosenMap == 2){ //If they selected the water map, they can only used characters that correspond with water characters
                    seaChose(i,j);
                }                
                characterGridPane.add(selectionBtn[i][j], j, i); 
            }
        }
        characterGridPane.setGridLinesVisible(true);
        characterGridPane.setVisible(true);
        characterGridPane.setTranslateY(-100);
        EventHandler z = new EventHandler<MouseEvent>() //Mouse click event for the gridpane
        {            
            @Override
            public void handle(MouseEvent t) 
            {
                rowSelected = GridPane.getRowIndex(((ImageView) t.getSource())); //Row Position of gridpane
                colSelected = GridPane.getColumnIndex(((ImageView) t.getSource())); //Col position of gridpane
                if(colors[rowSelected][colSelected] != 1){ //If colors is not equal to one, it means that the character in the position has not been chosen yet
                    colorAdjustGrayscale3.setSaturation(0); //When you press a charcter, it changes the color back to its original color. 
                    ((ImageView) t.getSource()).setEffect(colorAdjustGrayscale3);  //Set the color back
                    colors[rowSelected][colSelected] = 1; //Set to one so that the same character cannot be chosen twice
                    colorChange(rowSelected, colSelected); //This method is used to change every other color in the gridpane back to grey if it is not selected
                    changeChosen(rowSelected, colSelected); //Used to set the objects of the chaarcters that you will use for the game
                    fourSelected++; //Increase the number of characters you've chosen
                    if(fourSelected == 4){ //If you selected four characters, you cannot choose anymore
                        characterGridPane.setVisible(false);
                        button.setVisible(true); //set the start button visible
                        
                    }
                }
                
                
            }
            
        };
        for(int i=0; i<selectionBtn.length; i++){ //This allows you to be able to press on the imageviews
            for(int j=0; j<selectionBtn[0].length;j++){
                selectionBtn[i][j].setOnMouseClicked(z);
            }
        }
        
    }
    public void landChose(int i, int j){ 
        //Precondition: i and j are valid rows and columns within the size of the gridpane
        //The following sets the gridpane for the land characters you can use 
        //Only called when the user selects the land map to use
        if(i == 0){ //If the first row
            //J refers to the columns that are called
            if(j == 0){
                selectionBtn[i][j].setImage(knight);
            }
            if(j == 1){
                selectionBtn[i][j].setImage(archer);
            }
            if(j == 2){
                selectionBtn[i][j].setImage(castle);
            }
            if(j == 3){
                selectionBtn[i][j].setImage(dragon);
            }
                    
        }
        else if(i == 1){ //In the second row
            //J refers to the columns
            if(j == 0){
                selectionBtn[i][j].setImage(horse);
            }
            if(j == 1){
                selectionBtn[i][j].setImage(slingShot);
                a1 = cannonBall; //If the user selects the slingshot, it is no longer an arrow, but a cannon ball
            }
            if(j == 2){
                selectionBtn[i][j].setImage(healer);
            }
            if(j == 3){
                selectionBtn[i][j].setImage(garchomp);
            }
        }
    }
    public void seaChose(int i, int j){
        //Precondition: i and j are valid rows and columns within the size of the gridpane
        //The following sets the gridpane for the water characters you can use 
        //Only called when the user selects the water map to use
        if(i == 0){ //i refers to rows
            if(j == 0){ //j refers to columns
                selectionBtn[i][j].setImage(pirate);
            }
            else if(j == 1){
                selectionBtn[i][j].setImage(battleShip);
                //a1 = cannonBall; //If the user selects the battleship, it is no longer an arrow, but a cannon ball
            }
            else if(j == 2){
                selectionBtn[i][j].setImage(island);
            }
            else if(j == 3){
                selectionBtn[i][j].setImage(gyarados);
            }
                    
        }
        else if(i == 1){//i refers to rows
            if(j == 0){//j refers to columns
                selectionBtn[i][j].setImage(scuba);
            }
            else if(j == 1){
                selectionBtn[i][j].setImage(trooper);
                //a1 = laser; //This might not work. Go and check if the battleShip is working correctly first
            }
            else if(j == 2){
                selectionBtn[i][j].setImage(lightHouse);
            }
            else if(j == 3){
                selectionBtn[i][j].setImage(aqua);
            }
        }
    }
    public void colorChange(int r, int c){ //This is used to change the color of the images to grey (unless they are selected)
        for(int i =0; i < selectionBtn.length; i++){ //
            for(int j = 0; j < selectionBtn[0].length; j++){
                //Go through every single image view in the gridpane
                if(colors[i][j] != 1){ //If the image has not been selected, set that image to grey
                    colorAdjustGrayscale4.setSaturation(-100); //When you press a charcter, it changes the color
                    selectionBtn[i][j].setEffect(colorAdjustGrayscale4);
                }
            }
        }                
    }
    @FXML
    private void changeChosen(int r, int c){
        //Precondition: i and j are positive integers that exist in the size parameters of the gridpane
        if(chosenMap == 1){ //If the chosen map is the land map
            if(r == 0){ //Rows 
                if(c == 0){//Columns
                    c1 = knight; //Set temporary image to knight
                    tempObjects[0][0] = new Characters("knight", 100, 100); //Create knight object
                }
                else if(c == 1){
                    c2 = archer; //Create temporary image to archer
                    a1 = arrow;
                    tempObjects[1][0] = new Characters("archer", 50, 25); //Create archer object
                }
                else if(c == 2){
                    c3 = castle; //Create temporary image to castle
                    tempObjects[2][0] = new Characters("castle", 150, 125); //Create castle object
                }
                else if(c == 3){
                    c4 = dragon;//Create temporary image to dragon
                    tempObjects[3][0] = new Characters("dragon", 200, 150); //Create dragon object
                }
            }
            else if(r == 1){ //row2            
                if(c == 0){//col2
                    c1 = horse; //Create temporary image to horse
                    tempObjects[0][0] = new Characters("horse", 100, 100); //create horse object
                }
                else if(c == 1){
                    c2 = slingShot;//Create temporary image to slingshot
                    a1= cannonBall;
                    tempObjects[1][0] = new Characters("slingShot", 50, 25); //create slingshot object
                }
                else if(c == 2){
                    c3 = healer;//Create temporary image to healer
                    tempObjects[2][0] = new Characters("healer", 150, 125); //create healer object
                }
                else if(c == 3){
                    c4 = garchomp;//Create temporary image to garchomp
                    tempObjects[3][0] = new Characters("garchomp", 200, 150); //create egarchomp object
                }
            }
        }
        else if(chosenMap == 2){ //If the chosen map is the sea map
            if(r == 0){ //row1
                if(c == 0){//col1
                    c1 = pirate;//Create temporary image to pirate
                    tempObjects[0][0] = new Characters("pirate", 100, 100);//create pirate object
                }
                else if(c == 1){
                    c2 = battleShip;//Create temporary image to battleship
                    a1= cannonBall;//Create temporary image to cannonball
                    tempObjects[1][0] = new Characters("battleShip", 50, 25);//create battleship object
                }
                else if(c == 2){
                    c3 = island;//Create temporary image to island
                    tempObjects[2][0] = new Characters("island", 150, 125);//cr//create island object
                }
                else if(c == 3){
                    c4 = gyarados;//Create temporary image to gyarados
                    tempObjects[3][0] = new Characters("gyarados", 200, 150);//create gyarados object
                }
            }
            else if(r == 1){            
                if(c == 0){
                    c1 = scuba;//Create temporary image to scuba
                    tempObjects[0][0] = new Characters("scuba", 100, 100);//create scuba object
                }
                else if(c == 1){
                    c2 = trooper;//Create temporary image to trooper
                    a1 = laser;//Create temporary image to laser
                    tempObjects[1][0] = new Characters("trooper", 50, 25);//create trooper object
                }
                else if(c == 2){
                    c3 = lightHouse;//Create temporary image to lighthouse
                    tempObjects[2][0] = new Characters("lightHouse", 150, 125);//create lighthouse object
                }
                else if(c == 3){
                    c4 = aqua;//Create temporary image to aqua dragon
                    tempObjects[3][0] = new Characters("aqua", 200, 150);//create aqua object
                }
            }
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) { //Main start button  
        button.setText("reset"); //Once you start the game once, the button becomes a reset button
        button.setTranslateX(40);
        textArea.setText("The game has started!\n\nYour goal is to survive up to four\nwaves without losing all your health. Good Luck!");
        if(startGame){ //If the game has been started more than once, you are allowed to restart the game
            endGame2(); //Reset all the game stats
            resetButton(); //Restart the actual game itself
        }        
        if(!startGame){ //If this is the first time starting the game
            loadList2(); //Load the listviews
            loadList(); //Load the old listviews
            loadOld();
        }
        setMultiBoard(); //Set up the 2D array for the board
        setBoard(); //Set up the graphics for the board
        setGridLines(); //Set the gridlines for the gridpane
        setOutside(); //Set up the outside boundaries for the board that cannot be pressed
        setCharacters(); //Set up the selection of characters you can select from
        setImages(); //Sets up background images for the board
        setHealth(); //Sets up the gridpane which will display my health on the board
        setFlagBoard(); //Set the positions for where your flags will be
        setStatsBox(); //display the box that will show your stats for the game       
        startGame = true; //states that game has started
        leftGridPane.setVisible(true);                
        powerUpMenuBar.setVisible(true);                
        leftGridPane.setGridLinesVisible(true);
        leftGridPane.setTranslateX(350);
        powerBar.setVisible(true);
        //Set the following times to the system time
        startTime = System.nanoTime();
        cardTime = System.nanoTime();
        zombieTime = System.nanoTime();
        arrowTime = System.nanoTime();
        increaseTime = System.nanoTime();
        powerIncrease = System.nanoTime(); 
        playTime = false;
         //Initially starts with 200 manna        
        tracker.restartManna(); //Reset the manna back to 200 once the game starts
        mannaBoard(); //Displays the box that will show manna
        start(tracker); //Timer method; pass the amount of manna object as a parameter to be used in the start method
        mannaLabel.setText("Mana: " + tracker.showManna()); //Display the manna that will be used in the game
        EventHandler z = new EventHandler<MouseEvent>() //Identify the user click on the gridpane
        {            
            @Override
            public void handle(MouseEvent t) 
            {
                rowPos = GridPane.getRowIndex(((ImageView) t.getSource())); //The row position of the gridpane that was pressed
                colPos = GridPane.getColumnIndex(((ImageView) t.getSource())); //The column position of the gridpane that was pressed
                showHealthLeft(rowPos,colPos);                
                showVillianHealth(rowPos, colPos);
                findPosition(rowPos,colPos);
                if(multi[rowPos][colPos][0] == 1){ //1 means that it is possible to place an object there. Look at setMultiBoard() method for specific numbers 
                    if(chosen != 4){ //4 refers to any place on the board that can never be placed
                        
                        //**Lines 133-187 can be abstracted into one method                        
                        
                        boolean satisfied = false;//This boolean is used to make sure an object is not already placed on the board
                        
                        //The following objects should all be dummy variables so far. There should be an option to change characters later
                        if(chosen == 0){ //Knight Options
                            //Initially places a character; if it is not possible to place an object there, it is replaced with null
                            objects[rowPos][colPos] = new Characters(tempObjects[0][0]); //Used to clone objects as a way so that they are new objects every single time
                            if(tracker.showManna() < objects[rowPos][colPos].showCost()){
                                objects[rowPos][colPos]= null; //If it is not possible to press, a null object will be placed instead
                            }
                            else{
                                ((ImageView) t.getSource()).setImage(c1); 
                                tracker.subtractManna(objects[rowPos][colPos].showCost()); //This subtracts manna as you buy a character to use
                                satisfied = true;
                            }
                        }
                        if(chosen == 1){ //Archer Objects
                            objects[rowPos][colPos] = new Characters(tempObjects[1][0]);  
                            
                            if(tracker.showManna() < objects[rowPos][colPos].showCost()){
                                objects[rowPos][colPos]= null;
                            }
                            else{
                                ((ImageView) t.getSource()).setImage(c2); 
                                tracker.subtractManna(objects[rowPos][colPos].showCost());
                                multi[rowPos][colPos][1] = 1;
                                satisfied = true;
                            }
                            
                        }
                        if(chosen == 2){ //Castle Object
                            objects[rowPos][colPos] = new Characters(tempObjects[2][0]);  
                            if(tracker.showManna() < objects[rowPos][colPos].showCost()){
                                objects[rowPos][colPos]= null;
                            }
                            else{ //Dragon Object
                                ((ImageView) t.getSource()).setImage(c3);
                                tracker.subtractManna(objects[rowPos][colPos].showCost());
                                satisfied = true;
                            }
                            
                        }
                        if(chosen == 3){
                            objects[rowPos][colPos] = new Characters(tempObjects[3][0]);
                            
                            if(tracker.showManna() < objects[rowPos][colPos].showCost()){
//                              objects[rowPos][colPos]= new Characters("null", 0, 0); 
                                objects[rowPos][colPos]= null;
                            }
                            else{
                                ((ImageView) t.getSource()).setImage(c4); 
                                tracker.subtractManna(objects[rowPos][colPos].showCost());
                                satisfied = true;
                            }
                        }   
                        if(satisfied){
                            multi[rowPos][colPos][0] = 3; //3 is used to allow make sure that the user can no longer place on the board
                            
                            changeMultiBoard(rowPos, colPos); //When you place a character, you are allowed to place another character in first
//                            showMultiBoard();
                        }
                        mannaLabel.setText("Mana: " + tracker.showManna()); //Used to display the manna as it changes after you spend manna
                        chosen = 4;
                        itemPane.setVisible(false);
                        resetBack();
                    }
                }

            }
            
        };
        for(int i=0; i<btn.length; i++){ //This determines where you can press on the board
            for(int j=0; j<btn[0].length;j++){
                btn[i][j].setOnMouseClicked(z);
            }
        }  
    }
    @FXML
    private void resetBack(){ //Used to reset the colors as you press objects
        for(int i=0; i<characterBtn.length; i++){
            colorAdjustGrayscale2.setSaturation(-100); //DON'T CHANGE THIS ONE
            characterBtn[i][0].setEffect(colorAdjustGrayscale2);
        }
    }
    public void endGame2(){ //Used to reset the game in the MIDDLE of a game
        //**There is another method called endGame(). That method is used to reset the game after the game ends
        backgroundImage.setVisible(false);
        gPane.setVisible(false);
        gPane.setGridLinesVisible(false);
        characterPane.setVisible(false);
        characterPane.setGridLinesVisible(false);
        itemPane.setVisible(false);
        waveChecker.setVisible(false);
        powerUpPane.setVisible(false);
        healthGridPane.setGridLinesVisible(false);
        healthLeftPane.setVisible(false);
        statsPane.setVisible(false);
        leftGridPane.setVisible(false);
        leftGridPane.setGridLinesVisible(false);
        gameStatsLabel.setVisible(false);
        villiansPane.setVisible(false);                    
        playTime = true;
    }

    public void resetButton(){  //Used to reset the game
        chosen = 4;//This int keeps track of which character is chosen in the character selection list
        rowPos = 0; //Keeping track of row position on gridPane
        colPos = 0; //Keeping track of col Position of gridPane
        waveNum = 1; //Used to keep track of which wave the game is currently on
        userHealth = 4; //This is the amount of health that the user have (Same as the number of flags
        numberOfVillians1 = 0;
        zombieLimit = 10;
        unitsKilled = 0;
        villiansKilled = 0;
        incPower = 0;
        waveChecker.setProgress(0);
        powerBar.setProgress(0);
        backgroundImage.setVisible(true);
        characterPane.setVisible(true);
        characterPane.setGridLinesVisible(true);
        waveChecker.setVisible(true);
        powerUpPane.setVisible(true);
        healthGridPane.setGridLinesVisible(true);
        statsPane.setVisible(true);
        leftGridPane.setVisible(true);
        leftGridPane.setGridLinesVisible(true);
        gameStatsLabel.setVisible(true);
        listView.setVisible(false);
        gameResult.setVisible(false);
       
        setZero(); //Used to reset all the 3d and 2d arrays used for this game back to zero
        resetImages(); //Used to reset all the iamges used in the gridpanes
        
    }
    
 
    public void setZero(){ //This method is used to reset all the 3d and 2d arrays used for this game back to zero
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                multi[i][j][1] = 0;
            }
        }
        for(int i = 0; i < objects.length; i++){ //Set all the objects to null
            for(int j = 0; j < objects[0].length; j++){
                objects[i][j] = null;
            }
        }
        
    }
    public void resetImages(){ //This method is used to reset all the images used for the gridpanes in the game
        //**This method is important because if you do not reset the images, they will redraw themselves on top of the old gridpane
        //Therefore, it is necessary that each time you play, the gridpane starts with all new images
        for(int i =0; i < btn.length; i++){
            for(int j =0; j < btn[0].length; j++){
               btn[i][j].setImage(null); //Set the images to null
            }
        }
        for(int i = 0; i < characterBtn.length; i++){
            for(int j = 0; j < characterBtn[0].length; j++){
                characterBtn[i][j].setImage(null); //set image to null
            }
        }
        for(int i = 0; i < healthBtn.length; i++){
            for(int j = 0; j < healthBtn[0].length; j++){
                healthBtn[i][j].setImage(null); //set images to null
            }
        }
        for(int i = 0; i < flagPosition.length; i++){
            for(int j = 0; j < flagPosition[0].length; j++){
                flagPosition[i][j] = 0; //set the positions of the flags to zero
            }
        }
        
    }

    @FXML //This method is used to load the list of the top five scores
    private void loadList(){ //This is used to keep all the information parsed as strings so it can be recalled
        try{
            FileReader reader = new FileReader("src/resources/scores.txt"); //scores, not scores2
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                topScores.add(temp);
                displayList.add(temp);
                listView.setItems(displayList);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
    }
    
    @FXML
    private void loadList2(){ //This second loadList is used to load the list people who have played before.
        try{
            FileReader reader = new FileReader("src/resources/scores2.txt"); //scores2, not score1
            Scanner in = new Scanner(reader);
            while(in.hasNextLine())
            {
                String temp = in.nextLine();
                classSaver.add(temp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("SOMETHING HAS GONE HORRIBLY WRONG WE'RE ALL GONNA DIE!");
        }
    }
    @FXML //This method is used to save the top five scores every time the game adds a new user
    private void saveList(){
        String outFile = "src/resources/scores.txt";
        try {
                PrintWriter out = new PrintWriter(outFile);
                for(int i = 0; i < topScores.size(); i++)
                {
                    out.println(topScores.get(i));
                }
                out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something went wrong!");
        }
    }
        
    @FXML
    private void saveList2(){ //This saves the top five so that people playing in the next game can play.
        String outFile = "src/resources/scores2.txt";
        try {
                PrintWriter out = new PrintWriter(outFile);
                for(int i = 0; i < classSaver.size(); i++)
                {
                    out.println(classSaver.get(i));
                }
                out.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Something went wrong!");
        }
    }
    @FXML
    private void addList(){ // this method is used to change the listview once a new player plays
        listView.setItems(displayList);
        saveList();
    }
    @FXML
    private void addList2(){
        saveList2();
    }
    private void loadOld(){ //This method is used to keep track of the five best players after a game ends.
        for(int i = 0; i < classSaver.size(); i++){
            String total = classSaver.get(i);
            int check1 = total.indexOf(",");
            String name1 = total.substring(0,check1);
            int score1 = Integer.parseInt(total.substring(total.indexOf(",")+1,total.indexOf("|")));
            String result1 = total.substring(total.indexOf("|")+1,total.indexOf("#")); 
            int killed2 = Integer.parseInt(total.substring(total.lastIndexOf("#")+1)); 
            list.add(new Person(name1,score1,result1,killed2));
        }
    }
    public void setMultiBoard(){ //This method should be used to keep track of where on the board items can/cannot be placed
        //**Below are the numbers that represent which characters are placed on the board
        //Remember, this is a 3d array
        //0 - possible but cannot place yet
        //1 - can place        
        //2 - Villian
        //3 - Me
        //4 - cannot place
        //5 - Villian possible
        ///////////////////////////////////////
        //For 2nd layer of 3d array
        //1 - my hero
        //3 - arrow
        //2 - zombie
        //5 - Ghost
        //6 - evilDragon
        //7 - darkKnight        
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                multi[i][j][1] = 0;
                if(j == 1){
                    multi[i][j][0] = 1; //Initialize the board so that you can place on the board    
                }
                else if(j == 9){
                    multi[i][j][0] = 5; //initialize where villians will be placed on the board
                }
                else{
                    multi[i][j][0] = 0;
                }
                
            }
        }
        
    }
    @FXML //This is used to display the physical display board itself
    private void setBoard(){
        //This is the board where the actually game occurs
        
        for(int i=0; i<btn.length; i++){
            for(int j=0; j<btn[0].length;j++){
                btn[i][j] = new ImageView();
                btn[i][j].setFitHeight(60);
                btn[i][j].setFitWidth(60);
                if(j == 0){ //On the furtest column on the left, place your flags
                    btn[i][j].setImage(flag);
                    multi[i][j][0] = 4;
                }
                else if(j == 10){ //On the furthest right column, place tombstones
                    btn[i][j].setImage(tomb);
                    multi[i][j][0] = 4;
                }
                else{ //Everywhere else, place grass, which means the character can be placed there
                    //Initializing 2D buttons with values i,j
                    btn[i][j].setImage(g1);

                }
                //Paramters:  object, columns, rows
                gPane.add(btn[i][j], j, i); 
            }
        }
        
    }
  
    public void setGridLines(){ //This method is used to set up the gridlines for the board
        gPane.setGridLinesVisible(true); 
        gPane.setVisible(true);
    }
    @FXML
    public void setOutside(){ //used to set the trees of the outside borders the board so the user cannot place anything there
        for(int i = 0; i < btn.length; i++){
            for(int j = 0; j < btn[0].length; j++){
                //**If this map is sea map, it will be seaweed instead of trees
                btn[0][j].setImage(t1);
                multi[0][j][0] = 4; //Placed in the first row
                btn[5][j].setImage(t1);
                multi[5][j][0] = 4; //placed in the last row
            }
        }
    }
    @FXML 
    private void setCharacters(){ //Used to set the characters that the user can use for the game
        //The characters displayed in this method will change depending on the four chaarcters the user selected in the beginning of the game
        for(int i=0; i<characterBtn.length; i++){
            for(int j=0; j<characterBtn[0].length;j++){
                characterBtn[i][j] = new ImageView();
                characterBtn[i][j].setFitHeight(70);
                characterBtn[i][j].setFitWidth(70);
                colorAdjustGrayscale.setSaturation(-100);
                characterBtn[i][j].setEffect(colorAdjustGrayscale);
                if(i == 0){ //Display the first charcter in the first column
                    characterBtn[i][j].setImage(c1);
                }
                if(i == 1){ //Display the second charcter in the second column
                    characterBtn[i][j].setImage(c2);
                }
                if(i == 2){ //Display the third charcter in the third column
                    characterBtn[i][j].setImage(c3);
                }
                if(i == 3){//Display the fourth charcter in the fourth column
                    characterBtn[i][j].setImage(c4);
                }

                characterPane.add(characterBtn[i][j], j, i); 
            }
        }
        characterPane.setGridLinesVisible(true);
        characterPane.setVisible(true);
        secondGrid(); //Used to allow the user to press on this gridpane and to choose characters
    }
    @FXML
    private void secondGrid(){ //Used to set up the gridPane for the character selections
        EventHandler z = new EventHandler<MouseEvent>() 
        {            
            @Override
            public void handle(MouseEvent t) 
            {
                rowCharacter = GridPane.getRowIndex(((ImageView) t.getSource())); //Row position
                colCharacter = GridPane.getColumnIndex(((ImageView) t.getSource())); //This really isn't needed. as there is only one column you can choose from
                colorAdjustGrayscale.setSaturation(0); //When you press a charcter, it changes the color
                ((ImageView) t.getSource()).setEffect(colorAdjustGrayscale); 
                resetColors(rowCharacter, colCharacter); //Used to reset the colors of images if they are not pressed
                getCharacter(rowCharacter); //Used to determine which character you currently have pressed
                showPane(rowCharacter); //Used to display the mini box that shows the characters stats
            }
            
        };
        for(int i=0; i<characterBtn.length; i++){ //This allows you to be able to press on the imageviews
            for(int j=0; j<characterBtn[0].length;j++){
                characterBtn[i][j].setOnMouseClicked(z);
            }
        }
    }
    
    @FXML
    private void resetColors(int n1, int n2){ //Used to reset the colors as you press objects
        for(int i=0; i<characterBtn.length; i++){
            if(i != n1 ){
                colorAdjustGrayscale2.setSaturation(-100); //DON'T CHANGE THIS ONE
                characterBtn[i][0].setEffect(colorAdjustGrayscale2);
            }
        }
    }
    public void getCharacter(int n1){ //This finds the position of the character in the character array so it can be placed on the board
        chosen = 4; //4 means that nothing is currently chosen
        switch(n1){
            case 0: chosen = 0; //first chaarcter
                    break;
            case 1: chosen = 1; //second character
                    break;
            case 2: chosen = 2; //Third character
                    break;
            case 3: chosen = 3;//Fourth character
                    break;
        }          
    }
    @FXML
    private void showPane(int n1){ //Used to display the characters in the character selections chart
        itemPane.setVisible(true);
        itemPane.setStyle("-fx-border-color: #FFFFFF;"); //This is used to create the black border around the box you are using
        itemPane.setTranslateX(-30);
        itemPane.setStyle("-fx-background-color: #D3D3D3");//This is used to create the black box that shows which character you are placing 
        textArea.setText("You are now selecting a character.\nRemember, some characters have\nspecial abilities, like the archer\nwho can shoot projectiles, or the\ncastle who gains health. Villians\nhave abilities as well, such as the\nghost who gains more health if hit \nby a projectile.");
        if(n1 == 0){ //If you select the first item (or first character)
            itemPane.setTranslateY(10);
            charLabel.setText("Character: " + tempObjects[0][0].showType()); //Display character type
            charLabel2.setText("Cost: " + tempObjects[0][0].showCost()); //Display character cost
            attackLabel.setText("Attack: " +tempObjects[0][0].showAttack()); //display chaarcter attack
            //**Logos for characters will change depending on what you place
            if(tempObjects[0][0].showType().equals("knight")){
                logoImage.setImage(sword);
            }
            else if(tempObjects[0][0].showType().equals("horse")){
                logoImage.setImage(horseHead);
            }
            else if(tempObjects[0][0].showType().equals("pirate")){
                logoImage.setImage(pirateHead); 
            }
             else if(tempObjects[0][0].showType().equals("scuba")){
                logoImage.setImage(scubaMask); 
            }
        }
        else if(n1 == 1){ //If you select the second item
            itemPane.setTranslateY(80);
            //Notice how the tempObject change. It is [1][0] instead of [0][0]. For tempObject, the characters are displayed in the order they are placed.
            //[0][0] = first
            //[1][0] = two
            //[2][0] = three
            //[3][0] = four
            charLabel.setText("Character: " + tempObjects[1][0].showType());//display chaarcter type
            charLabel2.setText("Cost: "+ tempObjects[1][0].showCost());//display chaarcter cost
            attackLabel.setText("Attack: " +tempObjects[1][0].showAttack());//display chaarcter attack
            //**Logos for characters will change depending on what you place
            if(tempObjects[1][0].showType().equals("archer")){
                logoImage.setImage(bow);
            }
            else if(tempObjects[1][0].showType().equals("slingShot")){
                logoImage.setImage(sling);   
            }
            else if(tempObjects[1][0].showType().equals("battleShip")){
                logoImage.setImage(shipBattle); 
            }
            else if(tempObjects[1][0].showType().equals("trooper")){
                logoImage.setImage(gun); 
            }
        }
        else if(n1 == 2){//If you select the third item
            itemPane.setTranslateY(150);
            charLabel.setText("Character: " +tempObjects[2][0].showType());//display chaarcter name
            charLabel2.setText("Cost: "+tempObjects[2][0].showCost());//display chaarcter cost
            attackLabel.setText("Attack: "+ tempObjects[2][0].showAttack());//display chaarcter attack
            //**Logos for characters will change depending on what you place
            if(tempObjects[2][0].showType().equals("castle") || tempObjects[2][0].showType().equals("healer") || tempObjects[2][0].showType().equals("island")){
                logoImage.setImage(heart);
            }
            else if(tempObjects[2][0].showType().equals("lightHouse")){
                logoImage.setImage(light);
            }
            
        }
        else if(n1 == 3){//If you select the forth item
            itemPane.setTranslateY(220);
            charLabel.setText("Character: " + tempObjects[3][0].showType());//display chaarcter name
            charLabel2.setText("Cost: "+ tempObjects[3][0].showCost());//display chaarcter cost
            attackLabel.setText("Attack: "+tempObjects[3][0].showAttack());//display chaarcter attack
            //**Logos for characters will change depending on what you place
            if(tempObjects[3][0].showType().equals("dragon") || tempObjects[3][0].showType().equals("garchomp") || tempObjects[3][0].showType().equals("gyarados")){
                logoImage.setImage(fire);
            }
            else if(tempObjects[3][0].showType().equals("aqua")){
                 logoImage.setImage(droplet);
            }

        }
        
        
    }
    
    @FXML
    private void deleteActions(MouseEvent event){ //Allows me to change the character colors back to black when the user is not selecting a character
        //This method is run whenever you press anywhere on the board other than the character selection board
        for(int i=0; i<characterBtn.length; i++){
            colorAdjustGrayscale2.setSaturation(-100); //DON'T CHANGE THIS ONE
            characterBtn[i][0].setEffect(colorAdjustGrayscale2);
        }
        chosen = 4; //4 means that there is no character that is currenty chosen
        itemPane.setVisible(false); //Gets rid of character selection box
        healthLeftPane.setVisible(false);
        villiansPane.setVisible(false);
        powerChosen = 0;
        powerLabel.setText("");
    }
   

    @FXML
    private void setImages(){ //Sets up the background images for the board
        backgroundImage.setVisible(true);
        //This will change. Once you give the user more selections they can choose from, it shouldn't always be land
        if(chosenMap == 1){
            backgroundImage.setImage(land);  
        }
        else if(chosenMap == 2){
            backgroundImage.setImage(sea);  
        }                           
        //**Also, fix the how the image stretches out onto the board
        backgroundImage.setFitHeight(1000);
        backgroundImage.setFitWidth(2000);
        waveChecker.setVisible(true);// Setting the progress bar to visible
        waveChecker.setTranslateX(200); //Moving the progres bar to the middle of the board
    }
        
    @FXML
    private void setHealth(){ //This method creates a gridpane with imageviews that will show my health on the board
        for(int i =0; i < healthBtn.length; i++){
            for(int j = 0; j < healthBtn[0].length; j++){
                healthBtn[i][j] = new ImageView();
                healthBtn[i][j].setFitHeight(70);
                healthBtn[i][j].setFitWidth(70);
                healthBtn[i][j].setImage(heart); //add heart image
                healthGridPane.add(healthBtn[i][j], j, i); 
            }
        }
        healthGridPane.setGridLinesVisible(true);
        healthGridPane.setVisible(true);
        healthGridPane.setTranslateY(-370);
        healthGridPane.setTranslateX(200); 
    }
    public void setFlagBoard(){ //This method is used to set up the flag positions of the board
        //All the flags are placed in the same column, this method checks to see if a enemy enters that column and destroys the flags
        //If all the flags in the column are destroyed and the zombies get through, the characters lose
        for(int i =0; i < flagPosition.length; i++){
            for(int j = 0; j < flagPosition[0].length; j++){
                flagPosition[i][j] = 0;
            }
        }
    }
    @FXML
    private void setStatsBox(){ 
        //This method is used to set up the stats box of the game
        statsPane.setStyle("-fx-border-color: #FFFFFF;");
        statsPane.setStyle("-fx-background-color: #D3D3D3;");
        statsPane.setTranslateX(350);
        statsPane.setTranslateY(0); 
        gameStatsLabel.setVisible(true);
        wavesLabel.setText("Wave: " + waveNum); //display the wave that the user is one
        villiansKilledLabel.setText("Villians Killed: " + villiansKilled); //display the number of villians killed
        unitsKilledLabel.setText("Units Killed: " + unitsKilled); //Used to display the number of units killed
    }
    
    @FXML
    private void mannaBoard(){ //This is used to display the manna box on the top as you start the game
        powerUpPane.setVisible(true);
        mannaImage.setImage(manna);
        powerUpPane.setStyle("-fx-border-color: #FFFFFF;"); //sets the black border of the pane
        powerUpPane.setTranslateX(-260);
        powerUpPane.setTranslateY(20); 
        powerUpPane.setStyle("-fx-background-color: #D3D3D3;"); //Sets the black color of the pane
    }

    @FXML
    private void showHealthLeft(int row, int col){ //This method will be used to allow the user to press the board to check how much health a character has left
        if(multi[row][col][0] == 3){
            healthLeftPane.setVisible(true);
            healthLeftPane.setStyle("-fx-border-color: #FFFFFF;"); //sets the black border of the pane
            healthLeftPane.setStyle("-fx-background-color: #D3D3D3;");
            typeLabel.setText("Type: "+ objects[row][col].showType()); //display the object name
            attackShowLabel.setText("Attack: "+objects[row][col].showAttack());//display the object attack points            
            //Lines 1141-1175 are used to change the logo of the character depending on which character is displayed
            if(objects[row][col].showType().equals("knight")){ //If the character is a knight
                logoImage1.setImage(sword);
            }
            else if(objects[row][col].showType().equals("archer")){ //If the character is a archer
                logoImage1.setImage(bow);
            }
            else if(objects[row][col].showType().equals("castle") || objects[row][col].showType().equals("healer") || objects[row][col].showType().equals("island")){
                logoImage1.setImage(heart); //If the character is a
            }
            else if(objects[row][col].showType().equals("dragon") || objects[row][col].showType().equals("garchomp") || objects[row][col].showType().equals("gyarados")){
                logoImage1.setImage(fire);//If the character is a dragon, or garchomp, or gyarados
            }
            else if(objects[row][col].showType().equals("horse")){//If the character is a horse
                logoImage1.setImage(horseHead);
            }
            else if(objects[row][col].showType().equals("slingShot")){//If the character is a slingshot
                logoImage1.setImage(sling);   
            }
            else if(objects[row][col].showType().equals("pirate")){//If the character is a pirate
                logoImage1.setImage(pirateHead); 
            }
            else if(objects[row][col].showType().equals("battleShip")){//If the character is a battleship
                logoImage1.setImage(shipBattle); 
            }
            else if(objects[row][col].showType().equals("scuba")){//If the character is a scuba
                logoImage1.setImage(scubaMask); 
            }
            else if(objects[row][col].showType().equals("trooper")){//If the character is a trooper
                logoImage1.setImage(gun); 
            }
            else if(objects[row][col].showType().equals("lightHouse")){//If the character is a lighthouse
                logoImage1.setImage(light); 
            }
            else if(objects[row][col].showType().equals("aqua")){//If the character is a aqua
                logoImage1.setImage(droplet); 
            }  
            label2.setText("Chosen Character Status:");
        }
        
    }
    public void changeMultiBoard(int n1, int n2){ //This method is used to allow me to push troops foward                                                  
        //For example, a user cannot place a character on a certain column unless they have placed a character on the column before
        if(n2+1 < multi[0].length){
           multi[n1][n2+1][0] = 1; 
        }
    }

    @FXML
    private void showVillianHealth(int row, int col){ //Used to display the amount of health a villian has left
        if(multi[row][col][0] == 2){ //If the selected character is a villian
            villiansPane.setVisible(true);
            villiansPane.setStyle("-fx-border-color: #FFFFFF;");
            villiansPane.setStyle("-fx-background-color: #D3D3D3;");
            typeLabel1.setText("Type: "+ objects[row][col].showType()); //show villian name
            attackShowLabel1.setText("Attack: "+objects[row][col].showAttack()); //show villian attack
            //Lines 1196-1221 changes the logos depending on which villian is selected
            if(objects[row][col].showType().equals("zombie")){ //If the villian is a zombie
                logoImage2.setImage(zombieHead);
            }
            else if(objects[row][col].showType().equals("ghost")){//If the villian is a ghost
                logoImage2.setImage(ghostHead);
            }
            else if(objects[row][col].showType().equals("evilDragon")){//If the villian is a evil dragon
                logoImage2.setImage(darkFire);
            }
            else if(objects[row][col].showType().equals("darkKnight")){//If the villian is a dark knight
                logoImage2.setImage(darkSword);
            }
            ///////////////////////////////////////
            else if(objects[row][col].showType().equals("mermaid")){//If the villian is a mermaid
                logoImage2.setImage(mermaidHead);
            }
            else if(objects[row][col].showType().equals("shark")){//If the villian is a shark
                logoImage2.setImage(sharkFin);
            }
            else if(objects[row][col].showType().equals("waterDragon")){//If the villian is a water dragon
                logoImage2.setImage(waterDragonHead);
            }
            else if(objects[row][col].showType().equals("kraken")){//If the villian is a kraken
                logoImage2.setImage(squid);
            }
            label21.setText("Chosen Villian Status:");
        }
    }
    public void start(Manna x) { //This method is the animation timer     
        //The parameter that is passed is the manna object passed from the start button
        //This parameter is used as a way to increase the manna as the timer goes on
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(playTime){//Used to stop the animation timer
                    this.stop();
                }
                if(startTime > 0){                    
                    checkArrowCollisions();//Checking if the arrows that are shot have any collisions 
                    collisions(); //Checking if a villian is colliding with a unit
                    if(now - cardTime > 1000000000.0){ //This is used to create more manna for the user to use
                        x.increaseManna(); //This method increases the amount of manna that the user can use
                        showMultiBoard();
                        mannaLabel.setText("Mana: " + x.showManna()); //dispaly the manna
                        cardTime = now;
                    }                   
                    if(now - zombieTime> 3000000000.0){ //This is to add a new villian unto the user board 
                        zombieLimitChange(); //Once the amount of zombies for a certain wave is exceeded, the next wave is changed
                        if(numberOfVillians1 < zombieLimit){
                            addVillains(); //Add villians every 3 seconds
                            zombieTime = now;
                        }
                    }
 
                    if(now - moveTime > 1000000000.0){ //This is used to move the villians across the board
                        moveVillians(); //move villians every 1 second
                        moveTime = now;
                    }
                    if(now - arrowTime > 3000000000.0){ //This is used to allow the archers to shoot 
                        arrowShoot(); //shoot arrows every 3 seconds
                        arrowTime = now;
                    }
                    if(now - arrowTime2 > 500000000.0){ //This is used to move the arrows each time the archers are placed
                        moveArrow(); //Move arrows every half a second
                        //this.stop();
                        arrowTime2 = now;
                    }
                    if(now - increaseTime > 3000000000.0){
                        increaseHealth();
                        increaseTime = now;
                    }
                    if(now - powerIncrease > 1000000000.0 ){
                        powerer();
                        powerIncrease = now;
                    }
                }
                
            }
            
        }.start();
    }
    public void powerer(){
        if(incPower != 10){
            incPower++;
        }
        powerBar.setProgress((double)(incPower)/10);
    }
    public void increaseHealth(){ //This method is used to increase the health of units such as the castle
        for(int i =0; i < multi.length; i++){
            for(int j = 0; j<multi[0].length;j++){
                if(multi[i][j][0]==3){
                    if(objects[i][j].showType().equals("castle") ||objects[i][j].showType().equals("healer") || objects[i][j].showType().equals("lightHouse") || objects[i][j].showType().equals("island")){
                        objects[i][j].increaseHealth();
                        attackShowLabel.setText("Attack: " + objects[i][j].showAttack()); //increase health
                    }
                }
            }
        }
    }
    public void showMultiBoard(){ //Method that allows me to print and see the 2D array as it changes
        System.out.println("First Layer");
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                System.out.printf("%4d", multi[i][j][0]); //Use to print the 2d board nicely, so that it prints in a rectangle shape
            }
            System.out.println();
        }
        System.out.println("Second Layer");
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                System.out.printf("%4d", multi[i][j][1]); //Use to print the 2d board nicely, so that it prints in a rectangle shape
            }
            System.out.println();
        }
        System.out.println("/////////////////////////////");
    }
        
    public void zombieLimitChange(){
        //This method changes the amount of zombies that are spawned each round
        //For example, if there are 10 zombies spawn in wave 1, the wave increases and the new limit is 20
        if((numberOfVillians1 == zombieLimit) && waveNum !=4){ 
            waveNum++; //Increase wave num
            wavesLabel.setText("Wave: " + waveNum); //Wave number
            numberOfVillians1 = 0; //Number of villians (per wave)
            zombieLimit +=10; //Limit of zombies per round
            waveChecker.setProgress(0); //reset the progress bar            
        }
        else if((numberOfVillians1 == zombieLimit) && waveNum == 4){ //If the round is 4
            winOrLose = "Winner";
            endGame(); //end the game
            gameResult.setText("You win!");
        }
    }



    @FXML
    private void addVillains(){ //This method is used to randomly select places on the board and to place a villian there
        int minRow = 1; //Min row position
        int minCol = 9; //Min Col position
        int maxRow = 1; //max row position
        int randomRow = 0;
        int randomCol = 0;
        
        //**This might cause errors by pressing characters in random places. Make sure to debuug this if it does
        
        
        for(int i = 0; i<multi.length; i++){ //The for loops goes through the board and checks where villians are currently placed
            for(int j = 0; j< multi[0].length;j++){
                if(multi[i][j][0] == 5){
                    if(j < minCol){
                        minCol = j;
                    }
                    if(i > minRow){
                        maxRow = i;
                    }
                }
            }
        }
        boolean full = false;
        while(multi[randomRow][randomCol][0] != 5 && !full){ //This might start causing errors once you add more characters, so make sure to check more
            randomRow = 1+(int)(Math.random()*maxRow);
            randomCol = minCol+(int)(Math.random()*((9-minCol)+1));
            int counter = 0;
            for(int i = 0; i<multi.length; i++){
                for(int j = 0; j< multi[0].length;j++){
                    if(multi[i][j][0] == 2){
                        counter++;
                    }
                }
            }
            if(counter == 36){ //If a zombie is placed on every item on the board, then it is no longer possible for zombies to spawn
                full = true;
            }
        }
        if(multi[randomRow][randomCol][0] == 5){ //If it is possible to place a villian
            
            //**Make sure this changes as the waves get harder, so it is not always the same zombie.
            int numVillian = chooseVillians(randomRow,randomCol); //This method chooses which villians will be spawned randomly depending on which wave it is
            //Each sucessive number through lines 1343-1356 changes which villian is spawned
            if(numVillian == 1){ //If one is chosen
                btn[randomRow][randomCol].setImage(v1); 
                multi[randomRow][randomCol][1] = 2;
            }
            else if(numVillian == 2){ //if 2 is chosen
                btn[randomRow][randomCol].setImage(v2);
                multi[randomRow][randomCol][1] = 5;
            }
            else if(numVillian == 3){//if 3 is chosen
                btn[randomRow][randomCol].setImage(v3);
                multi[randomRow][randomCol][1] = 6;
            }
            else{ //if 4 is chosen
                btn[randomRow][randomCol].setImage(v4);
                multi[randomRow][randomCol][1] = 7;
            }
             //setting the image to the a certain villian
            multi[randomRow][randomCol][0] = 2;                        
            numberOfVillians1++; //Keeping track of the number of villians on the board
            waveChecker.setProgress(((double)numberOfVillians1/zombieLimit)); //This MUST be a double!!!
            if(randomCol - 1 > 0){
                multi[randomRow][randomCol - 1][0] = 5; 
            }
        
        }
       
    }
    
    public int chooseVillians(int randomRow, int randomCol){
        //This method randomly decides which villian will be spawned depending on the wave
        int random = 0;
        if(zombieLimit == 10){ //if wave 1
            random = 1;
        }
        else if(zombieLimit == 20){// if wave 2
            random = 1+(int)(Math.random()*2);
        }
        else if(zombieLimit == 30){ //if wave 3
            random = 1+(int)(Math.random()*3);
        }
        else{//if wave 4
            random = 1+(int)(Math.random()*4);
        }
        if(random == 1){ //You don't need manna cost for the zombies so just set it equal to zero
            objects[randomRow][randomCol] = new Characters(tempVillians[0][0]); //No special ability for zombies
            return 1;
        }
        else if(random == 2){ //Add special abilities
            objects[randomRow][randomCol] = new Characters(tempVillians[1][0]); //Zombie's health increases as it gets hit by an arrow
            return 2;
        }
        else if(random == 3){ //villians for wave 3
            objects[randomRow][randomCol] = new Characters(tempVillians[2][0]);
            return 3;
        }
        else{ //villians for wave 4
            objects[randomRow][randomCol] = new Characters(tempVillians[3][0]);
            return 4;
        }
    }
    
    public void moveVillians(){ //Here's a problem you need to deal with. Each time a zombie movies, it replaces the number with something else. What if the user pushed up to that point? It should be a 1 now not a 5.
        int i =0;
        int j = 0;
        //Used to make check if characters are colliding before they actually move across the board
        //These while loops go around and looks for a zombie. If it finds one, it will move it to the left
        
        //The reason this works is because the while loop goes by INCREASING increments, so if a zombie is moved to the left, it will never be checked again for that iteration.
        while(i < multi.length){
            j = 0;
            while(j < multi[0].length){
                if(multi[i][j][0] == 2){
                    if(j - 1 == 0){ //If the zombie reaches the end of the board
                        if(!checkHealth(i)){ //check to see if the zombies reaches the flags
                            userHealth--; //lose health
                            changeHearts(); //change the number of hearts that are displayed
                            if(userHealth == 0){ //Check the amount of health the user has left. If zero
                                gameResult.setText("You Lost..."); //The user loses
                                winOrLose = "Loser"; 
                                endGame();//end the game
                            }
                        }
                        //If the uer loses health but still has health left
                        btn[i][j-1].setImage(flames); //set image to flames                         
                        multi[i][j-1][0] = 4;
                        btn[i][j].setImage(g1);
                        objects[i][j] = null;   
                        multi[i][j][0] = 1;
                        multi[i][j-1][1] = 0;
                        multi[i][j][1] = 0;
                        
                    }
                    else if(multi[i][j-1][0] !=2){
                        //If the villians move but not at a flag
                        if(j - 1 > 0){ 
                            if(multi[i][j][1] == 2){ //If the villian that is moved is a zombie
                                btn[i][j-1].setImage(v1);
                            }
                            else if(multi[i][j][1] == 5){//If the villian that is moved is a ghost
                                btn[i][j-1].setImage(v2);
                            }
                            else if(multi[i][j][1] == 6){//If the villian that is moved is a evil dragon
                                btn[i][j-1].setImage(v3);
                            }
                            else if(multi[i][j][1] == 7){//If the villian that is moved is a dark knight
                                btn[i][j-1].setImage(v4);
                            }
                            btn[i][j].setImage(g1);
                            objects[i][j-1] = objects[i][j]; //Set to the character that was previously on there before.
                            objects[i][j] = null;
                            multi[i][j-1][0] = multi[i][j][0];
                            multi[i][j-1][1]= multi[i][j][1];
                            multi[i][j][1] = 0;
                            if(j == 9){ //If they die at the end of the board
                                multi[i][j][0] = 5;
                            }
                            else{ 
                                multi[i][j][0] = 0;
                            }
                        
                        }                        
                    }
                }
                j++; //increase increments of column
            }            
            i++;//increase increments of row
        }
        
        //showMultiBoard();
    }
    public boolean checkHealth(int i){
        //This method checks to see if user's flags are still there or if the villians destroyed them
        if(flagPosition[i][0] == 0){
            flagPosition[i][0] = 1;
            return true; //Means it is destroyed
        }
        else{
            return false; //Not destroyed
        }
        
    }
     
    public void changeHearts(){
        //If villians passes the flags, the user begins to lose health
        for(int i = 0; i < healthBtn.length; i++){
            for(int j = 0; j < healthBtn[0].length; j++){
                healthBtn[i][j].setImage(null); //set all the images to null
            }
        }
        for(int i = 0; i < healthBtn.length; i++){
            for(int j = 0; j < userHealth; j++){
                healthBtn[i][j].setImage(heart);//depending on how much health you have left, set the number of hearts based on that
            }
        }
    }
    @FXML
    private void arrowShoot(){ //This method is used to shoot arrows
        int i =0;
        int j = 0;
        //This while loop goes through the board and looks for archers. If if finds an archer, it places an arrow and it will shoot.
        while(i < multi.length){
            j = 0;
            while(j < multi[0].length){
                if(multi[i][j][0] == 3 && multi[i][j+1][0] !=3){//If the position is an archer and the position in front is not
                    if(objects[i][j].showType().equals("archer") || objects[i][j].showType().equals("battleShip")||objects[i][j].showType().equals("trooper") ||objects[i][j].showType().equals("slingShot")){
                        multi[i][j+1][1] = 3;
                        btn[i][j+1].setImage(a1);
                    }
                    
                }
                j++;
            }            
            i++;
        }        
    }
    
    public void moveArrow(){ //This method is used to actually move the arrows once they are placed
        int i =1;
        int j = 1;
        //ARCHERS VS. ZOMBIES
        //Zombies are much eaiser to code because they are moving to the left. When you run nested loops that look over the grid, and you move a character left, it will only move them once because that part of the grid has alrady been checked.                        
        //These while loops go through the 2ND layer of the 3d array. It will look for anywhere that an arrow is placed and move it.
        while(i < multi.length){ 
            j = 0;
            while(j < multi[0].length-1){
                if(multi[i][j][1] == 3){
                    if(multi[i][j+1][1]!=3){
                        if(j+1 == 10){
                            btn[i][j+1].setImage(tomb);
                            btn[i][j].setImage(g1);
                            multi[i][j+1][1] = 0;
                            multi[i][j][1] = 0;
                            j++;//Move it only by one when it reaches the end of the board
                        }
                        else{
                            btn[i][j+1].setImage(a1);
                            btn[i][j].setImage(g1);
                            multi[i][j+1][1] = 3;
                            multi[i][j][1] = 0;
                            j+=2; //Move by a position of 2 to make sure that the arrow is not checked twice
                            //Doesn't work if there are two archers right next to each other
                            //Reason I did this was so that as the loops go through the board, it won't move the arrow more than once per timer
                        }
                        
                    }
                    
                }
                else{
                    j++;//Move the column by one
                }
                
            }            
            i++;//Move it by row now
        }
        
    }
    public void checkArrowCollisions(){ //This method is constantly running every second to check if an arrow hits the target or not        
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                if(j+1 < 10){
                    if((multi[i][j+1][1] == 2 || multi[i][j+1][1] == 5 || multi[i][j+1][1] == 6 || multi[i][j+1][1] == 7) && multi[i][j][1] == 3){ 
                        if(multi[i][j+1][1] == 5){
                            objects[i][j+1].increaseHealthArrow();
                            attackShowLabel1.setText("Attack: "+objects[i][j+1].showAttack());
                            //System.out.println(objects[i][j+1].showAttack());
                        }
                        else{
                            objects[i][j+1].reduceHealthArrow();
                            attackShowLabel1.setText("Attack: "+objects[i][j+1].showAttack());
                        }
                        if(objects[i][j+1].showAttack() <= 0){
                            objects[i][j+1] = null;
                            villiansKilled++;
                            villiansKilledLabel.setText("Villians Killed: " + villiansKilled);
                            villiansPane.setVisible(false);
                            btn[i][j+1].setImage(g1);
                            multi[i][j+1][0] = 0;
                            multi[i][j+1][1] = 0;
                        }
                        else{
                            multi[i][j][1] = 0;
                            btn[i][j].setImage(g1);
                        }
                    }
                }
                
            }

        }
    }
    
    public void collisions(){ //This is used to change images as characters interact with each other
        for(int i = 0; i < multi.length; i++){
            for(int j = 0; j < multi[0].length; j++){
                if(multi[i][j][0] == 3 && (multi[i][j+1][0] == 2)){ //|| multi[i][j+1][0] == 1)){ //Might be out of range
                    if(objects[i][j+1] != null){
                        if(objects[i][j].showAttack() > objects[i][j+1].showAttack()){ //This is for when the user's characters are more powerful than the villian's attack power
                            objects[i][j].reduceAttack(objects[i][j+1].showAttack()); //reduce the character's attack
                            attackShowLabel.setText("Attack: "+objects[i][j].showAttack());//show the amount of health left
                            btn[i][j+1].setImage(g1);
                            objects[i][j+1] = null; //villian object is now null                                                                                        
                            multi[i][j+1][1] = 0;
                            multi[i][j+1][0] = 1; 
                            villiansKilled++; //Increase the number of villians killed
                            villiansKilledLabel.setText("Villians Killed: " + villiansKilled);//display the number of villians killed
                            villiansPane.setVisible(false);
                        }
                        else if(objects[i][j].showAttack() == objects[i][j+1].showAttack()){ //This is when the attack power of the user and the power of the villian is the same
                            objects[i][j+1] = null;
                            attackShowLabel.setText("Attack: "+0);//Both objects have an attack of zero
                            healthLeftPane.setVisible(false);
                            multi[i][j+1][0] = 1;
                            multi[i][j][0] = 1;
                            btn[i][j+1].setImage(g1); //reset the images
                            btn[i][j].setImage(g1);
                            unitsKilled++; //Increase the amount of units killed
                            villiansKilled++; //increase the amount of villians killed
                            villiansKilledLabel.setText("Villians Killed: " + villiansKilled);//Display the amount of villians killed
                            unitsKilledLabel.setText("Units Killed: " + unitsKilled);//display the amount of units killed
                            villiansPane.setVisible(false);
                        }
                        else if(objects[i][j].showAttack() < objects[i][j+1].showAttack()){ //This is when the attack pwoer of the user is less than the attack power of the villian
                            //Try to fix this bug. If you place it at the same time, it doesn't work
                            objects[i][j+1].reduceAttack(objects[i][j].showAttack());//reduce the amount of health the villian has left
                            attackShowLabel.setText("Attack: "+0);//reduce your character attack to zero
                            healthLeftPane.setVisible(false);
                            objects[i][j] = null;
                            multi[i][j][0] = 1;
                            multi[i][j][1] = 0;
                            btn[i][j].setImage(g1);
                            unitsKilled++;//increase the amounts of units killed
                            unitsKilledLabel.setText("Units Killed: " + unitsKilled);//display the amount of untis killed
                            attackShowLabel1.setText("Attack: "+objects[i][j+1].showAttack());//show the amount of health left
                        }
                    }                    
                }
            }
        }

    }


  
    public void endGame(){ //This method should be used to end the game once the user runs our of health
        //Stop timer
        backgroundImage.setImage(startBackground);
        backgroundImage.setFitHeight(900);
        backgroundImage.setFitWidth(1900);
        gPane.setVisible(false);
        gPane.setGridLinesVisible(false);
        characterPane.setVisible(false);
        characterPane.setGridLinesVisible(false);
        itemPane.setVisible(false);
        waveChecker.setVisible(false);
        powerUpPane.setVisible(false);
        healthGridPane.setGridLinesVisible(false);
        healthLeftPane.setVisible(false);
        statsPane.setVisible(false);
        leftGridPane.setVisible(false);
        leftGridPane.setGridLinesVisible(false);
        gameStatsLabel.setVisible(false);
        villiansPane.setVisible(false);  
        gameResult.setVisible(true);        
        listView.setVisible(true);
        powerUpMenuBar.setVisible(false);
        button.setVisible(false);
        powerBar.setVisible(false);
        powerLabel.setText("");
        resetImages();  //reset the images of the board      
        playTime = true;
        insertSort();//insertion sort the data left
        resetImages2();//reset images 
        starter();//restart the game from the very beginning of the board
    }        
    
    //The Following setPowerUp methods (lines 1708 - 1716) are part of the menuButton press methods
    public void setPowerUp(){ //Pressed to powerup characters
        powerChosen = 1;
        powerLabel.setText("Increase Attack");
        incPower = 0;
    }
    public void setPowerUp1(){//Pressed to kill villians right away
        powerChosen = 2;
        powerLabel.setText("Instant Kill");
        incPower = 0;
    }
    public void setPowerUp2(){//Pressed to increase Manna
        powerChosen = 3;
        powerLabel.setText("Increase Manna");
        incPower = 0;
    }
    public void findPosition(int r1, int c1){
        if(powerChosen == 1){ //If they want to increase attack power of heroes
            if(multi[r1][c1][0] == 3){
                PowerUps power = new PowerUps(objects[r1][c1].showAttack());
                power.increaseAttackPower();
                objects[r1][c1].changeAttack(power.showNewAttack());
                attackShowLabel.setText("Attack: "+objects[r1][c1].showAttack());
            }
            powerChosen = 0;
        }
        else if(powerChosen == 2){ //If you want to kill a villian instantly
            if(multi[r1][c1][0] == 2){
                objects[r1][c1] = null;
                btn[r1][c1].setImage(g1);
                multi[r1][c1][1] = 0;
                multi[r1][c1][0] = 0; 
                villiansPane.setVisible(false);
                villiansKilled++; //Increase the number of villians killed
                villiansKilledLabel.setText("Villians Killed: " + villiansKilled);//display the number of villians killed
            }
            powerChosen = 0;
        }
    }
    public void mannaIncreaser(){
        if(powerChosen == 3){
            tracker.mannaUp();
            powerChosen = 0;
        }
        
    }
    public void resetImages2(){//Reset the original images that were set up
        for(int i =0; i < selectionBtn.length; i++){ //set the selction images to null
            for(int j =0; j < selectionBtn[0].length; j++){
               selectionBtn[i][j].setImage(null); 
            }
        }
        for(int i = 0; i < tempVillians.length; i++){ //set the objects to null
            for(int j = 0; j <tempVillians[0].length; j++){
                tempVillians[i][j] = null;
            }
        }
        map1.setImage(null); //map is null
        map2.setImage(null); //map is null
        chosenMap = 0; //chosen map is zero
        c1 = knight;
        c2 = archer;
        c3 = castle;
        c4 = dragon; 
        g1 = grass; 
        a1 = arrow;
        v1 = zombie;
        t1 = tree; 
        v2 = ghost;
        v3 = evilDragon;
        v4 = darkKnight;
        
    }
    
    
    
    public void insertSort(){ //This method sorts the list and displays the top ten
        //This method first sorts by winner and loser
        //Then, it sorts by the wave number
        boolean winnerExists = false;
        boolean loserExists = false;
        boolean foundI = false;        
        list.add(new Person(playerName,waveNum,winOrLose, villiansKilled));//player name, wave number, if you won or lost, and the number of villians killed
        for(int i = 0; i < list.size(); i++){//First, go and check to see if the user won or lost
            //Based on string length
            //Winner = length of 6
            //loser = length of 5
            int temp2 = list.get(i).showStringLength();
            String temp3 = list.get(i).nameShow();
            String temp4 = list.get(i).showGameResult();
            int temp7 = list.get(i).scoreShow();
            int temp8 = list.get(i).showKilled();
            int z=i;
            //I made it less than now
            while(z>0 && list.get(z-1).showStringLength()<temp2){
                list.get(z).changer(list.get(z-1).nameShow(), list.get(z-1).showGameResult(), list.get(z-1).scoreShow(), list.get(z-1).showKilled());
                z--;
            }
            list.get(z).changer(temp3,temp4, temp7, temp8);
        }
        
        for(int i = 0; i < list.size(); i++){ //Now, you look to see if a loser exist in the list
            if(list.get(i).showGameResult().equals("Loser")){
                loserExists = true;
            }
        }
        for(int i = 0; i < list.size(); i++){ //used to check if a winner exists in teh program
            if(list.get(i).showGameResult().equals("Winner")){
                winnerExists = true;
            }
        }
        if(loserExists && winnerExists){ //If it is sorted by losers AND winners
            int index = 0;
            int i =0;
            while(!foundI){
                if(list.get(i).showGameResult().equals("Loser")){ //find the index of where the loser starts
                    index = i;
                    foundI = true;
                }  
                else{
                    i++;
                }
            }
            for(int j = 1;j < index; j++){ //sort from the loser first, then begin to sort loser and winner
                int temp = list.get(j).scoreShow();
                String temp2 = list.get(j).nameShow();
                int killed1 = list.get(j).showKilled();
                int z=j;
                //I made it less than now
                while(z>0 && list.get(z-1).scoreShow()<temp){
                    
                    list.get(z).changer1(list.get(z-1).nameShow(), list.get(z-1).scoreShow(), list.get(z-1).showKilled());
                    z--;
                }
                list.get(z).changer1(temp2,temp, killed1);
            }            

            
                
        }
        else if((!winnerExists && loserExists) || (winnerExists && !loserExists)){ //if only a winner or only a loser exists
            for(int j = 1;j < list.size();j++){
                int temp = list.get(j).scoreShow();
                String temp2 = list.get(j).nameShow();
                int killed2 =  list.get(j).showKilled();
                int z=j;
                //I made it less than now
                while(z>0 && list.get(z-1).scoreShow()<temp){
                    list.get(z).changer1(list.get(z-1).nameShow(), list.get(z-1).scoreShow(),list.get(z-1).showKilled());
                    z--;
                }
                list.get(z).changer1(temp2,temp,killed2);
            }
            if(winnerExists){ //if a winner exists
                for(int j = 1;j < list.size();j++){
                    String temp2 = list.get(j).nameShow();
                    int killed2 =  list.get(j).showKilled();
                    int z=j;
                    //I made it less than now
                    while(z>0 && list.get(z-1).showKilled()<killed2){
                        list.get(z).changer2(list.get(z-1).nameShow(), list.get(z-1).showKilled());
                        z--;
                    }
                    list.get(z).changer2(temp2,killed2);
                }
            }
            else if(loserExists){//if a loser exists
                for(int j = 1;j < list.size();j++){
                    String temp2 = list.get(j).nameShow();
                    int killed2 =  list.get(j).showKilled();
                    int z=j;
                    //I made it less than now
                    while(z>0 && list.get(z-1).showKilled()<killed2){
                        list.get(z).changer2(list.get(z-1).nameShow(), list.get(z-1).showKilled());
                        z--;
                    }
                    list.get(z).changer2(temp2,killed2);
                }
                
                
            }

        }

        displayList.clear();
        topScores.clear();
        classSaver.clear();
        for(int i = 0; i < list.size();  i++){
            if(i < 10){ //display the top ten
                String getter = ("Name: " + list.get(i).nameShow() + "| Result: " + list.get(i).showGameResult()+"| Wave: " + list.get(i).scoreShow()+ "| Killed: " + list.get(i).showKilled());
                String classy = list.get(i).nameShow() + "," + list.get(i).scoreShow() + "|" + list.get(i).showGameResult() + "#"+list.get(i).showKilled();
                topScores.add(getter);
                classSaver.add(classy);
                displayList.add(getter);
            }
            
        }
        addList2();
        addList();        
        winOrLose = "";
        waveNum = 1;
        villiansKilled = 0;
    }
    @FXML
    private void handleKeyPress(KeyEvent event)
    {
        //cheat codes for the project
        if (event.getCode() == KeyCode.A){ //used to allow the user to win the game
            winOrLose = "Winner";
            waveNum = 4;
            endGame();
            gameResult.setText("You Win!");
        }
        if (event.getCode() == KeyCode.B){ //used progress to second round
           waveNum = 2;
           zombieLimit = 20;
           waveChecker.setProgress(0);
        }
        if (event.getCode() == KeyCode.C){ //used to progress to third round
            waveNum = 3;
            zombieLimit = 30;
            waveChecker.setProgress(0);
        }
        if (event.getCode() == KeyCode.D){ //used to progress to fourth round
            //waveNum = 4;
            zombieLimit = 40;
            waveChecker.setProgress(0);
        }
        if (event.getCode() == KeyCode.E){ //used to make user lose in round 4
            winOrLose = "Loser";
            waveNum = 4;
            endGame();
            gameResult.setText("You lost...");
            
        }
        if (event.getCode() == KeyCode.F){ //used to make user lose in round 3
            winOrLose = "Loser";
            waveNum = 3;
            endGame();
            gameResult.setText("You lost...");
            
        }
        if (event.getCode() == KeyCode.G){ //used to make uesr lose in round 2
            winOrLose = "Loser";
            waveNum = 2;
            endGame();
            gameResult.setText("You lost...");
            
        }
        if (event.getCode() == KeyCode.H){ //used to make user lose in round 1
            winOrLose = "Loser";
            waveNum = 1;
            endGame();
            gameResult.setText("You lost...");
        }
        if (event.getCode() == KeyCode.I){ //used to make user lose in round 1
            waveNum = 3;
            zombieLimit = 0;
            numberOfVillians1 = 0;
        }
    
    }
    private boolean flipper = true;
    public void showQuestion(){
    //This method is the button that allows the user to press question button for help if they ever need it
        textArea.setVisible(flipper);
        if(flipper){ //These if statements help me to flip between on and off whenever I need it 
           flipper = false; 
        }
        else{
            flipper = true;
        }
    }
   
        
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Used to display or keep invisible certain images that I do not want shown when the game initially starts
        waveChecker.setVisible(false);
        gameStatsLabel.setVisible(false);
        leftGridPane.setVisible(false);
        backgroundImage.setImage(startBackground);
        backgroundImage.setFitHeight(900);
        backgroundImage.setFitWidth(1900);
        button.setVisible(false);
        startButton.setTranslateY(300);
        startButton.setTranslateX(500);
        questionButton.setTranslateX(850);
        questionButton.setTranslateY(600);        
        nameTextField.setTranslateY(-205);
        nameTextField.setTranslateX(430);
        gameResult.setTranslateY(-270);
        gameResult.setTranslateX(200);
        listView.setVisible(false);
        listView.setTranslateX(200);
        listView.setTranslateY(0);
        //////////////////////////////////////////
        mapSelection.setVisible(false);
        characterGridPane.setVisible(false);
        powerUpMenuBar.setVisible(false);
        powerUpMenuBar.setTranslateX(-400);
        button.setVisible(false);
        powerBar.setVisible(false);
        powerBar.setTranslateY(25);
        textArea.setTranslateY(30);
        textArea.setTranslateX(500); 
        textArea.setText("Welcome to Kingdom Battle! Press\nme whenever you have questions.\n\nStart off by entering your name,\nand then pressing the button.");
        textArea.setVisible(false);
    }    
    
}
