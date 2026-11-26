package hu.nye.progtech.model;

import java.util.ArrayList;
import java.util.List;

public class Car implements GameObjects {
    static final int Length = 2;
    static Position pos;


    @Override
    public List<Position> getOccupiedPositions() {
        List<Position> positions = new ArrayList<>();

        for (int i = 0; i < Length; i++) {
            positions.add(new Position(pos.getX() + i, pos.getY()));
        }

        return positions;
    }

    public Car(Position pos) {
        this.pos.setX(pos.getX());
        this.pos.setY(pos.getY());
    }

    public int getLength() {
        return Length;
    }


    @Override
    public String toString() {
        return "Jarmu adatok:\n"
                + "Position X: " + pos.getX() + "\n"
                + "\nPosition Y: " + pos.getY() + "\n";
    }
}
