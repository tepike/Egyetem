package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;


public class Player {
    public static final List<Player> players = new ArrayList<Player>();
    static int playerNumber = 1;
    public String playerName;
    private int exitX;
    private int exitY;
    public List<Car> car;

    public Player(String name) {
        playerName = name;
        playerNumber++;
    }

    public int getExitX() {
        return exitX;
    }

    public void setExitX(int exitX) {
        this.exitX = exitX;
    }

    public int getExitY() {
        return exitY;
    }

    public void setExitY(int exitY) {
        this.exitY = exitY;
    }

    public static void resetPlayer() {
        playerNumber = 1;
    }

}
