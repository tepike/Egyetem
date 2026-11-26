package hu.nye.progtech.model;

import hu.nye.progtech.map.MapVO;

import java.util.ArrayList;
import java.util.List;

public class Barrier implements GameObjects {

    Position pos;
    Position.orientation orientation;


    public Barrier(Position position, Position.orientation orientation) {
        pos.setX(position.getX());
        pos.setY(position.getY());
        this.orientation = orientation;
    }


    @Override
    public List<Position> getOccupiedPositions() {
        List<Position> result = new ArrayList<>();
/*
        for (int i = 0; i < barierLength; i++) {

            if (orientation == Position.orientation.HORIZONTAL) {
                result.add(new Position(pos.getX() + i,pos.getY()));
            }
            else {
                result.add(new Position(pos.getX(), pos.getY() + i));
            }

        }
*/
        return result;
    }


    public static void getBariersFromMap(MapVO mapVo) {
        String[][] map = mapVo.getMap();
        List<Position> position = new ArrayList<Position>();


        for (int i = 0; i < mapVo.getNumberOfColumns(); i++) {
            for (int j = 0; j < mapVo.getNumberOfRows(); j++) {
                String element = map[i][j];
                if (element.equals("h")) {
                    position.add(new Position(j, i));
                }
            }
            if (!position.isEmpty()) {
                Barrier barrier = new Barrier(position.get(0), Position.orientation.HORIZONTAL);
                ObjectList.addObject(barrier);
                position.clear();
            }
        }
        position.clear();

        for (int i = 0; i < mapVo.getNumberOfRows(); i++) {
            for (int j = 0; j < mapVo.getNumberOfColumns(); j++) {
                String element = map[j][i];
                if (element.equals("v")) {
                    position.add(new Position(i, j));
                }
            }
            if (!position.isEmpty()) {
                Barrier barrier = new Barrier(position.get(0), Position.orientation.VERTICAL);
                ObjectList.addObject(barrier);
                position.clear();
            }
        }
    }


    @Override
    public String toString() {
        return "Akadály x: " + pos.getX() + " y: " + pos.getY() + " iránya: " + orientation;
    }
}
