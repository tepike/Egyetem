package hu.nye.progtech.commands;

import hu.nye.progtech.engine.LocateSaveFolder;
import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.Car;
import hu.nye.progtech.model.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;


public class SaveGame extends LocateSaveFolder {


    public void saveDefaultGame(MapVO mapVO) throws FileNotFoundException {
        mapVO.setupMap();
        String[][] map = mapVO.getMap();
        String location = SaveFolder + File.separator + "default.txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(location));
            for (int y = 0; y < 6; y++) {
                for (int x = 0; x < 12; x++) {
                    bw.write(String.valueOf(map[y][x]));
                    System.out.println("Txt-be irt adat[y]:" + y + " [x]:" + x + " = " + map[y][x]);
                }
                bw.newLine();
            }
            bw.newLine();
            bw.write("Player1: Player1 0 3");
            bw.newLine();
            bw.write("Player2: CPU 11 1");
            bw.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void savetGame(MapVO map, String mentes) throws FileNotFoundException {

        String[][] mapSave = map.getMap();
        String location = SaveFolder + File.separator + mentes + ".txt";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(location));
            for (int y = 0; y < 6; y++) {
                for (int x = 0; x < 12; x++) {
                    bw.write(String.valueOf(mapSave[y][x]));
                }
                bw.newLine();
            }
            bw.newLine();
            //Player1: Player1 0 3
            /*
            bw.write("Player1: "+ players.getFirst().playerName+
                                    " "+
                                   players.getFirst().getExitX()+
                                    " "+
                    players.getFirst().getExitY()
            );
            bw.write("Player2: "+ players.getLast().playerName+
                    " "+
                    players.getLast().getExitY()+
                    " "+
                    players.getLast().getExitY()
            );
            */

            bw.close();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }


}
