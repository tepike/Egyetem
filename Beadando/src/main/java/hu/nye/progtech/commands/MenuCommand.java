package hu.nye.progtech.commands;

import hu.nye.progtech.engine.LocateSaveFolder;
import hu.nye.progtech.map.MapVO;

import java.util.Map;
import java.util.Scanner;

public class MenuCommand {
    MapVO map=new MapVO();
    static boolean jatekMod=false;
    static boolean jatekosok = false;

    static int errorNumbers=0;
    public void availableCommands(){
        System.out.println("Jatek inditas: "+ map.getMapName()+" (Start)");
        System.out.println("Jatek betoltes (load)");
        System.out.println("Jatekos modok (Modes)"); //PvP PvCpu
        System.out.println("Nev megadas (Names)");  //Jatekos nev felvetel
        System.out.println("Kilepes (Exit)");
        checkCommands();
    }

    public void checkCommands(){
        if(errorNumbers==3){System.out.print("\nJatekos modok (Mode)\nNev megadas (Names)\nKilepes (Exit)\n");errorNumbers=0;}
        System.out.print("Muvelet: ");
        Scanner Scanner = new Scanner(System.in);
        String command = Scanner.next().toLowerCase();

       switch(command){
           case "start":
               System.out.println("Betölteni kivánt pálya: ");
               //StartGame();
               break;
           case "load":
               new LoadGame().LoadGame();
               //StartGame();
               break;
           case "modes":
               System.out.println("Mode");
               break;
           case "names":
               System.out.println("Names");
               break;
           case "exit":
               System.out.println("Exit");
               System.exit(0);
               break;
           default:
               errorNumbers++;
               System.out.println("\nIsmeretlen parancs!");
               checkCommands();
           break;

       }
    }
}
