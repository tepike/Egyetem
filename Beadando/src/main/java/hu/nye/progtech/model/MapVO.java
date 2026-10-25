package hu.nye.progtech.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapVO {
    private int numberOfRows;
    private int numberOfColumns;
    private int [][] map;
    private boolean[][] occupiedArea;
    private List<String> mapData= new ArrayList<String>();

/*
    public MapVO(int numberOfRows, int numberOfColumns, int [][] map, boolean[][] occupiedArea) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = map;
        this.occupiedArea = occupiedArea;
    }
*/


    public void setMapFromFile(String mapEleres) throws IOException {
        int numberOfRows=0;
        int numberOfColumns=0;
        if(mapDataToList().size()>0) mapDataToList().clear();
        try {
            FileInputStream fis = new FileInputStream("Beadando/src/main/resources/map/"+mapEleres);
            int i;
            do{
                i= fis.read();

                if(i!=' '&&i!='\n'&&i!='\r'&&i!=-1){
                    numberOfRows++;
                    System.out.println("Olvasas: "+(char)i);
                    addMapDataToList(String.valueOf((char)i));
                }
                if(i=='\n'){
                    numberOfColumns++;
                    System.out.print("\n");
                }

            }while (i!=-1);
            fis.close();

            for(String eredmeny : mapDataToList()){
                System.err.println(eredmeny);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

        //System.out.println("Sorok: "+numberOfRows/numberOfColumns+" | Oszlopok: "+numberOfColumns);
        this.numberOfRows = numberOfRows/numberOfColumns;
        this.numberOfColumns = numberOfColumns;
    }

    public void addMapDataToList(String data){
        mapDataToList().add(data);
    }

    public List<String> mapDataToList() {
        return mapData;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int[][] getMap() {
        return map;
    }

    public boolean[][] getOccupiedArea() {return occupiedArea;}

}
