package hu.nye.progtech.commands;

import hu.nye.progtech.engine.JatekMezo;
import hu.nye.progtech.engine.Menu;
import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Barrier;
import hu.nye.progtech.model.GameObjects;
import hu.nye.progtech.model.ObjectList;

import java.util.*;

import static hu.nye.progtech.model.Barrier.getBariersFromMap;

public class StartGame extends InGameCommands{
    public String[]commands={"Mozgat","Kilép"};

    public void StartGame(){
        System.out.println("Game Started");
        new JatekMezo().printMap(new MapVO(MapVO.mapName));
        Barrier barrier;
        Barrier.getBariersFromMap(new MapVO(MapVO.mapName));

        while(isRuning()){
            System.out.print("Mit szeretnél?\nBevitel:");
            String bevitel= new Scanner(System.in).nextLine().toLowerCase();
            System.out.println("Bevitel: " + bevitel);
            if(bevitel.equals("kilép")){
                stopRuning();
                new Menu().menuLogin();
            }
            if(bevitel.equals("mozgat")){
                new InGameCommands().mozgat();

            }

        }
    }

}
