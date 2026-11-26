package hu.nye.progtech.engine;

import hu.nye.progtech.commands.LoadGame;
import hu.nye.progtech.map.MapVO;

public class Run {
    private final MapVO mapVO;
    public Run(MapVO mapVO) {
        mapVO.setupMap();
        this.mapVO = mapVO;
    }
    public void Start() {
        LocateSaveFolder locateSaveFolder = new LocateSaveFolder();
        locateSaveFolder.LocateSaveFolder();
        locateSaveFolder.PrintSavedFiles(mapVO);
        //Ez a default.txt a resource-ból

        new LoadGame().LoadGame(mapVO);


    }

}
