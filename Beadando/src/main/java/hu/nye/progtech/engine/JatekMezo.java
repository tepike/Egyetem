package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Cars;

import java.util.List;

public class JatekMezo {
    /*
        Player1:(1) \u1f683 -> \uD83D\uDE83    🚃
        PLayer2:(2) \u1F68B -> \uD83D\uDE8B    🚋
        Akadály:(3) \u1F6A7 -> \uD83D\uDEA7    🚧
        Fal:(0)     \u26D4  -> \u26D4          ⛔
        Üres:(4)    U+1F536 -> \uD83D\uDD36    🔶
        Kijárat:(9) U+2705 ->   \u2705         ✅//Ha a mátrix értéke az utolsó sornál vagy (0,0) (1,0) (2,0)-nál 9 akkor előtte vagy ha jobb oldali akkor utána kijárat van!

     */
    static boolean haveExit=false;

    public void printMap(MapVO mapVO){
        List<String>map = mapVO.mapDataToList();
        int sor=mapVO.getNumberOfRows(); //12
        int oszlop=mapVO.getNumberOfColumns(); //6
        String [] modells={"\u26D4","\uD83D\uDE83","\uD83D\uDE8B","\uD83D\uDEA7","\uD83D\uDD36"};
        String [] positionHorizontal={"A","B","C","D","E","F","G","H","I","J","K","L"};
        String [] positionVertical={"1","2","3","4","5","6"};
        for(String index:positionHorizontal){
            if(index.equals(positionHorizontal[0])) System.out.print("\t");
            System.out.print("\t "+index+" ");
        }
        for(int i=0;i<oszlop;i++){
            System.out.print("\n"+positionVertical[i]+"\t");
            for(int j=0;j<sor;j++){
                // exit={{0,0},{11,1}}; ha az elején lévő x = j-vel és i=y-al akkor
                //exit={{j,i},{j,i}};
                //Cars.exit[0][0]== x
                //Cars.exit[0][1]== y
                //System.out.print("\u2705"+"\t");



                if(j==0 && Cars.getExit()[0][0]==j){
                    if(Cars.getExit()[0][1]==i)System.out.print("\u2705"+"\t");
                    else System.out.print("\u26D4"+"\t");
                }

                if(i==0){
                    System.out.print(modells[Integer.parseInt(map.get(j))]+"\t");
                }
                else System.out.print(modells[Integer.parseInt(map.get(i*sor+j))]+"\t");

                if(j==11 && Cars.getExit()[1][0]==j){
                    if(Cars.getExit()[1][1]==i)System.out.print("\u2705"+"\t");
                    else System.out.print("\u26D4"+"\t");
                }

            }
        }
        System.out.println("\n");

    }



    }
