package hu.nye.progtech.model;

import java.util.Scanner;

public class Players {

    public static String Player1;
    public static String Player2;

    public Players(String name){
        name = name;
    }

    public void setPlayerVersusPlayer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Adja meg a jatekosok nevet\nPlayer1: ");

        String name=scanner.next();
        Player1=name;

        System.out.println("Player2: ");
        name=scanner.next();
        Player2=name;

    }

    public void setPlayerVersusComputer(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Adja meg a jatekosok nevet\nPlayer1: ");

        Player1= scanner.next();
        Player2="CPU";

    }

}
