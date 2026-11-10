package hu.nye.progtech.map;

import hu.nye.progtech.model.Cars;
import hu.nye.progtech.model.Players;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapVO {
    private final int numberOfRows=12;
    private final int numberOfColumns=6;
    private int [][] map;
    private List<String> mapData= new ArrayList<String>();
    private String mapName="default.txt";

    public MapVO()   {
       try {
           Cars.generatePlayerObjects();
           setMapFromFile(this.mapName);
       }catch (IOException e){
           System.err.println(e.getMessage());
       }
        insertDataToMatrix();
    }

    public MapVO(String name)   {
        try {
            setMapFromFile(name);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        insertDataToMatrix();
    }

    public void setMapFromFile(String mapName) throws IOException {
        int readHeight=0;
        if(!mapDataToList().isEmpty()) mapDataToList().clear();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Beadando/src/main/resources/map/"+mapName));
            String line="";
            while(line!=null){
                line=br.readLine();

                if(readHeight<=6){
                    for(int i=0;i<line.length();i++){
                        if(line.charAt(i)=='V'||line.charAt(i)=='H'||line.charAt(i)=='v'||line.charAt(i)=='h'){
                            //Mentés valamilyen formában, hogy akadály kezdő pozi
                            addMapDataToList("3");
                        }else
                        addMapDataToList(String.valueOf(line.charAt(i)));
                    }
                }

                else {
                    if (line != null) {
                        String[] temp = line.split(" ");
                        //index      0      1   2 3
                        //Sample: Player1: Adam 2 2
                        if (temp[0].equals("Player1:")){
                            Players.Player1 = temp[1];
                            int exitX=Integer.parseInt(temp[2]);
                            int exitY=Integer.parseInt(temp[3]);
                            Cars.Player1Car.setCarExitX(exitX);
                            Cars.Player1Car.setCarExitY(exitY);
                            System.out.println("Player1 car set exitX:"+Cars.Player1Car.getCarExitX()+" exitY:"+Cars.Player1Car.getCarExitY());

                        }

                        if (temp[0].equals("Player2:")){
                            Players.Player2 = temp[1];
                            int exitX=Integer.parseInt(temp[2]);
                            int exitY=Integer.parseInt(temp[3]);
                            Cars.Player2Car.setCarExitX(exitX);
                            Cars.Player2Car.setCarExitY(exitY);
                            System.out.println("Player2 car set exitX:"+Cars.Player2Car.getCarExitX()+" exitY:"+Cars.Player2Car.getCarExitY());
                        }
                    }
                }
                readHeight++;
                //System.out.println("Buffered:"+line);

            }
            System.out.println("Player1: "+Players.Player1+"\nPlayer2: "+Players.Player2);
            br.close();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void insertDataToMatrix(){
        map=new int[numberOfColumns][numberOfRows];
        for(int i=0;i<numberOfColumns;i++){
            for(int j=0;j<numberOfRows;j++){
                if(i==0)map[i][j]= Integer.parseInt(mapData.get(j));
                else map[i][j]= Integer.parseInt(mapData.get(i*numberOfRows+j));
                //System.out.print("\nMatrix betett adat ["+i+","+j+"]: "+mapData.get(i*numberOfRows+j));
            }
        }
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

    public void setMap(int[][] map,int numberOfRows,int numberOfColumns) {
        this.map = new int[numberOfRows][numberOfColumns];
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
}
