package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;

public class GenerateMap {

    public void StartGeneration(){
        System.out.println("Generating empty named map like default Map");
        MapVO defaultMap = new MapVO();
        if(!defaultMap.getMapName().equals("default")) {defaultMap.setMapName("default");}
        JatekMezo jatekMezo = new JatekMezo();
        jatekMezo.printMap(defaultMap);
    }
    public void StartGeneration(String mapName){
        System.out.println("Generating costume map");

        MapVO costumeMap= new MapVO("test"+".txt");
        costumeMap.setMapName(mapName);
        JatekMezo jatekMezo = new JatekMezo();
        jatekMezo.printMap(costumeMap);
    }
}
