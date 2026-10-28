package hu.nye.progtech.engine;

import hu.nye.progtech.model.MapVO;

import java.util.List;

public class JatekMezo {
    /*
        Player1:(1) \u1f683 -> \uD83D\uDE83    🚃
        PLayer2:(2) \u1F68B -> \uD83D\uDE8B    🚋
        Akadály:(3) \u1F6A7 -> \uD83D\uDEA7    🚧
        Fal:(0)     \u26D4  -> \u26D4          ⛔
        Üres:(4)    U+1F536 -> \uD83D\uDD36    🔶
        Kijárat:(9) //Ha a mátrix értéke az utolsó sornál vagy (0,0) (1,0) (2,0)-nál 9 akkor előtte vagy ha jobb oldali akkor utána kijárat van!

     */

    public void printMap(MapVO mapVO){
        List<String>map = mapVO.mapDataToList();
        int sor=mapVO.getNumberOfRows(); //12
        int oszlop=mapVO.getNumberOfColumns(); //6
        String [] modells={"\u26D4","\uD83D\uDE83","\uD83D\uDE8B","\uD83D\uDEA7","\uD83D\uDD36"};
        String [] positionHorizontal={"A","B","C","D","E","F","G","H","I","J","K","L"};
        String [] positionVertical={"1","2","3","4","5","6"};
        for(String index:positionHorizontal){
            System.out.print("\t "+index+" ");
        }
        for(int i=0;i<oszlop;i++){
            System.out.print("\n"+positionVertical[i]+"\t");
            for(int j=0;j<sor;j++){
                if(i==0){ //System.out.print("\uD83D\uDE83"+" ");
                    System.out.print(modells[Integer.parseInt(map.get(j))]+"\t");
                }
                else System.out.print(modells[Integer.parseInt(map.get(i*sor+j))]+"\t");
            }
        }
        System.out.println("\n");

    }



    }
