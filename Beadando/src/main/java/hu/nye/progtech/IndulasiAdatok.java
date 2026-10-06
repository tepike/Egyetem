package hu.nye.progtech;

import java.util.Scanner;

//Package default encapsulation
 class IndulasiAdatok {
    String jatekos1;
    String jatekos2;
     void mennyiJatekos(){
         System.out.println("Adja meg a jatekosok szamat: (1 | 2)");
         int jatekosok= new Scanner(System.in).nextInt();
         if(jatekosok<1||jatekosok>2){
             throw new IllegalArgumentException("Ez mégis mi?");
         }
         switch (jatekosok){
             case 1:
                 jatekos1="Player1";
                 jatekos2="Player2";
                 System.out.println("Jatekosok: "+jatekos1 + "| " + jatekos2);
                 break;
             case 2:
                 jatekos1="Player1";
                 jatekos2="CPU";
                 System.out.println("Jatekosok: "+jatekos1 + "| " + jatekos2);
                 break;
             default:
                 break;
         }
     }



 }
