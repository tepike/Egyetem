package hu.nye.progtech.commands;

import hu.nye.progtech.engine.JatekMezo;
import hu.nye.progtech.engine.Menu;
import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Barrier;
import hu.nye.progtech.model.GameObjects;
import hu.nye.progtech.model.ObjectList;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import static hu.nye.progtech.model.Barrier.getBariersFromMap;

public class StartGame extends InGameCommands{

    public void StartGame(){
        System.out.println("Game Started");
        new JatekMezo().printMap(new MapVO(MapVO.mapName));
        Barrier barrier = new Barrier();
        Barrier.getBariersFromMap(new MapVO(MapVO.mapName));

        while(isRuning()){
            System.out.print("Mit szeretnél?\nBevitel:");
            String bevitel= new Scanner(System.in).nextLine().toLowerCase();
            System.out.println("Bevitel: " + bevitel);
            if(bevitel.equals("exit")){
                stopRuning();
                new Menu().menuLogin();
            }
            if(bevitel.equals("mozgat")){
                System.out.println("X koordinata");
                int x=new Scanner(System.in).nextInt();
                System.out.println("Y koordinata");
                int y=new Scanner(System.in).nextInt();
                GameObjects found = ObjectList.findObjectAt(x,y);
                System.out.println(found);

            }

        }
    }

}
