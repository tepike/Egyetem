package hu.nye.progtech.map;

import hu.nye.progtech.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MapVO {
    private final int numberOfRows=12;
    private final int numberOfColumns=6;
    private int [][] map;
    static String mapName="default";

    public MapVO()   {
        System.out.println("MapVO");
       try {
           Cars.generatePlayerObjects();
           setMapFromFile(mapName);
       }catch (IOException e){
           System.err.println(e.getMessage());
       }
    }

    public MapVO(String name)   {
        System.out.println("MapVO (String name)");
        try {
            setMapFromFile(name);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void setMapFromFile(String mapName) throws IOException {
        int readHeight=0;
        map = new int[numberOfColumns][numberOfRows];
        BufferedReader br = new BufferedReader(new FileReader("Beadando/src/main/resources/map/"+mapName+".txt"));
        try {

            String line="";
            while(line!=null){
                line=br.readLine();

                if(readHeight<=6){

                    for(int i=0;i<line.length();i++){
                        char c=line.charAt(i);

                        if(c=='v' || c=='h'){
                            map[readHeight][i]=3;
                        }else {
                            map[readHeight][i]=c-'0';
                        }

                        if(line.charAt(i)=='1'&&Cars.Player1Car.getXPosition()==0){
                            Cars.Player1Car.setXPosition(i+1);
                            Cars.Player1Car.setYPosition(readHeight+1);
                        }
                        if(line.charAt(i)=='2'&&Cars.Player2Car.getXPosition()==0){
                            Cars.Player2Car.setXPosition(i+1);
                            Cars.Player2Car.setYPosition(readHeight+1);
                        }
                    }
                }
                else {
                    if (line != null) {
                        String[] temp = line.split(" ");
                        //index      0      1   2 3
                        //Sample: Player1: Adam 2 2
                        if (temp[0].equals("Player1:")){
                            Players.Player1 = temp[1];
                            Cars.Player1Car.setCarExitX(Integer.parseInt(temp[2]));
                            Cars.Player1Car.setCarExitY(Integer.parseInt(temp[3]));
                        }

                        if (temp[0].equals("Player2:")){
                            Players.Player2 = temp[1];
                            Cars.Player2Car.setCarExitX(Integer.parseInt(temp[2]));
                            Cars.Player2Car.setCarExitY(Integer.parseInt(temp[3]));
                        }

                    }
                }
                readHeight++;
            }
            br.close();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
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

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
