package hu.nye.progtech.commands;

import hu.nye.progtech.engine.LocateSaveFolder;
import hu.nye.progtech.map.MapVO;

import java.util.Scanner;

public class LoadGame extends MapVO {
    public void LoadGame() {
        new LocateSaveFolder().PrintSavedFiles();
        int index=new Scanner(System.in).nextInt();
        String loadMap= new LocateSaveFolder().getSavedGame(index - 1);
        String [] fixedName = loadMap.split(".txt");
        setMapName(fixedName[0]);
    }

}
