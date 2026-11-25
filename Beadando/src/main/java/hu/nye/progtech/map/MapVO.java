package hu.nye.progtech.map;

import hu.nye.progtech.engine.LocateSaveFolder;
import hu.nye.progtech.model.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapVO {
    static final int numberOfRows=12;
    static final int numberOfColumns=6;
    private String [][] map;
    public static String mapName="default";
    public List<Player> player;
    public List<Car> car;

    public void setupMap()   {
       try {
           setMapFromFile(mapName);
       }catch (IOException e){
           System.err.println(e.getMessage());
       }
    }

    public void setupMap(String name)   {
        try {
            setMapFromFile(name);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void setMapFromFile(String mapName) throws IOException {

        BufferedReader br;
        int readHeight=0;
        map = new String[numberOfColumns][numberOfRows];
       if(mapName.equals("default")) {
           br = new BufferedReader(new FileReader("Beadando/src/main/resources/map/default.txt"));
       }
       else {
            br= new BufferedReader((new FileReader(new LocateSaveFolder().SaveFolder+ File.separator+mapName+".txt")));
       }
        try {
            String line="";
            while(line!=null){
                line=br.readLine();

                if(readHeight<=6){

                    for(int i=0;i<line.length();i++){
                        char c=line.charAt(i);
                        map[readHeight][i]=Character.toString(c);

                        if(line.charAt(i)=='1'){
                            //System.out.println("\nPozicio 1-re x: " + readHeight+" y: "+i);
                            Player.players.getFirst().car.add(new Car(new Position(readHeight,i)));

                        }
                        if(line.charAt(i)=='2'){
                            //System.out.println("\nPozicio 2-re x: " + readHeight+" y: "+i);
                            Player.players.getLast().car.add(new Car(new Position(readHeight,i)));

                        }
                    }

                }
                else {
                    if (line != null) {
                        String[] temp = line.split(" ");
                        if (temp[0].equals("Player1:")){
                            Player player1= new Player(temp[1]);
                            player1.setExitX(Integer.parseInt(temp[2]));
                            player1.setExitY(Integer.parseInt(temp[3]));
                            Player.players.add(player1);
                            //System.out.println("\nNeve: "+ Player.players.get(0).playerName+" Kilepesi adat x: "+ Player.players.get(0).getExitX()+" y: "+ Player.players.get(0).getExitY());
                        }

                        if (temp[0].equals("Player2:")){
                            Player player2= new Player(temp[1]);
                            player2.setExitX(Integer.parseInt(temp[2]));
                            player2.setExitY(Integer.parseInt(temp[3]));
                            Player.players.add(player2);
                           // System.out.println("\nNeve: "+ Player.players.get(1).playerName+" Kilepesi adat x: "+ Player.players.get(1).getExitX()+" y: "+ Player.players.get(1).getExitY());
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

    public String[][] getMap() {
        return map;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        MapVO.mapName = mapName;
    }

    public List<Player> getPlayers() {
        return player;
    }
}
