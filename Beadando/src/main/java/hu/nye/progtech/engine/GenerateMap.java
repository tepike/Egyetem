package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;

import java.util.Map;

// Map generator
public class GenerateMap extends MapVO{

    public void StartGeneration(){
        System.out.println("Generating empty named map like default Map");
        if(!mapName.equals("default")) {MapVO.mapName="default";}
    }
    public void StartGeneration(String mapName){
        System.out.println("Generating costume map");
        setupMap("test");
        MapVO.mapName=mapName;
    }
}
