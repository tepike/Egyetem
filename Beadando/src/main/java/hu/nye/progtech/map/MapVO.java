package hu.nye.progtech.map;

import hu.nye.progtech.model.*;

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

                    //Kell egy while ciklus ami azt nézi, hogy ha Talált egy V-t pl és akkor a következő sorban lévő betű v akkor addig megy lefelé amíg olyat talál ami nem kis v. Így elkerülhető a dplázás felvétel





                    for(int i=0;i<line.length();i++){

                        /* KIDolgozásra vár!!
                        if(line.charAt(i)=='V'){ //Ez megegyezik az alatta lévővel   if(line.charAt(i)=='V'||line.charAt(i)=='H'||line.charAt(i)=='v'||line.charAt(i)=='h'){
                            int index=i;
                            Barrier.addBarrier(new Barrier(new Position(i,readHeight),1,line.charAt(i)));

                            while(line.charAt(index+6)=='v') {
                                System.out.println("A kovetkezo +6. helyen is v-van");
                                }
                        }
                        */


                        if(line.charAt(i)=='V'||line.charAt(i)=='H'||line.charAt(i)=='v'||line.charAt(i)=='h'){
                            //Mentés valamilyen formában, hogy akadály kezdő pozi
                            addMapDataToList("3");
                        }else {
                            addMapDataToList(String.valueOf(line.charAt(i)));
                        }
                        if(line.charAt(i)=='1'&&Cars.Player1Car.getXPosition()==0){
                            Cars.Player1Car.setXPosition(i+1);
                            Cars.Player1Car.setYPosition(readHeight+1);
                            System.out.println("\t\t\tBeolvasott text jarmu pozicio");
                            System.out.println(Cars.Player1Car.toString(Cars.Player1Car));
                        }
                        if(line.charAt(i)=='2'&&Cars.Player2Car.getXPosition()==0){
                            Cars.Player2Car.setXPosition(i+1);
                            Cars.Player2Car.setYPosition(readHeight+1);
                            System.out.println("\t\t\tBeolvasott text jarmu pozicio");
                            System.out.println(Cars.Player2Car.toString(Cars.Player2Car));
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
                            System.out.println("Player1 car set exitX:"+Cars.Player1Car.getCarExitX()+" exitY:"+Cars.Player1Car.getCarExitY());

                        }

                        if (temp[0].equals("Player2:")){
                            Players.Player2 = temp[1];
                            Cars.Player2Car.setCarExitX(Integer.parseInt(temp[2]));
                            Cars.Player2Car.setCarExitY(Integer.parseInt(temp[3]));
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
