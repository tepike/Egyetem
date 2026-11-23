package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Cars;
import hu.nye.progtech.model.GameObjects;

import java.util.List;

import static hu.nye.progtech.model.Cars.*;

public class JatekMezo {
    /*
        Player1:(1) \u1f683 -> \uD83D\uDE83    🚃
        PLayer2:(2) \u1F68B -> \uD83D\uDE8B    🚋
        Akadály:(3) \u1F6A7 -> \uD83D\uDEA7    🚧
        Fal:(0)     \u26D4  -> \u26D4          ⛔
        Üres:(4)    U+1F536 -> \uD83D\uDD36    🔶
        Kijárat:(9) U+2705 ->   \u2705         ✅//Ha a mátrix értéke az utolsó sornál vagy (0,0) (1,0) (2,0)-nál 9 akkor előtte vagy ha jobb oldali akkor utána kijárat van!

     */
    public static String [] modells={"\u26D4","\uD83D\uDE83","\uD83D\uDE8B","\uD83D\uDEA7","\uD83D\uDD36"};
    public static String [] positionHorizontal={"A","B","C","D","E","F","G","H","I","J","K","L"};
    public static String [] positionVertical={"1","2","3","4","5","6"};

    public void printMap(MapVO mapVO){
        String[][] map =mapVO.getMap();
        int player1ExitX=Cars.Player1Car.getCarExitX();
        int player1ExitY=Cars.Player1Car.getCarExitY();
        int player2ExitY=Cars.Player2Car.getCarExitY();
        int sor=mapVO.getNumberOfRows();
        int oszlop=mapVO.getNumberOfColumns();

        for(String index:positionHorizontal){
            if(index.equals(positionHorizontal[0])) System.out.print("\t");
            System.out.print("\t "+index+" ");
        }

        for(int i=0;i<oszlop;i++){
            System.out.print("\n"+positionVertical[i]+"\t");
            for(int j=0;j<sor;j++){

                //Kijárat rajzolása
                if(j == 0 && j == player1ExitX){
                    if(player1ExitY==i)System.out.print("\u2705"+"\t");
                    else System.out.print("\u26D4"+"\t");
                }

                if(map[i][j].equals("v")||map[i][j].equals("h")){
                    System.out.print(modells[3] + "\t");
                }else{
                    System.out.print(modells[Integer.parseInt(map[i][j])] + "\t");
                }


                //Kijárat rajzolása
                if(j == 11){
                    if(player2ExitY==i)System.out.print("\u2705"+"\t");
                    else System.out.print("\u26D4"+"\t");
                }

            }
        }
        System.out.println("\n");

    }




}
