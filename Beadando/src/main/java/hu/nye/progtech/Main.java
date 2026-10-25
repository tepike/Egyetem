package hu.nye.progtech;



import hu.nye.progtech.engine.*;
import hu.nye.progtech.model.MapVO;

import java.io.*;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
         new Menu().menuLogin();
         //new MapVO().setMapSize("Beadando/src/main/resources/map/default.txt");
         new MapVO().setMapFromFile("default.txt");


         //System.err.println("Random szam generalva: "+new RandomLepes().randomSzam());

         JatekMezo JatekMezo=new JatekMezo();
         JatekMezo.JatekMezo();

         Cars Car1=new Cars(true,0);
         Cars Car2=new Cars(false,0);
         Car1.setJarmuPozicio(0,0);
         Car2.setJarmuPozicio(1,1,1,2);

         System.out.println("Car 1 pozicioja [0][0]-n: "+Car1.getJarmuPozicio()[0][0]);
         System.out.println("Matrix merete: "+Car1.getJarmuPozicio().length);
         System.out.println("Auto merete: "+Car1.getMeret());
         System.out.println("\n");


    }
}