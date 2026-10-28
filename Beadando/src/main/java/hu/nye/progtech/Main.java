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


         MapVO defaultMap = new MapVO();

         JatekMezo jatekMezo = new JatekMezo();
         jatekMezo.printMap(defaultMap);



         Cars Car1=new Cars(true,0);
         Cars Car2=new Cars(false,0);
         Car1.setJarmuPozicio(0,0);
         Car2.setJarmuPozicio(1,1,1,2);




    }
}