package hu.nye.progtech.model;

import java.util.List;

public interface GameObjects {
    List<Position> getOccupiedPositions();

    default boolean containsPosition(int x, int y) {
        for(Position p : getOccupiedPositions()) {
            if(p.getX() == x && p.getY() == y) {
                return true;
            }
        }

        return false;
    }



}
