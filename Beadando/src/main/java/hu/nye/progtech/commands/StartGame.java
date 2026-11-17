package hu.nye.progtech.commands;

import hu.nye.progtech.engine.JatekMezo;
import hu.nye.progtech.engine.Menu;
import hu.nye.progtech.map.MapVO;

import java.util.Locale;
import java.util.Scanner;

public class StartGame extends InGameCommands{

    public void StartGame(){
        System.out.println("Game Started");
        new JatekMezo();
        while(isRuning()){
            System.out.print("Mit szeretnél?\nBevitel:");
            String bevitel= new Scanner(System.in).nextLine();
            System.out.println("Bevitel: " + bevitel);
            if(bevitel.toLowerCase().equals("exit")){
                stopRuning();
                new Menu().menuLogin();
            }

        }
    }

}
