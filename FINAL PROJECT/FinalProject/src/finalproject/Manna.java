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
public class Manna {
    //Used to calculate the amount of manna you are using for the game
    private int mannaAmount = 0;
    public Manna(int n1){//parameter is the manna amount
        mannaAmount = n1;
    }
    public int showManna(){//return the current amount of manna
        return mannaAmount;
    }
    public void increaseManna(){//Used to increase the amount of manna
        mannaAmount += 10;
    }
    public void mannaUp(){//Used to increase the manna through a powerup
        mannaAmount += 100;
    }
    public void subtractManna(int n1){//Used to subtract manna each time you purchase a chaarcter
        mannaAmount = mannaAmount - n1;
    }
    public void restartManna(){//Used to restart the game
        mannaAmount = 200;
    }
}
