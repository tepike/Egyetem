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
    private List<Player> players;

    public MapVO()   {
        System.out.println("MapVO");
       try {
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
        BufferedReader br;
        int readHeight=0;
        map = new String[numberOfColumns][numberOfRows];
        //String location=SaveFolder+ File.separator+"default.txt";
       if(mapName.equals("default")) {
           br = new BufferedReader(new FileReader("Beadando/src/main/resources/map/default.txt"));
       }
       else {
            br= new BufferedReader((new FileReader(new LocateSaveFolder().SaveFolder+ File.separator+mapName+".txt")));
       }
        try {
            List<Position> player1Position = new ArrayList<Position>();
            List<Position> player2Position = new ArrayList<Position>();

            String line="";
            while(line!=null){
                line=br.readLine();

                if(readHeight<=6){

                    for(int i=0;i<line.length();i++){
                        char c=line.charAt(i);
                        map[readHeight][i]=Character.toString(c);

                        if(line.charAt(i)=='1'){
                            player1Position.add(new Position(readHeight,i));
                        }
                        if(line.charAt(i)=='2'){
                            player2Position.add(new Position(readHeight,i));
                        }
                    }

                }
                else {
                    if (line != null) {
                        String[] temp = line.split(" ");
                        if (temp[0].equals("Player1:")){
                            Player player1= new Player(temp[1]);
                            System.out.println("\nNeve: "+player1.playerName+" Kilepesi adat x: "+player1.getExitX()+" y: "+player1.getExitY());
                            players.add(player1);
                            players.getFirst().setExitX(Integer.parseInt(temp[2]));
                            players.getFirst().setExitY(Integer.parseInt(temp[3]));

                        }

                        if (temp[0].equals("Player2:")){
                            Player player2= new Player(temp[1]);
                            players.add(player2);
                            players.getLast().setExitX(Integer.parseInt(temp[2]));
                            players.getLast().setExitY(Integer.parseInt(temp[3]));

                        }

                    }
                }
                readHeight++;
            }
            br.close();
            for(Player p: players){
                System.out.println("\nNeve: "+p.playerName+" Kilepesi adat x: "+p.getExitX()+" y: "+p.getExitY());
            }
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
        return players;
    }
}
