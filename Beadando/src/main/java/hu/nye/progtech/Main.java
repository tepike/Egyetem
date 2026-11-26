package hu.nye.progtech;



import hu.nye.progtech.engine.*;
import hu.nye.progtech.map.MapVO;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
    Run StartGame = new Run(new MapVO());
    StartGame.Start();




    /*
    Game class

    - List<GameObject> gameObjects;

    load()
    start() / init()
    run (game-loop)
    onEvent()
    draw()

    UI or CLI class
    I/O to and from command-line


    class CPUPlayer extends Player;


    < left
    > right
    ^ up
    v down

     */


    }
}