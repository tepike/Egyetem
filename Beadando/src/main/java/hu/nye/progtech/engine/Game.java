package hu.nye.progtech.engine;

import hu.nye.progtech.map.MapVO;
import hu.nye.progtech.model.GameObjects;
import hu.nye.progtech.model.Player;

import java.util.List;

public class Game {

    List<GameObjects> gameObjects;
    String [][] mapObjects;

    public void load(String mapName){

    }
    public void load(){
        System.out.println("Load process started");

    }

    public void init(){

        //System.out.println("Game.init.mapObjects.length: "+mapObjects.length+" "+mapObjects[0].length);
    }


    public void run(){

    }

    public void onEvent(){

    }

    public void draw(){

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