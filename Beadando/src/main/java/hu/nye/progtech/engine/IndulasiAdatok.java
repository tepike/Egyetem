package hu.nye.progtech.engine;

import java.util.Scanner;

//Package default encapsulation
class IndulasiAdatok {
    String player1;
    String player2;
     void mennyiJatekos(){
         System.out.println("Adja meg a jatekosok szamat: (1 | 2)");
         int jatekosok= new Scanner(System.in).nextInt();
         if(jatekosok<1||jatekosok>2){
             throw new IllegalArgumentException("Ez mégis mi?");
         }
         switch (jatekosok){
             case 1:
                 player1="Player1";
                 player2="CPU";
                 System.out.println("Jatekosok: "+player1 + " | " + player2);
                 break;
             case 2:
                 player1="Player1";
                 player2="player2";
                 System.out.println("Jatekosok: "+player1 + " | " + player2);
                 break;
             default:
                 break;
         }
     }



 }
