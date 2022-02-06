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
public class Characters {
    private String type = ""; //type
    private int mannaCost = 0; //cost of character
    private int attackPower = 0; //power of the character
    public Characters(String n1, int n2, int n3){
        //Parameters are the type of character, the cost of the character, and the attack power
        type = n1;
        mannaCost = n2;
        attackPower = n3;
    }
    public Characters(Characters n1){ //This constructor is used to copy an object.
        //I needed to copy an object, because I orginally have 4 main object for each caharcter or villian, and I set these objects equal to a caharcter each time they are formed.
        //This allows me to create new objects instead of my objects being pointed to the orignal object.
        type = n1.showType();
        mannaCost = n1.showCost();
        attackPower = n1.showAttack();
    }
    public int showCost(){ //Returns the cost of the character
        return mannaCost;
    }
    public String showType(){//returns the type of the object
        return type;
    }
    public int showAttack(){//returns the attack power of the object
        return attackPower;
    }
    public void reduceAttack(int n1){//Reduces the attack of the character when it collides with another object
        attackPower -=n1;
    }
    public void reduceHealthArrow(){ //Used to subtract attack each time the object shoots an arrow
        attackPower -=25;
    }
    public void increaseHealthArrow(){//Used to increase the health of a ghost each time they are attack by an projectile
        attackPower +=25;
    }
    public void increaseHealth(){//Increase the health of a character
        attackPower +=10;
    }
    public void changeAttack(int n1){//change the attack power of a character
        attackPower = n1;//This method is used for powerups
    }
    public void changeCost(int n1){//change the cost of a character
        mannaCost = n1;//This method is used for powerups
    }
}
