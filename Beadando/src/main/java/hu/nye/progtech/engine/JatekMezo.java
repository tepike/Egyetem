package hu.nye.progtech.engine;

import hu.nye.progtech.model.MapVO;

import java.util.List;

public class JatekMezo {

    public void printMap(MapVO mapVO){
        int [][] matrix=mapVO.getMap();
        List<String>map = mapVO.mapDataToList();
        int sor=mapVO.getNumberOfRows(); //12
        int oszlop=mapVO.getNumberOfColumns(); //6
        for(int i=0;i<oszlop;i++){
            System.out.println(" ");
            for(int j=0;j<sor;j++){
                if(i==0)System.out.print(map.get(j)+" ");
                else System.out.print(map.get(i*sor+j)+" ");
            }
        }
        System.out.println("\n");

    }



    }
