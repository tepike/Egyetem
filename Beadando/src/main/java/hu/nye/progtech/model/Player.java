package hu.nye.progtech.model;

import java.util.List;


public class Player {
    static int playerId = 1;
    public String playerName;
    private int exitX;
    private int exitY;
    public List<Car> car;
    public List<Player> players;

    public Player(String name) {
        playerName = name;
        playerId++;
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
        playerId = 1;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

}
