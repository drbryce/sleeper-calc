/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author designstation1
 */
public class SleeperCalcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Sleeper> sleeperList = new ArrayList();
        ArrayList<Dread> dreadList = new ArrayList();
        int[] distanceArray = {12000, 10000, 9000, 8000, 7000, 6000, 5000, 4000};
        
    /*  dreadList.add(new Dread(16778,3,488,28900,25000,"Revelation"));  base numbers
        dreadList.add(new Dread(22808,2,390,20500,50700,"Naglfar"));
        dreadList.add(new Dread(22650,3,439,14400,31300,"Moros"));   
    */
        
        dreadList.add(new Dread(16778,3,488,28900,25000,"Revelation"));
        dreadList.add(new Dread(22808,2,390,20500,50700,"Naglfar"));
        dreadList.add(new Dread(22650,3,439,15800,37500,"Moros"));

        
        while(dreadList.size() > 0){
            int seconds = 0;
            int lastVolleySecs = 0;
            int kills = 0;
            int wastedTimeSecs = 0;
            boolean wasteTime = false;
            int wasteTimeAmount = 100;

            System.out.println(dreadList.get(0).name);
            sleeperList = generateWave(distanceArray);
            
            while(sleeperList.size() > 0){
                int volley = 0;
                
                for (int z = 0; z < dreadList.get(0).guns.size(); z++){
                    if (dreadList.get(0).guns.get(z).lastVolleySecs >= dreadList.get(0).guns.get(z).rof && wasteTime == false){
                        if (sleeperList.size() == 0) break;
                        
                        volley = dreadList.get(0).shoot(sleeperList.get(0).distance);
                
                        //System.out.println("Volley for: " + volley + "   Distance: " + sleeperList.get(0).distance);
                        sleeperList.get(0).ehp -= volley;
                    
                        dreadList.get(0).guns.get(z).lastVolleySecs = 0;
                        if (sleeperList.get(0).ehp <= 0) {
                            wasteTime = true;
                            kills++;
                            System.out.println("***** Killed #" + kills + " Distance: " + sleeperList.get(0).distance + " Time: " + seconds + " HP: " + sleeperList.get(0).ehp + " *****");
                            sleeperList.remove(0);
                        }
                    }
                
                if (wasteTime) wastedTimeSecs++;
                if (wastedTimeSecs >= wasteTimeAmount) wasteTime = false;
                dreadList.get(0).guns.get(z).lastVolleySecs++;
                }
                for (int y = 0; y < sleeperList.size(); y++){
                    sleeperList.get(y).distance += sleeperList.get(y).speed / 100;
                }
                seconds++;
            }
            
            dreadList.remove(0);
        
        }
    }
    
    public static ArrayList generateWave(int[] distanceArray){
        ArrayList<Sleeper> tempArrayList = new ArrayList();
        for (int x : distanceArray){
            tempArrayList.add(new Sleeper(x));
        }
        return tempArrayList;
    }
    
}
