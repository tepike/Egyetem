package hu.nye.progtech.commands;

import java.util.Scanner;

public class MenuCommands {
    static boolean jatekMod=false;
    static boolean jatekosok = false;

    static int errorNumbers=0;
    public void availableCommands(){
        System.out.println("Jatek inditas (Start)");
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
               System.out.println("Starting Jatek");
               break;
           case "load":
               System.out.println("Loading Jatek");
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
