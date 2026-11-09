package hu.nye.progtech.map;

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
                        if(line.charAt(i)=='V'||line.charAt(i)=='H'){
                            //Mentés valamilyen formában, hogy akadály kezdő pozi
                            addMapDataToList("3");
                        }else
                        addMapDataToList(String.valueOf(line.charAt(i)));
                    }
                }

                else {
                    if (line != null) {
                        String[] temp = line.split(" ");
                        //index      0      1   2 3 4 5
                        //Sample: Player1: Adam 2 2 3 2
                        if (temp[0].equals("Player1:")){
                            Players.Player1 = temp[1];
                            int [][] Player1CarLocation={{Integer.parseInt(temp[2]),Integer.parseInt(temp[3])},{Integer.parseInt(temp[4]),Integer.parseInt(temp[5])}};
                            for (int[] row : Player1CarLocation) {
                                for (int num : row) {
                                    System.out.println(num);
                                }
                            }
                        }

                        if (temp[0].equals("Player2:")){
                            Players.Player2 = temp[1];
                            int [][] Player2CarLocation={{Integer.parseInt(temp[2]),Integer.parseInt(temp[3])},{Integer.parseInt(temp[4]),Integer.parseInt(temp[5])}};
                            for (int[] row : Player2CarLocation) {
                                for (int num : row) {
                                    System.out.println(num);
                                }
                            }
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
