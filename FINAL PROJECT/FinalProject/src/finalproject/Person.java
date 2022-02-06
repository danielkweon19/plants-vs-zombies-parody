/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Danie
 */
public class Person {
    //Used to store the stats of the player
    private String name; //player name
    private int score; //the wave the player made it yo
    private String gameResult = "";//the result of the game
    private int villiansKilled = 0;//how many villians they killed
    public Person(String n1, int n2, String n3, int n4){
        name = n1;//Name
        score = n2;//wave
        gameResult = n3;//win or lose
        villiansKilled = n4;//Killed villians
    }
    public String nameShow(){//return player names
        return name;
    }
    public int scoreShow(){//return player wave score
        return score;
    }
   
    public String showGameResult(){//return if they won or lost
        return gameResult;
    }
    public int showStringLength(){//return the length of the string that tells them if they won or lost
        //important for sorting. Winner is longer than loser, and this sorts by string length
        return gameResult.length();
    }
    public int showKilled(){//return number of villians killed
        return villiansKilled;
    }
    //Lines 42-58 are the methods I used to sort
    public void changer(String n1, String n2, int n3, int n4){
        name = n1;
        gameResult = n2;
        score = n3;
        villiansKilled = n4;
    }
    public void changer1(String n1, int n2, int n3){
        name = n1;
        score = n2;
        villiansKilled = n3;
    }
    public void changer2(String n1, int n2){
        name = n1;
        villiansKilled = n2;
    }
}
