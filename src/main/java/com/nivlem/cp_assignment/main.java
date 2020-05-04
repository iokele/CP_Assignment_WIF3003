/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nivlem.cp_assignment;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author melvi
 */
public class main {
    public static ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
    public static int n = 10000;
    public static int t = 1;
    public static int m = 10;
            
    public static void main(String[] args) {
//        UI ui = new UI();
//        ui.paint();
        Timer tm = new Timer();
        tm.start();
        coordinates = createRandomCoordinates(n);
        System.out.println(coordinates);
        LogicMain lM = new LogicMain(t, m, n, coordinates);
        ArrayList edge = lM.runLogic();
        System.out.println(edge);
//        UILogic ul = new UILogic(edge,t);
        UI ui = new UI(edge);
        tm.finish();
//        System.out.println(lM.getEdges());
        System.out.println("Total Length:"+lM.getEdgesLength());
        System.out.println("Time Taken: "+(float)tm.timeTaken()/1000+ " seconds");
    }
    
    public static ArrayList<Coordinate> createRandomCoordinates(int n) {
        ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
        while(temp.size() != n) {
            Random rand = new Random();
            float x = rand.nextInt(1000);
            float y = rand.nextInt(1000);
            Coordinate tempC = new Coordinate(x,y);
            if(!tempC.isExist(temp)) temp.add(tempC);
        }
        return temp;
    }
}
