package hu.nye.progtech.service.map.parser;

import java.util.List;

public class MapParser {
    private int numberOfRows;
    private int numberOfColumns;

    public MapParser(int numberOfRows, int numberOfColumns){
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }




    public int [][] getMap(List<String> rawMap){
        int[][] result= new int[numberOfRows][];

        for(int i = 0; i < numberOfRows; i++){
            result[i]=new  int[numberOfColumns];

            String line= rawMap.get(i);
            String[] parts= line.split("");

            for(int j=0;j< numberOfColumns;j++){
                result[i][j]= Integer.parseInt(parts[j]);
            }

        }
        return result;
    }

    public boolean[][] getFixed(int[][] map){
        boolean[][] result = new boolean[numberOfColumns][];

        for(int i = 0;i< numberOfRows;i++){
            result[i]= new boolean[numberOfColumns];

            for (int j=0;j< numberOfColumns;j++){
            result[i][j] = map[i][j]!= 0;
            }
        }

        return result;

    }
}
