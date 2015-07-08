package javaapplication1;

import static java.lang.Math.pow;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author designstation1
 */
public class Dread {
    
    public double optimal;
    public double fallOff;
    public String name;
    public int turrets;
    public ArrayList<Gun> guns;
    
    
    public Dread(int volley,int turrets, int fireRate, double optimal, double fallOff, String name){

        this.optimal = optimal;
        this.fallOff = fallOff;
        this.name = name;
        this.turrets = turrets;
        
        guns = new ArrayList();
        for (int x = 0; x < turrets ; x++){ guns.add(new Gun(volley,fireRate));}
        
    }
    
    public int shoot(double distance){
        
        
        double damage = 0;
        double damMult;
        double rawDam;
        
        double funcMax = (distance - optimal);
        if (funcMax < 0) funcMax = 0;
        else funcMax = funcMax / fallOff;
        funcMax = pow(funcMax,2);
        
        
        double chanceToHit = pow(0.5,funcMax);  
        double randNum = Math.random();
        
        if (randNum > chanceToHit) {
            damage = 0;
            //System.out.println("MISS: chanceToHit: " + chanceToHit + "   randNum: " + randNum);
        }
        else {
            if (randNum < 0.01) damage = guns.get(0).baseDam * 3; //wrecking shot
            else {
                damMult = randNum + .49;
                damage = damMult * guns.get(0).baseDam;
                
                
                
            }
            
            
            
        }
        
        return (int) damage;
    }
    
}
