package hu.nye.progtech.engine;

import java.util.Scanner;

public class Players {

    private static String name;

    public Players(String name){
        this.name = name;
    }

    public static String getName() {
        return name;
    }

    public void setPlayerVersusPlayers(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Adja meg a jatekosok nevet\nPlayer1: ");

        String name=scanner.next();
        Players Player1=new Players(name);

        System.out.println("Player2: ");
        name=scanner.next();
        Players Player2=new Players(name);

    }

    public void setPlayerVersusComputer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Adja meg a jatekosok nevet\nPlayer1: ");

        String name=scanner.next();
        Players Player1=new Players(name);

        Players Player2=new Players("CPU");

    }

}
