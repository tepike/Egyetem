package hu.nye.progtech.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapVO {
    private int numberOfRows;
    private int numberOfColumns;
    private int [][] map;
    private List<String> mapData= new ArrayList<String>();
    private String mapName="default.txt";


    //Hogy tudjunk példányosítani így itt kell megtörténni a setMpaFromFile metódusnak
    //public MapVO(int numberOfRows, int numberOfColumns, int [][] map)

    //Nem szabad a példányosításba metódust megadni, mert megmarhul minden létrehozásnál. Csak a fenti adatokat szabad feldolgozni benne.
    public MapVO()   {
       try {
           setMapFromFile(this.mapName);
       }catch (IOException e){
           System.err.println(e.getMessage());
       }
        insertDataToMatrix();

    }

    public void setMapFromFile(String mapName) throws IOException {

        int numberOfRows=0;
        int numberOfColumns=0;
        if(mapDataToList().size()>0) mapDataToList().clear();
        try {
            FileInputStream fis = new FileInputStream("Beadando/src/main/resources/map/"+mapName);
            int i;
            do{
                i= fis.read();

                if(i!=' '&&i!='\n'&&i!='\r'&&i!=-1){
                    numberOfRows++;
                    //System.out.println("Olvasas: "+(char)i);  Test
                    addMapDataToList(String.valueOf((char)i));
                }
                if(i=='\n'){
                    numberOfColumns++;
                    //System.out.print("\n");                   Test
                }

            }while (i!=-1);
            fis.close();
            numberOfColumns++;

            for(String eredmeny : mapDataToList()){
               // System.err.println(eredmeny);                 Test
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }

        System.err.println("Sorok: "+numberOfRows/numberOfColumns+" | Oszlopok: "+numberOfColumns);
        this.numberOfRows = numberOfRows/numberOfColumns;
        this.numberOfColumns = numberOfColumns;

    }

    public void insertDataToMatrix(){
        map=new int[numberOfColumns][numberOfRows];
        for(int i=0;i<numberOfColumns;i++){
            for(int j=0;j<numberOfRows;j++){
                if(i==0)map[i][j]= Integer.parseInt(mapData.get(j));
                else map[i][j]= Integer.parseInt(mapData.get(i*numberOfRows+j));
                System.out.print("\nMatrix betett adat ["+i+","+j+"]: "+mapData.get(i*numberOfRows+j));
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
