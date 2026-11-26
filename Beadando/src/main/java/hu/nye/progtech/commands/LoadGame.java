package hu.nye.progtech.commands;

import hu.nye.progtech.engine.LocateSaveFolder;
import hu.nye.progtech.map.MapVO;

import java.util.Scanner;

public class LoadGame  {
    public void LoadGame(MapVO mapVO) {
        new LocateSaveFolder().PrintSavedFiles(mapVO);
        int index=new Scanner(System.in).nextInt();
        String loadMap= new LocateSaveFolder().getSavedGame(index - 1);
        String [] fixedName = loadMap.split(".txt");
        //Saját default névnél gond, hogy a resource-ból tölti a mappot
        mapVO.setupMap(fixedName[0]);
    }

}
