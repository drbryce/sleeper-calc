/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author designstation1
 */
public class Gun {
    int baseDam;
    int rof;
    int lastVolleySecs = 0;
    
    public Gun(int baseDam, int rof){
        this.baseDam = baseDam;
        this.rof = rof;
    }
}
