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
public class PowerUps {
    //This is the power up class
    private int attackPower = 0;
    private int mannaCost = 0;
    private String name = "";
    public PowerUps(int n1){ //Used to increase the attack power through power ups
        attackPower = n1;
    }
    public PowerUps(String n1, int n2){//Used to increase your manna
        name = n1;
        mannaCost = n2;
    }
    public void increaseAttackPower(){//Increases the attack power
        attackPower += 50;
    }
    public int showNewAttack(){//returns the new attack power
        return attackPower;
    }
    public void reduceCost(){//lowers the cost of manna
        mannaCost -=50;
    }
    public int showNewCost(){//returns the new manna cost
        return mannaCost;
    }
}
