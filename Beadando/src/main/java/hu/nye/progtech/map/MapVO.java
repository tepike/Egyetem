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
    static final int numberOfRows = 12;
    static final int numberOfColumns = 6;
    private String[][] map;
    public static String mapName = "default";
    private final List<Player> player=new ArrayList<>();


    public void setupMap() {
        try {
            setMapFromFile(mapName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setupMap(String name) {
        try {
            setMapFromFile(name);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setMapFromFile(String mapName) throws IOException {

        BufferedReader br;
        int readHeight = 0;
        map = new String[numberOfColumns][numberOfRows];
        if (mapName.equals("default")) {
            br = new BufferedReader(new FileReader("Beadando/src/main/resources/map/default.txt"));
        } else {
            br = new BufferedReader((new FileReader(new LocateSaveFolder().SaveFolder + File.separator + mapName + ".txt")));
        }
        try {
            String line = "";
            player.clear();
            while (line != null) {
                line = br.readLine();

                if (readHeight <= 6) {

                    for (int i = 0; i < line.length(); i++) {
                        char c = line.charAt(i);
                        map[readHeight][i] = Character.toString(c);
                    }

                }


                if (line != null) {
                    String[] temp = line.split(" ");
                    if (temp[0].equals("Player1:")) {
                        player.add(new Player(temp[1]));
                        player.getFirst().setExitX(Integer.parseInt(temp[2]));
                        player.getFirst().setExitY(Integer.parseInt(temp[3]));
                    }
                    if (temp[0].equals("Player2:")) {
                        player.add(new Player(temp[1]));
                        player.getLast().setExitX(Integer.parseInt(temp[2]));
                        player.getLast().setExitY(Integer.parseInt(temp[3]));
                    }
                }

                readHeight++;

            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

    public List<Player> getPlayer() {
        return player;
    }
}
