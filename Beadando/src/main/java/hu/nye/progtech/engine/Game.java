package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.GameObjects;

import java.util.List;

public class Game {
    public MapVO map = new MapVO();
    List<GameObjects> gameObjects;
    String [][] mapObjects;

    public void load(String mapName){
        map.setupMap(mapName);
    }
    public void load(){
        System.out.println("Load process started");
        map.setupMap("default");
    }

    public void init(){
        mapObjects = map.getMap();
        //System.out.println("Game.init.mapObjects.length: "+mapObjects.length+" "+mapObjects[0].length);
    }


    public void run(){

    }

    public void onEvent(){

    }

    public void draw(){
        new JatekMezo().printMap(map);

    }

}


    /*

    UI or CLI class
    I/O to and from command-line


    class CPUPlayer extends Player;


    < left
    > right
    ^ up
    v down

     */